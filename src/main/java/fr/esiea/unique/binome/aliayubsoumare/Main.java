package fr.esiea.unique.binome.aliayubsoumare;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Cluster ordinateurs
        ReseauOrdinateurs reseauOrdinateurs = new ReseauOrdinateurs();
        MarcheAleatoire marcheAleatoire = new MarcheAleatoire(reseauOrdinateurs);
        System.out.println("Réseau d'ordinateurs, Topologie Circulaire\n");
        char ch;

        do {
            System.out.println("\nRéseau d'ordinateurs, Topologie Circulaire - List Operations\n");
            System.out.println("1. Insertion PC au début\n");
            System.out.println("2. Insertion PC à la fin");
            System.out.println("3. Insertion PC à une position");
            System.out.println("4. Insertion PC + Antivirus au début");
            System.out.println("5. Insertion PC + Antivirus à la fin");
            System.out.println("6. Insertion PC + Antivirus à une position");
            System.out.println("7. Insertion PC + Virus au début");
            System.out.println("8. Insertion PC + Virus à la fin");
            System.out.println("9. Insertion PC + Virus à une position");
            System.out.println("10. Suppression PC à une position");
            System.out.println("11. Vérifie si le réseau est vide");
            System.out.println("12. Nombre de machines");
            System.out.println("13. Lancer marche aléatoire");
            System.out.println("14. Afficher réseau");

            int choix = scanner.nextInt();
            switch (choix) {
            case 1: // PC -> DEBUT
                Ordinateur ordinateurDebut = new Ordinateur(null, null);
                reseauOrdinateurs.insertAtStart(ordinateurDebut);
                break;
            case 2: // PC -> FIN
                Ordinateur ordinateurFin = new Ordinateur(null, null);
                reseauOrdinateurs.insertAtEnd(ordinateurFin);
                break;
            case 3: // PC -> POSITION
                Ordinateur ordinateurPos = new Ordinateur(null, null);
                System.out.println("Entrez une position :");
                int pos = scanner.nextInt();
                if (pos < 1 || pos > reseauOrdinateurs.getTaille())
                    System.out.println("Poistion invalide\n");
                else
                    reseauOrdinateurs.insertAtPosition(ordinateurPos, pos);
                break;
            case 4: // PC + Antivirus -> DEBUT
                if (!reseauOrdinateurs.aUnAntivirus) {
                    Ordinateur ordinateur = new Ordinateur(null, null, new Antivirus());
                    reseauOrdinateurs.insertAtStart(ordinateur);
                    reseauOrdinateurs.setAUnAntivirus(true);
                } else
                    System.out.println("Le réseau a déjà un PC avec un antivirus.");
                break;
            case 5: // PC + Antivirus -> FIN
                if (!reseauOrdinateurs.aUnAntivirus) {
                    Ordinateur ordinateur = new Ordinateur(null, null, new Antivirus());
                    reseauOrdinateurs.insertAtEnd(ordinateur);
                    reseauOrdinateurs.setAUnAntivirus(true);
                } else
                    System.out.println("Le réseau a déjà un PC avec un antivirus.");
                break;
            case 6: // PC + Antivirus -> POSITION
                if (!reseauOrdinateurs.aUnAntivirus) {
                    Ordinateur ordinateur = new Ordinateur(null, null, new Antivirus());
                    System.out.println("Entrez une position :");
                    int pos1 = scanner.nextInt();
                    if (pos1 < 1 || pos1 > reseauOrdinateurs.getTaille())
                        System.out.println("Poistion invalide\n");
                    else {
                        reseauOrdinateurs.insertAtPosition(ordinateur, pos1);
                        reseauOrdinateurs.setAUnAntivirus(true);
                    }
                } else
                    System.out.println("Le réseau a déjà un PC avec un antivirus.");
                break;
            case 7: // PC + VIRUS -> DEBUT
                if (!reseauOrdinateurs.aUnVirus) {
                    Ordinateur ordinateur = new Ordinateur(null, null, new Virus());
                    reseauOrdinateurs.insertAtStart(ordinateur);
                    reseauOrdinateurs.setAUnVirus(true);
                } else
                    System.out.println("Le réseau a déjà un PC avec un virus.");
                break;
            case 8: // PC + VIRUS -> FIN
                if (!reseauOrdinateurs.aUnVirus) {
                    Ordinateur ordinateur = new Ordinateur(null, null, new Virus());
                    reseauOrdinateurs.insertAtEnd(ordinateur);
                    reseauOrdinateurs.setAUnVirus(true);
                } else
                    System.out.println("Le réseau a déjà un PC avec un virus.");
                break;
            case 9:
                if (!reseauOrdinateurs.aUnVirus) {
                    Ordinateur ordinateur = new Ordinateur(null, null, new Virus());
                    System.out.println("Entrez une position :");
                    int pos1 = scanner.nextInt();
                    if (pos1 < 1 || pos1 > reseauOrdinateurs.getTaille())
                        System.out.println("Poistion invalide\n");
                    else {
                        reseauOrdinateurs.insertAtPosition(ordinateur, pos1);
                        reseauOrdinateurs.setAUnVirus(true);
                    }
                } else
                    System.out.println("Le réseau a déjà un PC avec un virus.");
                break;
            case 10: // Suppression PC position
                System.out.println("Entrez une position :");
                int p = scanner.nextInt();
                if (p < 1 || p > reseauOrdinateurs.getTaille())
                    System.out.println("Position invalide\n");
                else
                    reseauOrdinateurs.supprimerPCPosition(p);
                break;
            case 11:
                if (reseauOrdinateurs.isEmpty())
                    System.out.println("Aucun réseau n'est établi.");
                else
                    System.out.println("Un réseau n'est établi.");
                break;
            case 12:
                System.out.println("Taille du réseau : " + reseauOrdinateurs.getTaille() + " ordinateur(s)\n");
                break;
            case 13:
                // TODO
                System.out.print("Combien de fois la marche aléatoire doit-elle être effectuée : ");
                int n = scanner.nextInt();
                for (int i = 0; i < n; i++) {
                    marcheAleatoire.parcoursListeDoubleChainee();
                    System.out.println("Instant n = " + (i + 1) + ":\n");
                    reseauOrdinateurs.affchageReseau();
                }
                break;
            case 14:
                reseauOrdinateurs.affchageReseau();
            }
            System.out.println("\nVoulez-vous continuer ? (yY ou nN)\n");
            ch = scanner.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
