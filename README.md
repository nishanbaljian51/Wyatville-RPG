# Wyatville RPG

A text-based adventure game written in Java. Build your hero, explore the randomly generated land of Wyatville, fight monsters, loot treasure, shop for gear, and track down the Dragon in its lair.

## How to play

1. **Create your hero.** You get 10 attribute points to split between **Max Health** and **Damage**. Any points you don't spend are sold for 5 coins each.
2. **Explore.** Every area is randomly chosen: Forest, Meadow, Mountains, Town, Volcano, Tundra, Dungeon, or the rare Dragon's Lair.
3. **Fight.** Monsters get tougher the farther you wander, from Weak Wolves in the Meadow to Lava Hounds and Ice Dragons. Type `attack` or `run`.
4. **Loot and shop.** Treasure chests hold coins and sometimes gear. Shops sell one item per visit: Swords add damage, Shields add max health, and Potions heal.
5. **Recover.** You regain 1 health each time you travel, every victory raises your Max Health by 1, and Towns have an inn where you can rest back to full health.
6. **Win** by defeating the Dragon. If your health hits 0, it's game over.

Everything is typed: answer questions with `yes` / `no`, type numbers when asked for points, and type an item's name to buy it in a shop.

## Install and run

The game runs in a terminal (Command Prompt on Windows) and needs **Java 17 or newer**. Setup takes about 5 minutes.

### Step 1: Install Java

Check whether you already have it by opening a terminal and typing:

```
javac -version
```

If it prints a version number like `javac 21.0.5`, skip to Step 2. Otherwise:

- **Windows or Mac (easiest):** go to [adoptium.net](https://adoptium.net), click the big **Download** button for the latest LTS release, and run the installer with the default options. On Windows, make sure **"Set JAVA_HOME"** and **"Add to PATH"** are turned on during install.
- **Mac with Homebrew:** `brew install openjdk`
- **Linux (Ubuntu/Debian):** `sudo apt install default-jdk`

Close and reopen your terminal after installing, then run `javac -version` again to confirm.

### Step 2: Get the code

**Option A: Download a ZIP (no Git needed)**

1. On this GitHub page, click the green **Code** button, then **Download ZIP**.
2. Unzip the file. You'll get a folder named `Wyatville-RPG-main`.

**Option B: Clone with Git**

```
git clone https://github.com/nishanbaljian51/Wyatville-RPG.git
```

### Step 3: Run the game

**Windows:** open the `Wyatville-RPG-main` folder and double-click **`run.bat`**.

**Mac / Linux:** open Terminal, go into the folder, and run the script:

```
cd ~/Downloads/Wyatville-RPG-main
sh run.sh
```

(If you cloned with Git, the folder is called `Wyatville-RPG` instead.)

**Any system, by hand:** from inside the folder, run:

```
javac -d bin src/*.java
java -cp bin Game
```

To skip the pauses between lines (handy for testing), add `fast` to the end: `sh run.sh fast`, `run.bat fast`, or `java -cp bin Game fast`.

### Troubleshooting

| Problem | Fix |
| --- | --- |
| `javac: command not found` or `'javac' is not recognized` | Java isn't installed or isn't on your PATH. Redo Step 1, then close and reopen the terminal. |
| Mac says "Unable to locate a Java Runtime" | You installed Java with Homebrew. Use `sh run.sh`, which finds it automatically. |
| `error: file not found: src/*.java` | You're not inside the game folder. `cd` into the folder that contains `src` first. |
| The game seems frozen | It's waiting for you to type something. Read the last line and type an answer, then press Enter. |

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
| `run.sh` / `run.bat` | One-step compile-and-run scripts |
