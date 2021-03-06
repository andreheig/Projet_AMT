package ch.heigvd.amt.mvcprojet.model;


public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String accountType;


    public User(int id, String firstName, String lastName, String mail, String password, String accountType) {
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.password = password;
        this.accountType = accountType;
    }
    public User(String firstName, String lastName, String mail, String password, String accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.password = password;
        this.accountType = accountType;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {  this.lastName = lastName;  }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }


    public User() { }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType;
    }

    /*public boolean equals(User user) {
        return Nom.equals(user.Nom) && password.equals(user.password);
    }*/

    public String toString() {
        return "User_id: " + userId + ", Prenom: " + firstName + ", Nom: " + lastName + ", Email: " + email + ", Type de compte: " + accountType;
    }
}
