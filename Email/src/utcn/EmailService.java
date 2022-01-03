package utcn;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmailService {

    private final EmailRepository emailRepository = new EmailRepository();

    public boolean send(UserRepository userRepository, Email email) throws EmailNotValidException {
        if(EmailValidator.validate(userRepository, email)) {
            emailRepository.save(email);
            return true;
        }
        return false;
    }

    public List<Email> findAllByUser(User user) {
        List<Email> userEmails = new ArrayList<>();
        for(Email e : emailRepository.getEmails()) {
            if(e.getSender().equals(user) || e.getReceiver().equals(user))
                userEmails.add(e);
        }
        return userEmails;
    }

    public String cancel(Email email) {
        if(LocalDateTime.now().getSecond() - email.getTimestamp().getSecond() > 30)
            return "Email cannot be canceled anymore";
        if(emailRepository.delete(email) == null)
            return "Email doesn't exist";
        return "Email cancelled successfully";
    }
}
