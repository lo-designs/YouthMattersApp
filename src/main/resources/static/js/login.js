let loginEmail = document.getElementById("email");
let loginPassword = document.getElementById("password");
let loginForm = document.getElementById("login-form");

loginForm.addEventListener("submit", function (e){
    e.preventDefault();

    if(loginEmail.value === "admin@test.com" && loginPassword.value === "pass123") {
        alert("You logged in successfully");
    } else {
        alert("Wrong username/password");
    }
})