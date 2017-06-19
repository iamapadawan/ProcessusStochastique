package fr.esiea.unique.binome.aliayubsoumare;

import java.util.Random;

public class Antivirus {

    private double probabiliteChargeAntivirale = 0.4;

    public boolean chargeAntiviraleSucces() {
        Random random = new Random();
        int nombre = random.nextInt(101);
        return nombre / 100 <= probabiliteChargeAntivirale;
    }
}