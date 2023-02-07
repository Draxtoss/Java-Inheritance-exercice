import java.util.Date;

public class Emprunt {
    private Etudiant etudiant;
    private Livre livre;
    private Date dateemp;
    private Date datret;
    public Emprunt(Etudiant etudiant, Livre livre, Date dateemp) {
        this.etudiant = etudiant;
        this.livre = livre;
        this.dateemp = dateemp;
        this.datret=null;
    }
    protected Etudiant getEtudiant(){return this.etudiant;}
    protected Livre getLivre(){return this.livre;}
    protected Date getDateemp(){return this.dateemp;}
    protected Date getDatret(){return this.datret;}
    protected void setDatret(Date datret){this.datret=datret;}
}