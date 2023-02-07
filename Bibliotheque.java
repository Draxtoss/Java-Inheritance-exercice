import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

class Bibliotheque implements Operation {
    private ArrayList<Adherent> adherents;
    private ArrayList<Livre> livres;
    private ArrayList<Emprunt> emprunts;

    public Bibliotheque() {
        this.adherents = new ArrayList<Adherent>();
        this.livres = new ArrayList<Livre>();
        this.emprunts = new ArrayList<Emprunt>();
    }
    public boolean rechercherAdherent(Adherent adh) {
        for (Adherent a : adherents) {
            if (a.getIdent() == adh.getIdent()) {
                return true;
            }
        }
        return false;
    }
    
    public void ajouterLivre(Livre l) {
        livres.add(l);
    }
    public void supprimerLivre(Livre l) {
        Iterator<Livre> iterator = livres.iterator();
        while (iterator.hasNext()) {
            Livre le = iterator.next();
            if (le.getTitre().equals(l.getTitre()) && le.getAuteur().equals(l.getAuteur())) {
                iterator.remove();
            }
        }
    }

    public void ajouterAdherent(Adherent a) {
        adherents.add(a);
    }
    public void supprimerAdherent(Adherent a) {
        Iterator<Adherent> iterator = adherents.iterator();
        while (iterator.hasNext()) {
            Adherent adh = iterator.next();
            if (adh.getIdent()==(a.getIdent()) && adh.getPrenom().equals(a.getPrenom()) && adh.getNom().equals(a.getNom()) ) {
                iterator.remove();
            }
        }
    }
    public boolean rechercherLivre(Livre l) {
        for (Livre le : livres) {
            if (le.getTitre().equals(l.getTitre()) && le.getAuteur().equals(l.getAuteur())) {
                return true;
            }
        }
        return false;
    }
    
    public void emprunter(Livre l, Adherent a, Date demp) {
        for (Livre le : livres) {
            if (le.getTitre().equals(l.getTitre()) && le.getAuteur().equals(l.getAuteur())) {
                le.setDisponible(false);
            }
        }
        emprunts.add(new Emprunt(new Etudiant(a.getIdent(), a.getNom(), a.getPrenom(),null), l, demp));
    }

