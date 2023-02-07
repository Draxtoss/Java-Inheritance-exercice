import java.util.Date;

interface Operation {
    void ajouterLivre(Livre l);
    boolean rechercherLivre(Livre livre);
    void supprimerLivre(Livre l);
    void ajouterAdherent(Adherent adherent);
    boolean rechercherAdherent(Adherent a);
    void supprimerAdherent(Adherent a);
    void emprunter(Livre l, Adherent a, Date demp);
    void rendre(Livre l, Adherent a, Date dretour);
}
