import {Component, OnInit} from "@angular/core";

import {CarPart} from "./car-part";
import {RacingDataService} from "./racing-data.service";

@Component({
    selector:'car-parts',
    templateUrl:'car-parts.component.html',
    styleUrls:['car-parts.component.css' ]
})
export class CarPartsComponent implements OnInit{
    title = "Ultra Racing";

    carParts:CarPart[];

    constructor(private racingDataService:RacingDataService){
        console.log(racingDataService);
    }

    ngOnInit() {
        //this.carParts = this.racingDataService.getCarParts();
        //Observable 를 사용
        this.racingDataService.getCarParts()
          .subscribe(responseData => this.carParts = responseData['data']);

        //Promise 를 사용
        //this.racingDataService.getCarPartsPromise().then(data => this.carParts = data);
    }

    upQuantity(carPart) {
        //alert("증가버튼 클릭" + value);
        if(carPart.inStock > carPart.quantity) {
            carPart.quantity++;
        }
    }

    downQuantity(carPart){
        if(carPart.quantity != 0) carPart.quantity--;
    }

    totalCarParts() {
        //1단계
        // let sum = 0;
        // for(let carPart of this.carParts){
        //     sum += carPart.inStock;
        // }
        // return sum;

        //2단계
        // return this.carParts.reduce(function (prev,curr) {
        //     return prev + curr.inStock;
        // },0);

        //3단계(람다식으로 표현)
        if(Array.isArray(this.carParts)) {
            return this.carParts.reduce((prev, curr) => prev + curr.inStock, 0);
        }
    }


}
