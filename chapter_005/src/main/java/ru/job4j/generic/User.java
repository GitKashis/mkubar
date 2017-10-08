package ru.job4j.generic;

/**
 *
 * Created by Kubar on 08.10.2017.
 */
class User extends Base {

    /**
     * User ID.
     */
    private String id;

    /**
     * User name.
     */
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    String getId() {
        return this.id;
    }

    @Override
    void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user=(User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result=id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
