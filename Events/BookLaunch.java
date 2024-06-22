package Events;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * BookLaunch is the type of the event.
 * @author krish
 */
public class BookLaunch extends Event  {

    /**
     * calculating the admission of the BookLaunch event using the eventType 
     * enum class.
     */
    @Override 
    public void calculateAdmissionFee() {
        this.admissionFees = EventType.BOOK_LAUNCH.getRate() * EventType.BOOK_LAUNCH.getDuration();
    }

  
}
