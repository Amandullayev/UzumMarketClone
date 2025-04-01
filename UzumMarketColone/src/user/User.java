package user;

import java.util.Objects;
import java.util.UUID;

public class User {
    private String name;
    private String userName;
    private UUID id;

    public User() {
    }

    public User(String name, String surname, UUID id) {
        this.name = name;
        this.userName = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userName);
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
