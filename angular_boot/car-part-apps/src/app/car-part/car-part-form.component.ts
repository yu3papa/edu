import {Component} from '@angular/core';
import {Router} from "@angular/router";

import {CarPart} from "./car-part";
import {FormControl,  FormGroup, Validators, FormBuilder} from '@angular/forms';
import {RacingDataService} from "./racing-data.service";

@Component({
    selector: 'car-part-form',
    templateUrl: 'car-part-templatedriven-form.component.html',
    styleUrls: ['car-parts.component.css']
})
export class CarPartFormComponent {

    carPartForm:FormGroup;

    constructor(private _formBuilder:FormBuilder, private router:Router, private dataService:RacingDataService){
        this.carPartForm= _formBuilder.group({
            id: new FormControl('', Validators.required),
            name: new FormControl('', Validators.required),
            description: new FormControl('', Validators.required),
            price:new FormControl('', Validators.compose([Validators.required,
                                                           Validators.pattern('[0-9]')])),
            quantity:new FormControl('', Validators.required)
        });
    }

    onSubmit(f){
        let formData = f.value as CarPart;
        console.log(formData);
        if (formData.name === "") {
            alert("입력하세요");
        }else {
            this.dataService.createProduct(formData);
        }

        this.router.navigate(['/carpart']);
    }

    // isEmpty(obj) {
    //   for (var x in obj) { if (obj.hasOwnProperty(x))  return false; }
    //   return true;
    // }
}
