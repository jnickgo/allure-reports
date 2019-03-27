# Allure | JUnit 5 
An example project for exploring the Allure Reporting Framework's JUnit 5 support.

# How to Use

## Installation
Installation with Maven is pretty straight forward.

The latest available version of allure-junit5: ![Allure JUnit5](https://img.shields.io/maven-central/v/io.qameta.allure/allure-junit5.svg)

The latest available version of allure-maven: ![Allure Maven](https://img.shields.io/maven-central/v/io.qameta.allure/allure-maven.svg)

## Running Tests and Report Generation
Simply run the projects test like you would any other Maven project.

```mvn test```

With the Allure Maven plugin installed it is recommended to execute and generate the results through the plugin tasks.

Notable ```allure:report``` and ```allure:serve```

Report artifacts (results) are generated and exported to the ```allure-results``` directory by default.

### Generating Reports
The Allure Command Line tools offers a way to serve and share reports by using just a couple of easy commands.

**Setting Environment Properties:**
The Allure documentation states that the environments.xml or environments.properties should be moved to the 
allure-results directory, within the target directory for Maven.  To help automate this task we'll use the Maven Resources
Plugin.
