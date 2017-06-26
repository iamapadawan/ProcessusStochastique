package fr.esiea.unique.binome.aliayubsoumare;

public class ComputerNetwork {

    protected Computer start;
    protected Computer end;
    public int taille;
    public boolean aUnVirus;
    public boolean aUnAntivirus;

    public ComputerNetwork() {
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

    // Fonction qui retourne la taille du réseau d'Computer
    public int getTaille() {
        return taille;
    }

    // Fonction qui ajoute un PC au début
    public void insertAtStart(Computer Computer) {
        // Computer Computer = new Computer(null, null);
        if (start == null) // Si le réseau est vide
        {
            Computer.setLinkNext(Computer);
            Computer.setLinkPrev(Computer);
            start = Computer;
            end = start;
        } else // Si un PC est déjà présent dans le réseau
        {
            Computer.setLinkPrev(end);
            end.setLinkNext(Computer);
            start.setLinkPrev(Computer);
            Computer.setLinkNext(start);
            start = Computer; // L'Computer est placé au début
        }
        taille++;
    }

    // Fonction qui ajoute un PC à la fin
    public void insertAtEnd(Computer Computer) {
        // Computer Computer = new Computer(null, null);
        if (start == null) {
            Computer.setLinkNext(Computer);
            Computer.setLinkPrev(Computer);
            start = Computer;
            end = start;
        } else {
            Computer.setLinkPrev(end);
            end.setLinkNext(Computer);
            start.setLinkPrev(Computer);
            Computer.setLinkNext(start);
            end = Computer; // L'Computer est placé vers la fin
        }
        taille++;
    }

    // Fonction qui ajoute un PC au réseau
    public void insertAtPosition(Computer Computer, int position) {
        // Computer Computer = new Computer(null, null);
        if (position == 1) {
            insertAtStart(Computer);
            return;
        }
        Computer Computer2 = start;
        for (int i = 2; i <= taille; i++) {
            if (i == position) {
                Computer tmp = Computer2.getLinkNext();
                Computer2.setLinkNext(Computer);
                Computer.setLinkPrev(Computer2);
                Computer.setLinkNext(tmp);
                tmp.setLinkPrev(Computer);
            }
            Computer2 = Computer2.getLinkNext();
        }
        taille++;
    }

    // Fonction qui supprime un Computer du réseau
    public void supprimerPCPosition(int position) {
        if (position == 1) // Si l'Computer à supprimer est au début
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
        if (position == taille) // Si l'Computer à supprimer est à la fin
        {
            end = end.getLinkPrevious();
            end.setLinkNext(start);
            start.setLinkPrev(end);
            taille--;
        }

        Computer Computer = start.getLinkNext();
        for (int i = 2; i <= taille; i++) {
            if (i == position) {
                Computer p = Computer.getLinkPrevious();
                Computer n = Computer.getLinkNext();

                p.setLinkNext(n);
                n.setLinkPrev(p);
                taille--;
                return;
            }
            Computer = Computer.getLinkNext();
        }
    }

    // Fonction qui affiche l'état du système
    public void affchageReseau() {
        System.out.print("\nRéseau d'Computers infectés/non infecté\n");
        Computer Computer = start;
        if (taille == 0) {
            System.out.print("VIDE\n");
            return;
        }
        if (start.getLinkNext() == start) {
            System.out.print(start + " <-> " + Computer + "\n");
            return;
        }

        System.out.print(start + " <-> ");
        Computer = start.getLinkNext();
        while (Computer.getLinkNext() != start) {
            System.out.print(Computer + " <-> ");
            Computer = Computer.getLinkNext();
        }
        System.out.print(Computer + " <-> ");
        Computer = Computer.getLinkNext();
        System.out.print(Computer + "\n");
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

    public Computer getStart() {
        return start;
    }

    public Computer getEnd() {
        return end;
    }
}