package org.javaLearnProj.Attachments;

public class Attachment{
    private final String name;
    public final AttachmentType type;

    public String getName() {
        return name;
    }

    public Attachment(String name, AttachmentType type) {
        this.name = name;
        this.type = type;
    }
}
