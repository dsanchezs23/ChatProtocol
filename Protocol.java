package protocolchat;

/**
 *
 * @author Daniel Sánchez S.
 * @version 2.0
 */
public class Protocol {

    public static final String SERVER = "localhost";
    public static final int PORT = 1234;

    public static final int LOGIN = 1;
    public static final int LOGOUT = 2;
    public static final int POST = 3;
    public static final int SIGNUP = 4;
    public static final int SEARCHING = 5;
    public static final int UPDATE = 6;
    public static final int UPDATEALLID = 7;
    public static final int UPDATECONTACT = 8;

    public static final int DELIVER = 1;

    public static final int NO_ERROR = 0;
    public static final int ERROR_LOGIN = 1;
    public static final int ERROR_LOGOUT = 2;
    public static final int ERROR_POST = 3;
}
