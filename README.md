##SHAUN REED IQ ASSESSMENT (SENDER)

IntelliJ was used while developing this maven project, using Java 8.

When cloning this project and opening in the IDE, please make sure that the maven dependencies are imported, when that is done you may run the project
***
###NB:
###MAKE SURE YOU RUN THE RECEIVER APPLICATION BEFORE RUNNING THIS APPLICATION

**Link Below:**
<br /> *https://github.com/original-shaun-reed/shaun-reed-iqbusinessgroup-assessment-receiver*

***
##NB: I made use of the RABBITMQ plugin to serve as a message bus. Please install that plugin if it doesn't pull through from the **pom.xml** file when importing maven dependencies  
***
To run this project 

*Run the main method of the following file*
<br />**../shaun-reed-iqbusinessgroup-assessment-sender/src/main/java/shaun/reed/iqbusiness/assessment/main/Client.java**
***
*When the project is in runtime;*
<br />**The first thing you'll see in your console is;**
<br />**-> To exit this application press enter 'q' then press the [ENTER] key on your keyboard**
<br />----------------------------------------------------------------------------------------------------------------------------
<br /> **-> Enter your name:**

You'll have to enter your/a name on the console;
<br /> *Example*:
<br /> **Enter your name:**
<br /> *Your input:* **James** *press [enter] key* 
<br /> *Output:* -> Sent message: 'Hello my name is, James' to the receiver.

You can also quit this application during runtime;
<br /> *Example*:
<br /> **Enter your name:**
<br /> *Your input:* **q** *press [enter] key* 
<br /> *Output:* Exiting application . . .
***




