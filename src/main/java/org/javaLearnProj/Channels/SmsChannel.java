package org.javaLearnProj.Channels;

public class SmsChannel extends Channel{

    public SmsChannel(int phoneNumber) {

        //make some actions on the emailAddress (validation).
        setAddress(Integer.toString(phoneNumber));
    }
}
