# STC-Automation-TasK
Test Automation framework using Java, Selenium, TestNG, Cucumber BDD and Gherkin for automating stctv website
# Tools and contents:
This is Java based project, 
- selenium webdriver for find and interact with locators, 
- TestNG for assertions,  
- Cucumber BDD and Gherkin language for writing Scenarios and for Test Report, 
- Using data driven from json file and other different methods for dealing with data like data table and examples of scenario outline 
- Maven as dependency management tool
- JDK 17
# Design pattern used
Page object module (POM), using By class and WebElement Interface to find and interact with web elements
# Plugins used:
- Cucumber for java,
- Gherkin
![2023-05-15 00_17_39-STC-Automation-Task – Runner java](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/55b9e5bf-8745-4f2a-a585-d38b4cb5c0ef)

# dependancies:
- selenium-java
- webdrivermanager
- cucumber-java 
- cucumber-testng >> for Assertions
- cucumber-reporting >> for Test report
- json-simple >> for Parsing data in Json file
![2023-05-15 00_19_21-STC-Automation-Task – pom xml (STC-Automation-Task)](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/2b60fa5c-3633-410a-84f6-92320da9796a)

# another plugins added to pom.xml file for building project from maven and for generate cucumber html report
- maven-surefire-plugin
- maven-cucumber-reporting
![2023-05-15 00_25_48-STC-Automation-Task – pom xml (STC-Automation-Task)](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/1d38eb6b-ca21-45ad-9794-a32afcf6c56d)

# How to Execute the project - From the Runner Class
- open the project 
- navigate to testRunner/Runner Class
- Right click on Runner class and select Run Runner OR Open Runner Class and run from it as the attaches
![2023-05-15 00_30_29-](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/b6188685-91ed-4df7-a3a0-af92f7a6c691)
![2023-05-14 22_37_29-STC-Automation-Task – Runner java](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/f8cc6701-eb97-4e48-95fc-a56ab08b9a04)

# Test Report When you Run from Runner Class:
- test report will be displayed on Target directory in cucumber.html file after you run the project from runner 
- Open cucumber.html file in any browser
![2023-05-15 01_11_23-STC-Automation-Task – C__Users_muham_OneDrive_Desktop_Local_Selenium-Workspace_S](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/cea3a152-f63e-4424-b0d9-38fc465858ca)
![2023-05-15 01_12_39-Cucumber](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/2c6c5db0-dda4-4ea5-86a5-8634fe10e45c)
![2023-05-15 01_13_10-Cucumber](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/04596452-a430-4775-b494-09f053d19cad)

# Execute the project from maven
- you can run the project from the terminal by writing this command "mvn clean verify"
![2023-05-14 22_51_46-STC-Automation-Task – C__Users_muham_OneDrive_Desktop_Local_Selenium-Workspace_S](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/d25a01ce-b749-42cb-b2f8-80e934604e37)
- or you can run it as the upcoming photos
![2023-05-15 01_23_48-Settings](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/82223ce1-14b3-457e-87ad-445c7c6abdc6)
# Test Report for cucumber-html when you run from maven commands
![2023-05-15 01_39_28-STC-Automation-Task – C__Users_muham_OneDrive_Desktop_Local_Selenium-Workspace_S](https://github.com/Shahinoo/STC-Automation-TasK/assets/48762136/ee805624-07e6-44e5-ae4f-8462444ffa58)
- see this video showing test reports
https://drive.google.com/file/d/1mARZTjYdKceJkFougMyXRli-CcD6b1yk/view?usp=sharing

