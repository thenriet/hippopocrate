import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cardiologie',
  templateUrl: './cardiologie.component.html',
  styleUrls: ['./cardiologie.component.scss']
})
export class CardiologieComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("cardiologie");
  }
}
