/**
 * Created by vega on 2017-05-29.
 */
let myArr = [1,2,3];

myArr = myArr.map(function (item) {
    return item * 2;
});
console.log(myArr);

// myArr = myArr.map(item => item * 2);
// console.log(myArr);

// myAdd has the full function type
let myAdd = function(x: number, y: number): number { return  x + y; };

// The parameters 'x' and 'y' have the type number
let myAdd2: (baseValue:number, increment:number) => number =
    function(x, y) { return x + y; };

//Optional and Default Parameters
function buildName(firstName: string, lastName?: string) {
    if (lastName)
        return firstName + " " + lastName;
    else
        return firstName;
}

let result1 = buildName("Bob");                  // works correctly now
//let result2 = buildName("Bob", "Adams", "Sr.");  // error, too many parameters
let result3 = buildName("Bob", "Adams");         // ah, just right