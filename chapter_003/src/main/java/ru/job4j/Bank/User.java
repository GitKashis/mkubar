package ru.job4j.Bank;

class User {
    private String name, passport;

    User(String name, String passport) {
        this.name = name;
        this.passport = passport;
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
