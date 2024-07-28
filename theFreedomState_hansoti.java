
/*Name: Dhyey Hansoti
 * Date: June 18, 2024
 * Description: The user is asked to play a game with three maps, or city paths to follow.
 * Each map has a different touch to it that will be recognized only when the user plays the 
 * game, instead of instructions letting the user know. There are two final bosses for the
 * user can beat, only one needs to be destroyed before the The State of Freedom, or the end
 * is given to them. Along with that they have a spot to collect purely gold and tools for
 * usage for their journey to the end. One big catch is that the more gold you use, the
 * less your victory will mean, and the easier it will be! The User has to press the location again
 * to access the special menu's.
 */
import java.util.Scanner;
import java.util.Random;

public class theFreedomState_Vasa {
//Each variable below describes a global variable, which would be used throughout the game
//Output is a blank string that is further used for the end of the game	
	public static String output = " ";
//Used to measure a singular gold amount in the game
	public static int gold = 0;
//Used for the final health of the second boss in the the three maps
	public static int finalHealthBar1 = 0;
//Used for the total sum of gold that the User earns
	public static int sum = 0;
//Used to measure the total damage of the User against one of the bosses
	public static int totalDamage = 0;
//Health for the second boss
	public static int health1 = 0;
//Shield for the second boss
	public static int shield1 = 0;
//Afterlife health of the second boss
	public static int afterLife1 = 0;
//Used as a bystander variable for the final health bar of the second boss, pass through variable
	public static int finalHealth = 0;
//Final health of the first boss, and would be the harder boss to beat
	public static int boss2Health = 100000;
//Tally to measure the amount of times tool damage input was shown
	public static int tally = 2;
//Tally to show the different input with gold amounts
	public static int tally1 = 1;
//Damage of a basic sword
	public static int sword = 100;
//Damage of a basic knife
	public static int knife = 50;
//Damage of a basic RPG
	public static int RPG = 500;
//Damage of a specialized weapon, RPG
	public static int specializedRPG = 5000;
//Damage of a specialized weapon, Notebook
	public static int specializedNotebook = 100000;
//Below are three sets of data that are used for tool counting/damage array, gold counter, and final damage amount
	public static int[] tools = new int[1000];
	public static int[] goldCount = new int[1000];
	public static int[] damageCount = new int[1000];

