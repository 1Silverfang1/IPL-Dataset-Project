import java.util.Scanner;
class ConstantsValues
{
        static final int OVER =6;
        static final String MATCHES_CSV = "matches.csv", DELIVERIES_CSV = "deliveries.csv", WIN_BY_RUNS ="win_by_runs";
        static final String WRONG_CHOICE = "You Entered a wrong choice", FILE_ERROR = "Unable to open the file, Does file exits?";
        static final String SEASON = "season", YEAR = "2016", PRE_YEAR ="2015",id = "id", MATCH_ID = "match_id", WINNER ="winner";
        static final String BOWLING_TEAM = "bowling_team", EXTRA_RUNS = "extra_runs", BOWLER ="bowler", TOTAL_RUNS ="total_runs";
        int options()
        {
        System.out.println("IPL DATASET PROJECT");
        System.out.println("Choose one of the Option Listed Below");
        System.out.println("1. Number of matches played per year of all the years in IPL.");
        System.out.println("2. Number of matches won of all teams over all the years of IPL.");
        System.out.println("3. For the year 2016 get the extra runs conceded per team.");
        System.out.println("4. For the year 2015 get the top economical bowlers.");
        System.out.println("5. For the year 2016, get the win by run per team");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
        }

        }