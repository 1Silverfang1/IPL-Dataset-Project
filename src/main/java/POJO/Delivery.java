package POJO;

import static ConstantPackage.ConstantValues.*;

public class Delivery {
    private String matchId,
            bowlingTeam,
            bowler,
            extraRuns,
            totalRuns;

    public Delivery(String[] curColumn) {
        this.matchId = curColumn[MATCH_ID_COLUMN];
        this.bowlingTeam = curColumn[BOWLING_TEAM_COLUMN];
        this.bowler = curColumn[BOWLER_COLUMN];
        this.extraRuns = curColumn[EXTRA_RUN_COLUMN];
        this.totalRuns = curColumn[TOTAL_RUN_COLUMN];
    }

    public String getMatchId() {
        return matchId;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public String getBowler() {
        return bowler;
    }

    public String getExtraRuns() {
        return extraRuns;
    }

    public String getTotalRuns() {
        return totalRuns;
    }
}
