package ch.heigvd.amt.mvcprojet.model;

public class User {
    private String Firstname;
    private String Lastname;
    private String username;
    private String password;
    private String email;


    public User(String Firstname, String Lastname, String username, String password, String email) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }


    public User() { }

    public boolean equals(User user) {
        return username.equals(user.username) && password.equals(user.password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
