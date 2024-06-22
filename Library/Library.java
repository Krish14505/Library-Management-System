/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library;

import Events.Event;

/**
 *
 * @author krish
 * This class is the abstract class of having the different types of Libraries(creator)
 * it class can be inherited by the another classes to make the specific event:
 * (AcademicLibraryFactory & PublicLibraryFactory) 
 */
public abstract class Library {
 
    //abstract method 
    public abstract Event createEvent(String eventType) ;
}
