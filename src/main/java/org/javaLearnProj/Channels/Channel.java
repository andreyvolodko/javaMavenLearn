package org.javaLearnProj.Channels;

public abstract class Channel {

    private String address;

    protected void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
