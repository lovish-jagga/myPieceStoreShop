const signinModal=document.getElementById('signin-modal');
const loginModal=document.querySelector('#login-modal');
const signInIconButton=document.querySelector('#signUp');
const logInIconButton=document.querySelector('#logIn');
const closeIcon=document.getElementById('closeIcon');
const closeIcon__login=document.querySelector('#closeIcon__login');
const alreadyHaveAccount=document.getElementById('alreadyHaveAccount');
const toRegisterNewAccount=document.querySelector('#toRegisterNewAccount');
const closedIcon__price=document.querySelector('#closedIcon__price')
function modalOpener()
{
	console.log('here');
	if(loginModal.classList.contains('invisible'))
	{	
		loginModal.classList.remove('invisible');
		loginModal.classList.add("visible");
	}
	else
	{
		signinModal.classList.remove('invisible');
		signinModal.classList.add("visible");
	}
}
function modalOpenerAndCloser()
{
	if(signinModal.classList.contains('visible'))
	{	
		signinModal.classList.remove('visible')
		signinModal.classList.add("invisible");
		if(loginModal.classList.contains('invisible'))
		{
			loginModal.classList.remove('invisible')
			loginModal.classList.add("visible");
		}
	}

	else if(loginModal.classList.contains('visible'))
		{
		loginModal.classList.remove('visible')
		loginModal.classList.add("invisible");
		if(signinModal.classList.contains('invisible'))
		{
			signinModal.classList.remove('invisible')
			signinModal.classList.add("visible");
		}
		
		}
}
function modalCloser()
{
	if(loginModal.classList.contains('visible'))
	{	
		loginModal.classList.remove('visible');
		loginModal.classList.add("invisible");
	}
	else
	{
		signinModal.classList.remove('visible');
		signinModal.classList.add("invisible");
	
	}

}

closeIcon__login.addEventListener('click',modalCloser);
closeIcon.addEventListener('click',modalCloser)

signInIconButton.addEventListener('click',(event)=>
{
//	const currentEvent=event.currentTarget.closest('span').class;
	const currentEvent=event.currentTarget.class;
	if(event.currentTarget.classList.contains('signUp'))
	{
		signinModal.classList.remove('invisible');
		signinModal.classList.add("visible");			
	}	
});

//bind can also be used here as a substitute
logInIconButton.addEventListener('click',(event)=>
{
//	const currentEvent=event.currentTarget.closest('span').class;
	if(event.currentTarget.classList.contains('logIn'))
	{
		loginModal.classList.remove('invisible');
		loginModal.classList.add("visible");			
	}	
});

alreadyHaveAccount.addEventListener('click',modalOpenerAndCloser);
toRegisterNewAccount.addEventListener('click',modalOpenerAndCloser);

function myFunction() {
  var x = document.getElementById("createPassword");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}


let myInput = document.getElementById("createPassword");
let letter = document.getElementById("letter");
let capital = document.getElementById("capital");
let number = document.getElementById("number");
let length = document.getElementById("length");

myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

myInput.onkeyup = function() {
  let lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  let upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  let numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}

let login__submitModal=document.getElementById(login__submitModal);
login__submitModal.addEventListener('click',)
//let submitButton=document.getElementById('submitButton');
//submitButton.addEventListener('click',validatePassword);
//let password = document.getElementById('createPassword');
//let confirm_password = document.getElementById('repeatPassword');
	//function validatePassword() {
		//if (password.value != confirm_password.value) {
			//confirm_password.setCustomValidity('Passwords Don\'t Match');
//		} else {
	//		confirm_password.setCustomValidity('');
		//}
	//}
	//password.onchange = validatePassword;
	//confirm_password.onkeyup = validatePassword;
	
	
	const dashboard__name=document.getElementById('dashboard__name').value.toUpperCase();