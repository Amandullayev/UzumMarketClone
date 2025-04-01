package auth;

import user.User;

import java.util.Optional;

public class Auth {
    public Optional<User> user(User user){
        return Optional.of(user);
    }
}
