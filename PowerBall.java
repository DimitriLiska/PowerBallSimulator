package powerball;

import java.util.Scanner;

/**
 *
 * @author Dim
 */
public class PowerBall {

    public static final int PRICE_TICKET = 2;
    public static final int ZERO_WHITE_ONE_RED_PRIZE = 4;
    public static final int ONE_WHITE_ONE_RED_PRIZE = 4;
    public static final int TWO_WHITE_ONE_RED_PRIZE = 7;
    public static final int THREE_WHITE_ZERO_RED_PRIZE = 7;
    public static final int THREE_WHITE_ONE_RED_PRIZE = 100;
    public static final int FOUR_WHITE_ZERO_RED_PRIZE = 100;
    public static final int FOUR_WHITE_ONE_RED_PRIZE = 50000;
    public static final int FIVE_WHITE_ZERO_RED_PRIZE = 1000000;
    public static final int FIVE_WHITE_ONE_RED_PRIZE = 89000000;

    private static int numberOfTicketBought;
    private static double balance;
    private static double totalLoss;
    private static double totalWon;
    private static int totalTicketBought;
    private static boolean jackpotWon = false;

    private static final int[] WINNING_TICKET = new int[6];
    private static final int[] USER_TICKET = new int[6];
    private static final int[] ARRAY_TICKET = new int[6];
    private static int drawCounter;
    private static int ballDraw;
    private static int whiteBallCounter;
    private static int redBallCounter;

    public static void main(String[] args) {
        totalLoss = 0;
        totalWon = 0;
        totalTicketBought = 0;
        balance = 0;
        while (!jackpotWon) {
            howManyTicketToBuy();
            setWinningTicket();
    //        powerCheck();
            checkForWin();
            balanceCheck();
        }
        if (jackpotWon) {
        System.out.println("Congratulation you won the Jackpot");
        balanceCheck();
        }

//            resetWinningTicket();
    }

    public static void howManyTicketToBuy() {
        numberOfTicketBought = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("How many ticket wish you to buy?");
        numberOfTicketBought = scan.nextInt();
        totalTicketBought += numberOfTicketBought;
        balance += -(numberOfTicketBought * PRICE_TICKET);
        System.out.println("You bought " + numberOfTicketBought + " Lotterie ticket(s)");
    }

    public static void balanceCheck() {
        System.out.println("Your balance is now: " + balance + "$");
        System.out.println("");
        System.out.printf("You bought a total of: %d tickets\n", totalTicketBought);
        System.out.printf("Your total losses are: %,.2f$\n", totalLoss);
        System.out.printf("Your total win are   : %,.2f$\n", totalWon);
        System.out.printf("Your balance is now  : %,.2f$\n", balance);
        System.out.println("");

    }

    public static void checkForWin() {
        int i = 0;
        while (i < numberOfTicketBought) {
            redBallCounter = 0;
            whiteBallCounter = 0;
            setUserTicket();
            for (int x = 0; x < WINNING_TICKET.length; x++) {
                for (int y = 0; y < USER_TICKET.length; y++) {
                    if (x < 5 && y < 5 && USER_TICKET[y] == WINNING_TICKET[x]) {
                        whiteBallCounter++;
                    }
                    if (x == 5 && y == 5 && USER_TICKET[y] == WINNING_TICKET[x]) {

                        redBallCounter++;
                    }
                }
            }
            System.out.println("---------------------------");
            getWinningTicket();
            getUserTicket();
            System.out.println("\n" + whiteBallCounter + " white ball are the same");
            System.out.println(+redBallCounter + " red ball are the same");
            winAndLosses();
            i++;
        }
    }

    private static void TicketWhiteBallsDraw() {
        while (drawCounter < 5) {
            ballDraw = (int) (Math.random() * 69) + 1;
            for (int x = 0; x < drawCounter; x++) {
                if (ARRAY_TICKET[x] == ballDraw) {
                    ballDraw = (int) (Math.random() * 69) + 1;
                    x = -1;
                }
            }
            ARRAY_TICKET[drawCounter] = ballDraw;
            drawCounter++;
        }
    }

    private static void TicketRedBallDraw() {
        while (drawCounter < 6) {
            ballDraw = (int) (Math.random() * 26) + 1;
            ARRAY_TICKET[drawCounter] = ballDraw;
            drawCounter++;
        }
    }

    private static void setWinningTicket() {
        TicketWhiteBallsDraw();
        TicketRedBallDraw();
        for (int i = 0; i < ARRAY_TICKET.length; i++) {
            WINNING_TICKET[i] = ARRAY_TICKET[i];
        }
        drawCounter = 0;
    }

    private static void getWinningTicket() {

        System.out.print("Winning Ticket: ");
        for (int i = 0; i < ARRAY_TICKET.length; i++) {
            System.out.print(WINNING_TICKET[i] + " | ");
        }
    }

