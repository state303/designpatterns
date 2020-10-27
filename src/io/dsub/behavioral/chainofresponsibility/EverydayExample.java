package io.dsub.behavioral.chainofresponsibility;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EverydayExample {
    private static Logger logger = Logger.getLogger(EverydayExample.class.getName());

    public static void main(String[] args) {
        // level to log at
        logger.setLevel(Level.FINER);

        ConsoleHandler handler = new ConsoleHandler();

        //level to publish at
        handler.setLevel(Level.FINER);
        logger.addHandler(handler);

        logger.finest("Finest level of logging"); // this won't print out
        logger.finer("Finer level, but not as fine as finest");
        logger.fine("Fine level, but not as fine a s finer or finest");
    }
}
