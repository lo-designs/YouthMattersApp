let registerfirstName = document.getElementById("firstName");
let registerlastName = document.getElementById("lastName")
let registeremail = document.getElementById("email");

let registerpassword = document.getElementById("password");
let registerage = document.getElementById("age");
let registerzipCode = document.getElementById("zipCode");
let registerinvalidCheck = document.getElementById("invalidCheck");
let registersignupForm = document.getElementById("signupForm");

registersignupForm.addEventListener("submit", function(e)  {
    e.preventDefault();
    console.log(registeremail);
    if(registerfirstName.value && registerlastName.value && registeremail.value && registerpassword.value && registerage.value && registerzipCode.value && registerinvalidCheck.checked) {
        window.location.href="register";
    } else {
        alert("please fill out all fields")
    }
} )