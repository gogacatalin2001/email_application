package utcn;

import java.time.LocalDateTime;
import java.util.Objects;

public class Email implements Comparable{

    private  Long id;
    private final User sender;
    private final User receiver;
    private final String subject;
    private final String text;
    private final LocalDateTime timestamp;

    public Email(User sender, User receiver, String subject, String text, LocalDateTime timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return sender.equals(email.sender) && receiver.equals(email.receiver) && subject.equals(email.subject) && text.equals(email.text) && timestamp.equals(email.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver, subject, text, timestamp);
    }

    @Override
    public int compareTo(Object o) {
        Email email = (Email) o;
        return this.timestamp.compareTo(email.getTimestamp());
    }
}
