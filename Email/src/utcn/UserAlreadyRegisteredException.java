package utcn;

public class UserAlreadyRegisteredException extends Exception {
    UserAlreadyRegisteredException(String msg) {
        super(msg);
    }
}
