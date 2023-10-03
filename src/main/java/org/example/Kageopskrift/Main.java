package org.example.Kageopskrift;

public class Main {
    public static void main(String[] args) {


        Opskrift opskrift = new Opskrift(3);
        
        opskrift.udskrivOpskrift();
        opskrift.udskrivSamletVægtEfterBagning();
        opskrift.udskrivEnergiIndhold();
    }

}