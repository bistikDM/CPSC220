/**
 *
 * @author danie
 */
public class EndorSmints 
{
    String[] character = {"Princess Leia", "Han Solo", "Luke Skywalker"};
    int player;
    int ewokPop;
    int landOwned;
    int smintsOwned;
    int weather;
    int landPrice = 20;
    int currentTurn = 0;
    int loseCond = 52;
    int finalTurn = 10;
    
    /**
     * Constructs an object with default values outlined in the project description.
     */
    public EndorSmints()
    {
        ewokPop = 100;
        landOwned = 1000;
        smintsOwned = 3000;
    }
    
    /**
     * Constructs an object with customized values.
     * @param initPopulation Will set the initial population size.
     * If the initial size is less than or equal to 52, it will default to 53.
     * @param initAcre Will set the initial acre of land that the player owns.
     * @param initSmints Will set the initial bushels of smints that the player owns.
     * If the initial size is less than 20 * initPopulation, will default to 20 * initPopulation.
     * @param win Will set the winning condition, the final turn before the player wins.
     */
    public EndorSmints(int initPopulation, int initAcre, int initSmints, int win)
    {
        ewokPop = initPopulation;
        landOwned = initAcre;
        smintsOwned = initSmints;
        finalTurn = win;
        
        if (ewokPop <= 52)
        {
            System.out.println("The initial pupulation size cannot be less than 52! "
                    + "Defaulting to population size of 53.");
            ewokPop = 53;
        }
        
        if (smintsOwned < 20 * ewokPop)
        {
            System.out.println("The initial bushels of smints is not enough for the game! "
                    + "Defaulting to " + (20 * ewokPop) + "bushels of smints.");
            smintsOwned = 20 * ewokPop;
        }
    }
    
    /**
     * Prints the introductory story to the console via System.out.println().
     */
    public void intro()
    {
        System.out.println("~~~~~~~~~~");
        System.out.println("You are " + character[player] + ", and you recently parachuted onto "
                + "Calduum Island of the forest moon Endor. The Ewoks of Calduum Island elected you to "
                + "be their leader. You have to keep Calduum Island alive for 10 years, at which time the "
                + "Millenium Falcon will return and you will be reunited with your Star Wars friend. "
                + "You have to buy/sell land, direct smints farming, and dispense smints to the Ewoks. "
                + "Teeny-weeny meteor showers and womp rats affect your life on Calduum."
                + "The following will help you make decisions:");
        System.out.println("*Each Ewok needs at least 20 bushels of smints per year to survive.");
        System.out.println("*Each Ewok can farm at most 10 acres of land.");
        System.out.println("*It takes 2 bushels of smints to farm and acre of land.");
        System.out.println("*The market price for land fluctuates yearly");
        System.out.println("The initial values are the following:");
        System.out.println("*Population: " + ewokPop);
        System.out.println("*Acres owned: " + landOwned);
        System.out.println("Land value: " + landPrice);
        System.out.println("Smints in storage: " + smintsOwned);
        System.out.println("Rule wisely for " + finalTurn + " years and you will be reunited with "
                + "your friends. Rule poorly, the Ewoks will die, you will perish, and you "
                + "will never see your friend again.");
        System.out.println("~~~~~~~~~~");
    }
    
    /**
     * Calculate to see if a meteor shower will occur on a specific turn.
     * @return Returns true if shower will occur (11% chance).
     * Otherwise returns false if shower will not occur (89% chance).
     */
    public boolean meteorCheck()
    {
        int check = (int)(101 * Math.random());
        return check <= 11;
    }
    
    /**
     * Calculates the number of Ewoks lost to death (28%) and migration (9%).
     * Subtract the number of ewoks owned by the player with calculated number.
     * Displays informative text via System.out.println().
     */
    public void meteorShower()
    {
        int deadEwoks = ewokPop * (28 / 100);
        int migrated = ewokPop * (9 / 100);
        
        System.out.println("You were affected by a teeny-weeny meteor shower!");
        System.out.println("*Number of Ewoks that swam away from Calduum: " + migrated);
        System.out.println("*Number of Ewoks killed by the meteor shower: " + deadEwoks);
        ewokPop -= (deadEwoks + migrated);
    }
    
    /**
     * Calculates to see if a womp rat event will occur on a specific turn.
     * @return Returns true if the event will occur (46% chance).
     * Otherwise returns false if the event will not occur (54% chance).
     */
    public boolean ratCheck()
    {
        int check = (int)(101 * Math.random());
        return check <= 46;
    }
    
    /**
     * Calculates the percentage to be used to apply to the womp rat event (4-40%).
     * Subtract the number of smints owned by the player with the calculated number.
     * Displays informative text via System.out.println().
     */
    public void wompRat()
    {
        int destroyedSmints = (int)(smintsOwned * (((37 * Math.random()) + 4) / 100));
        
        System.out.println("Womp rats swam to your island!");
        System.out.println("Womp rates destroyed: " + destroyedSmints + " bushels of smints.");
        smintsOwned -= destroyedSmints;
    }
    
