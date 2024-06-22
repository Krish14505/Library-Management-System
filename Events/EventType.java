package Events;

import Constants.Constants;

//this is the enum class that has the group of constats which are defined in the Constans package
public enum EventType {
	 KIDS_STORY(Constants.KIDS_STORYTIME_RATE,Constants.KIDS_STORYTIME_DURATION),
	 MOVIE_NIGHT(Constants.MOVIE_NIGHT_RATE,Constants.MOVIE_NIGHT_DURATION),
	 WORKSHOP(Constants.WORKSHOP_RATE,Constants.WORKSHOP_DURATION),
         BOOK_LAUNCH(Constants.BOOK_LAUNCH_RATE,Constants.BOOK_LAUNCH_DURATION);
        
    //creating a field to access the values for each of them
         final double rate;
         final double duration;
         
      //constructor 
         EventType(double rate, double duration){
             this.rate = rate;
             this.duration = duration;
         }
         
        //getters for the 
         
            public double getRate(){
                return rate;
            }
            public double getDuration(){
             return duration;
         }
            
         //you can use the variables like 
         //EventType.Workshop.getRate()
         
           //QUESTION? 
            //--> WHAT ABOUT BOOKLAUNCH?
         
         
}
