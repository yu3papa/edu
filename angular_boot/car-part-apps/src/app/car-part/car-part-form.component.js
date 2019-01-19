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
var router_1 = require("@angular/router");
var forms_1 = require("@angular/forms");
var CarPartFormComponent = (function () {
    function CarPartFormComponent(_formBuilder, router) {
        this._formBuilder = _formBuilder;
        this.router = router;
        this.carPartForm = _formBuilder.group({
            id: new forms_1.FormControl('', forms_1.Validators.required),
            name: new forms_1.FormControl('', forms_1.Validators.required),
            description: new forms_1.FormControl('', forms_1.Validators.required),
            price: new forms_1.FormControl('', forms_1.Validators.compose([forms_1.Validators.required,
                forms_1.Validators.pattern('[0-9]')])),
            quantity: new forms_1.FormControl('', forms_1.Validators.required)
        });
    }
    CarPartFormComponent.prototype.onSubmit = function (f) {
        console.log(f);
        // let formData = f.value as CarPart;
        // console.log(formData);
        // this.router.navigate(['/carpart']);
    };
    CarPartFormComponent = __decorate([
        core_1.Component({
            selector: 'car-part-form',
            templateUrl: './app/car-part/car-part-form.component1.html',
            styleUrls: ['app/car-part/car-parts.component.css']
        }),
        __metadata("design:paramtypes", [typeof (_a = typeof forms_1.FormBuilder !== "undefined" && forms_1.FormBuilder) === "function" && _a || Object, typeof (_b = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _b || Object])
    ], CarPartFormComponent);
    return CarPartFormComponent;
    var _a, _b;
}());
exports.CarPartFormComponent = CarPartFormComponent;
//# sourceMappingURL=car-part-form.component.js.map