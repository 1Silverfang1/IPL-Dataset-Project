package POJO;

import java.util.ArrayList;

public class Delivery {
private String match_id,inning,
        battingTeam, bowlingTeam,
        over,ball,batsman,non_striker,
        bowler, isSuperOver, wideRuns,
        byeRuns, legbyeRuns,
        noballRuns,
        penaltyRuns, batsmanRuns,
        extra_runs,total_runs,
        playerDismissed, dismissalKind,fielder;
    public Delivery(ArrayList<String> rows)
    {
        int i=0;
        this.match_id=rows.get(i++);
        this.inning=rows.get(i++);
        this.battingTeam =rows.get(i++);
        this.bowlingTeam =rows.get(i++);
        this.over=rows.get(i++);
        this.ball=rows.get(i++);
        this.batsman=rows.get(i++);
        this.non_striker=rows.get(i++);
        this.bowler=rows.get(i++);
        this.isSuperOver =rows.get(i++);
        this.wideRuns =rows.get(i++);
        this.byeRuns =rows.get(i++);
        this.legbyeRuns =rows.get(i++);
        this.noballRuns =rows.get(i++);
        this.penaltyRuns =rows.get(i++);
        this.batsmanRuns =rows.get(i++);
        this.extra_runs=rows.get(i++);
        this.total_runs=rows.get(i++);
        this.playerDismissed =rows.get(i++);
        this.dismissalKind =rows.get(i++);
        this.fielder=rows.get(i++);

    }
    public String getMatch_id() {
        return match_id;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }


    public String getBowler() {
        return bowler;
    }
    public String getExtra_runs() {
        return extra_runs;
    }

    public String getTotal_runs() {
        return total_runs;
    }
}
