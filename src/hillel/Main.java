package hillel;

import hillel.lesson4.*;

public class Main {

    public static void main(String[] args) {
        Car accord = new Car("ghj", 57, 2.5);
        accord.iWantToDrive(100);
        accord.iWantToDrive(150, 120);
        accord.fillTank(15);
        accord.showOdometer();
    }
}
