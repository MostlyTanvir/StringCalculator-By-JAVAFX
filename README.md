# StringCalculator-By-JAVAFX
This calculator can take one Arithmetic Expression as an input containing (),/,*,+,- and calculate the expression precedence wise. More description has been written on the PDF.
Project Description:
My String calculator will take inputs a mathematical expression like (2+3/5) and the output of the expression above will be 2.6.

Description of Front-end: There are 3 labels named Title, Input and Output. Again, 2 text fields one for taking input and another for showing output. There are 2 buttons one for doing the calculation and showing output and the other button is used to clear the text fields.

Description of Back-end: I have separated the string into smaller parts and solve then. 
There is a small function named math to solve 2 double numbers and one given operator and return one double.
There are 2 same size array one for storing the double numbers and another for marking the operators with numbers. 
There is a function name calculate, it takes mathematical expression as strings but without the brackets. Then it converts the strings to number and operator array. After that according to the precedence it calculates the numbers and store the answer at the first index of the array and returns the answer as string.

There is another function named calculateWithBrackets. This function takes input with brackets and make separation of the strings from the bracket precedence wise and pass that string to the calculate function without brackets and solve them one by one. It considers the whole string inside another bracket and solve them precisely.
Finally, we take the input from the input text field and check with the special string and validity of the mathematical expression. Next according to the rules, it shows the ID, answer and errors to the output text field area.



Screen Shots:
  
![image](https://user-images.githubusercontent.com/66480107/185978004-e4d406e6-4c06-4f49-ba96-2e8816d6f9ab.png)
![image](https://user-images.githubusercontent.com/66480107/185978064-1a585e0c-083f-48e9-b9c0-7ccc52e32495.png)
![image](https://user-images.githubusercontent.com/66480107/185978397-f4b88445-8fc6-4a4a-8245-8a476589c2db.png)
![image](https://user-images.githubusercontent.com/66480107/185978443-f77fe0e6-4d46-4d87-bdee-ab4f5e6961b9.png)
