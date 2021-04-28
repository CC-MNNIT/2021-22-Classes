
// ! EVENT DELEGATION

// const cateogry = document.getElementById("category");
// cateogry.addEventListener("click", (e) => {
//   console.log(e.target);
//   console.log(e.target.id);
//   console.log(e.currentTarget);
// });

const lists = document.querySelectorAll("#category>li");
console.log(lists);

lists.forEach(list => {
  list.addEventListener("click", (e) => {
    console.log("LISTS")
    console.log(e.target);
  })
})