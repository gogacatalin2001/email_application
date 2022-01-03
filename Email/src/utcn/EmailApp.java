package utcn;

import java.time.LocalDateTime;

public class EmailApp {
    public static void main(String[] args) {
        UserService userService = new UserService();
        EmailService emailService = new EmailService();

        User user1 = new User("gogacatalin2001", "gogac@yahoo.com", "123");
        User user2 = new User("gogacatalin2001", "gogac@yahoo.com", "123");
        User user3 = new User("trevtutor", "trevt@gmail.com", "123");
        try {
            userService.register(user1);
            userService.register(user2);
        } catch (UserAlreadyRegisteredException e) {
            e.printStackTrace();
        }

        try {
            emailService.send(userService.getUserRepository(), new Email(user1, user2, "I think it should work", "Test" , LocalDateTime.now()));
            emailService.send(userService.getUserRepository(), new Email(user1, user3, "This should throw an exception", "second test" , LocalDateTime.now()));
        } catch (EmailNotValidException e) {
            e.printStackTrace();
        }
    }
}
