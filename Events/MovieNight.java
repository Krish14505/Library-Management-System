/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package Events;
/**
 * this is the sub-class of Event.
 * 
 * @author krish
 */
public class MovieNight extends Event{

    /**
     * calculating the admission of the MovieNight event using the eventType
     * enum class.
     */
    @Override
    public void calculateAdmissionFee() {
       this.admissionFees = EventType.MOVIE_NIGHT.getRate() * EventType.MOVIE_NIGHT.getDuration();
   }
    
}
