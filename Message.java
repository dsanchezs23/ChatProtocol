package protocolchat;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Daniel Sánchez S.
 * @version 2.0
 */
@XmlType(name = "message", propOrder = {"sequence", "emitter", "receiver", "text"})
public class Message implements Serializable {

    public Message(int sequence, String emitter, String receiver, LocalDateTime date, String text) {
        this.sequence = sequence;
        this.emitter = emitter;
        this.receiver = receiver;
        this.date = date;
        this.text = text;
    }

    public Message() {
        this(0,"", "", null, "");
    }

    public int getSequence() {
        return sequence;
    }

    @XmlTransient
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getEmitter() {
        return emitter;
    }

    @XmlElement(name = "emitter")
    public void setEmitter(String emitter) {
        this.emitter = emitter;
    }

    public String getReceiver() {
        return receiver;
    }

    @XmlElement(name = "receiver")
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @XmlTransient
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    @XmlElement(name = "text")
    public void setText(String text) {
        this.text = text;
    }

    private int sequence;
    private String emitter;
    private String receiver;
    private LocalDateTime date;
    private String text;
}
