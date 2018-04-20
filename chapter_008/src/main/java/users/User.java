package users;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class User {

    /**
     * ID User in database.
     */
    private int id;

    /**
     * Name User.
     */
    private String name;

    /**
     * Login User.
     */
    private String login;

    /**
     * Email User.
     */
    private String email;

    /**
     * Create date User.
     */
    private Calendar createDate;

    /**
     * List roles user.
     */
    private List<String> roles = new ArrayList<>();

    /**
     * Password user.
     */
    private String password;

    /**
     * This constructor used if create new user for database.
     * @param name User
     * @param login User
     * @param email User
     * @param password User
     */
    public User(String name, String login, String email, String password) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = Calendar.getInstance();
        this.setPassword(password);
    }

    /**
     * This constructor used if create object user of database data.
     * @param id User
     * @param name User
     * @param login User
     * @param email User
     */
    public User(int id, String name, String login, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
    }

    /**
     * This constructor used if create object user of database data.
     * @param id User
     * @param name User
     * @param login User
     * @param email User
     * @param createDate User
     * @param password User
     * @param role User
     */
    public User(int id, String name, String login, String email, Calendar createDate, String role, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.roles.add(role);
        this.password = password;
    }

    /**
     *
     * @param id user
     * @param name user
     * @param login user
     * @param email user
     * @param roles list
     */
    public User(int id, String name, String login, String email, List<String> roles) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.roles = roles;
    }

    /**
     * Getter for ID User.
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for Name User.
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for Login User.
     * @return login
     */
    public String getLogin() {
        return this.login;
    }

    /**
     * Getter for Email User.
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for date create User.
     * @return date
     */
    public Calendar getCreateDate() {
        return this.createDate;
    }

    /**
     * Getter for JSTL.
     * @return date create to String.
     */
    public String getDate() {
        return this.createDate.getTime().toString();
    }

    /**
     * Getter field roles user.
     * @return user
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * Setter for list field.
     * @param roles user
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    /**
     * Add role user in list.
     * @param role user
     */
    public void addRole(String role) {
        this.roles.add(role);
    }

    /**
     * Getter for password.
     * @return user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Generate password md5.
     * @param password user
     */
    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", createDate=").append(createDate.getTime());
        sb.append(", roles=").append(roles);
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
