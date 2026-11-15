package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

public class ZooManagement {

    public static void main(String[] args) {
        Zoo myZoo = new Zoo("Belvedere", "Tunis");

        Animal[] toAdd = {
                new Terrestrial("Felidae", "Simba", 5, true, 4),
                new Dolphin("Delphinidae", "Flipper", 8, true, "ocean", 35.5f),
                new Penguin("Spheniscidae", "Pingu", -3, false, "antarctica", 120f),
                new Terrestrial("Canidae", "Rex", 2, true, 4),
                new Penguin("Spheniscidae", "Skipper", 5, false, "antarctica", 200f)
        };

        for (int i = 0; i < toAdd.length; i++) {
            try {
                myZoo.addAnimal(toAdd[i]);
                System.out.println(toAdd[i].getName() + " added");
            } catch (ZooFullException e) {
                System.out.println("ZooFullException : " + e.getMessage());
            } catch (InvalidAgeException e) {
                System.out.println("InvalidAgeException : " + e.getMessage());
            } finally {
                System.out.println("number of animals : " + myZoo.getNbrAnimals());
            }
        }

        myZoo.displayAnimals();
    }
}
