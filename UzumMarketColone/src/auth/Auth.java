package auth;

import db.DbSource;
import user.User;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Auth {
    private static List<User> users = new ArrayList<>();

    public static Optional<User> register(){

        String name = DbSource.StrScan("Ismingizni kiriting: ");
        String userName = DbSource.StrScan("UserName kiriting: ");
        Optional<User> isHaveUser = GetUserByUsername(userName);

        if (isHaveUser.isPresent()){
            System.err.println("Bu foydalanuvchi band !!");
            return Optional.empty();
        }
        String password = DbSource.StrScan("Parolingizni kiriting: ");
        User newUser = new User(name, userName, password, UUID.randomUUID());
        users.add(newUser);
        System.out.println("Foydalanuvchi muvoffaqiyatli qo'shildi !!");
        return Optional.of(newUser);
    }

    public static Optional<User> login(){
        String username = DbSource.StrScan("UserName ni kiriting: ");
        Optional<User> isUserhave = GetUserByUsername(username);
        String password = DbSource.StrScan("Parolingizni kiriting: ");
        return isUserhave.filter(user -> user.getPassword().equals(password))
                .map(user -> {
                    System.out.println("Kirish muvoffaqiyatli");
                    return user;
                })
                .or(() -> {
                    System.err.println("Parol yoki username xato !!");
                    return Optional.empty();
                });
    }

    private static Optional<User> GetUserByUsername(String username){
        return users.stream().
                filter(user -> user.getUserName().equals(username)).
                findFirst();
    }
}
