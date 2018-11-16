package be.freware.testjes.java10switch;

public class Main {

    public static void main(String[] args) {
        switch (args.length) {
            case 0:
                System.out.println("Geef me een weekdag!");
                break;
            case 1:
                try {
                    System.out.println("Aantal letters in de weekdag: " + aantalLetters(args[0]));
                } catch (IllegalArgumentException rethrown) {
                    System.out.println("Ik ken enkel de weekdagen uit de methode...");
                    throw rethrown;
                }
                break;
            default:
                System.out.println("Ik kan maar één ding tegelijk...");
        }
    }

    private static int aantalLetters(String potentieleWeekDag) {
        int result = switch (WeekDag.valueOf(potentieleWeekDag.toUpperCase())) {
            case ZONDAG -> 6;
            case MAANDAG, DINSDAG, VRIJDAG -> 7;
            case WOENSDAG, ZATERDAG -> 8;
            case DONDERDAG -> 9;
        }

        return result;
    }

    public static enum WeekDag {
        MAANDAG, DINSDAG, WOENSDAG, DONDERDAG, VRIJDAG, ZATERDAG, ZONDAG
    }
}
