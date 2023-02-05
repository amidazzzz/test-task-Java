import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression:");
        String input = sc.nextLine();
        System.out.println("Result: " + calc(input));
    }

    public static String calc(String input) {
        String[] tokens = input.split(" ");
        int num1 = 0, num2 = 0;
        char operation = ' ';

        if (tokens[0].matches("[0-9]+")) {
            num1 = Integer.parseInt(tokens[0]);
        } else if (tokens[0].matches("[IVX]+")) {
            num1 = RomanNumeral.valueOf(tokens[0]).getValue();
        }

        if (tokens[2].matches("[0-9]+")) {
            num2 = Integer.parseInt(tokens[2]);
        } else if (tokens[2].matches("[IVX]+")) {
            num2 = RomanNumeral.valueOf(tokens[2]).getValue();
        }

        operation = tokens[1].charAt(0);
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        if (num1 >= 1 && num1 <= 10 && num2 >= 1 && num2 <= 10) {
            return Integer.toString(result);
        } else {
            return RomanNumeral.toRoman(result);
        }
    }

    private enum RomanNumeral {
        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10);

        private int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static String toRoman(int num) {
            StringBuilder result = new StringBuilder();
            for (RomanNumeral r : RomanNumeral.values()) {
                while (num >= r.value) {
                    result.append(r.name());
                    num -= r.value;
                }
            }
            return result.toString();
        }
    }
}