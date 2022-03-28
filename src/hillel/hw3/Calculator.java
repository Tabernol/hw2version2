package hillel.hw3;

import java.util.Scanner;

public class Calculator {
    String str;
    char[] array;
    int index;

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.runCalculator();
    }

    public void runCalculator() {
        boolean b = true;
        System.out.println("Hello in my calculator" + "\n" + " input format : X operation Y");
        while (b) {
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();
            if (str.equalsIgnoreCase("exit")) {
                break;
            }
            calculate(str);
        }
    }

    public int findFirstNumber() {
        String first = "";
        for (int i = 0; i < index; i++) {
            first = first.concat(String.valueOf(str.charAt(i)));
        }
        try {
            Integer.parseInt(first);
        } catch (NumberFormatException e) {
            System.out.println("no correct input");
            runCalculator();
        }
        return Integer.parseInt(first);
    }

    public int findSecondNumber() {
        String second = "";
        for (int i = index + 1; i < str.length(); i++) {
            second = second.concat(String.valueOf(str.charAt(i)));
        }
        try {
            Integer.parseInt(second);
        } catch (NumberFormatException e) {
            System.out.println("no correct input");
            runCalculator();
        }
        return Integer.parseInt(second);
    }

    public void calculate(String s) {
        array = new char[s.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = str.charAt(i);
        }
        int rezult = 0;
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case ('+'):
                    index = i;
                    rezult = Math.addExact(findFirstNumber(), findSecondNumber());
                    break;
                case ('-'):
                    index = i;
                    rezult = Math.subtractExact(findFirstNumber(), findSecondNumber());
                    break;
                case ('/'):
                    index = i;
                    rezult = Math.floorDiv(findFirstNumber(), findSecondNumber());
                    break;
                case ('*'):
                    index = i;
                    rezult = Math.multiplyExact(findFirstNumber(), findSecondNumber());
                    break;
            }
        }
        System.out.println(rezult);
    }
}

