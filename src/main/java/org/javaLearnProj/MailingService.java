package org.javaLearnProj;

import org.javaLearnProj.Attachments.Attachment;
import org.javaLearnProj.Attachments.AttachmentType;
import org.javaLearnProj.Channels.EmailChannel;
import org.javaLearnProj.Channels.FacebookChannel;
import org.javaLearnProj.Messages.EmailMessage;
import org.javaLearnProj.Messages.FacebookMessage;
import org.javaLearnProj.Messages.Message;
import org.javaLearnProj.Messages.SmsMessage;

import java.util.ArrayList;
import java.util.Arrays;

public class MailingService {

    private ArrayList<Message> messages;

    private ArrayList<EmailMessage> emailMessages;
    private ArrayList<FacebookMessage> facebookMessages;
    private ArrayList<SmsMessage> smsMessages;

    public MailingService() {
        messages = new ArrayList<>();
    }

    public MailingService receiveMessages(Message message, Message... messages) {

        this.messages.add(message);
        this.messages.addAll(Arrays.asList(messages));

        return this;
    }

    public void sendMessages() {
        emailMessages.forEach(ms -> sendEmail(ms));
        facebookMessages.forEach(ms -> sendFacebookMes(ms));
        smsMessages.forEach((ms -> sendSms(ms)));
    }

    private void sendEmail(EmailMessage emailMessage){
        // send email functionality
        System.out.println(emailMessage.toString());
        System.out.println("Email message sent!");
        System.out.println();
    }
    private void sendFacebookMes(FacebookMessage facebookMessage){
        // send facebook mes functionality
        System.out.println(facebookMessage.toString());
        System.out.println("Facebook message sent!");
        System.out.println();
    }
    private void sendSms(SmsMessage smsMessage){
        // send sms functionality
        System.out.println(smsMessage.toString());
        System.out.println("SMS message sent!");
        System.out.println();
    }

    public MailingService buildMessagesToSend() {
        messages.forEach(ms -> {
            ms.getChannels().forEach(ch -> {
                if (ch instanceof EmailChannel){
                    if(emailMessages == null)
                        emailMessages = new ArrayList<>();
                    emailMessages.add(getEmailMessage(ms));
                } else if (ch instanceof FacebookChannel){
                    if(facebookMessages == null)
                        facebookMessages = new ArrayList<>();
                    facebookMessages.add(getFacebookMessage(ms));
                } else{
                    if(smsMessages == null)
                        smsMessages = new ArrayList<>();
                    smsMessages.add(getSmsMessage(ms));
                }
            });
        });
        return this;
    }

    private EmailMessage getEmailMessage(Message message) {
        EmailMessage emailMessage =
                new EmailMessage(message.getSenderName(),
                        message.getDepDate(),
                        message.getText(),
                        message.getAttachments());

        return emailMessage;
    }

    private FacebookMessage getFacebookMessage(Message message) {

        var facebookAttachments = new ArrayList<Attachment>();
        if(message.getAttachments() != null){
            for (Attachment attach : message.getAttachments()) {
                if (attach.type == AttachmentType.DOCUMENT || attach.type == AttachmentType.IMAGE) {
                    facebookAttachments.add(attach);
                }
            }
        }

        FacebookMessage facebookMessage = new FacebookMessage(message.getSenderName(),
                message.getDepDate(),
                message.getText(),
                facebookAttachments);

        return facebookMessage;
    }

    private SmsMessage getSmsMessage(Message message) {
        SmsMessage smsMessage = new SmsMessage(message.getSenderName(),
                message.getDepDate(),
                message.getText());

        return smsMessage;
    }
}
