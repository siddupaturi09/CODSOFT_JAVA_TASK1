import java.util.Random;
import java.util.Scanner;
class Task1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minValue = 1;
        int maxValue = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("For every round in the game, 100 points are alloted and for each incorrect attempt, 1 point is deducted.");
        while (true)
        {
            int targetNumber = random.nextInt(maxValue - minValue + 1) + minValue;
            int attempts = 0;

            System.out.println("I've selected a number between " + minValue + " and " + maxValue + ". Guess it!");

            while (true)
            {
                System.out.print("Enter your guess number: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < minValue || guess > maxValue)
                {
                    System.out.println("Please enter a number within the specified range.");
                }
                else if (guess == targetNumber)
                {
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                    score += findScore(attempts);
                    break;
                }
                else if (attempts >= maxAttempts)
                {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
                    break;
                }
                else if (guess < targetNumber)
                {
                    System.out.println("Too low! Try again.");
                } 
                else
                {
                    System.out.println("Too high! Try again.");
                }
            }

            System.out.println("Your current score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes"))
            {
                System.out.println("Thanks for playing! Your final score is: " + score);
                break;
            }
        }

        scanner.close();
    }

    private static int findScore(int attempts)
    {
        return 100 - attempts;
    }
}
