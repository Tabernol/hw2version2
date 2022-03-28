package hillel.hw3;

import java.util.Scanner;

public class Calculator {
    String expression;
    char[] array;
    int indexOfOperation;

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.runCalculator();
    }

    public void runCalculator() {
        boolean b = true;
        System.out.println("Hello in my calculator" + "\n" + "input format : X operation Y");
        while (b) {
            Scanner scanner = new Scanner(System.in);
            expression = scanner.nextLine();
            if (expression.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println(calculate());
        }
    }

    public int findFirstNumber() {
        String first = "";
        for (int i = 0; i < indexOfOperation; i++) {
            first = first.concat(String.valueOf(expression.charAt(i)));
        }
        return Integer.parseInt(first);
    }

    public int findSecondNumber() {
        String second = "";
        for (int i = indexOfOperation + 1; i < expression.length(); i++) {
            second = second.concat(String.valueOf(expression.charAt(i)));
        }
        try {
            Integer.parseInt(second);
        } catch (NumberFormatException e) {
            System.out.println("no correct input");
            runCalculator();
        }
        return Integer.parseInt(second);
    }

    public int calculate() {
        array = new char[expression.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = expression.charAt(i);
        }
        int rezult = 0;
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case ('+'):
                    indexOfOperation = i;
                    rezult = Math.addExact(findFirstNumber(), findSecondNumber());
                    break;
                case ('-'):
                    indexOfOperation = i;
                    rezult = Math.subtractExact(findFirstNumber(), findSecondNumber());
                    break;
                case ('/'):
                    indexOfOperation = i;
                    rezult = Math.floorDiv(findFirstNumber(), findSecondNumber());
                    break;
                case ('*'):
                    indexOfOperation = i;
                    rezult = Math.multiplyExact(findFirstNumber(), findSecondNumber());
                    break;
            }
        }
        return rezult;
    }
}

