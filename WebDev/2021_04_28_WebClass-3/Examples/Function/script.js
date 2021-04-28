/*
    Functions
*/

/* Normal Functions */

function hello1(name){
    console.log("hello1 to", name);
}

hello1("Aman");
console.log(typeof(hello1)); // function

/* Anonymous Functions: Functions without name */

const hello2 = function (name){
    console.log("hello2 to", name);
}
hello2("Harshit");
console.log(typeof(hello2));



/* Arrow Functions */
const hello3 = (name) => {
    console.log("hello3 to", name);
}

hello3("Kshitiz");
console.log(typeof(hello3));

/* Single Statement Arrow Functions: returns the output of statement */
const smallerHello3 = (name) => console.log("smallerHello3 to", name);

smallerHello3("Ankit");
console.log(typeof(smallerHello3));