# Installation
## Required Software:
- [Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/release/2022-12/r/eclipse-ide-enterprise-java-and-web-developers)
- [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
    - [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
    - The workbench is not required, but it does make this a lot easier.
- [Apache Tomcat 9](https://tomcat.apache.org/download-90.cgi)
    - *Binary Distributions* -> *Core* -> zip

## Steps
1. Install the required software above.
    - Install and extract the Apache Tomcat 9 files to your username directory.
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
5. Download this GitHub project. Make sure to remember where the zip file is saved to.
    <img width="1440" alt="image" src="https://user-images.githubusercontent.com/112665328/207179870-37364e2b-5743-452f-bb01-c6f1bfb18e0a.png">
6. Open Eclipse and make sure it is the Enterprise Java and Web Developers version. This may not work with other versions of Eclipse.
7. After opening Eclipse, a new folder in your username directory on your computer should be created called `eclipse-workspace`.
    - Extract the project zip file to this folder. On macOS, it should look something like the following screenshot. My folder says `eclipse-workspace-2`.
    <img width="1032" alt="image" src="https://user-images.githubusercontent.com/112665328/207180849-b9e475e1-1588-4150-9c5f-6d0a9324f6cb.png">
8. In Eclipse, click *Window* -> *Show View* -> *Servers*.
    - The tab should open at the bottom of the screen. Add a new server.
    - A window similar to the one in the screenshot should pop up. Under the Apache folder, click Tomcat v9.0 Server. Click Next >. Click Finish.
    <img width="586" alt="image" src="https://user-images.githubusercontent.com/112665328/207181905-d24df9d0-6ad4-4c02-9ddd-eac3ab98e2b4.png">
9. Eclipse should take you back to the main editor now, with a Servers folder in the Project Explorer tab on the right now.
10. Click *File* -> *Import...* -> *General* -> *Existing Projects into Workspace*. Click Next >.
    <img width="584" alt="image" src="https://user-images.githubusercontent.com/112665328/207182879-c5b5b9ff-2a5e-4a23-9f43-f7c271c8bef1.png">
11. Select the QuickFitCuisine folder that you just extracted in Step 8 where it says `Select root directory`. Check the project's checkbox in the box below it. Click Finish.  
    <img width="584" alt="image" src="https://user-images.githubusercontent.com/112665328/207183251-e09e8d85-d762-44ed-80ff-87f3b94436e6.png">
12. Before enjoying the website, right click on the file `rootView.jsp` and select *Run As* -> *1 Run on Server*.
    - After doing that, a webpage should come up. Click the button that says `Initialize the Database`.
    <img width="310" alt="image" src="https://user-images.githubusercontent.com/112665328/207184282-1a721155-6386-494f-9f55-24a0f4ffa500.png">
13. Now you may begin enjoying the website. Click the button that says `Logout`. This should take you to the only page that you would need from now on. Enjoy :)
