document.addEventListener('DOMContentLoaded', function () {


    // Importing the blogs
    const blogs = [

        {
            id: 2,
            tags: [
                "foreign language",
                "language learning",
                "personal growth",
                "cognitive abilities",
                "career prospects",
                "cultural appreciation",
            ],
            title:
                "Embracing the Power of Learning Foreign Languages: Unlocking New Horizons",
            blogAuthorID: 1,
            blogImageUrl: "../images/foreignLang.jpg",
            date: "2023-05-12",
            text: "Introduction:\nLearning a foreign language is a transformative journey that opens doors to new worlds. In this blog, we explore the importance of language learning, highlighting its profound impact on personal growth, cognitive abilities, career prospects, and cultural appreciation.\n\nBody:\n1. Cognitive Benefits:\nLearning a foreign language enhances cognitive abilities. It sharpens critical thinking, improves memory, and boosts problem-solving skills. It exercises the brain, fostering mental flexibility and creativity. Additionally, bilingual individuals often display better multitasking abilities and improved decision-making skills.\n\n2. Communication and Connection:\nLanguage is the key to effective communication and deep connections. By learning a foreign language, we gain the ability to connect with people from diverse cultures and backgrounds. It breaks down barriers, fosters understanding, and cultivates empathy. Language becomes a bridge that enables us to build relationships, both personally and professionally.\n\n3. Career Advantages:\nProficiency in a foreign language expands career opportunities. In today's globalized world, businesses are seeking individuals with language skills to engage with international clients and partners. It opens doors to work abroad, collaborate in multicultural teams, and pursue international careers. Moreover, language skills demonstrate adaptability and cultural competence, making job candidates stand out in competitive markets.\n\n4. Cultural Appreciation:\nLearning a foreign language goes beyond vocabulary and grammar; it provides insights into diverse cultures. Language learning exposes us to literature, music, art, and traditions of different countries. We gain a deeper appreciation for cultural nuances, perspectives, and customs. It broadens our worldview, fostering respect and tolerance for cultural diversity.\n\nConclusion:\nIn essence, learning a foreign language is an enriching endeavor that enhances our lives in countless ways. It stimulates intellectual growth, facilitates meaningful connections, boosts career prospects, and promotes cultural understanding. By embracing the power of language, we embark on a lifelong journey of discovery, embracing new horizons and experiencing the beauty of global interconnectedness.\n\nRemember, whether you choose French, Spanish, Mandarin, or any other language, the benefits of learning a foreign language are vast and everlasting.",
        },

        {
            id: 4,
            title:
                "The Ultimate Guide to Making the Most of Your Erasmus Exchange Experience",
            tags: [
                "different cultures",
                "horizons",
                "preconceived notions",
                "biases",
                "open-mindedness",
                "empathy",
            ],
            blogAuthorID: 2,
            blogImageUrl: "../images/mostof.jpg",
            date: "2023-05-11",
            text: "Hey fellow Erasmus adventurers! Are you ready to embark on an unforgettable journey? As a student who has been through the Erasmus exchange experience, I'm here to share the ultimate guide on how to make the most of it.\n\nFirst things first, step out of your comfort zone! Embrace new cultures, try local cuisine, and make friends from around the world. It's an opportunity to broaden your horizons and challenge your perspectives.\n\nNext, immerse yourself in the local community. Learn the language, participate in cultural events, and volunteer. It's the perfect way to connect with locals and truly experience their way of life.\n\nDon't forget about academics! Take advantage of the diverse courses, engage with professors, and delve into research opportunities. Erasmus is not just about fun; it's about academic growth too.\n\nLastly, document your journey. Capture memories through photos, keep a journal, or even start a blog. Sharing your experiences will not only preserve precious moments but also inspire others.\n\nSo, fellow Erasmus explorers, get ready to make lifelong memories, embrace new cultures, and become a global citizen. Your Erasmus exchange is waiting to be an extraordinary adventure!",
        },

        {
            id: 6,
            title:
                "Budgeting Tips for a Thriving Erasmus Experience. A complete guide.",
            tags: [
                "Erasmus exchange",
                "sense of belonging",
                "power of connections",
                "host city exploration",
                "stay connected with roots",
                "cozy living space",
            ],
            blogAuthorID: 3,
            blogImageUrl: "../images/belonging.png",
            date: "2023-05-3",
            text: "Embarking on an Erasmus adventure is an exciting opportunity, but managing your finances effectively is crucial for a smooth and enjoyable experience. Here are some budgeting tips to make the most of your time abroad.\n\nFirst, create a realistic budget by outlining your expected expenses and income sources. Research the cost of living in your host country and prioritize your spending. Look for affordable accommodation options, cook meals at home, and take advantage of student discounts.\n\nSave money on transportation by opting for public transit or walking. Explore local markets for fresh produce and groceries instead of dining out frequently. Engage in free or low-cost activities, such as exploring parks, attending cultural events, and joining student organizations.\n\nKeep track of your expenses using mobile apps or spreadsheets to monitor your spending habits. Lastly, consider part-time work or applying for scholarships to supplement your income.\n\nBy adopting these budgeting strategies, you can ensure a financially sound Erasmus journey while still having incredible experiences, making lifelong friendships, and immersing yourself in a new culture."


        },
    ];

    const authorsList = [
        {
            id: 1,
            name: "Emma Smith",
            age: 21,
            university: "University of Manchester",
            exchangeProgram: "Erasmus",
            description:
                "Emma is an adventurous and curious student studying International Relations at the University of Manchester. With a passion for exploring new cultures and embracing diverse perspectives, she embarked on an Erasmus exchange program to broaden her horizons and gain valuable international experience.",
        },
        {
            id: 2,
            name: "Alejandro López",
            age: 20,
            university: "Universidad de Buenos Aires",
            exchangeProgram: "Study Abroad Program",
            description:
                "Alejandro is a dynamic and ambitious student pursuing a degree in Economics at the Universidad de Buenos Aires. As part of his study abroad program, he ventured beyond his home country's borders to immerse himself in different academic systems and enhance his understanding of global economic dynamics.",
        },
        {
            id: 3,
            name: "Sofia Müller",
            age: 22,
            university: "Technische Universität München",
            exchangeProgram: "Erasmus+",
            description:
                "Sofia is a passionate and innovative student studying Mechanical Engineering at Technische Universität München. With a thirst for knowledge and a desire to embrace cultural diversity, she joined the Erasmus+ program to experience cutting-edge research facilities, collaborate with international peers, and expand her engineering expertise.",
        },
    ];

    for (let elem of blogs) {

        var div = document.createElement("div"); // create the div that will serve as the holder 
        div.classList.add("col-md-3", "m-1");    // add the required classes for the div to be displayed correctly


        //Finding the author of the current blog
        const authorCurrBlog = authorsList.find((author) => author.id === elem.blogAuthorID).name;

        const date = new Date(elem.date);
        const month = date.getMonth(); // Month is integer based so it must be converted to a string

        const monthNames = [ // Converting month to a string
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December",
        ];
        const monthString = monthNames[month];

        // Creating the div and filling it with the appropriate data
        div.innerHTML = `
     <div class="img-container">
       <img src=${elem.blogImageUrl} alt="Students sitting together">
       <div class="text-overlay">
         <strong class="number" data-value="${date.getDate
            }">${date.getDate()}</strong>
         <span>${monthString}</span>
         <span>${date.getFullYear()}</span>
       </div>
     </div>
     <div class="blogText">
       <h1>${authorCurrBlog}</h1>
       <span>${elem.title}</span>
     </div>
     <div>
       <a href="../blog/blog.html">
         <button class="blog-button" value="${elem.id}">Go to Blog</button>
       </a>
     </div>
     `;

        var parentElement = document.getElementsByClassName("blogHolder")[0];
        parentElement.appendChild(div);

    }

    //Select all the buttons in the page
    const buttons = document.querySelectorAll(".blog-button");
    buttons.forEach((button) => {
        button.addEventListener("click", getBlogIdExport);
    });

    //Places the id on the local storage so it can be used at ../blog/blog.js to display the corret blog
    function getBlogIdExport() {
        let blogId = parseInt(this.value);
        localStorage.setItem("blogId", blogId);
    }

});
