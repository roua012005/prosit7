package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

public class Zoo {
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages = 3;
    private int nbrAnimals;
    private Aquatic[] aquaticAnimals = new Aquatic[10];
    private int nbrAquatics;

    public Zoo() {
    }

    public Zoo(String name, String city) {
        animals = new Animal[nbrCages];
        setName(name);
        this.city = city;
        nbrAnimals = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("zoo name can't be empty");
            this.name = "unknown";
        } else {
            this.name = name;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (nbrAnimals == nbrCages) {
            throw new ZooFullException("the zoo " + name + " is full, can't add " + animal.getName());
        }
        if (animal.getAge() < 0) {
            throw new InvalidAgeException("the age of " + animal.getName() + " can't be negative");
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
    }

    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    public static Zoo compareZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals) {
            return z1;
        }
        return z2;
    }

    public void displayAnimals() {
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println(animals[i]);
        }
    }

    public void addAquaticAnimal(Aquatic aquatic) {
        if (nbrAquatics >= aquaticAnimals.length) {
            System.out.println("no more place for aquatic animals");
            return;
        }
        aquaticAnimals[nbrAquatics] = aquatic;
        nbrAquatics++;
    }

    public void swimAll() {
        for (int i = 0; i < nbrAquatics; i++) {
            aquaticAnimals[i].swim();
        }
    }

    public float maxPenguinSwimmingDepth() {
        float max = 0;
        for (int i = 0; i < nbrAquatics; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                Penguin p = (Penguin) aquaticAnimals[i];
                if (p.getSwimmingDepth() > max) {
                    max = p.getSwimmingDepth();
                }
            }
        }
        return max;
    }

    public void displayNumberOfAquaticsByType() {
        int nbDolphins = 0;
        int nbPenguins = 0;
        for (int i = 0; i < nbrAquatics; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) {
                nbDolphins++;
            } else if (aquaticAnimals[i] instanceof Penguin) {
                nbPenguins++;
            }
        }
        System.out.println("number of dolphins : " + nbDolphins);
        System.out.println("number of penguins : " + nbPenguins);
    }
}
