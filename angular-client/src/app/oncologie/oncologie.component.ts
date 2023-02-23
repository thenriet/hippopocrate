import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-oncologie',
  templateUrl: './oncologie.component.html',
  styleUrls: ['./oncologie.component.scss']
})
export class OncologieComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("oncologie");
  }

}
