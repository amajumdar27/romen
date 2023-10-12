import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("welcome to my roman numeral converter!!");
            System.out.println();
            System.out.println("pick a choice!");
            System.out.println("1. convert int to roman");
            System.out.println("2. convert roman to int");
            System.out.println("3. check if it's a roman");
            System.out.println("4. quit!");
            System.out.print("enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("enter an int: ");
                    int num = scanner.nextInt();
                    scanner.nextLine(); 
                    if (num >= 1 && num <= 3999) {
                        String romanNumeral = intToRoman(num);
                        System.out.println("roman: " + romanNumeral);
                    } else {
                        System.out.println("invalid input.  enter an integer between 1 and 3999 pleasee.");
                    }
                    break;
                case 2:
                    System.out.print("enter a roman: ");
                    String romanInput = scanner.nextLine().toUpperCase();
                    if (isValidRomanNumeral(romanInput)) {
                        int integer = romanToInt(romanInput);
                        System.out.println("int: " + integer);
                    } else {
                        System.out.println("invalid roman.");
                    }
                    break;
                case 3:
                    System.out.print("enter roman to verify: ");
                    String romanToVerify = scanner.nextLine().toUpperCase();
                    if (isValidRomanNumeral(romanToVerify)) {
                        System.out.println("valid roman.");
                    } else {
                        System.out.println("invalid roman.");
                    }
                    break;
                case 4:
                    System.out.println("bye, thanks for playing!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid option. please enter a valid option.");
            }
        }
    }

    public static String intToRoman(int num) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romanNumerals[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    public static int romanToInt(String roman) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int result = 0;
        int i = 0;
        while (i < roman.length()) {
            for (int j = 0; j < romanNumerals.length; j++) {
                if (i + romanNumerals[j].length() <= roman.length() && roman.substring(i, i + romanNumerals[j].length()).equals(romanNumerals[j])) {
                    result += values[j];
                    i += romanNumerals[j].length();
                    break;
                }
            }
        }

        return result;
    }

    public static boolean isValidRomanNumeral(String roman) {
        return roman.matches("^[IVXLCDM]+$");
    }
}
