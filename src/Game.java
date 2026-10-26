import java.util.Scanner;

public class Game{
  // One Scanner for the whole game, so typed input never gets lost between prompts
  private static final Scanner sc = new Scanner(System.in);
  // Run with "java Game fast" to skip the pauses (handy for testing)
  private static boolean fast = false;

   public static void main(String[] args){
       if (args.length > 0 && args[0].equalsIgnoreCase("fast")){
           fast = true;
       }
       printNWait("Welcome to Wyatville!");
       printNWait("Explore the land, battle monsters, find treasure, and track down the Dragon in its lair.");
       System.out.println();
       Player player = new Player();
       int area = 1;
       while (!player.isDead()){
           System.out.println();
           printNWait("----- Area " + area + " -----");
           Location location = new Location();
           printNWait("You arrive at the " + location.getTerrain() + ".");
           // Traveling lets you catch your breath a little
           if (area > 1 && player.getCurrHealth() < player.getMaxHealth()){
               player.addCurrHealth(1);
               printNWait("You catch your breath on the way here (+1 health).");
           }
           boolean somethingHere = false;

           Enemy enemy = location.getEnemy();
           String result = "";
           if (enemy != null){
               somethingHere = true;
               result = fight(player, enemy);
               if (result.equals("lost")){
                   break;
               }
               if (result.equals("won") && location.getTerrain().equals("Dragon's Lair")){
                   printNWait("The Dragon crashes to the ground. Wyatville is safe!");
                   printNWait("Congratulations, " + player.getName() + ", you beat the game!");
                   printNWait(player.getStats());
                   return;
               }
           }

           Treasure treasure = location.getTreasure();
           if (treasure != null && !result.equals("fled")){
               somethingHere = true;
               openTreasure(player, treasure);
           }

           Shop shop = location.getShop();
           if (shop != null){
               somethingHere = true;
               printNWait("There's a shop here. Would you like to go in? (yes/no)");
               if (getYesOrNoResponse(5).equals("yes")){
                   Shop.useShop(player, shop);
               }
           }

           // Towns have an inn where you can rest back to full health for free
           if (location.getTerrain().equals("Town") && player.getCurrHealth() < player.getMaxHealth()){
               printNWait("There's an inn in town. Would you like to rest for the night? (yes/no)");
               if (getYesOrNoResponse(5).equals("yes")){
                   player.addCurrHealth(player.getMaxHealth());
                   printNWait("You wake up feeling refreshed. Health fully restored!");
               }
           }

           if (!somethingHere){
               printNWait("It's quiet here. Nothing to see but the " + location.getTerrain() + ".");
           }

           printNWait(player.getStats());
           printNWait("Keep exploring? (yes/no)");
           if (getYesOrNoResponse(5).equals("no")){
               printNWait("You head home to rest. Thanks for playing Wyatville!");
               return;
           }
           area++;
       }
       printNWait("You have fallen in battle. GAME OVER.");
       printNWait("You made it through " + area + " areas.");
   }

   // Turn-based fight. Returns "won", "fled", or "lost"
   public static String fight(Player player, Enemy enemy){
       int reward = enemy.getHealth();
       printNWait("A " + enemy.getName() + " appears! (Health: " + enemy.getHealth() + ", Damage: " + enemy.getDamage() + ")");
       while (true){
           printNWait("Do you want to attack or run?");
           String choice = getSpecificResponse("attack", "run", 5);
           if (choice.equals("run")){
               if (Math.random() < 0.7){
                   printNWait("You got away!");
                   return "fled";
               }
               printNWait("You tried to run, but the " + enemy.getName() + " blocks your path!");
           }
           else {
               enemy.subtractHealth(player.getDamage());
               printNWait("You hit the " + enemy.getName() + " for " + player.getDamage() + " damage.");
               if (enemy.isDead()){
                   printNWait("You defeated the " + enemy.getName() + " and found " + reward + " coins!");
                   player.addCoins(reward);
                   // Every win toughens you up a little
                   player.addMaxHealth(1);
                   printNWait("The battle made you tougher! Max Health +1.");
                   return "won";
               }
               printNWait("The " + enemy.getName() + " has " + enemy.getHealth() + " health left.");
           }
           player.takeDamage(enemy.getDamage());
           printNWait("The " + enemy.getName() + " hits you for " + enemy.getDamage() + " damage. You have " + Math.max(player.getCurrHealth(), 0) + " health left.");
           if (player.isDead()){
               return "lost";
           }
       }
   }

