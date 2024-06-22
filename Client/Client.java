package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.Library.AcademicLibraryFactory;
import com.algonquin.cst8288.assignment2.Library.PublicLibraryFactory;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventManagement;
import java.util.Scanner;

/**
 * The class contains the main method taking input from the user. according to
 * the user choice, it performs the CRUD OPERATIONS.
 *
 * @author krish
 */
public class Client {

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {

        //creating an instance of the EventManagement to call the methods accordingly
        EventManagement eventmanagement = new EventManagement();
        //creating an instance of Event.
        Event event = null;
        int userInput; //controlls the loop for the user choice.

        //do-while loop continue until the user inputs 5.
        do {

            //prompts to display 
            System.out.println("======================================");
            System.out.println("The list of Operation: ");
            System.out.println("1.Create an Event");
            System.out.println("2.Retrieve an Event by event_id");
            System.out.println("3.update an event.");
            System.out.println("4.Delete an event.");
            System.out.println("5.Quit");
            System.out.println("======================================");

            Scanner sc = new Scanner(System.in); // scanner calls to take the user input.
            userInput = sc.nextInt(); // takes the Integer.

            //switch case for the different options for the CRUD operations.
            switch (userInput) {

                //case 1 for the inserting the record into the events table.
                case 1:
                    System.out.println("Inserting an event :");
                    System.out.println("What type of event do you want?(BookLaunch,Workshop,MovieNight,KidsStoryTime) ");
                    String userInputEvent = sc.next(); // take the name of the event.
                    //calling a method to determine which type of event object to create
                    createUserTypedEvent(event, userInputEvent); // calling a method 
                    event = createUserTypedEvent(event, userInputEvent); // event is created and assigned.
                    //inserting the data based on the user input
                    event.setEventName(userInputEvent); // set the type of the event.

                    //asking user for the event_description
                    System.out.println("Please Enter discription: ");
                    String userInputEventDes = sc.next(); //event_description column record
                    event.setEventDescription(userInputEventDes); //set the value.

                    //asking user for the event event_activities
                    System.out.println("Please Enter Event Activities: ");
                    String userInputEventAct = sc.next(); // event_activities record.
                    event.setEventActivities(userInputEventAct);

                    //set the event admission fee for the specific type of event 
                    event.calculateAdmissionFee(); // calling the method

                    System.out.println("Admission Fees: " + event.getAdmissionFees());

                    //send all the details to the database
                    eventmanagement.createEvent(event); // put all the things into the event.
                    System.out.println("Event Created..."); //last message 

                    break;

                //case 2 is for displaying the details of the event from the table based on the event id
                case 2:

                    //displaying the Event details depending on the event_id
                    System.out.println("Displaying One Event: ");
                    System.out.println("Enter an Event ID:  ");
                    int id = sc.nextInt(); //event_id

                    event = eventmanagement.retrieveEvent(id); //retrieving the event based on the id.
                    if (event != null) {
                        System.out.println("Event Name: " + event.getEventName());
                        System.out.println("Event Description: " + event.getEventDescription());
                        System.out.println("Event Activities: " + event.getEventActivities());
                        System.out.println("Admission Fees: " + event.getAdmissionFees());
                    } else {
                        System.out.println("Event not found!");
                    }
                    break;

                //case 3 for updating the row of the particular column value based on event_id 
                case 3:
                    //updating an event 
                    System.out.println("Updating an Event...");
                    //ask user which event they want to update
                    System.out.println("Please Enter an Event ID: ");
                    int event_id = sc.nextInt(); // event id

                    // Retrieve the event from the database
                    event = eventmanagement.retrieveEvent(event_id); //return the event and assign it.

                    //after getting an event_id, based on the user choice , which one to update
                    System.out.println("Please choose any of the following: ");
                    System.out.println("1.update Event name");
                    System.out.println("2.update Event description ");
                    System.out.println("3.update Event activities");

                    int userChoice = sc.nextInt();

                    //it executes when user wants to change the name of the event.
                    if (userChoice == 1) {
                        //ask the user for the event name
                        System.out.println("Please Enter the new event Name(BookLaunch,Workshop,MovieNight,KidsStoryTime) : ");
                        String eventtype = sc.next();
                        createUserTypedEvent(event, eventtype); // calling a method 
                        event = createUserTypedEvent(event, eventtype);
                        event.setEventName(eventtype); // set the type of the event.
                        event.calculateAdmissionFee(); // calculation of the admission fees if the user changes the event name.

                        System.out.println("Please enter the event description: ");
                        String eventDes = sc.next();
                        event.setEventDescription(eventDes);

                        System.out.println("Please enter the event activities: ");
                        String eventAct = sc.next();
                        event.setEventActivities(eventAct);

                    } //end of the if statement when the user selects to change the event name( any type of the event) 
                    //it is else-if statment which will be executed if the user selects the options(2 & 3) instead of selecting 1(event_name)
                    else if (userChoice == 2) {
                        //this event is the existing one that was built while the creation.

                        System.out.println("Please enter the event description: ");
                        String eventDes = sc.next(); //event_description.
                        event.setEventDescription(eventDes); //set it.
                    } else if (userChoice == 3) {
                        // the event used here is the existing one that was created while the insertation

                        System.out.println("Please enter the event Activities: ");
                        String eventAct = sc.next();
                        event.setEventActivities(eventAct);
                    }

                    //actually updating the event
                    EventManagement.updateEvent(event, event_id);

                    break;
                //case 4 for deleting the record from the events tables depending on the event_id
                case 4:
                    System.out.println("Deleting an Event");
                    System.out.println("Please enter an event_id you want to delete? ");
                    int userEnteredID = sc.nextInt();
                    eventmanagement.deleteEvent(userEnteredID); // user deleted
                    System.out.println("Event Deleted....");
                    break;

                default:
                    System.out.println("Please enter the valid number (between 1 and 4) to continue ");

            } //END OF SWITCH CASE.

        } while (userInput != 5); //end of do-while loop.

        System.out.println("Successfully Quit"); //quitting.

    }//end of main method

    //creating the static method to determine which type of event instance to create based on the userinput
    public static Event createUserTypedEvent(Event event, String userInputEvent) {
        //creating an instance of the  academic library factory which can be used to create the instance of the
        //Booklaunch and Workshop
        AcademicLibraryFactory factory1 = new AcademicLibraryFactory();

        //creating an instance of the public library factory which can be uitilized to create the instance of 
        //Movie Night and Kids story time.
        PublicLibraryFactory factory2 = new PublicLibraryFactory();
        //condition to create the specific type of objects of event.
        if (userInputEvent.equalsIgnoreCase("BookLaunch")) {
            event = factory1.createEvent(userInputEvent);
        } else if (userInputEvent.equalsIgnoreCase("Workshop")) {
            event = factory1.createEvent(userInputEvent);
        } else if (userInputEvent.equalsIgnoreCase("MovieNight")) {
            event = factory2.createEvent(userInputEvent);
        } else if (userInputEvent.equalsIgnoreCase("KidsStoryTime")) {
            event = factory2.createEvent(userInputEvent);
        } else {
            System.out.println("Please enter the valid category of Event !");
        }
        return event;

    }
    
} // end of client class

