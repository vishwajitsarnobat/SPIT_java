// Viewinfo method is yet to be completed

import java.util.Scanner;

class Animal {
    String species;
    String habitat;
    String diet;
    int lifespan;
    String specialFeatures;

    Animal(String species, String habitat, String diet, int lifespan, String specialFeatures) {
        this.species = species;
        this.habitat = habitat;
        this.diet = diet;
        this.lifespan = lifespan;
        this.specialFeatures = specialFeatures;
    }

    void display() {
        System.out.println("Species: " + species);
        System.out.println("Habitat: " + habitat);
        System.out.println("Diet: " + diet);
        System.out.println("Life Span: " + lifespan);
        System.out.println("Special Features: " + specialFeatures);
    }
}

class Mammal extends Animal {
    Mammal(String species, String habitat, String diet, int lifespan, String specialFeatures) {
        super(species, habitat, diet, lifespan, specialFeatures);
    }
}

class Bird extends Animal {
    Bird(String species, String habitat, String diet, int lifespan, String specialFeatures) {
        super(species, habitat, diet, lifespan, specialFeatures);
    }
}

class Reptile extends Animal {
    Reptile(String species, String habitat, String diet, int lifespan, String specialFeatures) {
        super(species, habitat, diet, lifespan, specialFeatures);
    }
}

class Fish extends Animal {
    Fish(String species, String habitat, String diet, int lifespan, String specialFeatures) {
        super(species, habitat, diet, lifespan, specialFeatures);
    }
}

class Zoo {
    static Scanner input = new Scanner(System.in);

    static void viewInfo() {
        

        mainMenu();
    }

    static void mainMenu() {
        System.out.println("1. Add animal. \n 2. View info about an animal. \n 3. Exit");

        int option = input.nextInt();

        switch(option) {
            case 1:
                addAnimal();
                break;

            case 2:
                viewInfo();
                break;

            case 3:
                System.out.println("See you soon! :)");
                break;

            case 4:
                System.out.println("Please enter a valid input");
                break;
        }
    }

    static void addAnimal() {
        System.out.println("Enter name of the species: ");
        String species = input.nextLine();
        System.out.println("Enter habitat: ");
        String habitat = input.nextLine();
        System.out.println("Enter diet: ");
        String diet = input.nextLine();
        System.out.println("Enter lifespan: ");
        int lifespan = input.nextInt();
        input.nextLine(); // Consume newline character left by nextInt()
        System.out.println("Enter special features: ");
        String specialFeatures = input.nextLine();

        Mammal[] mammals = new Mammal[10];
        int mammalsCtr = 0;
        Bird[] birds = new Bird[10];
        int birdsCtr = 0;
        Reptile[] reptiles = new Reptile[10];
        int reptilesCtr = 0;
        Fish[] fishes = new Fish[10];
        int fishesCtr = 0;

        switch (species) {
            case "Mammal":
                mammals[mammalsCtr] = new Mammal(species, habitat, diet, lifespan, specialFeatures);
                break;

            case "Bird":
                birds[birdsCtr] = new Bird(species, habitat, diet, lifespan, specialFeatures);
                break;

            case "Reptile":
                reptiles[reptilesCtr] = new Reptile(species, habitat, diet, lifespan, specialFeatures);
                break;

            case "Fish":
                fishes[fishesCtr] = new Fish(species, habitat, diet, lifespan, specialFeatures);
                break;

            default:
                System.out.println("Please enter a valid species name");
                break;
        }

        mainMenu();
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
