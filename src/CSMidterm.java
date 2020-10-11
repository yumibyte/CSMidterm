import java.util.ArrayList;
import java.util.Scanner;

public class CSMidterm {

    public static class Skills {
        public static ArrayList<Skills> kirbySkills = new ArrayList<Skills>();

        private String skillDescription;
        private int skillDamage;

        Skills(String skillDescription, int skillDamage) {
            this.skillDescription = skillDescription;
            this.skillDamage = skillDamage;
            kirbySkills.add(this);
        }

    }

    public static class Kirby {

        private String username;
        private int health;

        Kirby(String username) {
            this.health = 100;      // Predefined health
            this.username = username;
//            kirbyCharacters.add(this);
        }

        void createSkill(String skillDescription, int skillDamage) {
            Skills skills = new Skills(skillDescription, skillDamage);

        }

        public void readInstances() {

            // setup to read KirbyCharacters
            System.out.println("username: " + this.username);
            System.out.println("health: " + this.health);

            for (int i = 0; i < Skills.kirbySkills.size(); i ++) {
                // TODO: change to read from current Kirby character
                System.out.println("Skill description: " + Skills.kirbySkills.get(i).skillDescription);
                System.out.println("Skill damage: " + Skills.kirbySkills.get(i).skillDamage);
            }
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
                    int skillDamageInput = sc.nextInt();

                    a.createSkill(skillDescriptionInput, skillDamageInput);
                    break;
                case 2:
                    System.out.println("equip food");
            }



            a.readInstances();
        }


    }
}
