public abstract class Document {
    protected String titre;
    public Document(String titre){
        this.titre=titre;
    }
    protected String getTitre(){return this.titre;}
    protected void setTitre(String titre){this.titre=titre;}
    protected void affiche(){System.out.println("Titre : "+ this.titre);}
}