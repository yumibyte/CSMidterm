import java.util.ArrayList;
import java.util.Scanner;

public class CSMidterm {

    public static class Foods {
        private static ArrayList<Foods> kirbyFoods = new ArrayList<Foods>();

        private String foodName;
        private double healAmount;

        Foods() {
            this.foodName = "Maxim Tomato";
            this.healAmount = 100;
            kirbyFoods.add(this);
        }

        Foods(String foodName, double healAmount) {
            this.foodName = foodName;
            this.healAmount = healAmount;
            kirbyFoods.add(this);
        }

        protected ArrayList<Foods> readFoods() {
            return this.kirbyFoods;
        }
    }

    public static class Skills extends Foods {
        private static ArrayList<Skills> kirbySkills = new ArrayList<Skills>();

        private String skillDescription;
        private double skillDamage;

        protected void createDefaultSkill(String skillDescription) {
            Skills skills = new Skills();
            skills.skillDescription = skillDescription;
            skills.skillDamage = 100;
            kirbySkills.add(skills);
        }

        Skills(String skillName) {

        }
        protected void createSkill(String skillDescription, double skillDamage) {
            Skills skills = new Skills();
            skills.skillDescription = skillDescription;
            skills.skillDamage = skillDamage;
            kirbySkills.add(skills);
        }

        protected ArrayList<Skills> readSkills() {
            return this.kirbySkills;
        }
    }

    public static class Kirby extends Skills {

        private String username;
        private double health;
        private String offense;
        private String defense;

        Kirby(String username) {
            this.health = 100;      // Predefined health
            this.username = username;
        }

        public void readStats() {
            ArrayList<Skills> skillsList = this.readSkills();
            ArrayList<Foods> foodsList = this.readFoods();

            // Evaluate Kirby's total defense and offense based on skills/healing items equipped
            int totalDamage = 0;
            int totalHeal = 0;

            for (int i = 0; i < skillsList.size(); i ++) {
                totalDamage += skillsList.get(i).skillDamage;
            }
            for (int j = 0; j < foodsList.size(); j ++) {
                totalHeal += foodsList.get(j).healAmount;
            }

            if (totalDamage < 50) {
                this.offense = "weak";
            }
            else if (totalDamage < 200) {
                this.offense = "novice";
            } else {
                this.offense = "all powerful boss";
            }

            if (totalHeal < 50) {
                this.defense = "weak";
            }
            else if (totalHeal < 200) {
                this.offense = "novice";
            } else {
                this.offense = "all powerful boss";
            }

            // read Kirby's stats
            System.out.println("CurrentStats\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("username: " + this.username);
            System.out.println("health: " + this.health);
            System.out.println("Kirby has " + skillsList.size() + " powerful skill(s)");
            System.out.println("Kirby has " + foodsList.size() + " yummy food(s) equipped");
            System.out.println("Kirby's offense level is " + this.offense);
            System.out.println("Kirby's offense level is " + this.defense + "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
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
                    "2 - Equip a new food\n" +
                    "3 - Read skills\n" +
                    "4 - Read foods equipped\n" +
                    "5 - Read stats");
            int userInputChoice = sc.nextInt();

            switch (userInputChoice) {
                case 1:
                    System.out.println("1 - Create your own skill\n " +
                            "2 - Create default skill");
                    int optionInput = sc.nextInt();
                    if (optionInput == 1) {
                        System.out.println("Give a short description of your new skill: ");
                        String skillDescriptionInput = sc.next();

                        System.out.println("How much damage does this skill do?:\nEnter a number: ");
                        double skillDamageInput = sc.nextDouble();
                        a.createSkill(skillDescriptionInput, skillDamageInput);
                    }


                    a.readStats();
                    break;

                case 2:
                    System.out.println("1 - Create your own food\n" +
                            "2 - Create default food");
                    optionInput = sc.nextInt();

                    if (optionInput == 1) {
                        System.out.println("What's the name of your food?");
                        String foodNameInput = sc.next();

                        System.out.println("How much does your food heal?\nEnter a number:");
                        double healAmountInput = sc.nextInt();
//                        a.createFood(foodNameInput, healAmountInput);
                        Foods foods = new Foods(foodNameInput, healAmountInput);

                    } else {
                        Foods foods = new Foods();
                    }

                    a.readStats();
                    break;
                case 3:
                    ArrayList<Skills> skillsList = a.readSkills();
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

                    for (int i = 0; i < skillsList.size(); i ++) {
                        int currentSkill = i + 1;
                        System.out.println("Skill number " + currentSkill + ": ");
                        System.out.println("    - Skill Description: " + skillsList.get(i).skillDescription);
                        System.out.println("    - Skill Damage: " + skillsList.get(i).skillDamage + "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    }
                    break;
                case 4:
                    ArrayList<Foods> foodsList = a.readFoods();
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

                    for (int i = 0; i < foodsList.size(); i ++) {
                        int currentFood = i + 1;
                        System.out.println("Food number " + currentFood);
                        System.out.println("    - Food Title: " + foodsList.get(i).foodName);
                        System.out.println("    - Heal Amount: " + foodsList.get(i).healAmount + "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    }
                    break;
                case 5:
                    a.readStats();
                    break;
            }
        }
    }
}
