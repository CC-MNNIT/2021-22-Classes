
console.log("Welcome to Bulb ON/OFF tutorial!");

var onButton = document.getElementById("buttonOn");
var offButton = document.getElementById('buttonOff');

function changeToBulbOff() {
	var bulb = document.getElementById('bulbImage');
	bulb.src = "./images/pic_bulboff.gif";
	onButton.disabled = false;
	offButton.disabled = true;
}

onButton.onclick = function() {
	console.log("Bulb on clicked");
	var bulb = document.getElementById('bulbImage');
	bulb.src = "./images/pic_bulbon.gif";
	onButton.disabled = true;
	offButton.disabled = false;
}

// Method 1
offButton.onclick = changeToBulbOff;

// Method 2
offButton.addEventListener("click", changeToBulbOff);

// Method 3
offButton.onclick = function() {
	var bulb = document.getElementById('bulbImage');
	bulb.src = "./images/pic_bulboff.gif";
	onButton.disabled = false;
	offButton.disabled = true;
}

/*
	Wrong Way of doing things

	Wrong Method 1
	offButton.onclick = changeToBulbOff();

	Wrong Method 2
	offButton.addEventListener("click", changeToBulbOff());
*/

