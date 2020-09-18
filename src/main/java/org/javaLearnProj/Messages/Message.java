package org.javaLearnProj.Messages;

import org.javaLearnProj.Attachments.Attachment;
import org.javaLearnProj.Channels.Channel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Message extends MessageBase implements IAttachmentsGetter {

    private ArrayList<Channel> channels = new ArrayList<>();
    private ArrayList<Attachment> attachments;

    public Message(String senderName, Date depDate, String text, Channel channel, Channel... channels) {
        super(senderName, depDate, text);
        this.channels.add(channel);
        this.channels.addAll(Arrays.asList(channels));
    }

    public Message addAttachments(Attachment attach, Attachment... attaches){
        if(this.attachments == null)
            this.attachments = new ArrayList<>();
        this.attachments.add(attach);
        this.attachments.addAll(Arrays.asList(attaches));

        return this;
    }

    public ArrayList<Channel> getChannels() {
        return channels;
    }

    @Override
    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }
}
