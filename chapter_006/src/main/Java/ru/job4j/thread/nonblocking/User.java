package ru.job4j.thread.nonblocking;

public class User extends Model {

    /**
     * Constructor when create new User object.
     * @param name User
     * @param id User
     */
    public User(String name, final int id) {
        this.name = name;
        this.id = id;
        this.version = 0;
    }

    /**
     * Setter for User name.
     * @param name User
     */
    @Override
    public void setName(String name) {
        this.name = name;
        version++;
    }

    /**
     * Getter for field name.
     *
     * @return name
     */
    @Override
    String getName() {
        return this.name;
    }

    /**
     * Getter for ID field.
     * @return ID user
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Getter for version object.
     * @return version now
     */
    @Override
    public int getVersion() {
        return version;
    }

    /**
     * Equals Override.
     * @param o object need check
     * @return yes or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return id == user.id;
    }

    /**
     * HashCode.
     * @return hashcode object.
     */
    @Override
    public int hashCode() {
        return id;
    }
}
