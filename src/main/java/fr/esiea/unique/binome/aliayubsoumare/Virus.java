package fr.esiea.unique.binome.aliayubsoumare;

import java.util.Random;

public class Virus {

    private double probabiliteChargeVirale = 0.7;

    public boolean chargeViraleSucces() {
        Random random = new Random();
        int nombre = random.nextInt(101);
        return nombre / 100 <= probabiliteChargeVirale;
    }
}