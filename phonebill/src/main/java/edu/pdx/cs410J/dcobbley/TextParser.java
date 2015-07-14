package edu.pdx.cs410J.dcobbley;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.ParserException;
import edu.pdx.cs410J.PhoneBillParser;
import sun.plugin.dom.core.Text;

import java.io.*;

/**
 * Created by david on 7/13/15.
 */
public class TextParser implements PhoneBillParser {


    File file;
    String path=null;
    /**
     * Parses some source and returns a phone bill
     *
     * @throws ParserException If the source cannot be parsed
     */
    @Override
    public AbstractPhoneBill parse() {
        BufferedReader reader = null;
        try{
            reader=new BufferedReader(new FileReader(file));
            String line;
            String allLines="";
            while ((line = reader.readLine()) != null) {
                allLines+=line +"\n";
            }
            ParseString(allLines);
        }
        catch(IOException ex){
            System.out.println("Error Reading From File "+ ex);
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void setFilePath(String path){
        this.path = System.getProperty("user.dir");
        file = new File(this.path+ "/" + path + ".txt");
    }

    public void ParseString(String line){
        AbstractPhoneBill myPhoneBill;
        String callerNumber;
        String calleeNumber;
        String startTime;
        String endTime;

        //String[] tokens = line.split("\\s+|,\\s*|\\.\\s*");
        String[] tokens = line.split("\\r?\\n");
        int length = tokens.length;
        /*for(int x =0;x<tokens.length;x++)
        {
            System.out.println(x+": "+tokens[x]);
        }*/

        myPhoneBill = new phonebill(tokens[1].substring(10));
        for(int counter = 2;counter < length;counter++ ){
            if(tokens[counter] != null){
                String[] temp = tokens[counter].split("\\s+|,\\s*|\\.\\s*");
                if(temp.length>10)
                    System.out.println("foo");
                    //myPhoneBill.addPhoneCall(new phonecall(temp[3],temp[5],temp[7]+temp[8], temp[10]+temp[11].substring(0,temp[11].length()-1)));

            }
        }
    }


}
