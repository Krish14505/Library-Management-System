package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.client.Client;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.logger.LMSLogger;
import com.algonquin.cst8288.assignment2.logger.LogLevel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to do CRUD operation in the database.
 *
 * @author krish
 */
public class DBOperations {

    /**
     * method to insert the data into into the events table
     * @param event
     */
    public static void createEvent(Event event) {
        Connection connection = null;
        PreparedStatement pstatement = null;

        try {
            //establish the connection using the DBConnection.
            connection = DBConnection.getInstance().getConnection();
            //prepare the string variable and store the sql statment as a string.
            String sql = "INSERT INTO events (event_name,event_description,event_activities,admission_fees)"
                    + "VALUES (?,?,?,?)";
            pstatement = connection.prepareStatement(sql); //preparing the statement

            //Grabing the some instances of the Event classes.
            pstatement.setString(1, event.getEventName());
            pstatement.setString(2, event.getEventDescription());
            pstatement.setString(3, event.getEventActivities());
            pstatement.setDouble(4, event.getAdmissionFees());

            //executing the pstatement
            pstatement.executeUpdate();

        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failure to create Event:" + e.getMessage());
            LMSLogger.getInstance().logException(e);
        }
    }
    
    /**
     * This is used to retrieve an event record by the event_id.
     * @param event_id
     * @return Event instance
     */

    public static Event retrieveEvent(int event_id) {

        Connection connection;
        PreparedStatement pstatement;
        ResultSet rs;
        Event event = null;

        try {
            //establish the connection 
            connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM events WHERE event_id = ? ";
            pstatement = connection.prepareStatement(sql);
            pstatement.setInt(1, event_id);
            rs = pstatement.executeQuery();

            //loop through grabing all the data
            while (rs.next()) {

                //declaring the variable for each columns and get the value through the resultset.
                String eventName = rs.getString("event_name");
                String eventDescription = rs.getString("event_description");
                String eventActivities = rs.getString("event_activities");
                double admissionFees = rs.getDouble("admission_fees");

                //creating an event instance.
                event = Client.createUserTypedEvent(event, eventName);
                
                event.setEventName(eventName);
                event.setEventDescription(eventDescription);
                event.setEventActivities(eventActivities);
                event.setAdmissionFees(admissionFees);

            }
        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failure to retrieve an event" + e.getMessage());
            LMSLogger.getInstance().logException(e);
        }
        return event;
    }

    /**
     * This class is used to update an event based on the event_name and event_id
     * @param event
     * @param event_id 
     */
    public static void updateEvent(Event event, int event_id) {
        Connection connection = null;
        PreparedStatement pstatement = null;

        try {
            //establish the connection
            connection = DBConnection.getInstance().getConnection();
            //query
            String sql = "UPDATE events SET event_name = ?,"
                    + "event_description = ? , event_activities = ?,"
                    + "admission_fees =  ? WHERE event_id = ? ";
            //preparing the statement.
            pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, event.getEventName());
            pstatement.setString(2, event.getEventDescription());
            pstatement.setString(3, event.getEventActivities());
            pstatement.setDouble(4, event.getAdmissionFees());
            pstatement.setInt(5, event_id);
            pstatement.executeUpdate(); //execution of the update.

        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failure to update an event");
            LMSLogger.getInstance().logException(e);
        }

    }
    /**
     * this class is responsible for deleting a record in the events table.
     * @param event_id 
     */

    public static void deleteEvent(int event_id) {
        Connection connection = null;
        PreparedStatement pstatement = null;

        try {
            //build the connection
            connection = DBConnection.getInstance().getConnection();
            //query
            String sql = "DELETE FROM events WHERE event_id = ? ";
            //prepare the statement 
            pstatement = connection.prepareStatement(sql);
            pstatement.setInt(1, event_id);
            pstatement.executeUpdate(); //execution of the update 
        } catch (SQLException e) {
            LMSLogger.getInstance().log(LogLevel.ERROR, "Failure to delete an Event");
            LMSLogger.getInstance().logException(e);
        }
    }
}
