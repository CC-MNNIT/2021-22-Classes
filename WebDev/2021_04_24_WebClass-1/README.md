# Web Development Class - I

## Web Development Class - I recording: [Here](https://drive.google.com/file/d/1Ft_p_FqsyfswjIY3PaEn5tXWtgWFdvRc/view?usp=sharing)

#### April 24, 2021

<div align="center"><img src="./images/frontend.jpg" alt="Frontend" height=150/></div>

<hr>


<div align="center"><h2>HTML</h2></div>

*	### What is HTML?
	* HTML stands for **Hyper Text Markup Language**.
	* HTML is used to create web pages and web applications.
	* We can create a static website by HTML only.
	* Technically, HTML is a **Markup language** (helps to format the overall view of a page and the data it contains) rather than a programming language.


*	### Basic Structure of HTML file
	* `<!DOCTYPE html>` tag indicates **HTML 5** document.
	* `<html>` tag is the container for all other HTML elements (except `<!DOCTYPE html>`).
	* The `<head>` element is a container for metadata (data about data) and is placed between the `<html>` tag and the `<body>` tag.
	* Metadata typically define the document title, character set, styles, scripts, and other meta information.
	* The `<body>` element contains all the contents of an HTML document, such as headings, paragraphs, images, hyperlinks, tables, lists, etc.

	#### [1.html](./1.html)
	```html
	<!DOCTYPE html>
	<html>
	   <head>
	      <title>This is document title</title>
	   </head>	
	   <body>
	      <h1>This is a heading</h1>
	      <p>Hello World!</p>
	   </body>	
	</html>
	```

*	### HTML Tags
	* HTML tags are like keywords which defines that how web browser will format and display the content.
	* With the help of tags, a web browser can distinguish between an HTML content and a simple content.
	* *Generally*, HTML tags contain three main parts: **opening tag**, **content** and **closing tag**.
	* *Example*:
	```html
	<p> This is an HTML tutorial </p>
	```
	* Some tags need not be closed. Example: `<br>`, `<hr>`, etc.
	* Some **attributes** are present in each tag which define properties of that tag.

*	### HTML Heading
	* There are **six** different HTML headings which are defined with the `<h1>` to `<h6>` tags.
	* **h1** is the largest heading tag and **h6** is the smallest one.

*	### HTML Paragraph
	* HTML **paragraph** or HTML **p** tag is used to define a paragraph in a webpage.
	* A browser itself adds an empty line before and after a paragraph.

*	### HTML Anchor
	* The HTML anchor tag defines a **hyperlink** that *links one page to another page*.
	* It can create hyperlink to other web page as well as files, location, or any URL.
	*	#### href attribute
		* It stands for **Hypertext REFerence**.
		* Address of file is given here.

	#### [2.html](./2.html)
	```html
	<!DOCTYPE html>
	<html>
	   <head>
	      <title>Heading, Paragraph and Hyperlink demo</title>
	   </head>	
	   <body>
	      <h1>This is heading 1</h1>
	      <h2>This is heading 2</h2>
	      <h3>This is heading 3</h3>
	      <h4>This is heading 4</h4>
	      <h5>This is heading 5</h5>
	      <h6>This is heading 6</h6>
	      <h1> This is again Heading 1 and you will find a few paragraphs below</h1>
	      <p>This is first paragraph.</p>
	      <p>This is second paragraph.</p>
	      <p>This is third paragraph.</p>
	      <a href="https://www.facebook.com/wocmnnit">Weekend of Code</a>
	      <a href="1.html">HTML Structure File</a>    
	   </body>	
	</html>
	```

*	### HTML Image
	* HTML **img** tag is used to display image on the web page.
	*	#### src attribute
		* Path of image file is specified here.
		* Path can be either **relative** or **absolute**.
	*	#### alt attribute
		* Alternative Text to be displayed if image does not load.
	* It is an *empty tag*.
	* Explore other attributes of `<img>` like **width**, **height**, etc.

