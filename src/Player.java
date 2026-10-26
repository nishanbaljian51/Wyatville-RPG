public class Player{
   private int maxHealth = 1;
   private int currHealth = 1;
   private int coins = 0;
   private int damage = 1;
   private String name = "";

   public Player (){
       System.out.print("Enter name: ");
       this.name = Game.getStringResponse();
       Game.clear(2);
       Game.printNWait("You will start with 10 attribute points.");
       Game.printNWait("You may divide these points however you choose between the following characteristics: Max Health and Damage.");
       Game.printNWait("Any remaining points will automatically be sold for 5 coins each (you begin the game with 0 coins, and 1 attribute point in each characteristic).");
       Game.printNWait("Type the number of points you would like to spend under each characteristic name.");
       String first = "";
       String second = "";
       int rand = (int)(Math.random()*2 +1);
       if (rand == 1){
            first = "Max Health";
            second = "Damage";
       }
       else {
            first = "Damage";
            second = "Max Health";
       }

       Game.printNWait("First up is " + first);
       int answer1 = Game.getSpecificIntResponse(0, 10, 5);
       if (answer1 == -1){
            Game.printNWait("Setting all stats to 1 and coins to 0.");
       }
       else {
            addStat(first, answer1);
            Game.printNWait("Stats recorded. You have " + (10-answer1) + " attribute points left to spend.");
            Game.printNWait("Last up is " + second);
            int answer2 = Game.getSpecificIntResponse(0, 10-answer1, 5);
            if (answer2 == -1){
                 answer2 = 0;
            }
            addStat(second, answer2);
            int leftover = 10 - answer1 - answer2;
            coins += leftover * 5;
            Game.printNWait("Stats recorded. Your " + leftover + " leftover points sold for " + (leftover*5) + " coins.");
       }
       currHealth = maxHealth;
       Game.printNWait(getStats());
   }

   private void addStat(String stat, int points){
       if (stat.equals("Max Health")){
           maxHealth += points;
       }
       else {
           damage += points;
       }
   }

   public String getName(){
       return name;
   }

   public int getCoins(){
       return coins;
   }

   public int getDamage(){
       return damage;
   }

   public int getCurrHealth(){
       return currHealth;
   }

   public int getMaxHealth(){
       return maxHealth;
   }

   public boolean isDead(){
       return currHealth <= 0;
   }

   public void addCoins(int coins){
       this.coins += coins;
   }

   public void loseCoins(int coins){
       this.coins -= coins;
   }

   public void addAttack(int damage){
       this.damage += damage;
   }

   // Shields raise max health and fill the new space too
   public void addMaxHealth(int health){
       this.maxHealth += health;
       this.currHealth += health;
   }

   // Potions heal, but never past max health
   public void addCurrHealth(int health){
       this.currHealth += health;
       if (currHealth > maxHealth){
           currHealth = maxHealth;
       }
   }

   public void takeDamage(int damage){
       this.currHealth -= damage;
   }

   public String getStats(){
       return name + " | Health: " + currHealth + "/" + maxHealth + " | Damage: " + damage + " | Coins: " + coins;
   }
}
