// Class used for creating the treasure chests found at some locations
public class Treasure{
  private int coins = 0;
  private Equipment equip = null;

  public Treasure(int minCoins, int maxCoins){
      coins = (int)(Math.random() * ((maxCoins+1)-minCoins) + minCoins);
      int rand = (int)(Math.random() * 10 + 1);
      if (rand <= 4){
           equip = Equipment.chooseEquip();
      }
  }

  public static Treasure chooseTreasure(){
      return new Treasure(5, 25);
  }

   public Equipment getEquip(){
       return equip;
   }

  public int getCoins(){
      return coins;
  }
}
