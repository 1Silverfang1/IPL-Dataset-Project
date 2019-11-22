import java.util.Scanner;

class optionsSwitchCase
        {
        int choice;
protected int options()
        {
        System.out.println("IPL DATASET PROJECT");
        System.out.println("Choose one of the Option Listed Below");
        System.out.println("1. Number of matches played per year of all the years in IPL.");
        System.out.println("2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("4. For the year 2015 get the top economical bowlers.");
        System.out.println("5. For the year 2016, get the win by run per team");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        return choice;
        }

        }