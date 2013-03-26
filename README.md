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

*MORE TO BE DISCUSSED IN PROJECT ANALYSIS*

**Zhen Gou** and **David Winegar**: View, Model, and Util
	We worked mostly on the parts that deal with the state of the model and the view.

**Jay Wang** and **Will Nance**: Factory and Commands  
	Early on, the majority of our time was spent on figuring out how we were going to handle process commands. Ultimately, we built out a framework using the Parser, an Initializer (AbstractInitializer + Specific_Initializer), and a Command.

##### Any books, papers, online, or human resources that you used in developing the project

* Javadoc
* CS website resources
* [For writing/loading to a text file](http://www.kodejava.org/examples/591.html)

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
   Bugs:
     * set background image cause null-pointer exception for some files but not others
     * 
   Not implemented functionality:
     * allow user to set image for turtle; we imagine it will be very similar to set background image
	 * background images and colors are still problematic as not all commands are working correctly - we implemented it purely view side and there is a mostly complete
	 model side implementation that is not connected.
     * pen cannot choose to make dashed lines; not hard but we chose to work more on refactoring with our time
     * let user acess a html page for help
     * undo/do actions
     * show variables/functions defined by users ** GUI has windows for them but isn't functional yet
    

##### Any extra features included in the project
   Enhanced GUI, lets the user choose background color/toggle highlight for turtle/set background image/ toggle reference grid by clicking buttons in GUI without need
   to type commands

##### Your impressions of the assignment to help improve it in the future

We felt that this project was both challenging and rewarding. From the Command side, we wish that maybe one day could have been devoted to interpreter design. Our TA helped us a bit with planning out how to design the Parser, but for the most part, we struggled heavily with that in the beginning.
We also felt like there was a large mismatch between the amount of work each team had to do during each part of the project - the command side had vastly more work during part 2 and the model side had much more during part 3.