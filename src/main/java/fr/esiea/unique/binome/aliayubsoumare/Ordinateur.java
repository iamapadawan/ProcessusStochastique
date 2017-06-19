package fr.esiea.unique.binome.aliayubsoumare;

public class Ordinateur {

    private boolean infecte;
    private Virus virus;
    private Antivirus antivirus;
    private Ordinateur ordinateurGauche, ordinateurDroite;

    public Ordinateur() {
        this.ordinateurDroite = null;
        this.ordinateurGauche = null;
        this.virus = null;
        this.antivirus = null;
        this.infecte = false;
    }

    public Ordinateur(Ordinateur pOrdinateurGauche, Ordinateur pOrdinateurDroite) {
        this.ordinateurDroite = pOrdinateurDroite;
        this.ordinateurGauche = pOrdinateurGauche;
        this.infecte = false;
    }

    public Ordinateur(Ordinateur pOrdinateurGauche, Ordinateur pOrdinateurDroite, Virus pVirus) {
        this.ordinateurDroite = pOrdinateurDroite;
        this.ordinateurGauche = pOrdinateurGauche;
        this.virus = pVirus;
        this.infecte = true;
    }

    public Ordinateur(Ordinateur pOrdinateurGauche, Ordinateur pOrdinateurDroite, Antivirus pAntiVirus) {
        this.ordinateurDroite = pOrdinateurDroite;
        this.ordinateurGauche = pOrdinateurGauche;
        this.antivirus = pAntiVirus;
        this.infecte = false;
    }

    public void setLinkNext(Ordinateur pOrdinateur) {
        this.ordinateurDroite = pOrdinateur;
    }

    public void setLinkPrev(Ordinateur pOrdinateur) {
        this.ordinateurGauche = pOrdinateur;
    }

    public Ordinateur getLinkNext() {
        return this.ordinateurDroite;
    }

    public Ordinateur getLinkPrevious() {
        return this.ordinateurGauche;
    }

    public boolean getInfecte() {
        return infecte;
    }

    public void setInfecte(boolean infecte) {
        this.infecte = infecte;
    }

    public Ordinateur(boolean infecte) {
        this.infecte = infecte;
    }

    public boolean aLeVirus() {
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
        if (this.aLeVirus() && !this.aLAntivirus())
            str += " (V)";
        if (!this.aLeVirus() && this.aLAntivirus())
            str += " (A)";
        if (this.aLeVirus() && this.aLAntivirus())
            str += "(V, A)";

        return str;
    }
}