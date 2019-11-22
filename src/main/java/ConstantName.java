import java.util.Scanner;
class optionsSwitchCase
{

        static final String matches_csv = "matches.csv",delivery_csv = "deliveries.csv",winByRuns="win_by_runs";
        static final String wrongChoice = "You Entered a wrong choice",fileError = "Unable to open the file, Does file exits?";
        static final String season = "season",year = "2016", preYear ="2015",id = "id", matchId = "match_id",winner="winner";
        static final String bowlingTeam = "bowling_team", extraRuns = "extra_runs", bowler="bowler", totalRuns ="total_runs";


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