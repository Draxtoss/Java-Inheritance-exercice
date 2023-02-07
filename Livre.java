public class Livre extends Volume {
    protected boolean disponible;
    public Livre(String titre,String auteur,boolean disponible){
        super(titre,auteur);
        this.disponible=disponible;
    }
    public Livre(Livre l){
        super(l.getTitre(),l.getAuteur());
        this.disponible=l.disponible;
    }
    protected boolean getDisponible(){return this.disponible;}
    void setDisponible(boolean disponible){this.disponible=disponible;}
    public void affiche(){if (this.disponible=false){
        System.out.println("le livre : "+this.titre+"est n'est pas disponible");}
        else
        System.out.println("le livre : "+this.titre+"est disponible");
    }
}