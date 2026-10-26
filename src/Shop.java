public class Shop{
  private Equipment equip1 = null;
  private Equipment equip2 = null;

  public Shop(){
      equip1 = Equipment.chooseEquip();
      equip2 = Equipment.chooseEquip();
  }

  public static Shop chooseShop(){
      return new Shop();
  }

  public Equipment getEquip1(){
      return equip1;
  }

  public Equipment getEquip2(){
      return equip2;
  }

  private static void thank(){
   System.out.println("Thanks for visiting!");
   Game.clear(2);
  }

  public static void incrementPlayer(Equipment equip, Player player){
       if (equip.getType().equals("Sword")){
          player.addAttack(equip.getModifier());
       }
       else if (equip.getType().equals("Shield")){
           player.addMaxHealth(equip.getModifier());
       }
       else if (equip.getType().equals("Potion")){
           player.addCurrHealth(equip.getModifier());
       }
  }

  private static void buy(Equipment equip, Player player){
       player.loseCoins(equip.getCost());
       incrementPlayer(equip, player);
       System.out.println("You bought the " + equip.getName() + "!");
       System.out.println(player.getStats());
  }

  public static void useShop(Player player, Shop shop){
      System.out.println("The options for sale today are as follow: ");
      Game.wait(3);
      System.out.println();
      Equipment equip1 = shop.getEquip1();
      Equipment equip2 = shop.getEquip2();
      System.out.println(equip1);

      Game.wait(3);
      System.out.println();
      System.out.println(equip2);

      System.out.println();
      System.out.println("You may purchase one item today, if you choose to do so. I need to keep my stock strong for other adventurers like yourself.");
      Game.wait(6);
      System.out.println("It looks like you've got " + player.getCoins() + " coins on you today.");
      Game.wait(3);
      System.out.println();
      System.out.println("So what will it be?");
      Game.wait(2);
      System.out.println("Enter the name of your item of choice below (or 'none'):");
      String equipChosen = Game.getSpecificResponse(equip1.getName(), equip2.getName(), "none", player.getName().length());
      Game.clear(2);
      if (equipChosen.equalsIgnoreCase(equip2.getName())){
           if (player.getCoins() >= equip2.getCost()){
               buy(equip2, player);
               thank();
               return;
           }
           else{
               System.out.println("Sorry, you don't have enough money.");
               Game.wait(5);
               if (player.getCoins() >= equip1.getCost()){
                   System.out.println("You have enough money to buy the other item. Would you like to purchase it?");
                   String answer = Game.getSpecificResponse("yes", "no", "can i see the stats again?", player.getName().length());
                   if (answer.equals("yes")){
                       buy(equip1, player);
                       thank();
                       return;
                   }
                   else if (answer.equals("no")){
                       thank();
                       return;
                   }
                   else if (answer.equals("can i see the stats again?")){
                       System.out.println("Sure here they are: ");
                       Game.wait(2);
                       System.out.println(equip1);
                       Game.wait(8);
                       System.out.println("So what will it be?");
                       String answer2 = Game.getSpecificResponse("yes", "no", "can i see the stats again?", player.getName().length()-1);
                       if (answer2.equals("yes")){
                           buy(equip1, player);
                           thank();
                           return;
                       }
                       else if (answer2.equals("no")){
                           thank();
                           return;
                       }
                       else if (answer2.equals("can i see the stats again?") || answer2.equals("")){
                           Game.wait(2);
                           System.out.println("I don't get paid enough for this.");
                           thank();
                           return;
                       }
                   }
                   else if (answer.equals("")){
                        System.out.println("I don't get paid enough for this.");
                           thank();
                           return;
                   }
               }
               else {
                   thank();
                   return;
               }
           }
      }
      else if (equipChosen.equalsIgnoreCase(equip1.getName())){
           if (player.getCoins() >= equip1.getCost()){
               buy(equip1, player);
               thank();
               return;
           }
           else{
               System.out.println("Sorry, you don't have enough money.");
               if (player.getCoins() >= equip2.getCost()){
                   System.out.println("You have enough money to buy the other item. Would you like to purchase it?");
                   String answer3 = Game.getSpecificResponse("yes", "no", "can i see the stats again?", player.getName().length());
                   if (answer3.equals("yes")){
                       buy(equip2, player);
                       thank();
                       return;
                   }
                   else if (answer3.equals("no")){
                       thank();
                       return;
                   }
                   else if (answer3.equals("can i see the stats again?")){
                       System.out.println("Sure here they are: ");
                       System.out.println(equip2);
                       System.out.println("So what will it be?");
                       String answer4 = Game.getSpecificResponse("yes", "no", "can i see the stats again?", player.getName().length()-1);
                       if (answer4.equals("yes")){
                           buy(equip2, player);
                           thank();
                           return;
                       }
                       else if (answer4.equals("no")){
                           thank();
                           return;
                       }
                      else if (answer4.equals("can i see the stats again?") || answer4.equals("")){
                           Game.wait(2);
                           System.out.println("I don't get paid enough for this.");
                           thank();
                           return;
                       }
                   }
                   else if (answer3.equals("")){
                        System.out.println("I don't get paid enough for this.");
                           thank();
                           return;
                   }
               }
               else {
                   thank();
                   return;
               }
           }
       }
      else if (equipChosen.equals("")){
           System.out.println("I don't get paid enough for this.");
      }
      thank();
   }
}
