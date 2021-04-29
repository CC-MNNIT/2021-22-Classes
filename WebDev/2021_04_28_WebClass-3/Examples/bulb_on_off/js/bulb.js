
console.log("Welcome to Bulb ON/OFF tutorial!");

var onButton = document.getElementById("buttonOn");
var offButton = document.getElementById('buttonOff');

function changeToBulbOff() {
	var bulb = document.getElementById('bulbImage');
	bulb.src = "./images/pic_bulboff.gif";
	onButton.disabled = false;
	offButton.disabled = true;
}

function changeToBulbOn() {
	var bulb = document.getElementById('bulbImage');
	bulb.src = "./images/pic_bulbon.gif";
	onButton.disabled = true;
	offButton.disabled = false;
}



// Method 1
offButton.onclick = changeToBulbOff;
onButton.onclick = changeToBulbOn;

// Method 2 - using Event Listener
/* offButton.addEventListener("click", changeToBulbOff);

						OR

	offButton.addEventListener("click", function() {
		var bulb = document.getElementById('bulbImage');
		bulb.src = "./images/pic_bulboff.gif";
		onButton.disabled = false;
		offButton.disabled = true;
	});

	onButton.addEventListener("click", changeToBulbOn);

						OR

	onButton.addEventListener("click", function() {
		var bulb = document.getElementById('bulbImage');
		bulb.src = "./images/pic_bulbon.gif";
		onButton.disabled = true;
		offButton.disabled = false;
	});		
*/

// Method 3
// offButton.onclick = function() {
// 	var bulb = document.getElementById('bulbImage');
// 	bulb.src = "./images/pic_bulboff.gif";
// 	onButton.disabled = false;
// 	offButton.disabled = true;
// }

// onButton.onclick = function() {
// 	var bulb = document.getElementById('bulbImage');
// 	bulb.src = "./images/pic_bulbon.gif";
// 	onButton.disabled = true;
// 	offButton.disabled = false;
// }


/*
	Wrong Way of doing things

	Wrong Method 1
	offButton.onclick = changeToBulbOff();  --> Parenthesis should NOT be used with function name

	Wrong Method 2
	offButton.addEventListener("click", changeToBulbOff());
*/

