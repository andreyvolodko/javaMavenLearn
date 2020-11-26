package org.javaLearnProj.Channels;

public class SmsChannel extends Channel{

    public SmsChannel(int phoneNumber) {
        setAddress(Integer.toString(phoneNumber));
    }
}
