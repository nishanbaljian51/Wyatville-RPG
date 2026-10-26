# Wyatville RPG

A text-based adventure game written in Java. Build your hero, explore the randomly generated land of Wyatville, fight monsters, loot treasure, shop for gear, and track down the Dragon in its lair.

## How to play

1. **Create your hero.** You get 10 attribute points to split between **Max Health** and **Damage**. Any points you don't spend are sold for 5 coins each.
2. **Explore.** Every area is randomly chosen: Forest, Meadow, Mountains, Town, Volcano, Tundra, Dungeon, or the rare Dragon's Lair.
3. **Fight.** Monsters get tougher the farther you wander, from Weak Wolves in the Meadow to Lava Hounds and Ice Dragons. Type `attack` or `run`.
4. **Loot and shop.** Treasure chests hold coins and sometimes gear. Shops sell one item per visit: Swords add damage, Shields add max health, and Potions heal.
5. **Recover.** You regain 1 health each time you travel, every victory raises your Max Health by 1, and Towns have an inn where you can rest back to full health.
6. **Win** by defeating the Dragon. If your health hits 0, it's game over.

## Running the game

You need Java (JDK 17 or newer, for example from [adoptium.net](https://adoptium.net)).

```bash
javac -d bin src/*.java
java -cp bin Game
```

To skip the pauses between lines (useful for testing), run `java -cp bin Game fast`.

## Code layout

| File | What it does |
| --- | --- |
| `src/Game.java` | Main game loop, combat, input handling |
| `src/Player.java` | Hero creation and stats |
| `src/Location.java` | Random terrain and what's found there |
| `src/Enemy.java` | Monsters for each region |
| `src/Equipment.java` | Swords, Shields, and Potions |
| `src/Shop.java` | The shopkeeper |
| `src/Treasure.java` | Treasure chests |
