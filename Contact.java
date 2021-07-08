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
@XmlType(name = "contact", propOrder = {"id", "name"})
public class Contact implements Serializable {

    public Contact(String name, String id, LocalDateTime lastTime, boolean status) {
        this.name = name;
        this.id = id;
        this.lastTime = lastTime;
        this.status = status;
    }

    public Contact(String name, String id, LocalDateTime lastTime) {
        this.name = name;
        this.id = id;
        this.lastTime = lastTime;
    }

    public Contact(String name, String id) {
        this(name, id, LocalDateTime.now(), false);
    }

    public Contact(String id) {
        this("", id, LocalDateTime.now(), false);
    }

    public Contact() {
        this("", "", LocalDateTime.now(), false);
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    @XmlTransient
    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }

    @XmlTransient
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String name;
    private String id;
    private LocalDateTime lastTime;
    private boolean status;
}
