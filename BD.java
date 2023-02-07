public class BD extends Volume {
    private String dessinateur;
    public BD(String titre,String auteur,String dessinateur){
        super(titre,auteur);
        this.dessinateur=dessinateur;
    }
    protected String getDessinateur(){return this.dessinateur;}
    protected void setDessinateur(String dessinateur){this.dessinateur=dessinateur;}
    protected void affiche(){
    System.out.println("le dessinateur:"+this.dessinateur);}
}