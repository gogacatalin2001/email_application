package utcn;
import java.util.HashSet;

public class UserRepository implements AppRepository<User, Long> {

    private final HashSet<User> users = new HashSet<>();

    @Override
    public User save(User user) throws UserAlreadyRegisteredException {
        for(User u : users) {
            if(u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail()))
                throw new UserAlreadyRegisteredException("A user with the same email or username was already registered!");
        }
        user.setId((long) users.size() + 1);
        if(users.add(user))
            return user;
        else
            throw new UserAlreadyRegisteredException("A user with the same email or username was already registered!");
    }

    @Override
    public User findById(Long id) {
        for(User u : users)
            if(id == u.getId())
                return u;
        return null;
    }

    @Override
    public User delete(User user) {
        users.remove(user);
        return null;
    }

    public boolean isRegistered(User user) {
        for(User u : users) {
            if(user.equals(u))
                return true;
        }
        return false;
    }
}
