import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";

import {CarPartsComponent} from "./car-parts.component";
import {CarPartFormComponent} from "./car-part-form.component";
import {ReverseStrPipe} from "../shared/reverse-str.pipe";
import {UnderlineDirective} from "../shared/underline.directive";
import {FormsModule} from "@angular/forms";

@NgModule({
    imports:[CommonModule,FormsModule],
    declarations:[CarPartsComponent,
                  CarPartFormComponent,
                  ReverseStrPipe,
                  UnderlineDirective],
    exports:[CarPartsComponent,
        CarPartFormComponent,
        ReverseStrPipe,
        UnderlineDirective]

})
export class CarPartModule {

}