    /**
     * Calculates the value of smints gained per acre in each turn between 1 and 9.
     */
    public void harvest()
    {
        weather = (int)(9 * Math.random() + 1);
    }
    
    /**
     * Calculates the value of each acre of land in each turn between 17 and 26.
     */
    public void landValue()
    {
        landPrice = (int)(10 * Math.random() + 17);
    }
    
    /**
     * If no Ewoks died of starvation in a turn, adds a random amount of Ewoks into
     * the player's population.
     * @param starvedEwoks Checks to see if any Ewoks died of starvation.
     * @return If there are any Ewoks died of starvation, this method will return a value of 0.
     * Otherwise this method will return a calculated value based on the formula.
     */
    public int newEwoks(int starvedEwoks)
    {
        if (starvedEwoks > 0)
            return 0;
        else
            return (int)(((20 * landOwned + smintsOwned) / (100 * ewokPop) + 1) * Math.random());
    }
    
    /**
     * Simutes one year (one turn) in game.
     * @param acreBuy Used to calculate the number of acres bought and smints spent.
     * @param acreSell Used to calculate the number of acres sold and smints gained.
     * @param acrePlant Used to calculate the number of smints harvested from planted acres.
     * @param smintsFeed Used to calculate the amount of smints spent to feed the Ewoks.
     */
    public void simulateYear(int acreBuy, int acreSell, int acrePlant, int smintsFeed)
    {
        int hungryEwok = 0;
        int newEwok = 0;
        //Calls the harvest method() to randomize the weather this the current turn.
        harvest();
        landOwned += acreBuy;
        smintsOwned -= (acreBuy * landPrice);
        landOwned -= acreSell;
        smintsOwned += (acreBuy * landPrice);
        smintsOwned -= (acrePlant * 2);
        smintsOwned += (acrePlant * weather);
        
        /*
        Compares the smints owned by the player and smints to spend.
        If there is enough smints owned and the amount spent is at least equal to
        the amount needed, subtract smintsOwned by smintsFeed. Otherwise perform the step
        anyways but then calculate the amount of hungry Ewoks and subtract the population
        by the number of hungry Ewoks.
        */
        if (currentTurn > 0)
        {
            if (smintsOwned >= smintsFeed)
            {
                if (smintsFeed >= ewokPop * 20)
                    smintsOwned -= smintsFeed;
                else
                {
                    smintsOwned -= smintsFeed;
                    hungryEwok = ewokPop - (smintsFeed / 20);
                    ewokPop -= hungryEwok;
                }
            }
            else
            {
                smintsOwned = 0;
                hungryEwok = ewokPop - (smintsFeed / 20);
                ewokPop -= hungryEwok;
            }
        }
        
        if (currentTurn > 0 && smintsFeed == 0)
        {
            hungryEwok = ewokPop;
            ewokPop -= hungryEwok;
        }
        
        System.out.println("===========================");
        System.out.println(character[player] + ", you are leading Calduum Island in the "
                + "year " + (1000 + currentTurn) + ". The following events happened during the year "
                + (1000 + currentTurn) +":");
        System.out.println("*Starved to death: " + hungryEwok + " Ewoks.");
        if (currentTurn > 0)
            newEwok = newEwoks(hungryEwok);
        ewokPop += newEwok;
        System.out.println("*Swam to Caldum: " + newEwok + " Ewoks.");
        if (meteorCheck() == true && currentTurn > 0)
        {
            System.out.println("!!!!!!!!!!!!!!");
            meteorShower();
            System.out.println("!!!!!!!!!!!!!!");
        }
        if (ratCheck() == true && currentTurn > 0)
        {
            System.out.println("!!!!!!!!!!!!!!");
            wompRat();
            System.out.println("!!!!!!!!!!!!!!");
        }
        System.out.println("*Smints harvested: " + (acrePlant * weather) + " at "
                + weather + " bushels per acre.");
        System.out.println("At the end of the year " + (1000 + currentTurn) + ", Calduum "
                + "is characterized by:");
        System.out.println("*Population: " + ewokPop + " Ewoks.");
        System.out.println("*Land Owned: " + landOwned + " acres.");
        System.out.println("*Land value: " + landPrice + " bushels per acre.");
        System.out.println("*Smints in storage: " + smintsOwned + " bushels.");
        landValue();
        System.out.println("---------------------------------");
    }
    
    public int player()
    {
        return player;
    }
    
    public int ewokPop()
    {
        return ewokPop;
    }
    
    public int landOwned()
    {
        return landOwned;
    }
    
    public int smintsOwned()
    {
        return smintsOwned;
    }
    
    public int currentTurn()
    {
        return currentTurn;
    }
    
    public int finalTurn()
    {
        return finalTurn;
    }
    
    public int loseCond()
    {
        return loseCond;
    }
    
    public void player(int i)
    {
        player = i - 1;
    }
    
    public void turnIncrement()
    {
        currentTurn++;
    }
}