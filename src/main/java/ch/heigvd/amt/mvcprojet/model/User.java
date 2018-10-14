package ch.heigvd.amt.mvcprojet.model;

public class User {
    private int User_id;
    private String Prenom;
    private String Nom;
    private String Email;
    private String Type_compte;


    public User(int User_id, String Lastname, String username, String mail, String type_compte) {
        this.User_id = User_id;
        this.Prenom = Lastname;
        this.Nom = username;
        this.Email = mail;
        this.Type_compte = type_compte;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    public void setEmail(String mail) {
        this.Email = mail;
    }

    public void setTypeCompte(String type_compte) {
        this.Type_compte = type_compte;
    }

    public int getUser_id() {
        return User_id;
    }

    public String getPrenom() {
        return Prenom;
    }


    public User() { }

    public String getNom() {
        return Nom;
    }

    public String getEmail() {
        return Email;
    }

    public String getTypeCompte() {
        return Type_compte;
    }

    /*public boolean equals(User user) {
        return Nom.equals(user.Nom) && password.equals(user.password);
    }*/
}
