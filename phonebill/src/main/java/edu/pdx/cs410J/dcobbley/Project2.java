/** Description of Project2
        *
        * @author David Cobbley
        * @version 1.0 July 7, 2015.
        *Phonebill application for Advanced Java course at Portland State University
        * The main class for the CS410J Phone Bill Project
        * Parses the command line and calls appropriate functionality.
        */
package edu.pdx.cs410J.dcobbley;

import edu.pdx.cs410J.AbstractPhoneBill;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Project2 {

  static phonebill myPhoneBill;
  static String customer;
  static String callerNumber;
  static String calleeNumber;
  static String startTime;
  static String endTime;

  /**
   * Main will be called when the program is run, it parses the commands given by the user and calls the appropriate functionality.
   * @param args contains all the command line arguments passed into the program
   * @throws IllegalArgumentException Exception if there is either not enough arguments or the wrong arguments
   */
  public static void main(String[] args) {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
      try {
          if (args.length == 0) //Check if there are no arguments
              throw new IllegalArgumentException("Missing command line arguments");
          if(args.length == 1 && args[0].contains("-README")){
              Readme();
              System.exit(0);
          }
          if(args.length == 1 && args[0].contains("-testing")){
              new TextDumper().dump(null);
              System.exit(0);
          }
          else if (args.length < 6) //Check if there are not enough arguments to be a complete phonecall
              throw new IllegalArgumentException("Not enough args");      }
      catch(IllegalArgumentException ex)
      {
        System.out.println(ex.getMessage());
        System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>\n" +
                "   args are (in this order):\n" +
                "       customer               Person whose phone bill we’re modeling\n" +
                "       callerNumber           Phone number of caller\n" +
                "       calleeNumber           Phone number of person who was called\n" +
                "       startTime              Date and time call began (24-hour time)\n" +
                "       endTime                Date and time call ended (24-hour time)\n" +
                "   options are (options may appear in any order):\n" +
                "       -print                 Prints a description of the new phone call\n" +
                "       -README                Prints a README for this project and exits\n" +
                "   Date and time should be in the format: mm/dd/yyyy hh:mm");
        System.exit(1);
      }

    /**
     * These variables are used to temporarily store the data passed into the program
     * Not as efficient to store the data just to pass it into a new function, but if data needs to be scrubbed first...
     * @param myPhoneBill Used to store a new instance of the phonebill for a particular customer
     * @param customer Customer name
     * @param callerNumber Customer number
     * @param calleeNumber Number the customer is trying to contact
     * @param startTime Time the phonecall began
     * @param endTime Time the phonecall ended
     */

    try{
    customer = args[0];
    callerNumber = args[1];
    calleeNumber = args[2];

    startTime = args[3] + " ";
    startTime += args[4];

    endTime = args[5] + " ";
    endTime += args[6];

    if(startTime.contains("\"")||endTime.contains("\""))
        throw new IllegalArgumentException("Date and time cannot contain quotes ");
    if(!callerNumber.matches("\\d{3}-\\d{3}-\\d{4}$")||!calleeNumber.matches("\\d{3}-\\d{3}-\\d{4}$"))
        throw new IllegalArgumentException("Phone numbers must contain exactly 10 digits plus two dashes");
    if(!args[3].matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)")||!args[5].matches("(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)"))
        throw new IllegalArgumentException("Date format must follow mm/dd/yyyy");
    if(!args[4].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")||!args[6].matches("([01]?[0-9]|2[0-3]):[0-5][0-9]"))
        throw new IllegalArgumentException("Time format must follow mm:hh (24 hour time)");
    }
    catch (IllegalArgumentException ex){
        System.out.println(args[3]);
        System.out.println(ex.getMessage());
        System.exit(1);
    }
    //Create a new instance of Phonebill with a new phonecall. When we have persistent data, this line will change.
    myPhoneBill = new phonebill(customer, new phonecall(callerNumber, calleeNumber, startTime, endTime));

    /**This is a bit clunky, could use improvement.
    * If there are extra argument after those needed for a phone call, check if they are the print or the README option
    * Break if there are more than 8 arguments total.
     */
    try {
        for (int x = 7; x < args.length; x++) {
            if (x > 8)
                break;
            switch (args[x]) {
                case "-README":
                    Readme();
                    break;
                case "-print":
                    System.out.println("Customer: " + myPhoneBill.getCustomer() + " " + myPhoneBill.getPhoneCalls());
                    break;
                default:
                    throw new IllegalArgumentException("Command Line Argument not found: \"" + args[x] +"\"");
            }
        }
    }
    catch(IllegalArgumentException ex){
        System.out.println(ex.getMessage());
        System.exit(1);
    }
    System.exit(0);
  }

    /**
     * Readme function contains the readme of all useful information the user may need to know.
     */
    private static void Readme() {
        System.out.println("README has been called");
        System.out.println("This program is a phonebill application which takes a very specific amount of arguments");
        System.out.println("You must provide a customer name, caller number, callee number, start time, and end time (mm/dd/yyyy mm:hh)");
        System.out.println();
        System.out.println("Usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>\n" +
                "   args are (in this order):\n" +
                "       customer               Person whose phone bill we’re modeling\n" +
                "       callerNumber           Phone number of caller\n" +
                "       calleeNumber           Phone number of person who was called\n" +
                "       startTime              Date and time call began (24-hour time)\n" +
                "       endTime                Date and time call ended (24-hour time)\n" +
                "   options are (options may appear in any order):\n" +
                "       -print                 Prints a description of the new phone call\n" +
                "       -README                Prints a README for this project and exits\n" +
                "   Date and time should be in the format: mm/dd/yyyy hh:mm");
    }


}