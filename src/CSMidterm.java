import java.util.ArrayList;
import java.util.Scanner;

public class CSMidterm {

    public static class Foods {
        public static ArrayList<Foods> kirbyFoods = new ArrayList<Foods>();
        private String foodName;
        private double healAmount;

        protected void createFood(String foodName, double healAmount) {
            this.foodName = foodName;
            this.healAmount = healAmount;
            kirbyFoods.add(this);
        }

        protected ArrayList<Foods> readFoods() {
            return kirbyFoods;
        }
    }

    public static class Skills extends Foods {
        public static ArrayList<Skills> kirbySkills = new ArrayList<Skills>();
        private String skillDescription;
        private double skillDamage;

        protected void createSkill(String skillDescription, double skillDamage) {
            this.skillDescription = skillDescription;
            this.skillDamage = skillDamage;
            kirbySkills.add(this);
        }
        protected ArrayList<Skills> readSkills() {
            return kirbySkills;
        }
    }

    public static class Kirby extends Skills {

        private String username;
        private double health;

        Kirby(String username) {
            this.health = 100;      // Predefined health
            this.username = username;
//            kirbyCharacters.add(this);
        }

        public void readStats() {

            // setup to read KirbyCharacters
            System.out.println("CurrentStats\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("username: " + this.username);
            System.out.println("health: " + this.health);
            System.out.println("Kirby has " + this.readSkills().size() + " powerful skill(s)");
            System.out.println("Kirby has " + this.readFoods().size() + " yummy food(s) equipped\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
//            System.out.println("Kirby's level is " + kirbyLevel);
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
        a.readStats();


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
            a.readStats();
        }


    }
}
