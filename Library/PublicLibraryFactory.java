/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import Events.Event;
import Events.KidsStoryTime;
import Events.MovieNight;

/**
 *
 * @author krish
 * it is responsible for creating instances of PublicLibrary event types: MovieNight and KidsStoryTime
 */
public class PublicLibraryFactory extends Library {

    @Override
    public Event createEvent(String eventType) {

        //condition becomes true if the eventtype contains MovieNight
        if (eventType.equalsIgnoreCase("MovieNight")) {
            return new MovieNight();
            
        }
        //condition becomes true if the eventtype contains MovieNight
        else if (eventType.equalsIgnoreCase("KidsStoryTime")) {
            return new KidsStoryTime();
        }
        else {
            System.out.println("Please enter the valid event Type");
        }
        return null;
    }

}