    public void rendre(Livre l, Adherent a, Date dretour) {
        for (Livre le : livres) {
            if (le.getTitre().equals(l.getTitre()) && le.getAuteur().equals(l.getAuteur())) {
                le.setDisponible(true);
            }
        }
        for (Emprunt e : emprunts) {
            if (e.getLivre() == l && (e.getEtudiant()).getIdent() == a.getIdent()) {
                e.setDatret(dretour);
                break;
            }
        }
    }
    public static void main(String[] args) throws ParseException {
        Bibliotheque bibliotheque = new Bibliotheque();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Ajouter un adhérent");
            System.out.println("4. Supprimer un adhérent");
            System.out.println("5. Emprunter un livre");
            System.out.println("6. Rendre un livre");
            System.out.println("7. Afficher livres");
            System.out.println("8. Afficher les adherent");
            System.out.println("9. Quitter");
            
            System.out.println("Choisissez une option :");
            
                int choix = scan.nextInt();
                scan.nextLine();


                if (choix == 1) {
                    System.out.println("Titre du livre à ajouter :");
                    String titre = scan.nextLine();
                    System.out.println("Auteur du livre à ajouter :");
                    String auteur = scan.nextLine();
                    Livre livre = new Livre(titre, auteur, true);
                    Boolean monLivre = bibliotheque.rechercherLivre(livre);
                    if (monLivre == false) {
                    bibliotheque.ajouterLivre(livre);}
                    else {
                        System.out.println("Livre deja ajouter.");
                    }
                }
                else if (choix == 2) {
                    System.out.println("Titre du livre à supprimer :");
                    String titre = scan.nextLine();
                    System.out.println("Auteur du livre à supprimer :");
                    String auteur = scan.nextLine();
                    Livre livre = new Livre(titre, auteur, true);
                    Boolean monLivre = bibliotheque.rechercherLivre(livre);
                    if (monLivre == true) {
                    bibliotheque.supprimerLivre(livre);}
                    else {
                        System.out.println("Livre n'exist pas.");
                    }
                }

                else if (choix == 3) {
                    System.out.println("Identifiant de l'adhérent à ajouter :");
                    int ident = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Nom de l'adhérent à ajouter :");
                    String nom = scan.nextLine();
                    System.out.println("Prénom de l'adhérent à ajouter :");
                    String prenom = scan.nextLine();
                    Etudiant a = new Etudiant(ident, nom, prenom,"");
                    Boolean monAdherent = bibliotheque.rechercherAdherent(a);
                    if (monAdherent) {
                        System.out.println("Adhérent avec cette identif deja ajouter!");
                    }
                    else {
                    bibliotheque.ajouterAdherent(a);
                }
                }
                if (choix == 4) {
                    System.out.println("Identifiant de l'adhérent à supprimer :");
                    int ident = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Nom de l'adhérent à supprimer :");
                    String nom = scan.nextLine();
                    System.out.println("Prénom de l'adhérent à supprimer :");
                    String prenom = scan.nextLine();
                    Etudiant a = new Etudiant(ident, nom, prenom,"");
                    Boolean monAdherent = bibliotheque.rechercherAdherent(a);
                    if (monAdherent == true) {
                        bibliotheque.supprimerAdherent(a);}
                    else{
                        System.out.println("Adhérent avec cette ident n'exist pas.");
                    }
                }
                else if (choix == 5) {
                    System.out.println("Titre du livre à emprunter :");
                    String titre = scan.nextLine();
                    System.out.println("auteur du livre à emprunter :");
                    String auteur = scan.nextLine();
                    scan.nextLine();
                    System.out.println("Identifiant de l'adhérent :");
                    int ident = scan.nextInt();
                    scan.nextLine();
                    System.out.println("nom de l'adhérent :");
                    String nom = scan.nextLine();
                    System.out.println("prenom de l'adhérent :");
                    String prenom = scan.nextLine();
                    System.out.println("Date d'emprunt (jj/MMM exemple : Aug /aaaa) :");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                    Date dateemp = dateFormat.parse(scan.nextLine());
                    Livre livre = new Livre(titre, auteur, true);
                    Etudiant adh= new Etudiant(ident,nom,prenom,"");
                    Boolean monAdherent = bibliotheque.rechercherAdherent(adh);
                    Boolean monLivre = bibliotheque.rechercherLivre(livre);
                    if ((monAdherent == true)&&(monLivre == true)){
                    bibliotheque.emprunter(livre, adh, dateemp);}
                    else{
                        System.out.println("Adhérent ou livre non trouvé.");
                    }
                }
                else if (choix == 6) {
                    System.out.println("Titre du livre à retourne :");
                    String titre = scan.nextLine();
                    System.out.println("auteur du livre à retourne :");
                    String auteur = scan.nextLine();
                    System.out.println("Identifiant de l'adhérent :");
                    int ident = scan.nextInt();
                    scan.nextLine();
                    System.out.println("nom de l'adhérent :");
                    String nom = scan.nextLine();
                    System.out.println("prenom de l'adhérent :");
                    String prenom = scan.nextLine();
                    System.out.println("Date d'emprunt (jj/MMM exemple : Aug/aaaa) :");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                    Date dateret = dateFormat.parse(scan.nextLine());
                    Livre livre = new Livre(titre, auteur, true);
                    Etudiant adh= new Etudiant(ident,nom,prenom,"");
                    Boolean monAdherent = bibliotheque.rechercherAdherent(adh);
                    Boolean monLivre = bibliotheque.rechercherLivre(livre);
                    if ((monAdherent == true)&&(monLivre == true)){
                    bibliotheque.rendre(livre,adh,dateret);
                    }
                    else{
                        System.out.println("Adhérent ou livre non trouvé.");
                    }}
                    else if (choix == 7) {
                        if(bibliotheque.livres.isEmpty()){System.out.println("la list des livre est vide");}
                        else{System.out.println("Voici la liste de tous les livres :");
                        for (Livre l : bibliotheque.livres) {
                            System.out.println(l.getTitre() + " - " + l.getAuteur()+" - "+l.getDisponible());
                        }}
                    }
                    else if (choix == 8) {
                        if(bibliotheque.adherents.isEmpty()){System.out.println("la list d'adherents est vide");}
                        else{System.out.println("Voici la liste de tous les Adherents :");
                        for (Adherent l : bibliotheque.adherents) {
                            System.out.println(l.getIdent() + " - " + l.getNom()+" - "+l.getPrenom());
                        }
                    }}
                    else if (choix == 9) {break;}
            }
            scan.close();

        }
    
}