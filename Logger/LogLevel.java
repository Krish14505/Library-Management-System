package com.algonquin.cst8288.assignment2.logger;

//constants for the different types of various log types.
public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5);

    final int level;    
            
    //constructor
    LogLevel(int level) {
        this.level = level;
    }
}
