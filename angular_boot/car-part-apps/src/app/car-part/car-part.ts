/**
 * Created by 206-001 on 2017-05-30.
 */
//Model class
export class CarPart {
    id:number;
    name:string;
    description:string;
    price:number;
    inStock:number;
    image:string;
    featured:boolean;
    quantity:0;

    toString() {
      return 'id :' + this.id + ' name :' + this.name + ' desc :' + this.description +
        ' price :' + this.price + ' inStock :'+ this.inStock + ' image :'+this.image +
        ' features :' + this.featured + ' quantity :' + this.quantity;
    }
}
