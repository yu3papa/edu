"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var common_1 = require("@angular/common");
var car_parts_component_1 = require("./car-parts.component");
var car_part_form_component_1 = require("./car-part-form.component");
var reverse_str_pipe_1 = require("../shared/reverse-str.pipe");
var underline_directive_1 = require("../shared/underline.directive");
var forms_1 = require("@angular/forms");
var CarPartModule = (function () {
    function CarPartModule() {
    }
    CarPartModule = __decorate([
        core_1.NgModule({
            imports: [common_1.CommonModule, forms_1.FormsModule],
            declarations: [car_parts_component_1.CarPartsComponent,
                car_part_form_component_1.CarPartFormComponent,
                reverse_str_pipe_1.ReverseStrPipe,
                underline_directive_1.UnderlineDirective],
            exports: [car_parts_component_1.CarPartsComponent,
                car_part_form_component_1.CarPartFormComponent,
                reverse_str_pipe_1.ReverseStrPipe,
                underline_directive_1.UnderlineDirective]
        })
    ], CarPartModule);
    return CarPartModule;
}());
exports.CarPartModule = CarPartModule;
//# sourceMappingURL=car-part.module.js.map