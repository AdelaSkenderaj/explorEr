document.addEventListener("DOMContentLoaded", function() {
    //Select all the buttons in the page
    const buttons = document.querySelectorAll("button");
    
    //Add an event listener for said buttons
    buttons.forEach(button => {
        button.addEventListener("click", getBlogIdExport)
        });
      });

    //This 
    function getBlogIdExport(){
        let blogId = parseInt(this.value)
        localStorage.setItem('blogId', blogId)
    }

  