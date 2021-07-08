package protocolchat;

/**
 *
 * @author Daniel Sánchez S.
 * @version 2.0
 */
public interface IServiceProtocol {
    public Client login(Client client) throws Exception;
    public boolean signUp(Client client) throws Exception;
    public void logout(Client client) throws Exception; 
    public void post(Message message);
    public Client getClient(Client client)throws Exception;
    public Client getClient(String id)throws Exception;
    public void updateClient(Client client) throws Exception;
}
