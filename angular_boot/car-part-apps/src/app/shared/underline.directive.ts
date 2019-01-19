/**
 * Created by vega on 2017-03-29.
 */
import {Directive, HostListener, Renderer, ElementRef, Input} from '@angular/core';

@Directive({
    selector: '[myUnderline]'
})
export class UnderlineDirective{
    @Input('myUnderline') color;

    constructor(
        private renderer: Renderer,
        private el: ElementRef
    ){}
    // Event listeners for element hosting
    // the directive
    @HostListener('mouseenter')
    onMouseEnter() {
        this.hover(true);
    }

    @HostListener('mouseleave')
    onMouseLeave() {
        this.hover(false);
    }
    // Event method to be called on mouse enter and on mouse leave
    hover(shouldUnderline: boolean){
        if(shouldUnderline){
            // Mouse enter
            this.renderer.setElementStyle(this.el.nativeElement, 'text-decoration', 'underline');
            this.el.nativeElement.style.color=this.color;
        } else {
            // Mouse leave
            this.renderer.setElementStyle(this.el.nativeElement, 'text-decoration', 'none');
            this.el.nativeElement.style.color="white";
        }
    }
}