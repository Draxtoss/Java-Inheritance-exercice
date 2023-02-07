public class Enseignant extends Adherent {
    private String departement;

    public Enseignant(int ident, String nom, String prenom, String departement) {
        super(ident, nom, prenom);
        this.departement = departement;
    }

    public String getDepartement() {
        return this.departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public void affiche() {
        System.out.println("Identifiant: " + this.getIdent());
        System.out.println("Nom: " + this.getNom());
        System.out.println("Prénom: " + this.getPrenom());
        System.out.println("Département: " + this.departement);
    }
}
