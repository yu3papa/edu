import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";

import {AboutComponent} from "./about.component";
import {CarPartsComponent} from "./car-part/car-parts.component";
import {RacesComponent} from "./car-race/races.component";
import {CarPartFormComponent} from "./car-part/car-part-form.component";

export const routes : Routes = [
    {path:'', component:AboutComponent},
    {path:'carpart', component:CarPartsComponent},
    {path:'carrace', component:RacesComponent},
    {path:'carpartForm', component:CarPartFormComponent}
];

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
})
export class AppRoutingModule {

}