	/*
	 * Description: Prints to the User's screen in a slower motion, to allow the
	 * User to feel a authentic experience
	 */
	public static void printing(String line) {
		// Loops through the line, and then attempts to try slowing it down
		for (int i = 0; i < line.length(); i++) {
			System.out.print(line.charAt(i));
			try {
				// Exactly how fast or slow the letters show in the User's screen
				Thread.sleep(5);
				;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Description: Once the User picks out a character they have certain starting
	 * packages. This will print them to the User, and allow them to start their
	 * journey into the unknown world.
	 */
	public static void inventoryStarter(String character) {
		if (character.equals("Chanan")) {
			// Once the character is chosen this person gets only gold no tools, and then
			// carry forward
			gold = 20;
			goldCount[0] += 20;
			// Prints gold amount, and has been stored into the data set
			printing("\n" + gold + " is your gold right now");
		} else if (character.equals("Raviculan")) {
			// Once the character is chosen again they only get gold
			gold = 5;
			goldCount[0] += 5;
			printing("\n" + gold + " is your gold right now");
		} else if (character.equals("Salagadoe")) {
			// Once the character is chosen they only get gold
			gold = 35;
			goldCount[0] += 35;
			printing("\n" + gold + " is your gold right now");
		} else if (character.equals("Patel")) {
			// This character not only gets gold, but as well as a tool which are going to
			// be stored
			gold = 10;
			goldCount[0] += 10;
			tools[0] = 100;
			int tool1 = tools[0];
			String toolName = " ";
			toolName = "Sword";
			// Prints the selected weapon/tool for them to see, along with the gold value
			// they have
			printing("\n" + gold + " is your gold right now");
			printing("\n" + tool1 + " damage comes from " + toolName);
		} else {
			// If the name does the match, they have to re-input the name, which prints
			// Invalid for the User to see
			printing("\nInvalid name! Restart the game");
		}

	}

	/*
	 * Description: This is a game that asks the User to guess a number from 1-100
	 * inclusive. Once the number is picked they win a certain gold amount, and are
	 * sent back to a menu.
	 */
	public static void guessTheNumber() {
//Creates a random number, 1-100, along with a guess amount from the User	
		int number = (int) (Math.random()*100 + 1);
		int guess = 0;

//Creates a loop  for only 3 guesses that are accepted from the User
		for (int i = 0; i < 3; i++) {

			Scanner player = new Scanner(System.in);
			printing("Guess a number between 1 and 100, but you only have three tries!\n");
			guess = player.nextInt();
//Hints the User if they are too high for their too high in the guess
			if (guess > number) {
				printing("\nToo high\n");
//If number is too low, the hint will be give to the User
			} else if (guess < number) {
				printing("\nToo low\n");
			} else {
//Once they get it right within the three guess range, the earn gold that is put into a data 
				printing("\nThat's right!\n");
				printing("\nCongrats you won! You earn 150 gold!!");
				goldCount[tally1] = 150;
				tally1++;
				System.exit(0);

			}
		}
//If the three guesses are done, they are asked to leave, and try again
		printing("\nNice try! Your 3 attempts have failed!");
	}

	/*
	 * Description: This is a game that flips a coin, and the User has to identify
	 * which side it is. If they guess correctly they either win a gold amount or
	 * damage amount from a tool for their benefit.
	 */
	public static void coinFlip() {
//Creates a random number from 1-2, and then asks the User to guess a side
		int number2 = (int) Math.round((Math.random() * 1));
		Scanner player2 = new Scanner(System.in);
		printing("Guess Heads or Tails:");
//Makes input lower case always
		String guess2 = player2.nextLine().trim().toLowerCase();
		String coin = " ";
//If the random number is 0, they have to guess heads to win
		if (number2 == 0) {
			coin = "heads";
//If guessed right they get a gold amount
			if (guess2.equals(coin)) {
				printing("\nCongrats you won! You earn 100 gold!!");
//A 500 gold deposit is made into a data set for gold			
				goldCount[tally1] = 100;
				tally1++;
			} else {
//If they guess wrong, they are asked to try again
				printing("\nTry again!");
			}
//If the number is 1, then they have to guess tails to win
		} else if (number2 == 1) {
			coin = "tails";
			if (guess2.equals(coin)) {
//If guessed correctly the User gets extra damage from a tool, that will help them
				printing("\nCongrats you won! You receive more damage with a sword!");
//A 100 damage deposit is made into a data set for damage					
				tools[tally] = 100;
				tally++;
			} else {
//If guessed wrong, they are asked to try again through the main menu
				printing("\nTry again!");
			}
		}

	}

	/*
	 * Description: If a menu accepts the offer of the User exiting, then a message
	 * will be printed for them to see.
	 */
	public static void exit() {
//Printed message for the User about exiting 
		printing("\nYou have chosen to leave, or printed an error you may proceed now!");
	}

	/*
	 * Description: Through the damage recorded by the tools, it goes through the
	 * weapons, and sums the total of it. Returning the total damage possible by the
	 * User to a final boss.
	 */
	public static int damageCount(int tools[]) {
//Loops through the data set
		for (int i = 0; i < tools.length; i++) {
//Adds every value, and returns it to use for further assistance		
			totalDamage += tools[i];
		}
		return totalDamage;
	}

	/*
	 * Description: Through gold, the User can earn a free weapon/tool, however they
	 * will not know (infinite times).The weapon damage is given to people with
	 * certain gold amounts only!
	 */
	public static void goldCounter(int goldCount[]) {
//Loops through the gold data set, and then figures out the total		
		for (int i = 0; i < goldCount.length; i++) {
			sum += goldCount[i];
		}
//Prints the total for the User to see
		printing("\nTotal gold is: " + sum);

//Through certain ratios, they either are asked to continue the game, or get extra damage
		if (sum <= 100) {
			printing("\nContinue the game\n");
		} else if (sum <= 500) {
			printing("\nSo close to tool!\n");
//If they are above 500, they get a randomly pick weapon that they win for damage
		} else if (sum > 500) {
			printing("\nCongrats you get a tool\n");
			int random = 0;
//A number from 0-2 is picked, and then gets sorted for the User to see their prize
			random = (int) Math.round((Math.random() * 2));
			if (random == 0) {
//If zero, it will create an according amount of damage to a sword
				printing("\nYou get a sword\n");
				damageCount[tally] = 100;
				tally++;
			} else if (random == 1) {
//If 1, it will create an according damage to a knife
				printing("\nYou get a knife\n");
				damageCount[tally] = 50;
				tally++;
			} else if (random == 2) {
//If 2, it will make an according damage of a RPG
				printing("\nYou get a RPG\n");
				damageCount[tally] = 500;
				tally++;
			}
		} else {
//If they enter a different gold value out-existing the set boundaries, then error prints
			printing("\nError!");
		}
	}

	/*
	 * Description: With one of the final bosses requiring a personal preference, it
	 * asks the User how much health it wants the boss to have. They will no know
	 * what is at risk.
	 */
	public static void health() {
		Scanner sc3 = new Scanner(System.in);
//They are asked to select from a range of 1000=10000
		printing("\nWhat do you want the health for the final boss being, from 1000-10000: \n");
		health1 = sc3.nextInt();
		if (health1 < 1000 || health1 > 10000) {
//If the number does not qualify, they have to try again		
			printing("\nError");
			health();
//Once a error free message is given, it will be recorded, and passed through
		} else {
			printing("\nPerfect thats the health!\n");
		}
	}

	/*
	 * Description: Through the same health feature, they are asked for the shield
	 * now. The shield is an extra component of health in the boss they could fight.
	 */
	public static void health(int health1) {
		Scanner sc4 = new Scanner(System.in);
//Asks the User from a range of numbers
		printing("\nWhat do you want the shield for the final boss being, from 100-1000: \n");
		shield1 = sc4.nextInt();
		if (shield1 < 100 || shield1 > 1000) {
//If number does not fit, they are asked to do it again
			printing("\nError");
			health(health1);
		} else {
//Once the number is error free, it will print a message, and then pass it through
			printing("\nPerfect thats the shield!\n");
		}
	}

	/*
	 * Description: Through the same health feature again, they ask for afterlife
	 * health. The afterlife health is just extra health that the boss gets. They
	 * can only see this once inside the boss fight and choosing all the health
	 * preferences of the boss.
	 */
	public static void health(int health1, int shield1) {
		Scanner sc5 = new Scanner(System.in);
//Asks the User for the afterlife health from a range
		printing("\nWhat do you want the afterlife for the final boss being, from 1000-10000: \n");
		afterLife1 = sc5.nextInt();
		if (afterLife1 < 1000 || afterLife1 > 10000) {
//If number does not fit, they are asked to repeat the process
			printing("\nError");
			health(health1, shield1);
		} else {
//If the number is perfect in the range, then they will continue into the fighting stage
			printing("\nPerfect thats the afterlife!\n");
		}
	}

	/*
	 * Description: Through the selected health, shield, and afterlife, the User
	 * needs to see the total health at the end. This happens right before the fight
	 * determines the fate of the User.
	 */
	public static int finalHealthBar() {
//Gathers all the components of the final health with health, shield, and afterlife.
		finalHealthBar1 = health1 + shield1 + afterLife1;
//Prints it for the User to see, and is returned for further use
		printing("\nThe final health of the boss is: " + finalHealthBar1);
		return finalHealthBar1;
	}

	/*
	 * Description: Through the gold amounts, regardless of how much is spent,
	 * leaves behind a certain amount of gold. If they beat the ratio, they pass
	 * with ease, otherwise they passed with a lot of help. This will print it to
	 * the User, to let them know if they should restart or not.
	 */
	public static String finalGoldCount() {
		if (sum < 1000) {
//If gold amount is below 1000, they passed just barely, and it is printed to their screen
			output = "You have passed just barely :(";
		} else {
//If gold amount is above 1000, they passed with ease, and will be printed to their screen
			output = "You have passed with flying colours, congrats :)";
		}
//Returns the designated message
		return output;
	}

	/*
	 * Description: Place A is recognized as "The Fire Lord Ozai", and is shown that
	 * way. They have options to move around, but if they select to stay they have a
	 * menu to choose from. This menu is special to the place, and will be different
	 * as they move around.
	 */
	public static void placeA() {
		Scanner sc = new Scanner(System.in);
//Asks the User if they want to move, or stay here
		printing("\nYou can (a) stay here or (b) move to the right to The State of Ghosts: \n");
		String choice = sc.nextLine();
//If picked a, they get to pick from a menu	
		if (choice.equals("a")) {
			boolean wish = true;

			while (wish) {
				Scanner sc3 = new Scanner(System.in);
//User picks from 3 values if they selected a again, each digit represents something different
				printing("\nEnter a value from 1-3," + " one represents the final fight, " + "two represent shop, "
						+ "three is to exit!\n");
				int value = sc.nextInt();
				if (value == 1) {
//If selected 1, they go into a fight
					theFight();
				} else if (value == 2) {
//If selected 2, they go to the shop 
					shop();
				} else if (value == 3) {
//If selected 3, they get the option to move around again
					placeA();
				}
//Asks the user if they want to redo the menu, or leave
				printing("\nDo you want to continue (yes or no): \n");
				String option = sc.next();

				option = option.toLowerCase();
				if (option.equals("no")) {
					wish = false;
//If the select no, then they are given the location changes again
					placeA();

				}
//If they pick yes, they just get the menu options again
			}
		}
// If the User selects to go to location b from the start, they are given the
// options of b
		else
			placeB();
	}

	/*
	 * Description: With the second map, there is also another set of tasks that are
	 * possible here. These tasks are special in terms of the map, and could be
	 * chosen if they stay. Otherwise they can move around the world.
	 */
	public static void placeB() {
		Scanner sc = new Scanner(System.in);
//Prints all the options possible, with this location having two possible movements
		printing("\nYou can (b) stay here, move back to (a), Fire Lord Ozai, go right to (c), Doom's Day Fishing: \n");
		String choice = sc.nextLine();
		if (choice.equals("a"))
//If they select A, they get to back to A	
			placeA();
		else if (choice.equals("b")) {
//If the select B again, they are able to choose from a menu
			boolean wish = true;

			while (wish) {
				Scanner sc3 = new Scanner(System.in);
//The menu is printed to the User's screen, with different digits representing different things
				printing("\nEnter a value from 1-3," + " one represents another final boss fight, "
						+ "two represents shop, " + "three is to exit!\n");
				int value = sc.nextInt();
				if (value == 1) {
//If the value is 1, they go into a different boss fight
					theFight2();
				} else if (value == 2) {
//If the value is 2, they go to the shop
					shop();
				} else if (value == 3) {
//If value is three, they are asked if they want to leave to another place
					placeB();
				}
//Once one of the menu tasks are done, they are asked if they wanted to continue
				printing("\nDo you want to continue (yes or no): \n");
				String option = sc.next();

				option = option.toLowerCase();
//If they pick no, they have the option to move around through the world			
				if (option.equals("no")) {
					wish = false;
					placeB();
				}
//If the pick yes, they continue in the same path, with the options shown again

			}
//From the start if the picked c, they have the options of path c
		} else
			placeC();
	}

	/*
	 * Description: Place c has the special outlook on the other maps. This space is
	 * used to farm gold, and tools through different games. Once they do that, they
	 * can go fight one of the final bosses. But they have to pick c again,
	 * otherwise they move around in the world.
	 */
	public static void placeC() {
		Scanner sc = new Scanner(System.in);
//Two options are given for the User to pick from
		printing("\nYou can (c) stay here, move back to (b) State of Ghosts: \n");
		String choice = sc.nextLine();
		if (choice.equals("b"))
//If they select b, then they get the options of path b 
			placeB();
		else {
//If they pick c, they are give a menu
			boolean wish = true;

			while (wish) {
				Scanner sc3 = new Scanner(System.in);
//The menu has three different parts to it, and has according digits to identify them
				printing("\nEnter a value from 1-3," + " one represents guess the number game, "
						+ "two represent coin flip, " + "three is to exit!\n");
				int value = sc.nextInt();
				if (value == 1) {
//If they pick 1, they go the guess the number game
					guessTheNumber();
				} else if (value == 2) {
//If they pick 2, they go to the coin flip game				
					coinFlip();
				} else if (value == 3) {
//If they pick 3, they are given the options of path c again
					placeC();
				}
//Asks the user if they want to continue with this menu
				printing("\nDo you want to continue (yes or no): \n");
				String option = sc.next();

				option = option.toLowerCase();
				if (option.equals("no")) {
					wish = false;
//If they pick no, they are able to get the options to path c
					placeC();
//Otherwise they are sent back to the menu, and can pick again
				}

			}
		}
	}

	/*
	 * Description: The shop allows the User to buy specialized weapons, and also
	 * get free weapons. They are also told certain things about the gold inventory
	 * they have.
	 */
	public static void shop() {
//They are asked if they want to buy anything, and the gold data is brought upon them		
		printing(
				"\nWould you like to buy anything right before the fight, special weapons? Otherwise goldCounter will be active here!\n");
		Scanner sc4 = new Scanner(System.in);
//Brings the gold counter, and checks if they get a free weapon	
		goldCounter(goldCount);
//They are asked to type one digit from the three, representing different things
		printing("\nType 1 to buy specialized RPG, type 2 to buy specialized notebook, and type 3 to leave!\n");
		int buy = sc4.nextInt();
		if (buy == 1) {
//If they picked option 1, they have to go through their funds and get the money
			if (sum > 500) {
//The total gold is subtracted upon
				sum = sum - 500;
//The special weapon is added towards damage in the damage data set
				tools[tally] = 5000;
				tally++;
//Prints purchase done
				printing("\nSuccessful purchace!\n");
			} else {
//If they do not have enough money, they are asked to leave, and tells them about insufficent funds
				printing("\nYou cannot buy it, insufficent funds!\n");
			}
		} else if (buy == 2) {
//If they pick 2, again they have to get the money to buy the weapon
			if (sum > 10000) {
//Subtracts the cost from the total gold the User has
				sum = sum - 10000;
//Adds damage to the total damage data set for the User to use
				tools[tally] = 100000;
				tally++;
//Prints purchase was successful
				printing("\nSuccessful purchace!\n");
			} else {
//If they do not have enough money, they are told that, and are asked to leave
				printing("\nYou cannot buy it, insufficent funds!\n");
			}
		} else {
//If the picked number 3, they are able to leave, and choose from a menu again
			printing("\nYou have chosen to leave!\n");
		}
	}

	/*
	 * Description: Once they enter a boss fight, a set of math is done, to see if
	 * they win. If they win, they move forward, and win the game. If they lose then
	 * they basically restart the game.
	 */
	public static void theFight() {
//Prints what they are about to face, and how much damage they are able to output onto the boss		
		printing(
				"\nWelcome to the fight with the Fire Lord Ozai, you lose, you have to restart the game from scratch\n");
		printing("\nThe fight has started lets see if you win!\n");
//Using a set of math, the User is able to know the damage they output	
		damageCount(tools);
		printing("\n" + totalDamage + " is your total damage for this final fight!\n");
		if (totalDamage < boss2Health) {
//If they lose, the whole damage data set is lost, and gold data set is lost
			printing("\nYou have lost!\n");
			for (int i = 999; i >= 0; i--) {
				tools[i] = 0;
			}
			for (int i = 999; i >= 0; i--) {
				goldCount[i] = 0;
			}

		} else {
//If they win, they are given a message, and are told how easy it was for them to win
			printing("\nCONGRATS YOU HAVE REACH VICTORY, YOU HAVE ARRIVED TO THE FREEDOM STATE\n");
			finalGoldCount();
			printing(output);
//Exits the whole game
			System.exit(0);
		}
	}

	/*
	 * Description: Once they enter a boss fight, a set of math is done, to see if
	 * they win. They first have to determine the health of this boss though, and
	 * then they see if they win. If they win they move to the end of the game,
	 * otherwise they restart the game.
	 */
	public static void theFight2() {
//Prints the boss they are fighting, and then asks a series of questions		
		printing(
				"\nWelcome to the fight with the State of Ghosts, you lose, you have to restart the game from scratch\n");
		printing("\nThe fight has started lets see if you win!\n");
//Asks the User the health of the final boss	
		health();
//Asks the User the shield of the final boss	
		health(health1);
//Asks the User the afterlife of the final boss
		health(health1, shield1);
//Calculates the final damage that it needs to do to the final boss
		finalHealthBar();
//Calculates the damage the User can do, and then it shown to the User
		damageCount(tools);
		printing("\n" + totalDamage + " is your total damage for this final fight!\n");
		if (totalDamage < finalHealthBar1) {
//If they cannot beat the final boss in one go, they lose the gold data set, and damage data set
			printing("\nYou have lost!\n");
			for (int i = 999; i >= 0; i--) {
				tools[i] = 0;
			}
			for (int i = 999; i >= 0; i--) {
				goldCount[i] = 0;
			}

		} else {
//If they win, they are given a message, and how easy it was for them to win
			printing("\nCONGRATS YOU HAVE REACH VICTORY, YOU HAVE ARRIVED TO THE FREEDOM STATE\n");
			finalGoldCount();
			printing(output);
//Exits the whole game
			System.exit(0);
		}
	}

	/*
	 * Description: The User has the whole game overview here, and then is asked to
	 * move from location a, or stay there for the special menu. Before that they
	 * are asked to select the character, and they get to know the starting package
	 * it comes with. Then they continue into the game.
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
//Asks the User what character they choose to play 
		printing("Welcome to the game! What chracter do you choose: ");
//Prints "The Fire Lord Ozai" special animal	
		printing("                                     .\r\n"
				+ "   ___------~~~~~~~~~~~----__         .:.         __----~~~~~~~~~~~------___\r\n"
				+ " ~~ ~--__          ......====\\\\~~    .:::.    ~~//====......          __--~ ~~\r\n"
				+ "         ~\\ ...::::~~~~~~  //|||    .:::::.    |||\\\\  ~~~~~~::::... /~\r\n"
				+ "        -~~\\_            //  |||***.(:::::).***|||  \\\\            _/~~-\r\n"
				+ "             ~\\_        // *******.:|\\^^^/|:.******* \\\\        _/~\r\n"
				+ "                \\      / ********.::(>: :<)::.******** \\      /\r\n"
				+ "			     \\   /  ********.::::\\\\|//::::.********  \\   /\r\n"
				+ " 	          \\ /   *******.:::::(o o):::::.*******   \\ /\r\n"
				+ "                   /.   ******.::::'*|V_V|***`::.******   .\\\r\n"
				+ "                     ~~--****.:::'***|___|*****`:.****--~~\r\n"
				+ "                           *.::'***//|___|\\\\*****`.* \r\n"
				+ "                           .:'  **/##|___|##\\**    .\r\n"
				+ "                          .    (v(VVV)___(VVV)v)\n");
//Options are given to them to pick from 	
		printing("\nOptions: Chanan, Raviculan, Salagadoe, and Patel (Say the exact name):\n");
		String character = sc.nextLine();
//What the User types in is used to determine the starting tools/gold they get	
		inventoryStarter(character);
//If they finally have a starting gold amount, they start with the description of the game, and then options for path a are given
		if (goldCount[0] > 0) {
			printing(
					"\nYou are tasked to accomplish one thing. That is to reach the freedom for your character through\nthe trenches of destruction"
							+ " that is inbetween you and your peace.\nTo get there you must earn a certain amount of gold, and tool damage to win against"
							+ " one of two final bosses.\nGood luck, may the odd ever be in your favour!\n");

			printing("\nYou are at The Fire Lord Ozai\n");
			placeA();
		}

//If they do not have a starting gold value, then they are asked to pick a character once more, since it was invalid before
		else {
			printing("\nOptions: Chanan, Raviculan, Salagadoe, and Patel (Say the exact name):\n");
			String character2 = sc.nextLine();
			inventoryStarter(character2);
//Again they are given the back story, and options for path a, once they are ready to go
			if (goldCount[0] > 0) {
				printing(
						"\nYou tasked to accomplish one thing. That is to reach the freedom for your character through\nthe trenches of destruction"
								+ " that is inbetween you and your peace.\nTo get there you must earn a certain amount of gold, and tool damage to win against"
								+ " one of two final bosses.\nGood luck, may the odd ever be in your favour!\n");

				printing("\nYou are at The Fire Lord Ozai\n");
				placeA();
			}
		}

	}
}
