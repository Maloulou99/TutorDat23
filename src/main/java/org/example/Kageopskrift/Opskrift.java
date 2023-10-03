package org.example.Kageopskrift;

import java.util.ArrayList;

public class Opskrift {
    private ArrayList<Ingrediens> ingredienser;
    private int antalPersoner;

    public Opskrift(int antalPersoner) {
        this.antalPersoner = antalPersoner;
        this.ingredienser = new ArrayList<>();
        initialiserIngredienser();
    }

    private void initialiserIngredienser() {
        ingredienser.add(new Ingrediens("Mel", 250, "gram", 1500));
        ingredienser.add(new Ingrediens("Sukker", 200, "gram", 1700));
        ingredienser.add(new Ingrediens("Æg", 4, "stk", 300));
        ingredienser.add(new Ingrediens("Smør", 200, "gram", 3000));
        ingredienser.add(new Ingrediens("Bagepulver", 2, "teskefulde", 0));
    }

    public void udskrivOpskrift() {
        System.out.println("Opskrift til " + antalPersoner + " personer:");
        System.out.println("--------------------------");

        for (Ingrediens ingrediens : ingredienser) {
            double samletMængde = ingrediens.getMængde() * antalPersoner;
            System.out.printf("%-15s %.2f %s%n", ingrediens.getType(), samletMængde, ingrediens.getEnhed());
        }

        System.out.println("--------------------------");
    }

    public void udskrivEnergiIndhold() {
        double totalEnergiKilojoule = 0;
        double totalEnergiKcal = 0;

        for (Ingrediens ingrediens : ingredienser) {
            double energiPerEnhed = ingrediens.getEnergiPerEnhed();
            double enhedsMængde = ingrediens.getMængde();
            double samletMængde = enhedsMængde * antalPersoner;
            double energiKilojoule = (energiPerEnhed / 1000) * samletMængde;
            double energiKcal = energiKilojoule * 0.239;
            totalEnergiKilojoule += energiKilojoule;
            totalEnergiKcal += energiKcal;
        }

        System.out.println("Totalt energiindhold:");
        System.out.println("Kilojoule: " + totalEnergiKilojoule + " kJ");
        System.out.println("Kcal: " + totalEnergiKcal + " kcal");
    }


    private double beregnSamletVægtFørBagning() {
        double samletVægt = 0;
        for (Ingrediens ingrediens : ingredienser) {
            samletVægt += ingrediens.getMængde() * antalPersoner;
        }
        return samletVægt;
    }

    public void udskrivSamletVægtEfterBagning() {
        double samletVægtFørBagning = beregnSamletVægtFørBagning();
        double samletVægtEfterBagning = samletVægtFørBagning * 0.9;
        System.out.println("Samlet vægt efter bagning: " + samletVægtEfterBagning + " gram");
    }

    public void setIngredienser(ArrayList<Ingrediens> ingredienser) {
        this.ingredienser = ingredienser;
    }

    public void setAntalPersoner(int antalPersoner) {
        this.antalPersoner = antalPersoner;
    }
}
