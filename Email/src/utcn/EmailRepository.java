package utcn;

import java.util.ArrayList;
import java.util.TreeSet;

public class EmailRepository implements AppRepository<Email, Long> {

    private final TreeSet<Email> emails = new TreeSet<>();
    @Override
    public Email save(Email email) {
        email.setId((long) emails.size() + 1);
        emails.add(email);
        return null;
    }

    @Override
    public Email findById(Long id) {
        for(Email e : emails) {
            if(id.equals(e.getId()))
                return e;
        }
        return null;
    }

    @Override
    public Email delete(Email email) {
        if(isSent(email)) {
            emails.remove(email);
            return email;
        }
        return null;
    }

    public boolean isSent(Email email) {
        for(Email e : emails) {
            if(email.equals(e))
                return true;
        }
        return false;
    }

    public TreeSet<Email> getEmails() {
        return emails;
    }
}
