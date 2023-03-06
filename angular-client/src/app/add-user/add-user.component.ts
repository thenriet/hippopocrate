import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Role } from '../model/role';
import { User } from '../model/user';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss'],
})
export class AddUserComponent implements OnInit {
  addUserForm!: FormGroup;
  user!: User;
  roles!: Role[];
  roleId!: number;
  userListLength!: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserServiceService
  ) {
    this.user = new User();
    this.userService.findAllRoles().subscribe((data) => {
      this.roles = data;
    });
  }

  ngOnInit(): void {
    this.addUserForm = this.fb.group({
      name: ['', Validators.required],
      role: ['', Validators.required],
      password: ['', Validators.required],
    });

    this.userService
      .findAll()
      .subscribe((result) => (this.userListLength = result.length = 1));
  }

  onSubmit() {
    let data = this.addUserForm.value;
    this.user.id = this.userListLength;
    this.user.name = data.name;
    this.user.password = data.password;
    this.user.role = data.role;
    this.userService.save(this.user).subscribe((result) => this.goToUserList());
  }

  onSelectRole() {
    console.log('Selected option:', this.roleId);
    if (this.roleId) {
      console.log(this.userService.findOneRoleById(this.roleId));
      this.userService.findAllRoles().subscribe((data) => {
        this.roles = data;
        console.log(this.roles);
      });
    }
  }

  goToUserList() {
    this.router.navigate(['/users']);
  }
}
