package POJO;

import static ConstantPackage.ConstantValues.*;

public class Matches {
    private String id;
    private String season;
    private String winner;
    private String winByRuns;

    public Matches(String[] curColumn) {

        this.id = curColumn[ID_COLUMN];
        this.season = curColumn[SEASON_CLOUMN];
        this.winner = curColumn[WINNER_COLUMN];
        this.winByRuns = curColumn[WIN_BY_RUNS_COLUMN];

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
