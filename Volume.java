public abstract class Volume extends Document {
    protected String auteur;
    public Volume(String titre,String auteur){
        super(titre);
        this.auteur=auteur;
    }
    protected String getAuteur(){return this.auteur;}
    protected void setAuteur(String auteur){this.auteur=auteur;}
    protected void affiche(){System.out.println("le titre"+this.titre+"par l'Auteur : "+ this.auteur);}
}