import java.util.Date;

public class Journal extends Document {
    protected Date date_parution;
    public Journal(String titre,Date date_parution){
        super(titre);
        this.date_parution=date_parution;
    }
    protected Date getDate_parution(){return this.date_parution;}
    protected void setDate_parution(Date date_parution){this.date_parution=date_parution;}
    protected void affiche(){System.out.println("date_parution : "+ this.date_parution);}
}