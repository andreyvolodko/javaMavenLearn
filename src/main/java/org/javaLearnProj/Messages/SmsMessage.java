package org.javaLearnProj.Messages;

import java.util.Date;

public class SmsMessage extends MessageBase {
    public SmsMessage(String senderName, Date depDate, String text) {
        super(senderName, depDate, text);
    }
}
