// Class used for creating the enemies the player fights at each location
public class Enemy{
  private int damage = 0;
  private int health = 0;
  private String name = "";




  public Enemy(int damage, int health, String name){
      this.damage = damage;
      this.health = health;
      this.name = name;
  }

  public int getDamage(){
      return damage;
  }

  public String getName(){
      return name;
  }

  public Enemy setName(String name){
      this.name = name;
      return this;
  }

  public int getHealth(){
      return health;
  }

  public boolean isDead(){
      return health <= 0;
  }

  public void addDamage(int damage){
      this.damage += damage;
  }

  public void addHealth(int health){
      this.health += health;
  }

  public void subtractHealth(int health){
      this.health -= health;
  }

  public void subtractDamage(int damage){
      this.damage -= damage;
      if (this.damage < 1){
          this.damage = 1;
      }
  }

  public Enemy subtractBoth(int num){
      subtractDamage(num);
      subtractHealth(num*2);
      return this;
  }

  public Enemy addBoth(int num){
      addDamage(num);
      addHealth(num*2);
      return this;
  }

  private static Enemy chooseWolf(){
      int rand5 = (int)(Math.random() * 3 + 4);
      Enemy wolf = new Enemy(rand5/2, rand5, "Wolf");
      return wolf;
  }

  private static Enemy chooseHawk(){
      int rand5 = (int)(Math.random() * 2 + 3);
      Enemy hawk = new Enemy(rand5/2, rand5, "Hawk");
      return hawk;
  }

  private static Enemy chooseBoar(){
      int rand5 = (int)(Math.random() * 3 + 5);
      Enemy boar = new Enemy(rand5/2, rand5, "Boar");
      return boar;
  }

  public static Enemy chooseForestEnemy(){
      int rand4 = (int)(Math.random() * 100 +1);
      if (rand4 <= 33){
          return chooseWolf();
      }
      return chooseBoar();
  }

  public static Enemy chooseMeadowEnemy(){
      int rand4 = (int)(Math.random() * 100 +1);
      if (rand4 <= 70){
          return chooseWolf().subtractBoth(1).setName("Weak Wolf");
      }
      return chooseHawk();
  }

  public static Enemy chooseMountainEnemy(){
      int rand4 = (int)(Math.random() * 100 +1);
      if (rand4 <= 66){
          return chooseWolf().addBoth(3).setName("Alpine Wolf");
      }
      return chooseHawk().addBoth(2).setName("Falcon");
  }

  public static Enemy chooseVolcanoEnemy(){
      int rand4 = (int)(Math.random() * 100 +1);
      if (rand4 <= 66){
          return chooseWolf().addBoth(5).setName("Lava Hound");
      }
      return chooseHawk().addBoth(4).setName("Pheonix");
  }

  public static Enemy chooseTundraEnemy(){
      int rand4 = (int)(Math.random() * 100 +1);
      if (rand4 <= 66){
          return chooseWolf().addBoth(4).setName("Polar Bear");
      }
      return chooseHawk().addBoth(6).setName("Ice Dragon");
  }

  // Dungeons hold a monster from any of the tougher regions
  public static Enemy chooseDungeonEnemy(){
      int rand4 = (int)(Math.random() * 3 + 1);
      if (rand4 == 1){
          return chooseMountainEnemy();
      }
      if (rand4 == 2){
          return chooseVolcanoEnemy();
      }
      return chooseTundraEnemy();
  }
}
