import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-neurologie',
  templateUrl: './neurologie.component.html',
  styleUrls: ['./neurologie.component.scss']
})
export class NeurologieComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("neurologie");
  }
}
