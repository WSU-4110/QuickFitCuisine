# QuickFitCuisine
This web application lets users input what ingredients they currently own. The website then immediately outputs a list of recipes that includes any ingredients the user clicked. It is very simple, easy to use, and is all on one page.

## Features
- Choose ingredients on the left side.
- View recipes on the right side.
- Immediate responses.
- Sort recipes by time and/or number of ingredients.
- Filter ingredients for dietary preferences such as vegetarianism, veganism, etc.
- Log in to save up to 10 recipes.

## Installation
### Required Software:
- [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/release/2022-12/r/eclipse-ide-enterprise-java-and-web-developers)
- [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
    - [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
    - The workbench is not required, but it does make this a lot easier.
- [Apache Tomcat 9](https://tomcat.apache.org/download-90.cgi)
    - *Binary Distributions* -> *Core* -> zip

### Steps
1. Install the required software above.
2. Make sure the MySQL Server is running.
    - If on Windows: search the desktop for the Services program and find the name of the server. Make sure it's running.
    - If on macOS: There should automatically be a new panel created at the bottom of System Preferences. Make sure the light is solid green.
3. When creating the MySQL Server, make password for root as `pass1234`.
4. Open MySQL Workbench and log into the database by clicking `Database` at the top menu bar and then clicking `Connect to Database...`.
    - In the panel on the left side of the screen, under the Administration tab, click `Users and Privileges`.
    - At the bottom, click `Add Account`.
    - Change the login name to `john` and set the password to `john1234`.
    - Click the `Administrative Roles` tab in the middle of the window. Check the DBA checkbox to grant john the rights to perform all tasks.
    - The screen should look like this when these steps are complete:
    <img width="1440" alt="image" src="https://user-images.githubusercontent.com/112665328/207178713-bd50b7e3-00b5-4322-bc8d-cfe2e7098c30.png">
5. Download this GitHub project.
6. Open Eclipse and make sure it is the Enterprise Java and Web Developers version. This may not work with other versions of Eclipse.
