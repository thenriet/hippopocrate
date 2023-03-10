import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Role } from '../model/role';
import { User } from '../model/user';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss'],
})
export class UpdateUserComponent implements OnInit {
  updateUserForm!: FormGroup;
  user = new User();
  updateUser = new User();
  roles!: Role[];
  roleId!: number;
  // userListLength!: number;
  id!: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserServiceService
  ) {
    this.userService.findAllRoles().subscribe((data) => {
      this.roles = data;
    });
  }

  ngOnInit(): void {
    this.loadUserById();

    this.updateUserForm = this.fb.group({
      name: ['', Validators.required],
      role: ['', Validators.required],
    });

    // this.userService
    //   .findAll()
    //   .subscribe((result) => (this.userListLength = result.length + 1));
  }

  onSubmit() {
    let data = this.updateUserForm.value;
    console.log(data);
    if (data.name) {
      this.updateUser.name = data.name;
    } else {
      this.updateUser.name = this.user.name;
    }
    this.updateUser.role = data.role;
    this.updateUser.password = this.user.password;
    console.log(this.updateUser);
    this.userService.update(this.updateUser, this.id).subscribe(
      (updateUser) => {
        console.log('User updated:', updateUser);
        this.goToUserList();
      },
      (error) => {
        console.error('Error updating user:', error);
      }
    );
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
    this.router.navigate(['/users']).then(() => {
      window.location.reload();
    });
  }

  loadUserById() {
    this.id = this.route.snapshot.params['id'];
    this.userService.findUserById(this.id).subscribe({
      next: (data) => {
        this.user = data;
      },
      error: (e) => {
        console.log(e);
      },
    });
  }
}
