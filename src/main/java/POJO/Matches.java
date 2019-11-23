package POJO;

import java.util.ArrayList;

public class Matches {
    private String id, season, city,
            date, team1, team2, tossWinner,
            tossDecision, result, dlApplied,
            winner, winByRuns,
            winByWickets,
            playerOfMatch,
            venue, umpire1,
            umpire2,
            umpire3;

    public Matches(ArrayList<String> rows) {
        int curColumn = 0;
        this.id = rows.get(curColumn++);
        this.season = rows.get(curColumn++);
        this.city = rows.get(curColumn++);
        this.date = rows.get(curColumn++);
        this.team1 = rows.get(curColumn++);
        this.team2 = rows.get(curColumn++);
        this.tossWinner = rows.get(curColumn++);
        this.tossDecision = rows.get(curColumn++);
        this.result = rows.get(curColumn++);
        this.dlApplied = rows.get(curColumn++);
        this.winner = rows.get(curColumn++);
        this.winByRuns = rows.get(curColumn++);
        this.winByWickets = rows.get(curColumn++);
        this.playerOfMatch = rows.get(curColumn++);
        this.venue = rows.get(curColumn++);
        this.umpire1 = rows.get(curColumn++);
        this.umpire2 = rows.get(curColumn++);
        this.umpire3 = rows.get(curColumn++);

    }

    public String getId() {
        return id;
    }

    public String getSeason() {
        return season;
    }

    public String getWinner() {
        return winner;
    }

    public String getWinByRuns() {
        return winByRuns;
    }


}
