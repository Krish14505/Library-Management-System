/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package Library;

import Events.BookLaunch;
import Events.Event;
import Events.Workshop;

/**
 *
 * @author krish
 * this class is responsible for creating the instances of event-type of
 * Academic library.(Workshop & BookLaunch)
 * 
 */
public class AcademicLibraryFactory  extends Library{

   
    @Override
    public  Event createEvent(String eventType) {
        
        //condition becomes true if the string contains Workshop
        if(eventType.equalsIgnoreCase("WorkShop") ){
            return  new Workshop();
        }
         //condition becomes true if the string contains BookLaunch
        else if(eventType.equalsIgnoreCase("BookLaunch")) {
            return new BookLaunch();
        }
        else {
            System.out.println("Please enter the valid event type");
        }
        return null; 
    }
    
    
}
