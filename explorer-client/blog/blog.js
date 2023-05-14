  
const blogs = [
    {
      "id": 1,
      "title": "First Blog",
      "text": "This is the content of the first blog.",
      "author": "John Doe"
    },
    {
      "id": 2,
      "title": "Second Blog",
      "text": "This is the content of the second blog.",
      "author": "Jane Smith"
    }
  ];
  
    
  
  // Find the blog with the matching ID
  const blog = blogs.find(blog => blog.id === parseInt(localStorage.blogId));
  
    
  alert(blog.text)
    
    
  

