public class Etudiant extends Adherent {
    private String classe;

    public Etudiant(int ident, String nom, String prenom, String classe) {
        super(ident, nom, prenom);
        this.classe = classe;
    }

    public String getClasse() {
        return this.classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Classe: " + this.classe);
    }
}
