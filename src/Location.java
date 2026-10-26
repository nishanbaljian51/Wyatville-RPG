// Class used for creating the locations the player explores
public class Location{
  private String terrain = "";
  private Enemy enemy = null;
  private Treasure treasure = null;
  private Shop shop = null;

  // Constructs an object and assigns its instance variables based on its terrain
  public Location (){
      this.terrain = chooseTerrain();
      if (terrain.equals("Town")){
          shop = Shop.chooseShop();
      }
      else if (terrain.equals("Forest")){
          int rand3 = (int)(Math.random()*100 +1);
          if (rand3 <= 33){
              enemy = Enemy.chooseForestEnemy();
          }
          if (rand3 >= 90){
              treasure = Treasure.chooseTreasure();
          }
      }

      else if (terrain.equals("Meadow")){
          int rand3 = (int)(Math.random()*100+1);
          if (rand3 <= 20){
              enemy = Enemy.chooseMeadowEnemy();
              }
          if (rand3 >= 80){
              shop = Shop.chooseShop();
          }
      }

      else if (terrain.equals("Mountains")){
          int rand3 = (int)(Math.random()*100+1);
          if (rand3 <= 50){
              enemy = Enemy.chooseMountainEnemy();
          }
          if (rand3 >= 70){
              treasure = Treasure.chooseTreasure();
          }
      }

      else if (terrain.equals("Volcano")){
          int rand3 = (int)(Math.random()*100+1);
          if (rand3 <= 66){
              enemy = Enemy.chooseVolcanoEnemy();
          }
          else{
              treasure = Treasure.chooseTreasure();
          }
      }

      else if (terrain.equals("Tundra")){
          int rand3 = (int)(Math.random()*100+1);
          if (rand3 <= 66){
              enemy = Enemy.chooseTundraEnemy();
          }
          else{
              shop = Shop.chooseShop();
          }
      }

      // Dungeons always have a guard and a reward for beating it
      else if (terrain.equals("Dungeon")){
          enemy = Enemy.chooseDungeonEnemy();
          treasure = new Treasure(20, 50);
      }

      else if (terrain.equals("Dragon's Lair")){
          enemy = new Enemy(6, 30, "Dragon");
      }
  }

  public String getTerrain(){
      return terrain;
  }

  public Enemy getEnemy(){
      return enemy;
  }

  public Treasure getTreasure(){
      return treasure;
  }

  public Shop getShop(){
      return shop;
  }

  // Randomly selects a terrain to be used in a new Location object and to initialize enocunter classes
  public static String chooseTerrain(){
      int rand = (int)(Math.random() * 100 + 1);
      if (rand <= 30){
          return "Forest";
      }

      else if (rand <= 50){
          return "Meadow";
      }

      else if (rand <= 65){
          return "Mountains";
      }

      else if (rand <= 80){
          return "Town";
      }

      else if (rand <= 95){
          int rand2 = (int)(Math.random() * 2 +1);
          if (rand2 == 1){
              return "Volcano";
          }
          return "Tundra";
      }

      else if (rand <= 97){
          return "Dungeon";
      }
      return "Dragon's Lair";
  }
}
