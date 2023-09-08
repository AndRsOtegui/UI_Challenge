# UI_Challenge
Maven java test for UI for movie database

## Framework structure

For this exercise, Selenium 4.11 was used as the browser driver, Maven 3.11 for dependency management, TestNG for testing, and java.util.logging.Logger with a custom class named "LogTextFormatter" to log events in a plain text format log file. Everything was done in IntelliJ IDEA with OpenJDK 11.

## Test case solutions

### User login:

I began by identifying the locators with Xpath for the elements on the webpage, ensuring I could interact with them effectively. Using these locators, I implemented a boolean verification step to confirm that the script was  on the profile page. This initial exercise served as a refresher, allowing me to reinforce the fundamental concepts covered in in the GUI training, i decide to go with Xpath since its a little more visual for me to remember the logic of the locator.

### Fail login:

This scenario was similar to the previous one, but it involved verifying three error messages that changed with each attempt. I used 'contains(text())' to find the messages and 'getCssValue' to check the message color. This helped ensure it mathced all expected contitions. 

### Search movie:

This scenario was the simplest as I reused what I did in the previous two scenarios, but this time on the main page, not the login page. I used a locator on the results page to check the title of the first movie.

### Search by genre filter:

This was one of the more challenging scenarios to resolve. I had to implement explicit and implicit waits. In the end, I used an explicit wait with a JavaScript executor that waited until all queries had been executed. This was necessary because the only thing that changes on the page is the specific information on each movie card. This approach helped avoid hardcoding the test.

### Validate actor timeline:

This scenario had the most steps, and the key was to detect the number of actors and randomly select one of them, then save the title of the movie chosen for the test. This was done to later review it on the actor's page.

### Sort movies in release date ascending order:

This scenario was resolved using the same query wait technique as the movie filter case. The main challenge was to extract the release dates of the movies as text, convert them to integers, and verify that they were in the expected order. The solution involved dynamically modifying the XPath based on the position of the first four movies and comparing them: 1<2, 2<3, and 3<4 to ensure the correct order.

## Imports and other important components to solve the challenge

:⚫ The 'LogTextFormatter' class extends 'import.java.util.logging.Formatter' to manually build the appender configurations along with a simple date format for generating log messages using 'java.util.logging.Logger.' It's also important to note that this class should be in the same package as the 'BasePage' class so that it can be used in conjunction with the 'FileHandler,' also from 'java.util.logging,' to manage and create the 'TestUILog.log' file.

:⚫ BasePage is the parent class of the pages from which all inherit the driver constructor, the driver.findElement method, and elements that are common across all pages, such as the buttons in the navbar.

:⚫ The 'js' object is a JavaScriptExecutor used for scrolling down and avoiding click interception errors caused by the cookie banner that appears on some pages.

:⚫ randomInt was used to introduce randomness in the necessary scenarios for selecting 'any' object according to the scenario to ensure that the test case is scalable and not hard-coded.
