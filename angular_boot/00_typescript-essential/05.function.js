/**
 * Created by vega on 2017-05-29.
 */
var myArr = [1, 2, 3];
myArr = myArr.map(function (item) {
    return item * 2;
});
console.log(myArr);
// myArr = myArr.map(item => item * 2);
// console.log(myArr);
// myAdd has the full function type
var myAdd = function (x, y) { return x + y; };
// The parameters 'x' and 'y' have the type number
var myAdd2 = function (x, y) { return x + y; };
//Optional and Default Parameters
function buildName(firstName, lastName) {
    if (lastName)
        return firstName + " " + lastName;
    else
        return firstName;
}
var result1 = buildName("Bob"); // works correctly now
//let result2 = buildName("Bob", "Adams", "Sr.");  // error, too many parameters
var result3 = buildName("Bob", "Adams"); // ah, just right
