package org.example.SuperheroGame;

import java.time.LocalDate;
import java.util.ArrayList;

public class SuperheroDatabase {
    private ArrayList<Superhero> superheroes;

    public SuperheroDatabase() {
        this.superheroes = new ArrayList<>();

        Superhero superhero1 = new Superhero("Malou", "supermalou", "Udødelig", LocalDate.of(1999, 04, 13), true, 10000);
        Superhero superhero2 = new Superhero("BLack", "Superman", "Stærk", LocalDate.of(1938, 03, 12), true, 30000);

        superheroes.add(superhero1);
        superheroes.add(superhero2);
    }
    public boolean addSuperheroes(String name, String realName, String superpower, LocalDate yearCreated, boolean isHuman, int strength) {
        Superhero newSuperhero = new Superhero(name, realName, superpower, yearCreated, isHuman, strength);
        superheroes.add(newSuperhero);
        return true;
    }

    public Superhero showSuperhero(String name) {
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equals(name)) {
                return superhero; // Returner superhelten med det angivne navn
            }
        }
        return null; // Returner null, hvis superhelten ikke findes
    }


    public void showSuperheroes(){
        System.out.println("Liste over superhelte: ");
        for (Superhero superhero : superheroes){
            System.out.println(superhero);
        }
    }

    public boolean removeSuperhero(String superheroName) {
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equals(superheroName)) {
                superheroes.remove(superheroName);
                System.out.println("Superhelten med navnet " + superheroName + " blev fjernet i databasen.");
                return true;
            }
        }
        System.out.println("Superhelten med navnet " + superheroName + " blev ikke fundet i databasen.");
        return false;
    }

    public boolean updateSuperhero(String superheroName, String newName, String newRealName, String newSuperpower, LocalDate newYearCreated, int newStrength) {
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equals(superheroName)) {
                superhero.setName(newName);
                superhero.setRealName(newRealName);
                superhero.setSuperpower(newSuperpower);
                superhero.setYearCreated(newYearCreated);
                superhero.setStrength(newStrength);

                System.out.println("Superhelten med navnet " + superheroName + " blev opdateret i databasen.");
                return true;
            }
        }
        System.out.println("Superhelten med navnet " + superheroName + " blev ikke fundet i databasen, så opdatering kunne ikke udføres.");
        return false;
    }

}
