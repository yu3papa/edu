/**
 * Created by 206-001 on 2017-05-30.
 */
import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {AppComponent} from "./app.component";
import {RacingDataService} from "./car-part/racing-data.service";
import {AboutComponent} from "./about.component";
import {AppRoutingModule} from "./app-routing.module";
import {RaceService} from "./car-race/race.service";
import {RacesComponent} from "./car-race/races.component";
import {CarPartModule} from "./car-part/car-part.module";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
    declarations:[AppComponent,
                AboutComponent,
                RacesComponent],

    imports:[BrowserModule,
        FormsModule,
        HttpClientModule,
        AppRoutingModule,
        ReactiveFormsModule,
        CarPartModule],

    bootstrap:[AppComponent],

    providers:[RacingDataService,RaceService]
})
export class AppModule {
}
