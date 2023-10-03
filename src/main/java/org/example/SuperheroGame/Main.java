package org.example.SuperheroGame;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SuperheroDatabase database = new SuperheroDatabase();
        SuperheroController superheroController = new SuperheroController(database);
        Scanner scanner = new Scanner(System.in);

        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("Menu ");
            System.out.println("1. Tilføj superhelt");
            System.out.println("2. Fjern superhelt");
            System.out.println("3. Vis liste over superhelte");
            System.out.println("4. Update superhelte");
            System.out.println("5. Afslut programmet");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Indtast realname: ");
                        String name = scanner.nextLine();
                        System.out.println("Indtast superheltenavn: ");
                        String superheroName = scanner.nextLine();
                        System.out.println("Indtast superpower: ");
                        String superpower = scanner.nextLine();
                        System.out.println("Indtast oprindelsesår (YYYY-MM-DD): ");
                        String yearCreatedStr = scanner.nextLine();
                        LocalDate yearCreated = LocalDate.parse(yearCreatedStr, DateTimeFormatter.ISO_LOCAL_DATE);
                        boolean isHuman;
                        do {
                            System.out.print("Er din superhelt et menneske? (ja/nej): ");
                            String isHumanInput = scanner.nextLine().toLowerCase();
                            if (isHumanInput.equals("ja")) {
                                isHuman = true;
                                break;
                            } else if (isHumanInput.equals("nej")) {
                                isHuman = false;
                                break;
                            } else {
                                System.out.println("Ugyldigt svar. Skriv enten 'ja' eller 'nej'.");
                            }
                        } while (true);
                        System.out.println("Hvor stærk er din superhelt? ");
                        int strength = scanner.nextInt();
                        superheroController.addSuperhero(name, superheroName, superpower, yearCreated, isHuman, strength);
                        System.out.println("Superhelt er tilføjet i databasen.");
                        break;
                    case 2:
                        System.out.println("Indtast superheronavnet på din superhelt du vil have fjernet se listen ...");
                        database.showSuperheroes();
                        String superName = scanner.nextLine();
                        database.removeSuperhero(superName);
                        break;
                    case 3:
                        superheroController.showSuperhero();
                        break;
                    case 4:
                        System.out.println("Indtast superheronavnet på den superhelt, du vil opdatere: ");
                        String superNameToUpdate = scanner.nextLine();

                        // Find superhelten i databasen
                        Superhero superheroToUpdate = database.showSuperhero(superNameToUpdate);

                        if (superheroToUpdate != null) {
                            System.out.println("Indtast nye oplysninger for superhelten:");

                            System.out.println("Nyt realname (" + superheroToUpdate.getRealName() + "): ");
                            String newName = scanner.nextLine();
                            if (!newName.isEmpty()) {
                                superheroToUpdate.setRealName(newName);
                            }

                            System.out.println("Nyt superheltenavn (" + superheroToUpdate.getName() + "): ");
                            String newSuperheroName = scanner.nextLine();
                            if (!newSuperheroName.isEmpty()) {
                                superheroToUpdate.setName(newSuperheroName);
                            }

                            System.out.println("Nyt superpower (" + superheroToUpdate.getSuperpower() + "): ");
                            String newSuperpower = scanner.nextLine();
                            if (!newSuperpower.isEmpty()) {
                                superheroToUpdate.setSuperpower(newSuperpower);
                            }

                            System.out.println("Nyt oprindelsesår (" + superheroToUpdate.getYearCreated() + "): ");
                            String newYearCreatedStr = scanner.nextLine();
                            if (!newYearCreatedStr.isEmpty()) {
                                try {
                                    LocalDate newYearCreated = LocalDate.parse(newYearCreatedStr, DateTimeFormatter.ISO_LOCAL_DATE);
                                    superheroToUpdate.setYearCreated(newYearCreated);
                                } catch (DateTimeParseException e) {
                                    System.out.println("Fejl: Forkert datoformat. Brug YYYY-MM-DD.");
                                }
                            }

                            System.out.println("Ny styrke (" + superheroToUpdate.getStrength() + "): ");
                            try {
                                int newStrength = scanner.nextInt();
                                superheroToUpdate.setStrength(newStrength);
                            } catch (InputMismatchException e) {
                                System.out.println("Fejl: Indtast venligst en gyldig numerisk værdi. Styrken vil forblive uændret.");
                            }

                            System.out.println("Superhelten er blevet opdateret.");
                        } else {
                            System.out.println("Superhelten med navnet " + superNameToUpdate + " blev ikke fundet i databasen.");
                        }
                        break;

                    case 5:
                        System.out.println("Farvel!");
                        exitProgram = true; // Afslut programmet
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen ...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Fejl: Indtast venligst en gyldig værdi.");
                scanner.nextLine();
            } catch (DateTimeParseException e) {
                System.out.println("Fejl: Forkert datoformat. Brug YYYY-MM-DD.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Der opstod en fejl: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}
