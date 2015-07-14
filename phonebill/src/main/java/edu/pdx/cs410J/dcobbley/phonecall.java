package edu.pdx.cs410J.dcobbley;

import edu.pdx.cs410J.AbstractPhoneCall;

/**
 * Created by david on 7/6/15.
 * A single instance of a phonecall that has occured. Includes a caller and callee number
 */
public class phonecall extends AbstractPhoneCall {
    String callerNumber;
    String calleeNumber;
    String startTime;
    String endTime;

    /**
     * Constructor for the phonecall class. Holds all relavent data for a particular phonecall
     * @param callerNumber The phone number of the customer
     * @param calleeNumber The phone number that the customer is trying to reach
     * @param startTime The time at which the phonecall began
     * @param endTime The time at which the phonecall ended
     */
    phonecall(String callerNumber, String calleeNumber, String startTime, String endTime){
        this.callerNumber = callerNumber;
        this.calleeNumber = calleeNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     *
     * @return Returns callerNumber - Getter function
     */
    @Override
    public String getCaller() {
        return callerNumber;
    }

    /**
     *
     * @return Returns calleeNumber - Getter function
     */
    @Override
    public String getCallee() {
        return calleeNumber;
    }

    /**
     *
     * @return Returns startTime - Getter function
     */
    @Override
    public String getStartTimeString() {
        return startTime;
    }

    /**
     *
     * @return Returns endTime - Getter function
     */
    @Override
    public String getEndTimeString() {
        return endTime;
    }
}
