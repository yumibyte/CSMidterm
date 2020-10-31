import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// NOTE -- you need to have the kirbyEatFood.txt file in the same directory for this project. It needs to be on the same level
// as the code and should be accessible not within src but within the main folder of the project (same level as the .iml)
public class CSMidterm {
    public static class Foods {
        Scanner sc = new Scanner(System.in);
        private ArrayList<Foods> kirbyFoods = new ArrayList<Foods>();
        private String foodName;
        private double healAmount;

        protected void createDefaultFood() {
            Foods foods = new Foods();
            foods.foodName = "Maxim Tomato";        // default food, never changes (will reappend same food)
            foods.healAmount = 100;
            kirbyFoods.add(foods);
        }

        protected void createFood(String foodName, double healAmount) {
            Foods foods = new Foods();
            foods.foodName = foodName;
            foods.healAmount = healAmount;
            kirbyFoods.add(foods);
        }

        protected ArrayList<Foods> readFoodsList() {
            return this.kirbyFoods;
        }

        protected void readFoods() {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

            // CLEAN CODE CORRECTION (CCC)
            for (int foodItem = 0; foodItem < kirbyFoods.size(); foodItem ++) {     // change i to foodItem so it is easy to tell it's taking each object in kirbyFoods
                int currentFood = foodItem + 1;
                System.out.println("Food number " + currentFood);
                System.out.println("    - Food Title: " + kirbyFoods.get(foodItem).foodName);
                System.out.println("    - Heal Amount: " + kirbyFoods.get(foodItem).healAmount + "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            }
        }


        protected void deleteFood() throws InterruptedException {       // handle exception for Thread.sleep
            System.out.println("*In a rush, you drop the food*");
            Thread.sleep(2000);
            System.out.println("'It is weighing me down!!!' You yell");
            Thread.sleep(2000);     // space out with 2000ms to give more time to read
            System.out.println("What is number of the food item you dropped?");
            int foodNumber = sc.nextInt();
            kirbyFoods.remove(foodNumber - 1);
            Thread.sleep(1000);
            System.out.println("You have successfully dropped a food item. Hopefully you won't need it for later...");
            Thread.sleep(1000);

        }

        protected void readFullFoodsList() {

            // TODO -- fix writing to file as individual lines
//            String allFoodNames = "";
//            for (int foodItem = 0; foodItem < kirbyFoods.size(); foodItem ++) {
//                allFoodNames +=
//            }
//
//            return ("FOODS_LIST_NUMBER\n" + this.kirbyFoods.size() + "\n" +
//                    "FOOD_NAMES\n" + this.allFoodNames + "\n" +
//                    "FOOD_HEAL_AMOUNT\n" + this.allHealAmounts
//            );
        }
    }

    public static class Skills extends Foods {
        Scanner sc = new Scanner(System.in);
        private ArrayList<Skills> kirbySkills = new ArrayList<Skills>();
        private String skillDescription;
        private double skillDamage;

        protected void createDefaultSkill() {
            Skills skills = new Skills();
            skills.skillDescription = "Dove barrage";       // default skill, never changes (will reappend same skill)
            skills.skillDamage = 100;
            kirbySkills.add(skills);
        }

        protected void createSkill(String skillDescription, double skillDamage) {
            Skills skills = new Skills();
            skills.skillDescription = skillDescription;
            skills.skillDamage = skillDamage;
            kirbySkills.add(skills);
        }

        protected void readSkills() {

            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

            // CCC - change i to skillItem so it's clear we are retrieving each skill object from kirbySkills
            for (int skillItem = 0; skillItem < kirbySkills.size(); skillItem ++) {
                int currentSkill = skillItem + 1;
                System.out.println("Skill number " + currentSkill + ": ");
                System.out.println("    - Skill Description: " + kirbySkills.get(skillItem).skillDescription);
                System.out.println("    - Skill Damage: " + kirbySkills.get(skillItem).skillDamage + "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            }
        }

        protected ArrayList<Skills> readSkillsList() {      // getter method for reading skillsList
            return kirbySkills;
        }

        protected void deleteSkill() throws InterruptedException {      // throw exception for Thread.sleep
            System.out.println("*You carefully choose which skill to lose*");
            Thread.sleep(2000);
            System.out.println("Hopefully you do not need this skill to defeat the magic mirror...");
            Thread.sleep(2000);
            System.out.println("What is the skill number?");
            int skillNumber = sc.nextInt();
            kirbySkills.remove(skillNumber - 1);
            Thread.sleep(1000);
            System.out.println("*You feel yourself slightly weaken as you successfully drop the skill*");
            Thread.sleep(1000);     // wait before displaying user menu
        }
    }

    public static class Kirby  extends Skills implements Serializable {

        private String username;
        private double health;
        private String offense;
        private String defense;

        Kirby(String username) {
            this.health = 100;      // Predefined health
            this.username = username;
        }

        protected void writeToFile() throws IOException {
            try {
//                File myFile = new File("kirbyInfo.txt");
//                if (myFile.createNewFile()) {
//                    System.out.println("Created new game file " + myFile.getName());
//                } else {
//                    System.out.println("The file " + myFile.getName() + " already exists. You're info was written to this game file.");
//                }

                FileWriter writer = new FileWriter("kirbyInfo.txt");
                try (FileOutputStream f = new FileOutputStream("kirbyInfo.txt");
                    ObjectOutput s = new ObjectOutputStream(f)) {
                    s.writeObject(this);
                }


                // write to kirby file TODO -- this is trying to write to file as individual lines
//                FileWriter writer = new FileWriter("kirbyInfo.txt");
//                writer.write(
//                        "USERNAME\n" + this.username + "\n" +
//                        "DEFENSE\n" + this.defense + "\n" +
//                        "OFFENSE\n" + this.offense + "\n" +
//                        "HEALTH\n" + this.health + "\n" +
//                        "SKILLS\n" + this.fullSkillsList + "\n" +
//                        "FOODS\n" + this.readFoodsList());
//                writer.close();
//                System.out.println("Game successfully saved!");

            } catch (IOException error) {
                error.printStackTrace();
            }

            System.out.println("******* read");
        }

        protected void readFile() throws IOException {
            System.out.println("KIRBY READ STATS");
            try(FileInputStream in = new FileInputStream("kirbyInfo.txt");
                ObjectInputStream s = new ObjectInputStream(in)) {
                System.out.println(s.readObject());

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        @Override
        public String toString() {
            ArrayList<Skills> skillsList = this.readSkillsList();
            ArrayList<Foods> foodsList = this.readFoodsList();

            // Evaluate Kirby's total defense and offense based on skills/healing items equipped
            int totalDamage = 0;
            int totalHeal = 0;

            // CCC - changed i to skillItem like the previous for loop. Makes it easy to understand this loop retrieces each object in foodsList.
            for (int skillItem = 0; skillItem < skillsList.size(); skillItem ++) {
                totalDamage += skillsList.get(skillItem).skillDamage;
            }

            // CCC - changed j to foodItem like the previous for loop. Makes it easy to understand this loop retrieces each object in foodsList.
            for (int foodItem = 0; foodItem < foodsList.size(); foodItem ++) {
                totalHeal += foodsList.get(foodItem).healAmount;
            }

            if (totalDamage < 50) {
                this.offense = "weak";
            }
            else if (totalDamage < 200) {
                this.offense = "novice";
            }
            else {
                this.offense = "all powerful boss";
            }

            if (totalHeal < 50) {
                this.defense = "weak";
            }
            else if (totalHeal < 200) {
                this.defense = "novice";
            }
            else {
                this.defense = "all powerful boss";
            }

            // read Kirby's stats
            return ("CurrentStats\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" +
                    "username: " + this.username + "\t|\thealth: " + this.health +
                    "\nKirby has " + skillsList.size() + " powerful skill(s)\n" +
                    "Kirby has " + foodsList.size() + " yummy food(s) equipped\n" +
                    "Offense level " + this.offense + "\t|\tDefense level " + this.defense + "\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
    }

    public static class GraphicsOptions {

        public void createTitle() {
            BufferedImage image = new BufferedImage(320, 32, BufferedImage.TYPE_INT_RGB);       // set to a very long title
            Graphics g = image.getGraphics();       // any graphics will be displayed on this object
            g.setFont(new Font("Dialog", Font.PLAIN, 15));
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,     // smooth jagged edges with rendering options
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            graphics.drawString("Welcome to Kirby!", 6, 24);

            for (int y = 0; y < 32; y++) {
                StringBuilder sb = new StringBuilder();

                for (int x = 0; x < 144; x++)
                    sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");        // there are 16777216 possible chars and set the formatting for ASCII drawings
                if (sb.toString().trim().isEmpty()) continue;
                System.out.println(sb.toString());
            }
        }

        public void printKirbyASCII() {
            // print line by line since there aren't multiple frames to print. Wait before printing in main
            System.out.println("              @@@@@@@@@.....            ");
            System.out.println("         @,,,,,@,,,,,,,,,,,,,,*@        ");
            System.out.println("       /,,,,,,,,,,#*,,,,,,,,,,,,@.      ");
            System.out.println("      /*,,,,,,,,,@ @,,,,,,,,,,,,,@..    ");
            System.out.println("      /@,,,,,,,,##@,,,,&@@#,,,,,,@..    ");
            System.out.println("       @,,////,,,,,,,,,,,,////,,,,,@... ");
            System.out.println("    ####%*#%#@,,,,,///%,,,,,,,,,,,,,,,# ");
            System.out.println("   #&&&&&&&####%,,,,,,,,,,,,,,,,,,,,,/@ ");
            System.out.println("   &&&&&&&&&&%##%@,,,,,,,,,,,,@////(@   ");
            System.out.println("   @&&&&&&&&&&&%#@,,,,,,,,,,//*&##@     ");
            System.out.println("     @&&&&&&&&&##(////////*@#######@    ");
            System.out.println("       &@&&&&&&@.......@&&&########%    ");
            System.out.println("...... .       ............@@&&&&%@     ");
            System.out.println("..........     ......  .............    ");
        }

        public void createLoadingBar() throws InterruptedException {
            System.out.println("/");
            Thread.sleep(1000);
            System.out.println("-");
            Thread.sleep(1000);
            System.out.println("\\");
            Thread.sleep(1000);
            System.out.println("|");
            Thread.sleep(1000);
            System.out.println("Skill obtained!");
            Thread.sleep(500);
        }

        public void kirbyFoodAnimation() throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader("kirbyEatFood.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    if (line.equals("Break")) {
                        Thread.sleep(1000);     // wait between each frame
                        System.out.println(sb.toString());
                        sb.setLength(0);        // clear StringBuilder before printing next frame
                        line = br.readLine();
                    } else {
                        sb.append(line);
                        sb.append(System.lineSeparator());
                        line = br.readLine();
                    }
                }
            } catch (InterruptedException | IOException error) {      // CCC - rename e to error so its less ambiguous
                error.printStackTrace();        // catch any exceptions thrown by Thread.sleep and file opening/closing
            }
        }
    }



    public static void main(String[] args) throws IOException, InterruptedException {        // throw necessary if Thread.sleep fails of retrieving from the file fails

        /* CCC - change any graphics to being performed within the graphics class.
        This was done so it is clear where all graphics are located. Graphics is in its own class so main
        is simplified to only the core menu components
        */
        // create title
        GraphicsOptions graphics = new GraphicsOptions();
        graphics.createTitle();

        Thread.sleep(2000);

        graphics.printKirbyASCII();

        // MARK -- end of intro with title and create object
        // Begin by creating user then enter forever loop of creating skills/equipping food

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Kirby! Are you ready to embark on a great quest to defeat the magic mirror?\n<hit enter to continue>");
        sc.nextLine();
        System.out.println("What will you name your powerful Kirby fighter?");
        String username = sc.next();

        // initialize Kirby with username
        Kirby mainKirby = new Kirby(username);      // CCC - rename a to mainKirby instead of a so the main object we are dealing with is less ambiguous
        System.out.println(mainKirby);
        while (true) {
            System.out.println("What would you like to do?\n" +
                    "1 - Learn a new skill\t | " +
                    "2 - Equip a new food\t | " +
                    "3 - Read skills\t | " +
                    "4 - Read foods equipped\t | " +
                    "5 - Unequip Skill\t | " +
                    "6 - Unequip Food\t | " +
                    "7 - Save game\t | " +
                    "8 - Load previous game\t | " +
                    "9 - Exit program");
            int userInputChoice = sc.nextInt();

            switch (userInputChoice) {
                case 1:
                    System.out.println("Great choice! You must be ready to fight the magic mirror at any time!!");
                    System.out.println("1 - Create your own skill\t|\t" +
                            "2 - Create default skill");
                    int optionInput = sc.nextInt();


                    if (optionInput == 1) {
                        System.out.println("What is a description of this great power you are about to obtain?");
                        String skillDescriptionInput = sc.next();

                        System.out.println("How much damage does this skill do?:\nEnter a number: ");
                        double skillDamageInput = sc.nextDouble();
                        mainKirby.createSkill(skillDescriptionInput, skillDamageInput);
                    } else {
                        mainKirby.createDefaultSkill();
                    }

                    System.out.println("*You feel your Kirby powers strengthen as you steal the power of a magical beast*");

                    graphics.createLoadingBar();        // CCC - loading bar moved to GraphicsOptions class to simplify code
                    System.out.println(mainKirby);

                    Thread.sleep(2000);
                    break;

                case 2:
                    System.out.println("Good job " + mainKirby.username + ", you must be able to heal up when fighting the final boss!" +
                            "\n1 - Create your own food\t|\t" +
                            "2 - Create default food");
                    optionInput = sc.nextInt();

                    if (optionInput == 1) {
                        System.out.println("What's the name of your magical food?");
                        String foodNameInput = sc.next();

                        System.out.println("How much does your food heal?\nEnter a number:");
                        double healAmountInput = sc.nextInt();

                        mainKirby.createFood(foodNameInput, healAmountInput);
                    } else {
                        mainKirby.createDefaultFood();
                    }

                    System.out.println("*Currently inhaling food*");

                    // MARK -- display Kirby ASCII animations from txt file
                    // utilized txt file in order to effectively pull images in the least # of lines
                    // placed retrieving method for reading file in main rather than Foods so Foods focuses on modifying objects while any
                    // additional formatting for the user is performed on the main class
                    graphics.kirbyFoodAnimation();        // will print ASCII animation. CCC - changed so printing from the text file is a separate method
                    System.out.println("Food obtained!");
                    Thread.sleep(500);
                    System.out.println(mainKirby);
                    Thread.sleep(2000);     // wait before displaying menu

                    break;
                case 3:
                    mainKirby.readSkills();
                    break;
                case 4:
                    mainKirby.readFoods();
                    break;
                case 5:
                    mainKirby.deleteSkill();
                    break;
                case 6:
                    mainKirby.deleteFood();
                    break;
                case 7:
                    mainKirby.writeToFile();
                    break;
                case 8:
                    mainKirby.readFile();
                case 9:
                    System.out.println(mainKirby);
                    break;
            }
        }
    }
}


