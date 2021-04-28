/*
    DOM Manipulation
*/

// Selecting Label from DOM
const label = document.getElementById('id_item_label');
console.log(label.innerHTML);

label.style.color = 'blue';
label.style.fontSize = '20px';
label.style.textDecoration = 'underline';

// Selecting Input from DOM
const input = document.getElementById('id_input');
// input.value  = "Item-1";
input.placeholder  = "Type Item Name Here...";


// Selecting Button from DOM
const button = document.querySelector('button');
console.log(button);

// Selecting List from DOM
const list = document.querySelector('ul');
// const list = document.getElementsByTagName('ul')[0];
// const list = document.getElementsByClassName('class_list')[0];
console.log(list)


button.onclick = function() {
    let itemInputValue = input.value;
    input.value = '';

    const listItem = document.createElement('li'); console.log(listItem);
    const listText = document.createElement('span'); console.log(listText);
    const listBtn = document.createElement('button'); console.log(listBtn);

    listItem.appendChild(listText);
    listText.textContent = itemInputValue;
    listItem.appendChild(listBtn);
    listBtn.textContent = 'Delete';

    list.appendChild(listItem);

    listBtn.onclick = function() {
        console.log(itemInputValue);
        console.log(listItem);
        console.log(listBtn);
        list.removeChild(listItem);
    }

    input.focus();
}

