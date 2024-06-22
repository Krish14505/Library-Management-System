package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Logger.LMSLogger;
import Logger.LogLevel;
/**
 * This class is used to build the database connection between database.
 * @author krish
 */
public class DBConnection {
	
	private static Connection connection = null;
	private static DBConnection dbconnection ; // instance of itself to make it singleton
        
        
        //Information for the connection.
	private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
	private String userString = "CST8288";
	private String passwordString = "Krish@14505";
	private String driverString = "com.mysql.cj.jdbc.Driver";
	
        
        //prinvate connection when object created,establish the connection using DriverManager.
        private DBConnection() {
           try {
               //establishing the connection with using DriveManager.
                Class.forName(driverString);
                connection = DriverManager.getConnection(serverUrl,userString,passwordString);
                
           }catch(ClassNotFoundException | SQLException e) {
                 LMSLogger.getInstance().log(LogLevel.ERROR, "Failure to Connect Database"+e.getMessage());
                LMSLogger.getInstance().logException(e);
           }
            
        }
        
        
        /**
         * create a method by which this class can be instantiated.
         * @return the instance of the db connection
         */
        public static DBConnection getInstance(){
           
            if(dbconnection == null ){
                dbconnection = new DBConnection();
            }
            return dbconnection;
        }
        
       /**
        *  //get the connection
        * @return connection
        */
        public Connection getConnection() {
            return connection;
        }
}
