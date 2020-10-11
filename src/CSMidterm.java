import java.util.ArrayList;
import java.util.Scanner;

public class CSMidterm {

    public static class Skills {
        public String skillDescription;
        public int skillDamage;
    }

    public static class Kirby extends Skills {

        public String username;
        public int health;

        public String type;
        static ArrayList<Kirby> kirbyCharacters = new ArrayList<Kirby>();


        Kirby(String username) {
            this.health = 100;
            this.username = username;
//            this.skillDecription = skillDescription;
//            this.skillDamage = skillDamage;
            kirbyCharacters.add(this);
        }

//        Kirby(String skillDescription, int skillDamage) {
//            this.skillDescription = skillDescription;
//            this.skillDamage = skillDamage;
//            kirbyCharacters.add(this);
//        }

        public void readInstances() {

            for (int i = 0; i < kirbyCharacters.size(); i ++) {
                // TODO: change to read from current Kirby character
                System.out.println("username: " + kirbyCharacters.get(i).username);
                System.out.println("character damage: " + kirbyCharacters.get(i).skillDamage);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to create a Kirby!\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n" +
                    "What is your username?\n" +
                    "Enter name: ");

            String username = sc.next();
            Kirby a = new Kirby(username);

            System.out.println("What skill type will your Kirby have?\n" +
                    "1 - Bomb\n" +
                    "2 - Magical\n" +
                    "3 - Ice\n" +
                    "Number input 1-3: ");
            int userInputType = sc.nextInt();
            switch (userInputType) {
                case 1:
                    a.type = "Bomb";
                    break;
                case 2:
                    a.type = "Magical";
                    break;
                case 3:
                    a.type = "Ice";
                    break;
            }

            a.readInstances();
        }


    }
}
