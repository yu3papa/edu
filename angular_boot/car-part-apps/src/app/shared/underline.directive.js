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
/**
 * Created by vega on 2017-03-29.
 */
var core_1 = require("@angular/core");
var UnderlineDirective = (function () {
    function UnderlineDirective(renderer, el) {
        this.renderer = renderer;
        this.el = el;
    }
    // Event listeners for element hosting
    // the directive
    UnderlineDirective.prototype.onMouseEnter = function () {
        this.hover(true);
    };
    UnderlineDirective.prototype.onMouseLeave = function () {
        this.hover(false);
    };
    // Event method to be called on mouse enter and on mouse leave
    UnderlineDirective.prototype.hover = function (shouldUnderline) {
        if (shouldUnderline) {
            // Mouse enter
            this.renderer.setElementStyle(this.el.nativeElement, 'text-decoration', 'underline');
            this.el.nativeElement.style.color = this.color;
        }
        else {
            // Mouse leave
            this.renderer.setElementStyle(this.el.nativeElement, 'text-decoration', 'none');
            this.el.nativeElement.style.color = "white";
        }
    };
    __decorate([
        core_1.Input('myUnderline'),
        __metadata("design:type", Object)
    ], UnderlineDirective.prototype, "color", void 0);
    __decorate([
        core_1.HostListener('mouseenter'),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], UnderlineDirective.prototype, "onMouseEnter", null);
    __decorate([
        core_1.HostListener('mouseleave'),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", []),
        __metadata("design:returntype", void 0)
    ], UnderlineDirective.prototype, "onMouseLeave", null);
    UnderlineDirective = __decorate([
        core_1.Directive({
            selector: '[myUnderline]'
        }),
        __metadata("design:paramtypes", [typeof (_a = typeof core_1.Renderer !== "undefined" && core_1.Renderer) === "function" && _a || Object, typeof (_b = typeof core_1.ElementRef !== "undefined" && core_1.ElementRef) === "function" && _b || Object])
    ], UnderlineDirective);
    return UnderlineDirective;
    var _a, _b;
}());
exports.UnderlineDirective = UnderlineDirective;
//# sourceMappingURL=underline.directive.js.map