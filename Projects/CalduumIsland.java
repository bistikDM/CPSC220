import java.util.Scanner;

public class CalduumIsland
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean endTurn = false;
        int selection;
        int character;
        int pop;
        int land;
        int food;
        int win;
        int buy = 0;
        int sell = 0;
        int plant = 0;
        int feed = 0;
        
        System.out.println("Select your Star Wars character.");
        System.out.print("(1)Princess Leia, (2)Han Solo, (3) Luke Skywalker: ");
        character = in.nextInt();
        while (character > 3)
        {
            System.out.println("Invalid selection!");
            System.out.println("Select your Star Wars character.");
            System.out.print("(1)Princess Leia, (2)Han Solo, (3) Luke Skywalker: ");
            character = in.nextInt();
        }
        System.out.print("Would you like to play with the (1)default values or (2)custom values?");
        selection = in.nextInt();
        
        if (selection == 1)
        {
            EndorSmints game = new EndorSmints();
            game.player(character);
            game.intro();
            while (game.currentTurn() < game.finalTurn() && game.ewokPop() >= game.loseCond())
            {
                game.simulateYear(buy, sell, plant, feed);
                System.out.print("Do you wish to (1)buy or (2)sell land? ");
                selection = in.nextInt();
                if (selection == 1)
                {
                    System.out.print("How many acres do you wish to buy? ");
                    buy = in.nextInt();
                    sell = 0;
                    if (buy * game.landPrice > game.smintsOwned())
                    {
                        boolean check = false;
                        while (check == false)
                        {
                            System.out.println("You don't have enough smints!");
                            System.out.print("How many acres do you wish to buy? ");
                            buy = in.nextInt();
                            if (buy * game.landPrice <= game.smintsOwned())
                                check = true;
                        }
                    }
                }
                else
                {
                    System.out.print("How many acres do you wish to sell? ");
                    sell = in.nextInt();
                    buy = 0;
                    if (sell > game.landOwned())
                    {
                        boolean check = false;
                        while (check == false)
                        {
                            System.out.println("You don't have enough land to sell!");
                            System.out.print("How many acres do you wish to sell?");
                            sell = in.nextInt();
                            if (sell >= game.landOwned())
                                check = true;
                        }
                    }
                }
                
                System.out.print("How many acres do you wish to plant with smints? ");
                plant = in.nextInt();
                if (plant * 2 > game.smintsOwned())
                {
                    boolean check = false;
                    while (check == false)
                    {
                        System.out.println("You don't have enough smints!");
                        System.out.print("How many acres do you wish to plant with smints? ");
                        plant = in.nextInt();
                        if (plant * 2 <= game.smintsOwned())
                            check = true;
                    }
                }
                else if (plant > game.landOwned())
                {
                    boolean check = false;
                    while (check == false)
                    {
                        System.out.println("You don't have enough land!");
                        System.out.print("How many acres do you wish to plant with smints? ");
                        plant = in.nextInt();
                        if (plant < game.landOwned())
                            check = true;
                    }
                }
                
                System.out.print("How many bushels of smints do you wish to feed your Ewoks? ");
                feed = in.nextInt();
                if (feed > game.smintsOwned())
                {
                    boolean check = false;
                    while (check == false)
                    {
                        System.out.println("You dont have enough smints!");
                        System.out.print("How many bushels of smints do you wish to feed your Ewoks? ");
                        feed = in.nextInt();
                        if (feed <= game.smintsOwned())
                            check = true;
                    }
                }
                game.turnIncrement();
            }
            
            if (game.currentTurn() > game.finalTurn() && game.ewokPop() > game.loseCond())
                System.out.println("Congratulations on surviving on Calduum Island for "
                        + game.currentTurn() + " years! You have proven to be a wise leader and "
                        + "now the Millenium Falcon has returned from the Hapsacean Galaxy to rescue you.");
            else
                System.out.println("You only survived for " + game.currentTurn() + " years on Calduum "
                        + "Island before you were eaten by womp rats...");
        }
        else
        {
            System.out.println("Please enter the customized values");
            System.out.print("Ewok population: ");
            pop = in.nextInt();
            System.out.print("Initial land size: ");
            land = in.nextInt();
            System.out.print("Initial smins in storage: ");
            food = in.nextInt();
            System.out.print("Winning turn: ");
            win = in.nextInt();
            EndorSmints game = new EndorSmints(pop, land, food, win);
            game.player(character);
            game.intro();
            while (game.currentTurn() < game.finalTurn() && game.ewokPop() >= game.loseCond())
            {
                game.simulateYear(buy, sell, plant, feed);
                System.out.print("Do you wish to (1)buy or (2)sell land? ");
                selection = in.nextInt();
                if (selection == 1)
                {
                    System.out.print("How many acres do you wish to buy? ");
                    buy = in.nextInt();
                    sell = 0;
                    if (buy * game.landPrice > game.smintsOwned())
                    {
                        boolean check = false;
                        while (check == false)
                        {
                            System.out.println("You don't have enough smints!");
                            System.out.print("How many acres do you wish to buy? ");
                            buy = in.nextInt();
                            if (buy * game.landPrice <= game.smintsOwned())
                                check = true;
                        }
                    }
                }
                else
                {
                    System.out.print("How many acres do you wish to sell? ");
                    sell = in.nextInt();
                    buy = 0;
                    if (sell > game.landOwned())
                    {
                        boolean check = false;
                        while (check == false)
                        {
                            System.out.println("You don't have enough land to sell!");
                            System.out.print("How many acres do you wish to sell?");
                            sell = in.nextInt();
                            if (sell >= game.landOwned())
                                check = true;
                        }
                    }
                }
                
                System.out.print("How many acres do you wish to plant with smints? ");
                plant = in.nextInt();
                if (plant * 2 > game.smintsOwned())
                {
                    boolean check = false;
                    while (check == false)
                    {
                        System.out.println("You don't have enough smints!");
                        System.out.print("How many acres do you wish to plant with smints? ");
                        plant = in.nextInt();
                        if (plant * 2 <= game.smintsOwned())
                            check = true;
                    }
                }
                else if (plant > game.landOwned())
                {
                    boolean check = false;
                    while (check == false)
                    {
                        System.out.println("You don't have enough land!");
                        System.out.print("How many acres do you wish to plant with smints? ");
                        plant = in.nextInt();
                        if (plant < game.landOwned())
                            check = true;
                    }
                }
                
                System.out.print("How many bushels of smints do you wish to feed your Ewoks? ");
                feed = in.nextInt();
                if (feed > game.smintsOwned())
                {
                    boolean check = false;
                    while (check == false)
                    {
                        System.out.println("You dont have enough smints!");
                        System.out.print("How many bushels of smints do you wish to feed your Ewoks? ");
                        feed = in.nextInt();
                        if (feed <= game.smintsOwned())
                            check = true;
                    }
                }
                game.turnIncrement();
            }
            
            if (game.currentTurn() > game.finalTurn() && game.ewokPop() > game.loseCond())
                System.out.println("Congratulations on surviving on Calduum Island for "
                        + game.currentTurn() + " years! You have proven to be a wise leader and "
                        + "now the Millenium Falcon has returned from the Hapsacean Galaxy to rescue you.");
            else
                System.out.println("You only survived for " + game.currentTurn() + " years on Calduum "
                        + "Island before you were eaten by womp rats...");
        }
    }
}