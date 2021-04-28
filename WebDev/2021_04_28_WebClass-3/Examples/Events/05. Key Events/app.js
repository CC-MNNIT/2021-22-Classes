// keypress - when key is pressed
// keydown - when key is down
// keyup - when key is released

const nameInput = document.getElementById('name');

// nameInput.addEventListener('keypress', function() {
//   console.log('you pressed a key');
// });
// nameInput.addEventListener('keydown', function() {
//   console.log('you pressed a key');
// });
nameInput.addEventListener('keyup', function() {
  console.log(nameInput.value);
});
