/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package Events;

/**
 *Event management class is used to invoke the specific CRUD operation method from the 
 * DBOperation class. 
 * @author krish
 */
public class EventManagement {
   
    //instance variable the type of DBOperation to call the methods.
   public DBOperations dboperation = null;
   
   //constructor
  public EventManagement (){
     
  }
  
  //methods which will invoke the DBOperation methods.
  public static void createEvent(Event event) {
           DBOperations.createEvent(event);
  }
 
  public static Event retrieveEvent(int event_id){
          return  DBOperations.retrieveEvent(event_id);
  }
  
  public static void updateEvent(Event event,int event_id){
      DBOperations.updateEvent(event,event_id);
  }
  
  public static void deleteEvent(int event_id){
      DBOperations.deleteEvent(event_id);
  }
  

  
  
           
   
   
}
