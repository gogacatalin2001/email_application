package utcn;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public User register(User user) throws UserAlreadyRegisteredException {
        return userRepository.save(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public boolean isRegistered(User user) {
        return userRepository.isRegistered(user);
    }
}
