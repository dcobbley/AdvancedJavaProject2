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
    //Constants
    private static final int MAXARGUMENTS = 3;//Update this value if we get more than -readme -print -textFile
    //Global variables
    static ArrayList<String> commands; //used to keep track of all the commands that will be run at the end of the program
    static phonebill MyPhoneBill = null;
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
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Cannot have zero arguments");
            }


            //Check if one of the first 3 args is a command
            //If one or all three args are commands, put them into a command array which will get executed after work is done
            //Start parsing for a customer
            for (; element < MAXARGUMENTS && element < args.length; element++) {
                //check if -print, -README, -textFile filename
                switch (args[element]) {
                    case "-README":
                        //add readme to the command list
                        addArgumentCommand("-README");
                        break;
                    case "-print":
                        //add print to the list
                        addArgumentCommand("-print");
                        break;
                    case "-textFile":
                        //check for ++element
                        if (args.length > element + 1) {
                            //save -textfile Filename
                            addArgumentCommand("textFile " + args[++element]);
                        } else {
                            //throw error
                        }
                        break;
                    default:
                        parseCustomerIfExists(args, element);
                        break;
                }
            }
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            Readme();
            System.exit(1);
        }
        //if first three args are all commands, then begin to parse the next bit if it exists.
        parseCustomerIfExists(args, element);

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

        //check that element to element+6 exists
        if(args.length>element+6){
            //parse out customer information
            MyPhoneBill = new phonebill(args[element++], new phonecall(args[element++], args[element++], args[element++]+ " " + args[element++], args[element++]+ " "+  args[element++]));
                                        //customer                       caller            callee        starttime         +         data          endtime           +         data
            //Parse commands at the end of the arg
            parseCommandsAtEnd(args, element);
        }
        else{
            if(args.length>element+5){
                //didn't provide enough args
                //throw error
            }
            else{
                //go straight to executing the commands

                System.out.println("Execute B called");
                executeCommands();
            }
        }
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
        int maxElement = element +3;
        while(args.length> element && args.length<maxElement){
            //there are args to parse
            switch(args[element]){
                case "-README":
                    //add readme to the command list
                    addArgumentCommand("-README");
                    break;
                case "-print":
                    //add print to the list
                    addArgumentCommand("-print");
                    break;
                case "-textFile":
                    //check for ++element
                    if(args.length > element+1){
                        //save -textfile Filename
                        addArgumentCommand("textFile "+args[++element]);
                    }
                    else{
                        //throw error
                    }
                    break;
                default:
                    //throw error, cannot exist
                    break;
            }

            element++;

        }
        //no args left to parse, begin execution

        System.out.println("execute A called");
        executeCommands();
    }

    /**
     *
     * @param arg
     * @throws
     */
    private static void addArgumentCommand(String arg){
        //Modify the list array of commands.
        //This list of commands ie -README, -print, -textFile will get executed after any other work is done.
        if(!commands.contains(arg)){
            //Check if the list already contains it
            commands.add(arg);
        }
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

    private static void executeCommands(){

        System.out.println("Execute commands called");
        boolean printFlag = false;
        //Begin executing commands
        //check if the commands exist and execute in this order.
        //textFile-
        // check if it exists, if so, {
        // read in and compare with myPhoneBill.
        //if customer name not equal throw error
        //if myPhoneBill == null, set TemporaryPhoneBill to myPhoneBill
        //
        //else{
        //create a new empty phone bill
        //add myPhoneBill to it, if myPhoneBill is null, create emptyphonebill

        //print
        //simply print myPhoneBill, should contain an up to date version of whatever it needs

        //readme
        //Simply call the readme
        try {
            for (String comm : commands) {
                if (comm.contains("-textFile")) {


                    //commands.remove(commands.indexOf(comm));

                    //commands.remove(commands.indexOf(comm)+1);
                }
            }
            int x= 0;
            for (String comm : commands) {
                if (!printFlag &&comm.contains("-print")) {
                    System.out.println("if Statement called");
                    if (MyPhoneBill != null) {
                        System.out.println("Customer: " + MyPhoneBill.getCustomer() + " " + MyPhoneBill.getPhoneCalls());
                        printFlag = true;
                    } else {
                        //MyphoneBill is null, throw exception
                        throw new Exception("Must provide a phone bill");
                    }
                }
            }
            for (String comm : commands) {
                if (comm.contains("-README")) {
                    Readme();

                    //commands.remove(commands.indexOf(comm));
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            Readme();
            System.exit(1);
        }
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