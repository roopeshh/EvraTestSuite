# How to run the tests

## Pre-requisites
1. Java 11 (JDK) installed on the machine.
2. Java IDE preferably Intellij Idea.

## Steps:
1. Import the project as a gradle project.
2. To run all the implemented tests use command:
`./gradlew clean test -DCUCUMBER_FILTER_TAGS="@implemented"`.
3. To run the tests based on smoke or regression tests we can use:
    `./gradlew clean test -DCUCUMBER_FILTER_TAGS="@smoke"`. (`@regression` for regression tests)
4. To run the tests based on a specific feature we can use:
   `./gradlew clean test -DCUCUMBER_FILTER_TAGS="@login"`. (Feature tags are on top of the feature file for each feature)
5. To run the tests on firefox browser use:
   `./gradlew clean test -DCUCUMBER_FILTER_TAGS="@login" -Dwebdriver.driver=firefox`. Currently, chrome runs by default
   without passing parameter ``webdriver.driver``.  
6. These tests can be run headless too, for that we need to use command:
   `./gradlew clean test -DCUCUMBER_FILTER_TAGS="@login" -Dheadless.mode=true`.
7. The reports for the tests are available at the location
`target/site/serenity/index.html`.
   
#### NOTE: 
- This framework was developed on Mac OS.
- Some tests use @notimplemented tags intentionally to make use of tags while running tests.