# API Changes for our project


### Original API

##### Model Interfaces

Interface Observable
* Normal Observable interface, to tell when the model has been updated

Interface DataSource
* getPaintableIterator() returns Iterator<Paintable>

Interface iModel
* executeCommand(String command) return int
* saveFunctionsAndVariables(File fileToSave) return void
* loadFunctionsAndVariables(File fileToLoad) return void

##### View Interface

Interface iView
* returnMessage(String message) return void
* clearCommandWindow() return void
* updatePositionLabel(Location location) return void
* updateHeadingLabel(int heading) return void
* setModel(iModel model) return void

### New API

Changed/added methods are bolded and explained, removed methods are explained.

##### Model Interface

Interface Observable
* Normal Observable interface, to tell when the model has been updated

Interface DataSource
* getPaintableIterator() return Iterator<Paintable>
* __getReturnValue ()__ return int
** Replicates part of the returnMessage() in the original view. Decided to break out the 
return value from any additional message for testing purposes and because it better reflects
how our project is actually supposed to work.
* __getTurtlePosition ()__ return Location
** replicates updatePositionLabel from iView.
* __getTurtleHeading ()__ return int
** replicates UpdateHeadingLabel from iView.
* __showMessage ()__ return String
** Returns any additional message, such as an error message. 

Interface IModel
* executeCommand(String command) return int
* saveFunctionsAndVariables(File fileToSave) return void
* loadFunctionsAndVariables(File fileToLoad) return void
* __getDataSource()__ returns DataSource
** Added because now any View only has to take in a single IModel, reducing the co-dependence of
view and model.
* __initializeObserver(Observer observer)__ return void 
** adds the observer and then notifies it an initial time. Added so that View only has to take in 
the single IModel.

##### Why we removed the View interface
We found that all the methods in the view were just the Model giving the view data. 
Therefore, it would be simpler for the DataSource to contain this information and to
have the View query the DataSource for it instead of having the Model pass it this information.
We chose to do this because doing so would remove a link between the View and Model
(and thus further separate and insulate in the case of changes in either's structure),
made it easier to test Model (now we can just use the DataSource to test whether commands
worked or not), and keeps all the information that View recieves from Model in one place.
Before, the information was split up between DataSource (for the paintables) and iView 
(for the other information). 
