const form = document.getElementById("form");
let dob = document.getElementById("dob");
let age = document.getElementById("age");
const Name = document.getElementById("name");

window.onload = function () {
  form.addEventListener("submit", function (e) {
    e.preventDefault();
    age.value = "";
    if (/[0-9]/.test(Name.value)) {
      alert("Name should be only in alphabets");
      return;
    }
    if (!/^[0-9]{2}\/[0-9]{2}\/[0-9]{4}$/.test(dob.value)) {
      alert("Date should be in the format dd/mm/yyyy");
      return;
    }
    const year = new Date().getFullYear() * 1;
    const birthYear = dob.value.split("/")[2] * 1;
    const Age = year - birthYear;
    console.log(year, birthYear, Age);

    age.value = Age;
  });
};
