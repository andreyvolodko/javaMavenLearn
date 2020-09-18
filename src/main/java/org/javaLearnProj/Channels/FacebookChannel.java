package org.javaLearnProj.Channels;

public class FacebookChannel extends Channel{

    public FacebookChannel(int id) {

        //make some actions on the emailAddress (validation)
        setAddress(String.format("id%s", id));
    }
}
