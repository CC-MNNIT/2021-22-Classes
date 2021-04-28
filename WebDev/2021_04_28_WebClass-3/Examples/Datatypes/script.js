/*
    Primitive Dataypes
*/

var num;
num = 10; 
console.log(num, typeof(num));

num = 10.2;
console.log(num, typeof(num));


var b = true
console.log(b, typeof(b));

var str = "Hello JavaScript";
console.log(str, typeof(str));

var x = undefined;
console.log(x, typeof(x));

var obj = null;
console.log(obj, typeof(obj));


console.log(`We have following Primitive Data: ${num}, ${b}, ${str}, ${x}, ${obj}`);


/* Objects */

var laptop = new Object();

console.log(obj)

laptop.weight = "2kg"
console.log(laptop.weight, laptop['weight'])

var person = {
    name: 'ABC',
    age: '30',
    books_written: 2,
}

var book = {
    'pages': 300,
    'price': 'Rs. 2000',
    'is_available': true,
    'author': person,
    'show_name': function(){
        console.log("Name of the book is XYZ");
    }
} 

console.log("Book has following Properties:-")
for (prop in book){
    console.log(prop, "=>", book[prop]);
}

book.show_name();



/* Arrays */

var arr = [1, 2, "hello", false]
console.log(arr);
console.log("Length of array is:", arr.length);
console.log("Element at index 2 is: ", arr[2]);

/* General Operations:
    
push() => To add element at the end
pop() => remove from end
shift() => remove from begining.
indexOf(element) => to get index of an existing element.
splice(index, 1) => remove 1 item present at index position. It returns the removed item.

*/

