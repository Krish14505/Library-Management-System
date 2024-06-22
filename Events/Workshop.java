/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Events;
/**
 * Workshop is the type of the event.
 * @author krish
 */
public class Workshop extends Event{

    /**
     * calculating the admission of the Workshop event using the eventType
     * enum class.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = EventType.WORKSHOP.getRate() * EventType.WORKSHOP.getDuration();
    }
    
    
}
