
/* Global Scope */

var ax = 15; 
let ay = 16; // Not-Actually Global as not associated with window object. But can be used inside any block/function.
const az = 17; // Not-Actually Global as not associated with window object. But can be used inside any block/function.

no_name = "un-named"

console.log("Value of x is:", ax);
console.log("Value of y is:", ay);
console.log("Value of z is:", az);

function hello(){
    console.log("Hello World.")
}
hello();

/*  Local Scope */

// function hello(){
//     // Local Scope.
//     var x = 15; 
//     let y = 16;
//     const z = 17;
//     console.log("Value of x is:", x);
//     console.log("Value of y is:", y);
//     console.log("Value of z is:", z);
// }

// hello();

// // x,y,z are not-defined outside of hello function.
// console.log("Value of x is:", x);
// console.log("Value of y is:", y);
// console.log("Value of z is:", z);



/* Block Scope */

// {
//     var x = 15; 
//     let y = 16;
//     const z = 17;
//     console.log("Value of x is:", x);
//     console.log("Value of y is:", y);
//     console.log("Value of z is:", z);
// }


// // As x has a 'var' declaration hence it is visible outside the block also.
// console.log("Value of x is:", x);

// // y,z are not-defined outside of hello function.
// console.log("Value of y is:", y);
// console.log("Value of z is:", z);

