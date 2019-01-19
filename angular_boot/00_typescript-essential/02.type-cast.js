/**
 * Created by vega on 2017-05-28.
 */
var Color;
(function (Color) {
    Color[Color["Red"] = 1] = "Red";
    Color[Color["Green"] = 2] = "Green";
    Color[Color["Blue"] = 3] = "Blue";
})(Color || (Color = {}));
var colorName = Color[2];
console.log(colorName);
var someValue = "this is a string";
//let strLength: number = (<string>someValue).length
var strLength = someValue.length;
console.log(strLength);
