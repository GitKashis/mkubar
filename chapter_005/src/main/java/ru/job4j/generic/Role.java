package ru.job4j.generic;

/**
 * Role.
 * Created by Kubar on 08.10.2017.
 */
class Role extends Base {

    // Role id.
    private String id;

    // Role name.
    private String roleName;

    // Constructor
    public Role(String id, String roleName) {
        this.id = id;
        this.roleName = roleName;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) {
            return false;
        }
        return roleName != null ? roleName.equals(role.roleName) : role.roleName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
