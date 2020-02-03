import java.util.Random;
import java.util.Scanner;

public class GameSetup
	{
		static Scanner userStringInput = new Scanner(System.in);
		static Scanner userIntInput = new Scanner(System.in);
		static boolean play = true;
		static boolean start = true;
		static Player p;
		static int foodAmount;
		static int miles;
		static int dayCounter;
		public static void main(String[] args)
			{
				p = new Player("Job", 0, Player.STARTING_HEALTH, 0, 0);
				while (play)
					{
						welcomePlayer();
						while (start)
							{
								setJob();
								setFood();
								travel();
								
							}
					}
			}
		public static void welcomePlayer()
		{
			System.out.println("Welcome to The Oregon Trail!");
			System.out.println("What would you like to do?");
			System.out.println("        1. Travel the Trail");
			System.out.println("        2. Learn about the trail");
			System.out.println("        3. End");
			String welcomeChoice = userStringInput.nextLine();
			if (welcomeChoice.equals("1"))
				{
					System.out.println("Lets play");
					spacer();
				}
			else if (welcomeChoice.equals("2"))
				{
					System.out.println("Try taking a journeyy by covered wagon across 2000 miles\n "
							+ "of plains, rivers, and mountains. Try! On the plains,\n"
							+ "will you slosh your oxen through mud and water filled ruts or\n "
							+ "will you plod through dust six inches deep?");
					spacer();
					
					
				}
			else 
				{
					System.out.println("Bye");
					System.exit(0);
				}
		}
		
		public static void setJob()
		{
			System.out.println("Many kinds of people made the trip to Oregon.");
			System.out.println("You may: ");
			System.out.println("        1. Be a banker from Boston");
			System.out.println("        2. Be a carpenter from Ohio");
			System.out.println("        3. Be a farmer from Illinois");
			System.out.println("        4. Find out the differences between the choices");
			
			String jobChoice = userStringInput.nextLine();

			if (jobChoice.equals("1"))
				{
					System.out.println("You choose banker!");
					spacer();
					p.setJob("Banker");
					p.setMoney(800.00);
				}
			else if (jobChoice.equals("2"))
				{
					System.out.println("You choose carpenter!");
					spacer();
					p.setJob("Carpenter");
					p.setMoney(400.00);
				}
			else if (jobChoice.contentEquals("3"))
				{
					System.out.println(("You choose farmer!"));
					spacer();
					p.setJob("Farmer");
					p.setMoney(200.00);
				}
			else
				{
					System.out.println("These are the jobs. What job you chose will change \n"
							+ "how much money you start with. The more money you start with \n"
							+ "the more food you'll be able to buy for your journey on the road.\n"
							+ "Bankers start with $800, carpenters start with $400, and farmers \n"
							+ "start with $200. Choose wisely.");
					spacer();
					setJob();
				}
		}
		
		public static void setFood()
			{
				System.out.println("Your going to need supplies for your trip.");
				System.out.println("The amount of food you get will help you survive");
				System.out.println("200 lbs of food is recommended");
				System.out.println("1 pound of food costs $2 ");
				System.out.println("You have $" + p.getMoney());
				foodAmount = userIntInput.nextInt();
				
				for (int i = 0; i <= foodAmount; i++)
					{
						p.setFood(p.getFood()+1);
					}
				p.setMoney(p.getMoney()-(foodAmount*2));
				System.out.println("You now have $" + p.getMoney());
			}
			
		public static void travel()
			{
				dayCounter = 0;
				System.out.println("Lets travel the trail!");
				spacer();
				for (miles = 0; miles <2000; miles+=100)
					{
						Random rand = new Random();
						
						double randomNum = rand.nextDouble();
							
						if (randomNum <= .2)
							{
								tradingPost();
								changeLevels();
								showStats();
								spacer();
							}
						else if (randomNum <= .4)
							{
								System.out.println("You've made it to a landmark!");
								changeLevels();
								showStats();
								spacer();
							}
						else
							{
								changeLevels();
								showStats();
								spacer();
							}
						dayCounter++;
					}
				System.out.println("You made it to Oregon!");
				playAgain();
			}
		
		public static void tradingPost()
			{
				System.out.println("You've reached a trading post!");
				System.out.println("Would you like to buy more supplies?");
				
				String moreFood = userStringInput.nextLine().toLowerCase();
				
				if (moreFood.equals("yes"))
					{
						System.out.println("1 pound of food costs 0.20 cents");
						System.out.println("How many pounds would you like to buy?");
						foodAmount = userIntInput.nextInt();
						
						for (int i = 0; i <= foodAmount; i++)
							{
								p.getFood();
								p.setFood(p.getFood()+1);
							}
						System.out.println("You now have " + p.getFood() +"lbs of food");
						p.getMoney();
						p.setMoney(p.getMoney()-(foodAmount * 0.20));
						spacer();
					}
				else if (moreFood.equals("no"))
					{
						System.out.println("Continue on the trail!");
						spacer();
					}
				else
					{
						tradingPost();
					}
			}
		
		public static void changeLevels()
			{
				if (p.getFood() > 1)
					{
						p.setFood(p.getFood()-5);
					}
				else
					{
						p.setFood(0);
						p.setHealth(p.getHealth()-10);
						
					}
				if (p.getHealth() == 0)
					{	
						System.out.println("You've Died");
						System.out.println("You didn't make it to Oregon.");
						playAgain();
					}
				else if (p.getHealth() < 20)
					{
						System.out.println();
						System.out.println("You have the flu!");
						System.out.println();
					}
				else
					{
						
					}

			}
		
		public static void showStats()
			{	
				int milesLeft = 2000 - miles;
				System.out.println("You've been on the trail for " + dayCounter + " days");
				System.out.println("You have $" + p.getMoney());
				System.out.println("Health: " + p.getHealth());
				System.out.println("Food: " + p.getFood() + " lbs");
				System.out.println("Distance to Oregon: " + milesLeft + " miles");
			}
		public static void spacer()
			{
				userStringInput.nextLine();
				System.out.println("-------------------------------------");
				System.out.println();
			}
		
		public static void playAgain()
			{
				System.out.println("Would you like to play again?");
				String playAgain = userStringInput.nextLine().toLowerCase();
				if (playAgain.equals("yes"))
					{
						System.out.println("Lets play again!");
						spacer();
					}
				else
					{
						System.out.println("Thanks for playing!");
						System.exit(0);
					}
			}
		
		//imma see if this works
		
	}






