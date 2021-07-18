package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int money = 550;
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int dcups = 9;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        selectAction();
    }

    private static void selectAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
        switch (action) {
            case "buy":
                getBuying();
                break;
            case "fill":
                getFilling();
                break;
            case "take":
                getTakingMoney();
                break;
            case "remaining":
                printSupplies();
                break;
            case "exit":
                exitOnProgram();
                break;
        }
        selectAction();
    }

    private static void getBuying() {
        System.out.println("What do you want to buy? 1 - espresso, " +
                "2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scanner.next()) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                selectAction();
                break;
        }
    }

    private static void makeCoffee(int waterCur, int milkCur, int beansCur, int moneyCur) {
        if (water < waterCur) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkCur) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < beansCur) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (dcups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterCur;
            milk -= milkCur;
            beans -= beansCur;
            dcups -= 1;
            money += moneyCur;
        }
    }

    private static void getFilling() {
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addDCups = scanner.nextInt();
        water += addWater;
        milk += addMilk;
        beans += addBeans;
        dcups += addDCups;
    }

    private static void getTakingMoney() {
        System.out.printf("I gave you $%s%n", money);
        money = 0;
    }

    private static void printSupplies() {
        System.out.printf("The coffee machine has:%n" +
                "%s ml of water%n" +
                "%s ml of milk%n" +
                "%s g of coffee beans%n" +
                "%s disposable cups%n" +
                "$%s of money%n", water, milk, beans, dcups, money);
    }

    private static void exitOnProgram() {
        scanner.close();
        System.exit(0);
    }
}
