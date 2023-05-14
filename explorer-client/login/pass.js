$(".toggle-password").click(function(){
    $(this).toggleClass("fa-eye fa-eye-slash")
    var input = $($(this).attr("toggle"));

    if(input.attr("type")=="password"){
        input.attr("type","text");
    
    } else {
        input.attr("type","password");
    }

});

//validation-box

var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

//validation box on click
myInput.onfocus=function(){
    document.getElementById("validation_box").style.display="block";

}

//hide the validation box autside the password field;
myInput.onblur=function(){
    document.getElementById("validation_box").style.display="none";
}

//when the user start to type sth inside the pass field
myInput.onkeyup=function(){

    //validation for lowercase
    var lowerCaseLetter= /[a-z]/g;

    if(myInput.value.match(lowerCaseLetter)){
        letter.classList.remove("invalid");
        letter.classList.add("valid");
    }else{
        letter.classList.remove("valid");
         letter.classList.add("invalid");
    }

    //var uppercase
    var upperCaseLetter= /[A-Z]/g;

    if(myInput.value.match(upperCaseLetter)){
        capital.classList.remove("invalid");
        capital.classList.add("valid");
    }else{
        capital.classList.remove("valid");
        capital.classList.add("invalid");
    }

    // var number 
    var number = /[0-9]/g;

    if(myInput.value.match(number)){
        number.classList.remove("invalid");
        number.classList.add("valid");
    }else{
        number.classList.remove("valid");
        number.classList.add("invalid");
    }


//validation for length
if(myInput.value.length >= 8){
    length.classList.remove("invalid");
    length.classList.add("valid");
}else{
    length.classList.remove("valid");
    length.classList.add("invalid");
}

} 
