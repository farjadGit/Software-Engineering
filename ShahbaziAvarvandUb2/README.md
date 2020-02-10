# GUI-Interface about BMI calculation
This program opens an GUI window where you can give your height, weight, gender and age. After clicking "berechnen", your BMI is going to be calculated.
On the other window you can see your BMI categorie

# Tasks
## UML diagrams
- [class diagram](./Proofs/class%20diagram.png):shows the structure of the two main classes used for this program: Hauptfenster and Ausgabepanel.
Also the test class can be seen.
- [use case diagram](./Proofs/UseCaseDiagram.png):shows how the script runs and what the expected result is
- [activity diagram](./Proofs/Aktivitätsdiagram.png):shows the activities that are involved in this program
## Metrics
via sonarqube, you can see the result in [this screenshot](./Proofs/sonarqube.PNG)
the following points has been tested
- reliability
- security
- maintainability
- duplications
- coverage: is very low but you should consider that the main class is very small.
An overview of the metrics can be seen [here](./Proofs/sqoverview.PNG)
## Clean Code Development
- Encapsulation: means if some variables or methods in class need to be defined as **private** in order to avoid unnecessary access to this 
variables from othe classes. examples can be seen in Hauptfenster class line 46
- there is no useless/commented out code
- readability: code can be read very well
- precise naming of variables (e.g. koerpergroesse, koerpergewicht, ergebnisBmi, berechneButton and alter) and functions (e.g. buttonBeendeClicked, buttonBerechneClicked,
bmiBerechnung,panelLinks, panelLinksErsteZeile)
- fields define state: temporary variables are only declared within local scope (e.g. in Hauptfenster class buttonBerechneClicked method)
- correct exception handling: in Hauptfenster class buttonBerechneClicked method line 130
- avoid negative conditionals ( in Hauptfenster class line 134)
- Avoid Negative Words in Method Names: We often include method names in our ‘if’ statements and therefore we should probably avoid negative terms in the names of our methods.(e.g. Ausgabepanel class line 94)
- Avoid Negative Words in Variable Names: The guidance to avoid negative words in method names holds similar value for variable names, particularly the names of boolean variables.
e.g. Hauptfenster Class line 56
- no duplications as can be seen in SonarQube
- KISS: simple function definitions( e.g. line 173 in Hauptfenster)
- split long methods (Hauptfenster class line 202, 219 and 240 divided the whole panel in 3 different functions )
- design and implementation do not overlap
- 'divide and conquer': no long method chaining (Hauptfenster class line 219)
- consistency: both methods that are related to the Button ("berechne" and "Beenden") have the "Button" name) 
## Build Management
I have used Maven as a Build Management. For more details you can see the [pom.xml](./pom.xml)
## Unit Tests
My JUnittest is integrated in Maven. For more detailes feel free to take a look at the [Test Class AbstractUiTest](./src/AbstractUiTest.java)
## Continuous Delivery
The building process was successful [first proof](./Proofs/BuildInstall1.jpg) and also the integration of SonarQube. because I used [Eclipse](./Proofs/eclipse.PNG) I had to run [sonarscanner](./Proofs/sonarscannerSucces.PNG) to analyse my code.
## IDE
For coding this project I used Eclipse. My favourite key-shortcuts are Ctrl+S (save),Ctrl + SHIFT + L (open a list of all shortcuts), Ctrl+/ and Ctrl-Shift-/ (comment), Ctrl-\ (uncomment), Ctrl+F (find), Ctrl+F11(run).
## DSL
I wrote a simple [DSL script](./DSL/DSL_Simple_Greeting) which simply outputs Hello.
## Functional Programming
- No Side Effects means that function cannot change any state outside of the function(e.g. Class Hauptfenster line 108)
- Pure Functions
  - A function is a pure function if:

      - The execution of the function has no side effects.
      - The return value of the function depends only on the input parameters passed to the function. Example can be seen in Ausgabepanel Class line 80
- No state external to the function (e.g. Class Ausgabepanel line 94)
## Bonus
Logical Solver: the testing methods in AbstractUiTest could also be interpreted as a logical solver.

      
