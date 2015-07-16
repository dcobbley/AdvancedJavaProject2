package edu.pdx.cs410J.dcobbley;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import edu.pdx.cs410J.InvokeMainTestCase;

import java.io.File;
import java.io.PrintWriter;

import static junit.framework.Assert.assertEquals;

/**
 * Tests the functionality in the {@link Project2} main class.
 */
public class Project2Test extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project2} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project2.class, args );
    }

  /**
   * Tests that invoking the main method with no arguments issues an error
   */

/*
    //Conditional upon their being a DavesBill file in the correct directory
    @Test
    public void TestTextFileNoDataNoArgsWithFileExists(){
        MainMethodResult result = invokeMain("-textFile","DavesBill");
        assertEquals(new Integer(0), result.getExitCode());
        assertTrue(result.getOut().equals(""));
    }
*/
    @Test
    public void TestFromGrader(){
        MainMethodResult result = invokeMain("-print", "Test8", "123-456-7890", "234-567-8901", "03/03/2015", "12:00", "05/04/2015", "16:00");
        assertEquals(new Integer(0), result.getExitCode());
        assertTrue(result.getOut().contains("Customer: Test8 [Phone call from 123-456-7890 to 234-567-8901 from 03/03/2015 12:00 to 05/04/2015 16:00]"));
    }




  @Test
  public void TestEmptyTextFile(){
      try {
          String path = System.getProperty("user.dir") + "/DavesBill.txt";
          File file = new File(path);
          PrintWriter writer = new PrintWriter(file);
          writer.write("");
          writer.flush();
          writer.close();
      }
      catch(Exception ex){

      }
      MainMethodResult result = invokeMain("-textFile", "DavesBill");
      assertEquals(new Integer(1), result.getExitCode());
      assertTrue(result.getOut().contains("Error Reading From File Empty File"));
  }



    @Test
  public void TestTextDumper(){
      MainMethodResult result = invokeMain("david", "503-709-4866", "503-880-6960", "10/15/2015", "09:38", "10/15/2015", "09:42", "-textFile", "DavesBill");
      assertEquals(new Integer(0), result.getExitCode());

  }

    @Test
  public void TestTextFileNodataNoArgsNofile(){
      MainMethodResult result = invokeMain("-textFile");
      assertEquals(new Integer(1), result.getExitCode());
      assertTrue(result.getOut().contains("-textFile argument must be followed by <filename>\n" +
              "README has been called\n" +
              "This program is a phonebill application which takes a very specific amount of arguments\n" +
              "You must provide a customer name, caller number, callee number, start time, and end time (mm/dd/yyyy mm:hh)\n" +
              "\n" +
              "usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>\n" +
              "args are (in this order):\n" +
              "customer               Person whose phone bill we’re modeling\n" +
              "callerNumber           Phone number of caller\n" +
              "calleeNumber           Phone number of person who was called\n" +
              "startTime              Date and time call began (24-hour time)\n" +
              "endTime                Date and time call ended (24-hour time)\n" +
              "options are (options may appear in any order):\n" +
              "-textFile file         Where to read/write the phone bill\n" +
              "-print                 Prints a description of the new phone call\n" +
              "-README                Prints a README for this project and exits\n" +
              "Dates and times should be in the format: mm/dd/yyyy hh:mm"));
      //System.out.println(result.getOut());
  }

  @Test
  public void TestPrintNoDataNoOtherArgs(){
      MainMethodResult result = invokeMain("-print");
      assertEquals(new Integer(1), result.getExitCode());
        assertTrue(result.getOut().contains("Must provide a phone bill\n" +
                "README has been called\n" +
                "This program is a phonebill application which takes a very specific amount of arguments\n" +
                "You must provide a customer name, caller number, callee number, start time, and end time (mm/dd/yyyy mm:hh)\n" +
                "\n" +
                "usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>\n" +
                "args are (in this order):\n" +
                "customer               Person whose phone bill we’re modeling\n" +
                "callerNumber           Phone number of caller\n" +
                "calleeNumber           Phone number of person who was called\n" +
                "startTime              Date and time call began (24-hour time)\n" +
                "endTime                Date and time call ended (24-hour time)\n" +
                "options are (options may appear in any order):\n" +
                "-textFile file         Where to read/write the phone bill\n" +
                "-print                 Prints a description of the new phone call\n" +
                "-README                Prints a README for this project and exits\n" +
                "Dates and times should be in the format: mm/dd/yyyy hh:mm"));

  }

  @Test
  public void TestReadmeNoDataNoArgs(){
      MainMethodResult result = invokeMain("-README");
      assertEquals(new Integer(0), result.getExitCode());
      assertTrue(result.getOut().contains("README has been called\n" +
              "This program is a phonebill application which takes a very specific amount of arguments\n" +
              "You must provide a customer name, caller number, callee number, start time, and end time (mm/dd/yyyy mm:hh)\n" +
              "\n" +
              "usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>\n" +
              "args are (in this order):\n" +
              "customer               Person whose phone bill we’re modeling\n" +
              "callerNumber           Phone number of caller\n" +
              "calleeNumber           Phone number of person who was called\n" +
              "startTime              Date and time call began (24-hour time)\n" +
              "endTime                Date and time call ended (24-hour time)\n" +
              "options are (options may appear in any order):\n" +
              "-textFile file         Where to read/write the phone bill\n" +
              "-print                 Prints a description of the new phone call\n" +
              "-README                Prints a README for this project and exits\n" +
              "Dates and times should be in the format: mm/dd/yyyy hh:mm"));
  }

    @Test
    public void testRegularCommandLineArguments(){
        MainMethodResult result = invokeMain("david", "503-709-4866", "503-880-6960", "10/15/2015", "09:38", "10/15/2015", "09:42", "-print");
        assertEquals(new Integer(0), result.getExitCode());
        assertTrue(result.getOut().contains("david [Phone call from 503-709-4866 to 503-880-6960 from 10/15/2015 09:38 to 10/15/2015 09:42]"));
    }


    @Test
    public void testAllCommandLineArguments(){
        MainMethodResult result = invokeMain("david", "503-709-4866", "503-880-6960", "10/15/2015", "09:38", "10/15/2015", "09:42", "-print", "-README");
        assertEquals(new Integer(0), result.getExitCode());
        assertTrue(result.getOut().contains("Customer: david [Phone call from 503-709-4866 to 503-880-6960 from 10/15/2015 09:38 to 10/15/2015 09:42]\n" +
                "README has been called\n" +
                "This program is a phonebill application which takes a very specific amount of arguments\n" +
                "You must provide a customer name, caller number, callee number, start time, and end time (mm/dd/yyyy mm:hh)\n" +
                "\n" +
                "usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>\n" +
                "args are (in this order):\n" +
                "customer               Person whose phone bill we’re modeling\n" +
                "callerNumber           Phone number of caller\n" +
                "calleeNumber           Phone number of person who was called\n" +
                "startTime              Date and time call began (24-hour time)\n" +
                "endTime                Date and time call ended (24-hour time)\n" +
                "options are (options may appear in any order):\n" +
                "-textFile file         Where to read/write the phone bill\n" +
                "-print                 Prints a description of the new phone call\n" +
                "-README                Prints a README for this project and exits\n" +
                "Dates and times should be in the format: mm/dd/yyyy hh:mm"));
    }

    @Test
    public void NoCommandLineArgs(){
        MainMethodResult result = invokeMain();
        assertEquals(new Integer(1), result.getExitCode());
        assertTrue(result.getOut().contains("Cannot have zero arguments\n" +
                "README has been called\n" +
                "This program is a phonebill application which takes a very specific amount of arguments\n" +
                "You must provide a customer name, caller number, callee number, start time, and end time (mm/dd/yyyy mm:hh)\n" +
                "\n" +
                "usage: java edu.pdx.cs410J.<login-id>.Project2 [options] <args>\n" +
                "args are (in this order):\n" +
                "customer               Person whose phone bill we’re modeling\n" +
                "callerNumber           Phone number of caller\n" +
                "calleeNumber           Phone number of person who was called\n" +
                "startTime              Date and time call began (24-hour time)\n" +
                "endTime                Date and time call ended (24-hour time)\n" +
                "options are (options may appear in any order):\n" +
                "-textFile file         Where to read/write the phone bill\n" +
                "-print                 Prints a description of the new phone call\n" +
                "-README                Prints a README for this project and exits\n" +
                "Dates and times should be in the format: mm/dd/yyyy hh:mm"));
        //System.out.println(result.getOut());
    }

    @Test
    public void TestNonExistantFile(){
        try{
            String path = System.getProperty("user.dir") + "/DavesBill.txt";
            File file = new File(path);
            file.delete();
        }
        catch(Exception ex){
            System.out.println("Sad Day");
        }
        MainMethodResult result = invokeMain("-textFile", "DavesBill");
        assertEquals(new Integer(0), result.getExitCode());

    }



}