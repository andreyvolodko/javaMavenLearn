package org.javaLearnProj.Channels;

public class EmailChannel extends Channel{

    public EmailChannel(String emailAddress) {

        //make some actions on the emailAddress (validation)
        setAddress(emailAddress);
    }
}