   public static void openTreasure(Player player, Treasure treasure){
       printNWait("You found a treasure chest!");
       player.addCoins(treasure.getCoins());
       printNWait("Inside are " + treasure.getCoins() + " coins.");
       Equipment equip = treasure.getEquip();
       if (equip != null){
           printNWait("There's also something else in here...");
           System.out.println(equip);
           Shop.incrementPlayer(equip, player);
           printNWait("You equip the " + equip.getName() + ".");
       }
   }

   public static void wait(int x){
       if (fast){
           return;
       }
       try {
           Thread.sleep(x*1000);
       }
       catch (InterruptedException e){
           return;
       }
   }

   // Pauses, then clears the terminal screen
   public static void clear(int x){
       wait(x);
       System.out.print("\033[H\033[2J");
       System.out.flush();
   }

   // Prints a line, then pauses long enough to read it
   public static void printNWait(String str){
       System.out.println(str);
       if (fast){
           return;
       }
       try {
           Thread.sleep(str.length()*40);
       }
       catch (InterruptedException e){
           return;
       }
   }

   // Reads one line, or quits cleanly if the input runs out
   private static String readLine(){
       if (!sc.hasNextLine()){
           System.out.println();
           System.out.println("Goodbye!");
           System.exit(0);
       }
       return sc.nextLine().trim();
   }

   public static String getStringResponse(){
       return readLine();
  }

  public static int getIntResponse(){
       try {
           return Integer.parseInt(readLine());
       }
       catch (NumberFormatException e){
           return -1;
       }
  }

  public static int getSpecificIntResponse(int min, int max, int numTimes){
       if (min == max){
            return min;
       }
       if (numTimes <= 0){
           return -1;
       }
       int next = getIntResponse();
       if (next >= min && next <= max){
           return next;
       }
       else{
           System.out.println("Sorry I didn't get that. Can you type it again (Use a number from " + min + " to " + max + "):");
           return getSpecificIntResponse(min, max, numTimes-1);
       }
  }

   public static String getYesOrNoResponse(int numTimes){
       return getSpecificResponse("yes", "no", numTimes);
  }

   public static String getSpecificResponse(String str1, String str2, String str3, int numTimes){
       if (numTimes <= 0){
           return "";
       }
       String next = readLine().toLowerCase();
       if (next.equals(str1.toLowerCase()) || next.equals(str2.toLowerCase()) || next.equals(str3.toLowerCase())){
           return next;
       }
       else{
           System.out.println("Sorry I didn't get that. Can you type it again (Use only '" + str1 + "', '" + str2 + "' or '" + str3 + "'):");
           return getSpecificResponse(str1, str2, str3, numTimes-1);
       }
  }

   public static String getSpecificResponse(String str1, String str2, int numTimes){
       if (numTimes <= 0){
           return "";
       }
       String next = readLine().toLowerCase();
       if (next.equals(str1.toLowerCase()) || next.equals(str2.toLowerCase())){
           return next;
       }
       else{
           System.out.println("Sorry I didn't get that. Can you type it again (Use only '" + str1 + "' or '" + str2 + "'):");
           return getSpecificResponse(str1, str2, numTimes-1);
       }
  }


  public static String getSpecificResponse(String str1, int numTimes){
       if (numTimes <= 0){
           return "";
       }
       String next = readLine().toLowerCase();
       if (next.equals(str1.toLowerCase())){
           return next;
       }
       else{
           System.out.println("Sorry I didn't get that. Can you type it again (Use only '" + str1 + "'):");
           return getSpecificResponse(str1, numTimes-1);
       }
  }
}
