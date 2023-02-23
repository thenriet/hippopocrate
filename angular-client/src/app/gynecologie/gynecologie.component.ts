import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gynecologie',
  templateUrl: './gynecologie.component.html',
  styleUrls: ['./gynecologie.component.scss']
})
export class GynecologieComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("gynecologie");
  }
}
