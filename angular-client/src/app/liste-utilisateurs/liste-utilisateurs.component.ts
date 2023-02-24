import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-liste-utilisateurs',
  templateUrl: './liste-utilisateurs.component.html',
  styleUrls: ['./liste-utilisateurs.component.scss']
})
export class ListeUtilisateursComponent {
  constructor ( private route: Router){
  }
  ngOnInit():void{
  this.route.navigateByUrl("/users");
  }
}
