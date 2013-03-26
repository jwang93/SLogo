# SLogo

##### Names of all people who worked on the project

**CS 308 - Team 7 SLogo**   
**Team:** Zhen Gou, Will Nance, Jay Wang, David Winegar  
**UTA:** Brandon Millman  

##### Date you started, date you finished, and an estimate of the number of hours worked on the project

**Started:** Feb 23, 2013    
**Finished:** Mar 25, 2013    
**Hours worked:** ~100 hours    

##### For team projects, the link to your project repository

[Link to Github Repo](https://github.com/jwang93/SLogo)

##### For team projects, each person's role in developing the project

**Zhen Gou** and **David Winegar**: View, Model, and Util
	We worked mostly on the parts that deal with the state of the model and the view.

**Jay Wang** and **Will Nance**: Factory and Commands  
	Early on, the majority of our time was spent on figuring out how we were going to handle process commands. Ultimately, we built out a framework using the Parser, an Initializer (AbstractInitializer + Specific_Initializer), and a Command.

##### Any books, papers, online, or human resources that you used in developing the project

* Javadoc
* CS website resources
* http://www.kodejava.org/examples/591.html (for writing/loading to .txt file) 

##### Files used to start the project (i.e., the class containing main) and test the project (the class containing TestSuite)

Files were taken from the previous Springies project, including much of the Util such as Sprite, Location, Pixmap, Vector; 
code was also taken from the Canvas class and is contained in both the View and the current Canvas class.

##### Any data or resource files required by the project (including format of non-standard files)
* Requires an English.properties file with the proper language for View to function correctly
* Requires an Initializers.properties file, which the Parser uses to grab the appropriate Initializer. 
* Requires a picture to represent the turtle

##### Any information about using the program (i.e., command-line/applet arguments, key inputs, interesting example data files, or easter eggs)
* When using Save/Load FunctionsAndVariables, please save your file in the src/file directory. It is the same directory that has the session.txt file. 

##### Any known bugs, crashes, or problems with the project's functionality


##### Any extra features included in the project

##### Your impressions of the assignment to help improve it in the future

We felt that this project was both challenging and rewarding. From the Model side, we wish that maybe one day could have been devoted to interpreter design. Our TA helped us a bit with planning out how to design the Parser, but for the most part, we struggled heavily with that in the beginning.
