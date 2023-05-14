document.addEventListener("DOMContentLoaded", function() {
    
    const buttons = document.querySelectorAll("button");

    buttons.forEach(button => {
        button.addEventListener("click", getBlogIdExport)
        });
      });

    
    function getBlogIdExport(){
        let blogId = parseInt(this.value)
        localStorage.setItem('blogId', blogId)
    }

  