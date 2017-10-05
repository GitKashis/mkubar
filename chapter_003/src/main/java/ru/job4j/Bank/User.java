package ru.job4j.Bank;

public class User {
    String name, passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name.equals(user.name) && passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + passport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User " + name;
    }
}
