package protocolchat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Daniel Sánchez S.
 * @version 2.0
 */
@XmlType(name = "client", propOrder = {"id", "contacts", "messages"})
@XmlRootElement
public class Client implements Serializable {

    public Client(String id, String name, String password, LocalDateTime lasTime, HashMap<String, Contact> contacts, HashMap<Integer, Message> messages) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.lastTime = lasTime;
        this.contacts = contacts;
        this.messages = messages;
    }

    public Client(String id, String name, String password, LocalDateTime lasTime) {
        this(id, name, password, lasTime, new HashMap<String, Contact>(), new HashMap<Integer, Message>());
    }

    public Client(String id, String name, String password) {
        this(id, name, password, null, new HashMap<String, Contact>(), new HashMap<Integer, Message>());
    }

    public Client(String id) {
        this(id, "", "", null, new HashMap<String, Contact>(), new HashMap<Integer, Message>());
    }

    public Client() {
        this("", "", "", null, new HashMap<String, Contact>(), new HashMap<Integer, Message>());
    }

    public String getName() {
        return name;
    }

    @XmlTransient
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    @XmlTransient
    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<String, Contact> getContacts() {
        return contacts;
    }

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    @XmlTransient
    public void setLastTime(LocalDateTime lastTime) {
        this.lastTime = lastTime;
    }

    @XmlElement(name = "contacts")
    public void setContacts(HashMap<String, Contact>  contacts) {
        this.contacts = contacts;
    }    
    

    public HashMap<Integer, Message> getMessages() {
        return messages;
    }

    @XmlElement(name = "messages")
    public void setMessages(HashMap<Integer, Message>  messages) {
        this.messages = messages;
    }
    
    public Object[] toArray() {
        Object[] obj = new Object[2];
        obj[0] = getContacts();
        obj[1] = getMessages();
        return obj;
    }

    public Client load(String idClient) {
        Client client = new Client();
        try {
            JAXBContext ctx = JAXBContext.newInstance(Client.class);
            Unmarshaller mrs = ctx.createUnmarshaller();
            client = (Client) mrs.unmarshal(new FileInputStream("../" + idClient + ".xml"));
        } catch (JAXBException | FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            System.err.printf("Error: '%s'", ex.getMessage());
        }
        return client;
    }

    public void save(Client client) {
        try {
            JAXBContext ctx2 = JAXBContext.newInstance(Client.class);
            Marshaller mrs2 = ctx2.createMarshaller();
            mrs2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mrs2.marshal(client, new FileOutputStream("../" + client.getId() + ".xml"));
        } catch (FileNotFoundException | JAXBException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            System.err.printf("Error: '%s'", ex.getMessage());
        }
    }

    @Override
    public String toString() {
        String x = "Name: " + name + "\nId: " + id + "\nPassword: " + password + "\nContacts: " + contacts.toString()
                + "\nMessages: " + messages.toString();

        return x;
    }

    private String name;
    private String id;
    private String password;
    private LocalDateTime lastTime;
    private HashMap<String, Contact> contacts;
    private HashMap<Integer, Message> messages;

}
