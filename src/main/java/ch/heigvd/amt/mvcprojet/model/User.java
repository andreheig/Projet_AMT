package ch.heigvd.amt.mvcprojet.model;

import javax.ejb.Stateless;


public class User {
    private int user_id;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String type_compte;


    public User(int user_id, String lastname, String firstname, String mail, String password, String type_compte) {
        this.user_id = user_id;
        this.prenom = lastname;
        this.nom = firstname;
        this.email = mail;
        this.password=password;
        this.type_compte = type_compte;
    }
    public User(String lastname, String firstname, String mail, String password, String type_compte) {
        this.prenom = lastname;
        this.nom = firstname;
        this.email = mail;
        this.password=password;
        this.type_compte = type_compte;
    }

    public void setUser_id(int User_id) {
        this.user_id = User_id;
    }

    public void setPrenom(String Prenom) {
        this.prenom = Prenom;
    }

    public void setNom(String nom) {  this.nom = nom;  }

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

    public String getPrenom() {
        return prenom;
    }


    public User() { }

    public String getNom() {
        return nom;
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
        return "User_id: " + user_id + ", Prenom: " + prenom + ", Nom: " + nom + ", Email: " + email + ", Type de compte: " + type_compte;
    }
}
