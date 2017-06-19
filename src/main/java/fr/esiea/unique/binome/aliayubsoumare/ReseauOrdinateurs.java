package fr.esiea.unique.binome.aliayubsoumare;

public class ReseauOrdinateurs {

    protected Ordinateur start;
    protected Ordinateur end;
    public int taille;
    public boolean aUnVirus;
    public boolean aUnAntivirus;

    public ReseauOrdinateurs() {
        start = null;
        end = null;
        aUnAntivirus = false;
        aUnVirus = false;
        taille = 0;
    }

    // Fonction qui vérifie si le réseau est vide
    public boolean isEmpty() {
        return start == null;
    }

    // Fonction qui retourne la taille du réseau d'ordinateur
    public int getTaille() {
        return taille;
    }

    // Fonction qui ajoute un PC au début
    public void insertAtStart(Ordinateur ordinateur) {
        // Ordinateur ordinateur = new Ordinateur(null, null);
        if (start == null) // Si le réseau est vide
        {
            ordinateur.setLinkNext(ordinateur);
            ordinateur.setLinkPrev(ordinateur);
            start = ordinateur;
            end = start;
        } else // Si un PC est déjà présent dans le réseau
        {
            ordinateur.setLinkPrev(end);
            end.setLinkNext(ordinateur);
            start.setLinkPrev(ordinateur);
            ordinateur.setLinkNext(start);
            start = ordinateur; // L'ordinateur est placé au début
        }
        taille++;
    }

    // Fonction qui ajoute un PC à la fin
    public void insertAtEnd(Ordinateur ordinateur) {
        // Ordinateur ordinateur = new Ordinateur(null, null);
        if (start == null) {
            ordinateur.setLinkNext(ordinateur);
            ordinateur.setLinkPrev(ordinateur);
            start = ordinateur;
            end = start;
        } else {
            ordinateur.setLinkPrev(end);
            end.setLinkNext(ordinateur);
            start.setLinkPrev(ordinateur);
            ordinateur.setLinkNext(start);
            end = ordinateur; // L'ordinateur est placé vers la fin
        }
        taille++;
    }

    // Fonction qui ajoute un PC au réseau
    public void insertAtPosition(Ordinateur ordinateur, int position) {
        // Ordinateur ordinateur = new Ordinateur(null, null);
        if (position == 1) {
            insertAtStart(ordinateur);
            return;
        }
        Ordinateur ordinateur2 = start;
        for (int i = 2; i <= taille; i++) {
            if (i == position) {
                Ordinateur tmp = ordinateur2.getLinkNext();
                ordinateur2.setLinkNext(ordinateur);
                ordinateur.setLinkPrev(ordinateur2);
                ordinateur.setLinkNext(tmp);
                tmp.setLinkPrev(ordinateur);
            }
            ordinateur2 = ordinateur2.getLinkNext();
        }
        taille++;
    }

    // Fonction qui supprime un ordinateur du réseau
    public void supprimerPCPosition(int position) {
        if (position == 1) // Si l'ordinateur à supprimer est au début
        {
            if (taille == 1) {
                start = null;
                end = null;
                taille = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(end);
            end.setLinkNext(start);
            taille--;
            return;
        }
        if (position == taille) // Si l'ordinateur à supprimer est à la fin
        {
            end = end.getLinkPrevious();
            end.setLinkNext(start);
            start.setLinkPrev(end);
            taille--;
        }

        Ordinateur ordinateur = start.getLinkNext();
        for (int i = 2; i <= taille; i++) {
            if (i == position) {
                Ordinateur p = ordinateur.getLinkPrevious();
                Ordinateur n = ordinateur.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                taille--;
                return;
            }
            ordinateur = ordinateur.getLinkNext();
        }
    }

    // Fonction qui affiche l'état du système
    public void affchageReseau() {
        System.out.print("\nRéseau d'ordinateurs infectés/non infecté\n");
        Ordinateur ordinateur = start;
        if (taille == 0) {
            System.out.print("VIDE\n");
            return;
        }
        if (start.getLinkNext() == start) {
            System.out.print(start + " <-> " + ordinateur + "\n");
            return;
        }

        System.out.print(start + " <-> ");
        ordinateur = start.getLinkNext();
        while (ordinateur.getLinkNext() != start) {
            System.out.print(ordinateur + " <-> ");
            ordinateur = ordinateur.getLinkNext();
        }
        System.out.print(ordinateur + " <-> ");
        ordinateur = ordinateur.getLinkNext();
        System.out.print(ordinateur + "\n");
    }

    /* ACCESSEURS */
    public boolean getAUnVirus() {
        return aUnVirus;
    }

    public void setAUnVirus(boolean aUnVirus) {
        this.aUnVirus = aUnVirus;
    }

    public boolean getAUnAntivirus() {
        return aUnAntivirus;
    }

    public void setAUnAntivirus(boolean aUnAntivirus) {
        this.aUnAntivirus = aUnAntivirus;
    }

    public Ordinateur getStart() {
        return start;
    }

    public Ordinateur getEnd() {
        return end;
    }
}