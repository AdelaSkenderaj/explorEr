

//check if at least one option from the checkbox is choosed
function validateForm() {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    var isChecked = false;
    for (var i = 0; i < checkboxes.length; i++) {
      if (checkboxes[i].checked) {
        isChecked = true;
        break;
      }
    }
    if (!isChecked) {
      alert("Please select at least one option.");
      return false;
    }
    return true;
  }


  //controlli njevlefshmerie passwordi

  function validateForm() {
    var password = document.getElementById("psw").value;
    var confirm_password = document.getElementById("confirm").value;
    
    if (password == "") {
      alert("Please enter a password.");
      return false;
    }
    
    if (password != confirm_password) {
      alert("Passwords do not match.");
      return false;
    }
    
    return true;
  }