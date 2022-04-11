# ClipboardHealth_SDETTests

A Maven Framework which is the solution to the test given for the SDET position at Clipboard Health. Selenium tests written in Java and TestNG for Reports of Test Result. This test follows the Page Object Model(POM) and helper methods were created for repetitive page interactions like click.
This framework has the provision to run the tests locally and on Selenium Grid, also with Docker.
This framework automates two test cases;

##### 1. Web Automation for Amazon site (Automating the following steps)
- Open https://www.amazon.in/
- Click on the hamburger menu in the top left corner.
- Then Click on the TV, Appliances and Electronics.
- Then click on Televisions.
- Filter the results by Brand ‘Samsung’
- Click on the second highest priced item.
- Switch the Window
- Assert that “About this item” section is present and log this section text to console/report.

##### 2. Data Driven API Automation (Creating a User on Reqres.in using a json file) 
This test will run twice with the given set of data in the json file below;
```
[
  {
   "name": "admin",
   "job": "admin"
  },
  {
   "name": "ronaldo",
   "job": "player"
  }
 ]
```




## Getting Started

Copy the repo into your local machine.

### Run tests locally
1. In the testng.xml file, Under the test with name "Web Automation", in the parameter tag, with name = "browser", input the value as "chrome".
2. Right click the testng.xml file and select "Run" to start the test.


### Run tests on Selenium Grid
1. Download the Selenium Grid jar file from https://www.selenium.dev/downloads/. The Latest stable version is 4.1.3. Keep this jar file in a folder.
2. Open your terminal and change directory to where you stored the Selenium Grid jar file. To spin up the selenium server, enter the following into your terminal. The version is the version of the selenium grid jar file you downloaded.

```
java -jar selenium-server-<version>.jar standalone
```
3. In the testng.xml file, Under the test with name "Web Automation", in the parameter tag, with name = "browser", input the value as "remote".
4. Right click the testng.xml file and select "Run" to start the test.


### Run tests on Docker
1. Download Docker Desktop from https://www.docker.com/products/docker-desktop/. After installation, open the terminal and install these images needed to run our test, You can find these images on https://hub.docker.com/ and input the image name in the search box.
2. These are the commands to type into the terminal to pull these images.
```
docker pull selenium/hub
docker pull selenium/node-chrome
docker pull selenium/node-firefox
docker pull selenium/node-chrome-debug
docker pull selenium/node-firefox-debug
```
3. After downloading all the images into your container you can check it using the below command.
```
docker images
```
4. To start the selenium nodes, in your IDE terminal, type the following command
```
docker-compose -f docker-compose.yml up
```
5. You can verify whether Selenium server has started or not by checking the following link in your browser: http://localhost:4444/grid/console.
6. Once you verify it has started, In the testng.xml file, Under the test with name "Web Automation", in the parameter tag, with name = "browser", input the value as "remote".
7. Right click the testng.xml file and select "Run" to start the test.



### View TestNG Report
1. Open the test-output folder
2. Right click on the emailable-report.html file
3. Select Open in >  Browser > Choose the Browser you want to view the report in
