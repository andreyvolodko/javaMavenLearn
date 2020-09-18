package org.javaLearnProj.Messages;

import java.util.Date;

public abstract class MessageBase {
    private final String senderName;
    private final Date depDate;
    private final String text;
    protected StringBuilder stringBuilder;

    public String getSenderName() {
        return senderName;
    }

    public Date getDepDate() {
        return depDate;
    }

    public String getText() {
        return text;
    }

    public MessageBase(String senderName, Date depDate, String text) {
        this.senderName = senderName;
        this.depDate = depDate;
        this.text = text;
    }

    public String toString(){
        stringBuilder = new StringBuilder().append(String.format("Sender name: %s", getSenderName()))
                                           .append(String.format("\nDep date: %s", getDepDate()))
                                           .append(String.format("\nText: %s", getText()));
        return stringBuilder.toString();
    }
}
