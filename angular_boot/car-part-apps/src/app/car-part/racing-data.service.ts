import {Injectable} from "@angular/core";
import {Http,Response} from "@angular/http";

import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import "rxjs/add/observable/throw";
import "rxjs/add/operator/toPromise";

import {CarPart} from "./car-part";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class RacingDataService {
    constructor(private http:HttpClient){}

    // getCarPartsPromise() {
    //     return this.http.get('app/car-part/car-parts.json')
    //         .toPromise()
    //         .then(res => <CarPart[]> res.json().data)
    //         .catch(resError => console.log(resError));
    // }


    getCarParts():Observable<any> {
        let jsonData = this.http.get('assets/car-parts.json',{responseType: 'json'});
        jsonData.subscribe(function(data){
          console.log(data);
           console.log(data['data']);
        });

      return this.http.get('assets/car-parts.json',{responseType: 'json'});
      //  return this.http.get('http://127.0.0.1:52274/products',{responseType: 'json'});
    }//getCarParts()

  public createProduct(carPart:CarPart):Observable<any> {
      alert(carPart);
    return this.http.post("http://127.0.0.1:52274/products", carPart);
  }

    private handleError(resError:Response) {
        console.log(resError);
        alert(resError.toString());
        return Observable.throw(resError.json().error);
    }


}
