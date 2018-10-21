package ch.heigvd.amt.mvcprojet.model;


public class User {
    private int user_id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String type_compte;


    public User(int user_id, String firstname, String lastname, String mail, String password, String type_compte) {
        this.user_id = user_id;
        this.firstname = lastname;
        this.lastname = firstname;
        this.email = mail;
        this.password=password;
        this.type_compte = type_compte;
    }
    public User(String firstname, String lastname, String mail, String password, String type_compte) {
        this.firstname = lastname;
        this.lastname = firstname;
        this.email = mail;
        this.password=password;
        this.type_compte = type_compte;
    }

    public void setUser_id(int User_id) {
        this.user_id = User_id;
    }

    public void setFirstname(String Prenom) {
        this.firstname = Prenom;
    }

    public void setLastname(String lastname) {  this.lastname = lastname;  }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType_compte(String type_compte) {
        this.type_compte = type_compte;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getFirstname() {
        return firstname;
    }


    public User() { }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getType_compte() {
        return type_compte;
    }

    /*public boolean equals(User user) {
        return Nom.equals(user.Nom) && password.equals(user.password);
    }*/

    public String toString() {
        return "User_id: " + user_id + ", Prenom: " + firstname + ", Nom: " + lastname + ", Email: " + email + ", Type de compte: " + type_compte;
    }
}
