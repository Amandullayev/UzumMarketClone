package user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private String name;
    private String userName;
    private String password;
    private UUID id;

    public User() {
    }

    public User(String name, String userName, String password, UUID id) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    @Override
    public String toString() {
        return "User[" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", id=" + id +
                ']';
    }
}
