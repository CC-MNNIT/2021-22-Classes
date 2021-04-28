const heading = document.querySelector('h2');
const btn = document.querySelector('.btn');
const text = document.querySelector('p');

text.addEventListener('mouseenter', function() {
  heading.classList.add('red');
});
text.addEventListener('mouseleave', function() {
  heading.classList.remove('red');
});
btn.addEventListener('click', function() {
  if (heading.classList.contains('blue')) {
    heading.classList.remove('blue');
  } else {
    heading.classList.add('blue');
  }
});
