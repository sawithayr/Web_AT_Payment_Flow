Midtrans Web Automation to check SUCCESS and FAILED payment flow using credit card 

Tools and Libraries
- Java : Programming Language
- Maven : Build Tool
- testNG : TestNg Java testing framework
- Selenium Webdriver : Browser automation framework 
- Cucumber : BDD Framework
- Gherkin : Language which is used to write features, scenarios, steps.
- Custom Page Object Pattern and utility functions

Step to run project :
1. Open project
2. Wait the dependencies finish loading
3. Set tag "@midtrans" in TestRunner file "src/test/java/runner/TestRunner.java"
4. Run project right click on TestNG.xml
5. The webdriver will open and run the scripts
6. It will close automatically after finish and the result will display on IDE.

note : 
- using properties file to assert customer details
- using scenario outline for positif and negetive cases
- main/java for page object
- test/java for features file and steps
