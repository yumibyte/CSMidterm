import java.util.ArrayList;
import java.util.Scanner;

public class CSMidterm {

    public static class Foods {
        public static ArrayList<Foods> kirbyFoods = new ArrayList<Foods>();

        private String foodName;
        private double healAmount;

        Foods(String foodName, double healAmount) {
            this.foodName = foodName;
            this.healAmount = healAmount;
            kirbyFoods.add(this);
        }
    }
    public static class Skills {
        public static ArrayList<Skills> kirbySkills = new ArrayList<Skills>();

        private String skillDescription;
        private double skillDamage;

        Skills(String skillDescription, double skillDamage) {
            this.skillDescription = skillDescription;
            this.skillDamage = skillDamage;
            kirbySkills.add(this);
        }
    }

    public static class Kirby {

        private String username;
        private double health;

        Kirby(String username) {
            this.health = 100;      // Predefined health
            this.username = username;
//            kirbyCharacters.add(this);
        }

        void createSkill(String skillDescription, double skillDamage) {
            Skills skills = new Skills(skillDescription, skillDamage);
        }

        void createFood(String foodName, double foodHealh) {
            Foods foods = new Foods(foodName, foodHealh);
        }

        public void readInstances() {

            // setup to read KirbyCharacters
            System.out.println("username: " + this.username);
            System.out.println("health: " + this.health);

            System.out.println("Kirby has " + Skills.kirbySkills.size() + " powerful skill(s)");
            System.out.println("Kirby has " + Foods.kirbyFoods.size() + " yummy food(s) equipped");

            /**
            for (int i = 0; i < Skills.kirbySkills.size(); i ++) {
                // TODO: change to read from current Kirby character
//                System.out.println("Skill description: " + Skills.kirbySkills.get(i).skillDescription);
//                System.out.println("Skill damage: " + Skills.kirbySkills.get(i).skillDamage);
            }


            for (int i = 0; i < Foods.kirbyFoods.size(); i ++) {
                // TODO: change to read from current Kirby character
                System.out.println("Skill description: " + Foods.kirbyFoods.get(i).foodName);
                System.out.println("Skill damage: " + Foods.kirbyFoods.get(i).healAmount);
            }
             **/
        }
    }

    public static void main(String[] args) {

        // Begin by creating user then enter forever loop of creating skills/equipping food
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to create a Kirby!\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" +
                "What is your username?\n" +
                "Enter name: ");
        String username = sc.next();

        // initialize Kirby with username
        Kirby a = new Kirby(username);
        a.readInstances();


        while (true) {

            System.out.println("What would you like to do?\n" +
                    "1 - Learn a new skill\n" +
                    "2 - Equip a new food");
            int userInputChoice = sc.nextInt();

            switch (userInputChoice) {
                case 1:
                    System.out.println("Give a short description of your new skill: ");
                    String skillDescriptionInput = sc.next();

                    System.out.println("How much damage does this skill do?:\nEnter a number: ");
                    double skillDamageInput = sc.nextDouble();

                    a.createSkill(skillDescriptionInput, skillDamageInput);
                    break;
                case 2:
                    System.out.println("What's the name of your food?");
                    String foodNameInput = sc.next();

                    System.out.println("How much does your food heal?\nEnter a number:");
                    double healAmountInput = sc.nextInt();

                    a.createFood(foodNameInput, healAmountInput);

            }
            a.readInstances();
        }


    }
}
