package org.javaLearnProj;

import org.javaLearnProj.Attachments.Attachment;
import org.javaLearnProj.Attachments.AttachmentType;
import org.javaLearnProj.Channels.Channel;
import org.javaLearnProj.Channels.EmailChannel;
import org.javaLearnProj.Channels.FacebookChannel;
import org.javaLearnProj.Channels.SmsChannel;
import org.javaLearnProj.Messages.Message;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {

        Channel emailChannel = new EmailChannel("andrei.valadzko@itechart-group.com");
        Channel smsChannel = new SmsChannel(12312441);
        Channel facebookChannel = new FacebookChannel(1241244);

        Attachment attach1 = new Attachment("Audio", AttachmentType.AUDIO);
        Attachment attach2 = new Attachment("Document!", AttachmentType.DOCUMENT);
        Attachment attach3 = new Attachment("Image", AttachmentType.IMAGE);

        Message message1 =
                new Message("Andrew", new Date(), "This is text of a message with all channels and attachments types", emailChannel, smsChannel, facebookChannel).addAttachments(attach1, attach2, attach3);
        Message message2 = new Message("Sanya", new Date(), "This message contains audio and image inside", facebookChannel, smsChannel).addAttachments(attach1, attach3);

        MailingService mailingService = new MailingService();
        mailingService.receiveMessages(message1, message2).buildMessagesToSend().sendMessages();
    }

}
