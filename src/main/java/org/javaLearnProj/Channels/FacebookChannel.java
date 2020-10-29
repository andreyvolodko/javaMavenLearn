package org.javaLearnProj.Channels;

public class FacebookChannel extends Channel{

    public FacebookChannel(int id) {

        setAddress(String.format("id%s", id));
    }
}
