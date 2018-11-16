package be.freware.testjes.pre10switch;

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
        int result;

        switch (WeekDag.valueOf(potentieleWeekDag.toUpperCase())) {
            case ZONDAG:
                result = 6;
                break;

            case MAANDAG:
            case DINSDAG:
            case VRIJDAG:
                result = 7;
                break;

            case WOENSDAG:
            case ZATERDAG:
                result = 8;
                break;

            case DONDERDAG:
                result = 9;
                break;

            default:
                throw new IllegalArgumentException("Dit gebeurt er dus als een slimmerik dacht een weekdag bij te maken zonder deze methode aan te passen...");
        }

        return result;
    }

    public static enum WeekDag {
        MAANDAG, DINSDAG, WOENSDAG, DONDERDAG, VRIJDAG, ZATERDAG, ZONDAG
    }
}
