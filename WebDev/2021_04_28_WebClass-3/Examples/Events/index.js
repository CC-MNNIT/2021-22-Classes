// function checkUsername() {
//   console.log("CheckUsername Fired");

//   var elMsg = document .getElementById('feedback') ;
//   // Get feedback element
//   var elUsername = document.getElementById('username'); // Get username input
//   if (elUsername.value.length < 5) {
//     elMsg.textContent ='Username must be 5 characters or more'; // Set Msg
//   } else {
//   //Otherwise
//     elMsg.textContent = ''; // Clear Message
//   }
// }

//! Method 2 : Traditional DOM Event Handlers
// function checkUsername() {

//   var elMsg = document .getElementById('feedback') ;
  
//   if (this.value.length < 5) {
//     elMsg.textContent ='Username must be 5 characters or more';
//   } else {
//     elMsg.textContent = '';
//   }
// }

// var ele = document.getElementById("username");
// ele.onblur = checkUsername;

//! Method 3: Event Listeners

// function checkUsername() {

//   var elMsg = document .getElementById('feedback') ;
  
//   if (this.value.length < 5) {
//     elMsg.textContent ='Username must be 5 characters or more';
//   } else {
//     elMsg.textContent = '';
//   }
// }

// var el = document.getElementById("username");
// el.addEventListener("blur", checkUsername, false);


// ! EVENT DELEGATION

const cateogry = document.getElementById("category");
cateogry.addEventListener("click", (e) => {
  console.log(e.target);
  console.log(e.target.id);
  console.log(e.currentTarget);
});