    private static void setUserTicket() {
        TicketWhiteBallsDraw();
        TicketRedBallDraw();
        for (int i = 0; i < ARRAY_TICKET.length; i++) {
            USER_TICKET[i] = ARRAY_TICKET[i];
        }
        drawCounter = 0;
    }

    private static void getUserTicket() {
        System.out.print("\nUser Ticket:    ");
        for (int i = 0; i < ARRAY_TICKET.length; i++) {
            System.out.print(USER_TICKET[i] + " | ");
        }
    }

    private static void winAndLosses() {
        if (redBallCounter == 0) {
            switch (whiteBallCounter) {
                case 0:
                    System.out.println("Nothing won!");
                    balance += 0;
                    totalLoss += PRICE_TICKET;
                    break;
                case 1:
                    System.out.println("Nothing won!");
                    balance += 0;
                    totalLoss += PRICE_TICKET;
                    break;
                case 2:
                    System.out.println("Nothing won!");
                    balance += 0;
                    totalLoss += PRICE_TICKET;
                    break;
                case 3:
                    System.out.println(THREE_WHITE_ZERO_RED_PRIZE + "$ won!");
                    balance += THREE_WHITE_ZERO_RED_PRIZE;
                    totalWon += THREE_WHITE_ZERO_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    break;
                case 4:
                    System.out.println(FOUR_WHITE_ZERO_RED_PRIZE + "$ won!");
                    balance += FOUR_WHITE_ZERO_RED_PRIZE;
                    totalWon += FOUR_WHITE_ZERO_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    break;
                case 5:
                    System.out.println(FIVE_WHITE_ZERO_RED_PRIZE + "$ won!");
                    balance += FIVE_WHITE_ZERO_RED_PRIZE;
                    totalWon += FIVE_WHITE_ZERO_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    break;
            }
        } else if (redBallCounter == 1) {
            switch (whiteBallCounter) {
                case 0:
                    System.out.println(ZERO_WHITE_ONE_RED_PRIZE + "$ won!");
                    balance += ZERO_WHITE_ONE_RED_PRIZE;
                    totalWon += ZERO_WHITE_ONE_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    break;
                case 1:
                    System.out.println(ONE_WHITE_ONE_RED_PRIZE + "$ won!");
                    balance += ONE_WHITE_ONE_RED_PRIZE;
                    totalWon += ONE_WHITE_ONE_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    break;
                case 2:
                    System.out.println(TWO_WHITE_ONE_RED_PRIZE + "$ won!");
                    balance += TWO_WHITE_ONE_RED_PRIZE;
                    totalWon += TWO_WHITE_ONE_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    break;
                case 3:
                    System.out.println(THREE_WHITE_ONE_RED_PRIZE + "$ won!");
                    balance += THREE_WHITE_ONE_RED_PRIZE;
                    totalWon += THREE_WHITE_ONE_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    break;
                case 4:
                    System.out.println(FOUR_WHITE_ONE_RED_PRIZE + "$ won!");
                    balance += FOUR_WHITE_ONE_RED_PRIZE;
                    totalWon += FOUR_WHITE_ONE_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    break;
                case 5:
                    System.out.println("Jackpot!!!!!!");
                    System.out.println(FIVE_WHITE_ONE_RED_PRIZE + "$ won!");
                    balance += FIVE_WHITE_ONE_RED_PRIZE;
                    totalWon += FIVE_WHITE_ONE_RED_PRIZE;
                    totalLoss += PRICE_TICKET;
                    balanceCheck();
                    jackpotWon = true;
                    break;
            }
        }
    }

//    private static void resetWinningTicket() {
//        for (int x = 0; x < WINNING_TICKET.length; x++) {
//            WINNING_TICKET[x] = 0;
//        }
//    }
//
//    private static void powerCheck() {
//        for (int x = 0; x < 5; x++) {
//            for (int y = 0; y < 5; y++) {
//                if (WINNING_TICKET[x] == WINNING_TICKET[y] && x != y && x != 5 && y != 5) {
//                    System.out.print("on a un doublon!!!!!! ");
//                    System.out.println(WINNING_TICKET[x] + " == " + WINNING_TICKET[y]);
//                    System.exit(1);
//                }
//            }
//            if (WINNING_TICKET[x] == 0) {
//                System.out.println("on a un 000000000!!!!!!");
//                System.exit(1);
//            }
//            if (x < 5 && WINNING_TICKET[x] > 69) {
//                System.out.println("on a un 70000000!!!!!!");
//                System.exit(1);
//            }
//            if (WINNING_TICKET[5] > 26) {
//                System.out.println("on a un 26666666!!!!!!");
//                System.exit(1);
//            }
//        }
//    }
}
