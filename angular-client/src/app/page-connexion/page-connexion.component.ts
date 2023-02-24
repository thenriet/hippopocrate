import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { identifiantModel } from '../model/identifiant-models';

@Component({
  selector: 'app-page-connexion',
  templateUrl: './page-connexion.component.html',
  styleUrls: ['./page-connexion.component.scss']
})

export class PageConnexionComponent {
  contactForm: FormGroup;
  remplissageForm= new identifiantModel;
  error= false; 
  

  constructor(private fb: FormBuilder) { 

    this.contactForm = this.fb.group({
      id:['',Validators.required],
      password :['',Validators.required],
     });
  }

  onSubmit() {
    let data = this.contactForm.value;
    this.remplissageForm.id = data.id;
    this.remplissageForm.password = data.password;
    console.log(this.remplissageForm);
    try {
      this.contactForm.value
      
    }
    catch (error){
     console.log(error);
     this.error= true;
    }
  }

}
