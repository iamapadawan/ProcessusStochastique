package fr.esiea.unique.binome.aliayubsoumare;

public class Computer {

    private boolean infecte;
    private Virus virus;
    private Antivirus antivirus;
    private Computer ordinateurGauche, ordinateurDroite;

    public Computer() {
        this.ordinateurDroite = null;
        this.ordinateurGauche = null;
        this.virus = null;
        this.antivirus = null;
        this.infecte = false;
    }

    public Computer(Computer pOrdinateurGauche, Computer pOrdinateurDroite) {
        this.ordinateurDroite = pOrdinateurDroite;
        this.ordinateurGauche = pOrdinateurGauche;
        this.infecte = false;
    }

    public Computer(Computer pOrdinateurGauche, Computer pOrdinateurDroite, Virus pVirus) {
        this.ordinateurDroite = pOrdinateurDroite;
        this.ordinateurGauche = pOrdinateurGauche;
        this.virus = pVirus;
        this.infecte = true;
    }

    public Computer(Computer pOrdinateurGauche, Computer pOrdinateurDroite, Antivirus pAntiVirus) {
        this.ordinateurDroite = pOrdinateurDroite;
        this.ordinateurGauche = pOrdinateurGauche;
        this.antivirus = pAntiVirus;
        this.infecte = false;
    }

    public void setLinkNext(Computer pOrdinateur) {
        this.ordinateurDroite = pOrdinateur;
    }

    public void setLinkPrev(Computer pOrdinateur) {
        this.ordinateurGauche = pOrdinateur;
    }

    public Computer getLinkNext() {
        return this.ordinateurDroite;
    }

    public Computer getLinkPrevious() {
        return this.ordinateurGauche;
    }

    public boolean getInfecte() {
        return infecte;
    }

    public void setInfecte(boolean infecte) {
        this.infecte = infecte;
    }

    public Computer(boolean infecte) {
        this.infecte = infecte;
    }

    public boolean HasVirus() {
        return this.virus != null;
    }

    public boolean aLAntivirus() {
        return this.antivirus != null;
    }

    public void setVirus(Virus pVirus) {
        this.virus = pVirus;
    }

    public void setAntivirus(Antivirus pAntiVirus) {
        this.antivirus = pAntiVirus;
    }

    public Antivirus getAntivirus() {
        return this.antivirus;
    }

    public Virus getVirus() {
        return this.virus;
    }

    public String toString() {
        String str = "";

        // Infecté ou non ?
        if (this.getInfecte())
            str += "I";
        else
            str += "S";

        // Antivirus ? Virus ? Rien ?
        if (this.HasVirus() && !this.aLAntivirus())
            str += " (V)";
        if (!this.HasVirus() && this.aLAntivirus())
            str += " (A)";
        if (this.HasVirus() && this.aLAntivirus())
            str += "(V, A)";

        return str;
    }
}