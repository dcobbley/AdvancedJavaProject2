package edu.pdx.cs410J.dcobbley;

import edu.pdx.cs410J.AbstractPhoneBill;
import edu.pdx.cs410J.PhoneBillDumper;

import java.io.IOException;

/**
 * Created by david on 7/13/15.
 */
public class TextDumper implements PhoneBillDumper {

    //private FILEPATH =
    /**
     * Dumps a phone bill to some destination.
     *
     * @param bill
     */
    @Override
    public void dump(AbstractPhoneBill bill) {
        String path = System.getProperty("user.dir");
        System.out.println( path);
        //System.out.println(bill.getCustomer());
        //System.out.println(bill.getPhoneCalls());
    }
}
