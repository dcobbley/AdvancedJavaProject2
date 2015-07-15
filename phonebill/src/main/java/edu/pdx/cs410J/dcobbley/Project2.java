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
import edu.pdx.cs410J.AbstractPhoneCall;

import java.util.ArrayList;
import java.util.Collection;

public class Project2 {
    //Global variables
    static ArrayList<String> commands; //used to keep track of all the commands that will be run at the end of the program
  /**
   * Main will be called when the program is run, it parses the commands given by the user and calls the appropriate functionality.
   * @param args contains all the command line arguments passed into the program
   * @throws IllegalArgumentException Exception if there is either not enough arguments or the wrong arguments
   */
  public static void main(String[] args) {
    Class c = AbstractPhoneBill.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    commands = new ArrayList<String>();
      parseCommandsAtBeginning(args);

    System.exit(0);
  }


    /**
     *
     * @param args
     * @throws
     */
    private static void parseCommandsAtBeginning(String[] args){
        int element = 0;
        //Check if one of the first 3 args is a command
        //If one or all three args are commands, put them into a command array which will get executed after work is done
        //Start parsing for a customer


        /*
        try {
          if (args.length == 0) //Check if there are no arguments
              throw new IllegalArgumentException("Missing command line arguments");
          if(args.length == 1){
              switch(args[0]) {
                  case "-README":
                      Readme();
                      System.exit(0);
                      break;
                  default:
                      throw new IllegalArgumentException("Incorrect args");
              }
          }
          if(args.length == 2){
              switch(args[0]){
                  case "-textFile":
                      parse = new TextParser();
                      parse.setFilePath(args[1]);
                      if(parse.ifFileExists()){
                          currentPhoneBill = parse.parse();
                          System.exit(0);
                      }
                      else
                      {
                          //Create an empty phopne bill and write to disk
                          currentPhoneBill = new phonebill();
                          dump = new TextDumper();
                          dump.setFilePath(args[1]);
                          dump.dump(currentPhoneBill);
                      }

                      break;
                  default:
                      throw new IllegalArgumentException("Incorrect args for -textFile ");
                      }
                  }
                  if(args.length == 3){
                      switch(args[0]){
                          case "-textFile":
                              parse = new TextParser();
                              parse.setFilePath(args[1]);
                              currentPhoneBill = parse.parse();
                              break;
                          case "-README":
                              Readme();
                              System.exit(0);
                              break;
                          default:
                              throw new IllegalArgumentException("Incorrect args for -textFile ");
                      }
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
         */
        parseCustomerIfExists(args, element);
    }

    /**
     *
     * @param args
     * @param element
     * @throws
     */
    private static void parseCustomerIfExists(String[] args, int element){
        //collect all customer data and phone call data.
        //Try to use only locals as much as possible
/*
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
        catch (IllegalArgumentException ex){;
            System.out.println(ex.getMessage());
            System.exit(1);
        }
 */
        //Create a new instance of Phonebill with a new phonecall. When we have persistent data, this line will change.
        //myPhoneBill = new phonebill(customer, new phonecall(callerNumber, calleeNumber, startTime, endTime));


        //Parse for commands at the end
        parseCommandsAtEnd(args, element);
    }

    /**
     *
     * @param args
     * @param element
     * @throws
     */
    private static void parseCommandsAtEnd(String[] args, int element){
        //while elements<args.length keep parsing.
        //if case is a valid command, add it to the list
    }

    /**
     *
     * @param arg
     * @throws
     */
    private static void addArgumentCommand(String arg){
        //Modify the list array of commands.
        //This list of commands ie -README, -print, -textFile will get executed after any other work is done.

        /*
        try {
        for (int x = 7; x < args.length; x++) {
            if (x > 10)
                break;
            switch (args[x]) {
                case "-README":
                    Readme();
                    break;
                case "-print":
                    System.out.println("Customer: " + myPhoneBill.getCustomer() + " " + myPhoneBill.getPhoneCalls());
                    break;
                case "-textFile":
                    //must contain x+1, pass the
                    if(args[++x] != null) {
                        parse = new TextParser();
                        parse.setFilePath(args[x]);
                        //File exists
                        if(parse.ifFileExists()){
                            //Parse the file & read in phonebill
                            otherPhoneBill = parse.parse();
                            //check that the customer names match
                            if(myPhoneBill.getCustomer().equals(otherPhoneBill.getCustomer())){
                                //try to add the phonecall to the list of phone calls - watch for duplicates
                                Collection tempPhoneCalls = otherPhoneBill.getPhoneCalls();
                                tempPhoneCalls.forEach(obj->myPhoneBill.addPhoneCall((AbstractPhoneCall) obj));
                                //dump the bill back to the text file
                                dump = new TextDumper();
                                dump.setFilePath(args[x]);
                                dump.dump(myPhoneBill);

                            }
                        }
                        else{
                            //File does not exist
                            //create a new dump
                            dump = new TextDumper();
                            dump.setFilePath(args[x]);
                            //dump
                            dump.dump(myPhoneBill);
                        }
                        }
                        else{
                            throw new IllegalArgumentException("-textFile argument must contain a valid file name");
                        }

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
         */


        //Check if arg exists in the list before adding
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