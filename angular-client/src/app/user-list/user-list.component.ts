import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserServiceService } from '../service/user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {
  users!: User[];

  constructor(private userService: UserServiceService, private router: Router) {
  }

  ngOnInit() {
    this.loadUsers()
  }

  loadUsers() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  updateUser(id: number) {
    this.router.navigate(['updateUser', id]);
  }
}
