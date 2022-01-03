package utcn;

public class EmailValidator {

    public static boolean validate(UserRepository userRepository, Email email) throws EmailNotValidException {
        if(userRepository.isRegistered(email.getSender())
                && userRepository.isRegistered(email.getReceiver())
                && !email.getSubject().isBlank()
                && !email.getText().isBlank())
            return true;
        else
            throw new EmailNotValidException("Email is not valid!");
    }
}
