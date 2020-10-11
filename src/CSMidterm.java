import java.util.ArrayList;
import java.util.Scanner;

public class CSMidterm {

    public static class Skills {
        public String skillDescription;
        public int skillDamage;
    }

    public static class Kirby extends Skills {

        public String userName;
        static ArrayList<Kirby> kirbyCharacters = new ArrayList<Kirby>();


        Kirby(String userName) {
            this.userName = userName;
            this.skillDescription = skillDescription;
            this.skillDamage = skillDamage;
            kirbyCharacters.add(this);
        }

        Kirby(String skillDescription, int skillDamage) {
            this.skillDescription = skillDescription;
            this.skillDamage = skillDamage;
            kirbyCharacters.add(this);
        }

        public void readInstances() {

            for (int i = 0; i < kirbyCharacters.size(); i ++) {
                System.out.println("username: " + kirbyCharacters.get(i).userName);
                System.out.println("character damage: " + kirbyCharacters.get(i).skillDamage);
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to create a Kirby!\nWhat is your username?>");
            String userName = sc.next();
            Kirby a = new Kirby(userName);
            Kirby b = new Kirby("yumibyte");

            a.skillDamage = 20;
            a.skillDescription = "hi";

            b.skillDamage = 40;

            a.readInstances();
        }


    }
}
