public abstract class Adherent {
    protected int ident;
    protected String nom;
    protected String prenom;

    public Adherent(int ident, String nom, String prenom) {
        this.ident = ident;
        this.nom = nom;
        this.prenom = prenom;
    }

    protected int getIdent() {
        return this.ident;
    }

    protected void setIdent(int ident) {
        this.ident = ident;
    }

    protected String getNom() {
        return this.nom;
    }

    protected void setNom(String nom) {
        this.nom = nom;
    }

    protected String getPrenom() {
        return this.prenom;
    }

    protected void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    protected void affiche() {
        System.out.println("Identifiant: " + this.ident);
        System.out.println("Nom: " + this.nom);
        System.out.println("Prénom: " + this.prenom);
    }
}
