"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var racing_data_service_1 = require("./racing-data.service");
var CarPartsComponent = (function () {
    function CarPartsComponent(racingDataService) {
        this.racingDataService = racingDataService;
        this.title = "Ultra Racing";
        console.log(racingDataService);
    }
    CarPartsComponent.prototype.ngOnInit = function () {
        //this.carParts = this.racingDataService.getCarParts();
        //Observable 를 사용
        //this.racingDataService.getCarParts().subscribe(data => this.carParts = data);
        var _this = this;
        //Promise 를 사용
        this.racingDataService.getCarPartsPromise().then(function (data) { return _this.carParts = data; });
    };
    CarPartsComponent.prototype.upQuantity = function (carPart) {
        //alert("증가버튼 클릭" + value);
        if (carPart.inStock > carPart.quantity) {
            carPart.quantity++;
        }
    };
    CarPartsComponent.prototype.downQuantity = function (carPart) {
        if (carPart.quantity != 0)
            carPart.quantity--;
    };
    CarPartsComponent.prototype.totalCarParts = function () {
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
        if (Array.isArray(this.carParts)) {
            return this.carParts.reduce(function (prev, curr) { return prev + curr.inStock; }, 0);
        }
    };
    CarPartsComponent = __decorate([
        core_1.Component({
            selector: 'car-parts',
            templateUrl: 'app/car-part/car-parts.component.html',
            styleUrls: ['app/car-part/car-parts.component.css']
        }),
        __metadata("design:paramtypes", [racing_data_service_1.RacingDataService])
    ], CarPartsComponent);
    return CarPartsComponent;
}());
exports.CarPartsComponent = CarPartsComponent;
//# sourceMappingURL=car-parts.component.js.map