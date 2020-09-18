package org.javaLearnProj.Messages;

import org.javaLearnProj.Attachments.Attachment;

import java.util.ArrayList;
import java.util.Date;

public class EmailMessage extends MessageBase implements IAttachmentsGetter {

    private ArrayList<Attachment> attachments;

    public EmailMessage(String senderName, Date depDate, String text, ArrayList<Attachment> attachments) {
        super(senderName, depDate, text);
        this.attachments = attachments;
    }

    @Override
    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    @Override
    public String toString(){
        super.toString();
        if(attachments != null){
            stringBuilder.append("\nAttachments:");
            attachments.forEach(attach -> stringBuilder.append("\n " + attach.getName()));
        }
        return stringBuilder.toString();
    }
}
