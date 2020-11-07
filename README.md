# Writing a README sample

**Version 1.0.0**

Code and document samples for the writing a README test 

----

## Contributors

- Catalina Cercel <catalinacerceltasi@gmail.com>

---

## License & copyright

© Catalina Cercel , London 



*Project Title 
Software QA Engineer Coding Challenge - Cucumber - v1

*Installation guide:* 
This is a maven project. so It's assumed that the host running this code have Java and maven installed and already set. 
Here is the guide for maven installation just in case : https://maven.apache.org/install.html

Project get all dependencies from maven repository. So no additional installation needed.

*Below are the dependencies are being used for this project 

Cucumber-Junit,
Cucumber-java,
RestAssured,
Hamcrest,
Jackson,

##Credentials  
Cucumber use public key and private key to authorize the request. to externalize the data a configuration reader utility are created
to read configuration.properties. 
Due to sensitive nature of the keys , user is expected to provide his/her own key while running the tests. 

##Build and run your project 
This is maven project and tests are written in Cucumber Gherkin language . so we use maven command line commands to run the project 
as below to pick up tests:  

Go to your project directory from terminal and hit following commands

-- mvn clean test ( This is the main command of running Test from Terminal and getting the Cucumber HTML reports in Target Foldersoi )

-- mvn test (default will run on local firefox browser).

-- mvn test "-Dbrowser=chrome" (to use any other browser).

-- mvn test -Dcucumber.options="classpath:features/my_first.feature" to run specific feature.

-- mvn test -Dcucumber.options="–-plugin html:target/result-html" to generate a HTML report.

-- mvn test -Dcucumber.options="–-plugin json:target/result-json" to generate a JSON report.

##Vending Machine Test Runner (terminal use is a must!)

-- src/main/java/com/catalinacercel/VendingMachineRunner.java

-- mvn package (BUILD THE PROJECT)

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------

[INFO] Total time:  3.180 s

[INFO] Finished at: 2020-11-07T23:11:42Z

[INFO] ------------------------------------------------------------------------

-- java -cp target/vending-machine-collinson-1.0-SNAPSHOT.jar com.catalinacercel.app.VendingMachineRunner
    (RUN YOUR PROJECT)
    
    =====================================
    =     WELCOME TO VENDING MACHINE    =
    =   THIS MACHINE ACCEPTS CASH ONLY  =
    =====================================


##Architecture Info

-- src/test/resources/features : A new feature file will be created  under this path .feature ext required (Gherkin Syntax : 
is the language that Cucumber understands)

-- src/test/java/StepDefinition : Every feature file will be define by a step definition that comes into this package

-- src/test/java/env : Configuration/Setup comes from "CukesRunner" that allows you to glue your code location "com/catalinacercel/step_def/", 
define test results output format "html, json, xml". "Hooks" can be configured in src/test/java/com/catalinacercel/step_def/NetworkApiTest.java
(all @Before and @After test settings). "DriverUtil" 
contains code for initializing driver instances
 
-- src/main/java/browserConfig : Providing capabilities and platform information here


##The framework is actual a BDD (Behaviour Data Driven) Cucumber framework.

Runner Class is specifically to run all tests from one location.
I also store my cucumber feature files separately it also helps in reusability and utilise.
Step definitions are storing my actual code.
An extra re-run class has to be created that will help us to rerun failed scenarios.

"# vending-machine-collinson" 
"# vending-machine-collinson" 
