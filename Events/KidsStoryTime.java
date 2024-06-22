/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

/**
 * KidsStoryTime is the type of event.
 *
 * @author krish
 */
public class KidsStoryTime extends Event {

    /**
     * calculating the admission of the KidsStoryTime event using the eventType
     * enum class.
     */
    @Override
    public void calculateAdmissionFee() {
        this.admissionFees = EventType.KIDS_STORY.getRate() * EventType.KIDS_STORY.getDuration();
    }

}