*	### HTML Horizontal Rule and Line Break
	* The `<hr>` tag is used to draw a horizontal line in a HTML document.
	* The `<br>` tag in HTML document is used to create a line break in a text.
	* Both `<hr>` and `<br>`tags are *empty tags*.
	* *Note*: Explore attributes of `<hr>`.

*	### HTML Comments
	* Comments are some text or code written in your code to give an explanation about the code.
	* Comments are not visible to the user (*Really?*).
	* `<!-- ... -->` tag is used for comments.

	#### [3.html](./3.html)
	```html
	<!DOCTYPE html>
	<html>
	   <head>
	      <title>Image, HR, BR and Comment demo</title>
	   </head>	
	   <body>
	      <img src="frontend.jpg" alt="Frontend Image">
	      <br>
	      <br>
	      <hr>
	      <img src="backend.jpg" alt="Backend Image">
	      <hr>
	      <br>
	      <p>This is a paragraph</p>
	      <hr>
	      <!-- This is a comment. Tell me whether it's visible to you or not. -->
	   </body>	
	</html>
	```

*	### HTML Table
	* HTML `<table>` tag is used to display data in *tabular form (row * column)*.
	* 	#### HTML Table tags
		* `<table>` - It defines a table.
		* `<tr>` - It defines a row in a table.
		* `<th>` - It defines header cell in a table.
		* `<td>` - It defines a cell in a table.
		* Explore other table related tags like `<caption>`, `<colgroup>`, `<col>`, etc.
	* **border** attribute is used to specify border of the table.
	* Read more about HTML table [here](https://www.javatpoint.com/html-table).

* ### HTML Lists
	* HTML Lists are used to specify lists of information.
	* There are three different types of HTML lists - 
		* Ordered List or Numbered List (`<ol>`)
		* Unordered List or Bulleted List (`<ul>`)
		* Description List or Definition List (`<dl>`)
	* `<li>` tag is used to specify list elements.
	* Explore various attributes of `<ol>`, `<ul>` and `<dl>`.
	* Read more about HTML Lists [here](https://www.javatpoint.com/html-lists).

	#### [4.html](./4.html)
	```html
	<!DOCTYPE html>
	<html>
	<head>
    	<title>Table and List demo</title>
	</head>
	<body>
        <h1>HTML TABLES</h1>
        <table border="1">
            <tr>
                <th>Column 1</th>
                <th>Column 2</th>
                <th>Column 3</th>
             </tr>
             <tr>
                <td>Row 1 Cell 1</td>
                <td>Row 1 Cell 2</td>
                <td>Row 1 Cell 3</td>
             </tr>
             <tr>
                <td>Row 2 Cell 1</td>
                <td>Row 2 Cell 2</td>
                <td>Row 2 Cell 3</td>
             </tr>
             <tr>
                <td>Row 3 Cell 1</td>
                <td>Row 3 Cell 2</td>
                <td>Row 3 Cell 3</td>
             </tr>
        </table>
        <h1>HTML LISTS</h1>
        <h3>Ordered List</h3>
        <ol>
            <li>Chapter One</li>
            <li>Chapter Two
              <ol>
                <li>Section One</li>
                <li>Section Two </li>
                <li>Section Three </li>
              </ol>
            </li>
            <li>Chapter Three</li>
          </ol>
        <h3>Unordered List</h3>
        <ul>
            <li>bread</li>
            <li>coffee beans</li>
            <li>milk</li>
            <li>butter</li>
        </ul>
        <h3>Description List</h3>
        <dl>
            <dt>Name</dt>
            <dd>Godzilla</dd>
            <dt>Born</dt>
            <dd>1952</dd>
            <dt>Birthplace</dt>
            <dd>Japan</dd>
            <dt>Color</dt>
            <dd>Green</dd>
        </dl>
	</body>
	</html>
	``` 
	* [Here](./4_styled.html) is another example of Tables and List with some other attributes and styling.

* ### HTML Form
	* An HTML form facilitates the user to enter data that is to be sent to the server for processing such as name, email address, password, etc.
	* It can contain - 
		* text fields, password fields, 
		* checkboxes, radio buttons, 
		* submit button, menus, etc.
	*	**`<form>` tag** - It is used to define a form.
		* 	**action attribute** - It is used to specify the server's URL (where data is to be sent when Submit button is clicked).
		*	**method attribute** - It specifies the method (*GET*, *POST*, etc) that will be used to send the data.
	* *Syntax* - 
		```
		<form action="server url" method="get|post">  
		  //input controls e.g. textfield, textarea, radiobutton, button  
		</form>  
		```
	*	**`<input>` tag** - It is used to create various types of input fields.
		*	**type attribute** - It's value can be *"text"*, *"password"*, etc.
		*	**name attribute** - Useful for backend integration (will be explained later).
	*	**`<label>` tag** - It defines a label for an input element.
	*	**`<textarea>` tag** - Used when we need to take large texts/paragraphs as input.
	*	**`<select>` tag** - Used to create drop - down list.
	*	**`<option>` tag** - Used to define an option in a drop - down list.
	*	**`<button>` tag** - It defines a clickable button.
		*	**type attribute** - It defines functionality of button.
			* submit - Clicking the button will submit the form.
			* reset - Clicking the button will reset the form.
	* Read more about HTML form [here](https://www.javatpoint.com/html-form).

	#### [5.html](./5.html)
	```html
	<!DOCTYPE html>  
	<html>  
	  <head>  
	    <title>Form in HTML</title>  
	  </head>  
	  <body>  
	      <h2>Registration form</h2>  
	      <form action="#", method="POST">  
	      <fieldset>  
	          <legend>User personal information</legend>
	          <label>Enter your full name</label><br>  
	          <input type="text" name="name"><br>  
	          <label>Enter your email</label><br>  
	          <input type="email" name="email"><br>  
	          <label>Enter your password</label><br>  
	          <input type="password" name="pass"><br>  
	          <label>confirm your password</label><br>  
	          <input type="password" name="pass"><br>
	          <br><label>Enter your gender</label><br>  
	          <input type="radio" id="gender" name="gender" value="male"/>Male  <br>  
	          <input type="radio" id="gender" name="gender" value="female"/>Female <br/>    
	          <input type="radio" id="gender" name="gender" value="others"/>others <br/>
	          <br><label>Hobbies</label><br>
	          <input type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
	          <label for="vehicle1">Hobby 1</label><br>
	          <input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
	          <label for="vehicle2">Hobby 2</label><br>
	          <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
	          <label for="vehicle3">Hobby 3</label>
	          <br>
	          <br><label>Select Age Group</label><br>
	          <select name = "dropdown">
	              <option value = "0-10" selected>0-10 yrs</option>
	              <option value = "10-20">10-20 yrs</option>
	              <option value = "20-30">20-30 yrs</option>
	              <option value = "30-40">30-40 yrs</option>
	              <option value = "40-50">40-50 yrs</option>
	              <option value = "50-60">50-60 yrs</option>
	           </select>
	           <br>
	           <br><label>Upload Profile Picture</label><br>
	           <input type = "file" name = "fileupload" accept = "image/*" />
	           <br>
	          <br>Enter your Address:<br>  
	          <textarea></textarea><br>
	          <input type="submit" value="SIGN-UP">  
	          <input type = "reset" name = "reset"  value = "Reset" />
	      </fieldset>  
	    </form>  
	  </body>  
	</html>  
	```

## Content Contributors

* [Kshitiz Srivastava](https://github.com/pirateksh/)
* [Harshit Garg](https://github.com/harshit212705)

### Material

* [JavatPoint HTML Tutorial](https://www.javatpoint.com/html-tutorial).
* [W3Schools HTML Tutorial](https://www.w3schools.com/html/).

### Note
* Rest of the material has been moved to [WebClass-II folder](../2021_04_26_WebClass-2).