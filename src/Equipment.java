public class Equipment{
  private String name = "";
  private String type = "";
  private int cost = 0;
  private int modifier = 0;

  public Equipment(String name, String type, int cost, int modifier){
      this.name = name;
      this.type = type;
      this.cost = cost;
      this.modifier = modifier;
  }

  public String getName(){
      return name;
  }

  public int getCost(){
      return cost;
  }

   public int getModifier(){
      return modifier;
  }

   public String getType(){
      return type;
  }

  public String toString(){
      return "Type: " + type +
          "\nName: " + name +
          "\nModifier: " + modifier +
          "\nCost: " + cost;
  }

  public static Equipment chooseEquip(){
      int rand = (int)(Math.random() * 100 + 1);
      if (rand < 40){
          return chooseSword();
      }
      if (rand < 80){
          return chooseShield();
      }
      return choosePotion();
  }

  private static Equipment chooseSword(){
      int randDamage = (int)(Math.random() * 3 + 2);
      int randChance = (int)(Math.random() * 25 + 1);
      if (randChance == 25){
          Equipment sword = new Equipment("Dragontooth", "Sword", randDamage*5, randDamage);
          return sword;
      }
      if (randChance >= 22){
          Equipment sword = new Equipment("Super Sick Sword", "Sword", randDamage*5, randDamage);
          return sword;
      }
      if (randChance >= 16){
          Equipment sword = new Equipment("Sorta Sick Sword", "Sword", randDamage*5, randDamage);
          return sword;
      }
      if (randChance >= 9){
          Equipment sword = new Equipment("Rusty Pipe", "Sword", randDamage*5, randDamage);
          return sword;
      }
      Equipment sword = new Equipment("Old Butter Knife :(", "Sword", randDamage*5, randDamage);
      return sword;
  }

  private static Equipment chooseShield(){
      int randProtection = (int)(Math.random() * 3 + 1);
      int randChance = (int)(Math.random() * 25 + 1);
      if (randChance == 25){
          Equipment shield = new Equipment("Dragonscale", "Shield", randProtection*5, randProtection);
          return shield;
      }
      if (randChance >= 22){
          Equipment shield = new Equipment("Very Cool Shield", "Shield", randProtection*5, randProtection);
          return shield;
      }
      if (randChance >= 16){
          Equipment shield = new Equipment("Kinda Cool Shield", "Shield", randProtection*5, randProtection);
          return shield;
      }
      if (randChance >= 9){
          Equipment shield = new Equipment("Trash Can Lid", "Shield", randProtection*5, randProtection);
          return shield;
      }
      Equipment shield = new Equipment("Moldy Pizza Box :(", "Shield", randProtection*5, randProtection);
      return shield;
  }

  private static Equipment choosePotion(){
      int randHeal= (int)(Math.random() * 4 + 1);
      int randChance = (int)(Math.random() * 25 + 1);
      if (randChance == 25){
          Equipment potion = new Equipment("Dragonblood", "Potion", randHeal*5, randHeal);
          return potion;
      }
      if (randChance >= 22){
          Equipment potion = new Equipment("Gourmet Potion", "Potion", randHeal*5, randHeal);
          return potion;
      }
      if (randChance >= 16){
          Equipment potion = new Equipment("Pretty Tasty Potion", "Potion", randHeal*5, randHeal);
          return potion;
      }
      if (randChance >= 9){
          Equipment potion = new Equipment("Dubious Potion", "Potion", randHeal*5, randHeal);
          return potion;
      }
      Equipment potion = new Equipment("Dragonpiss :(", "Potion", randHeal*5, 1);
      return potion;
  }
}
