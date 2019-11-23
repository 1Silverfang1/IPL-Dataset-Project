package POJO;

import java.util.ArrayList;

public class Delivery {
private String match_id,inning,
        batting_team,bowling_team,
        over,ball,batsman,non_striker,
        bowler,is_super_over,wide_runs,
        bye_runs,legbye_runs,
        noball_runs,
        penalty_runs,batsman_runs,
        extra_runs,total_runs,
        player_dismissed,dismissal_kind,fielder;
    public Delivery(ArrayList<String> rows)
    {
        int i=0;
        this.match_id=rows.get(i++);
        this.inning=rows.get(i++);
        this.batting_team=rows.get(i++);
        this.bowling_team=rows.get(i++);
        this.over=rows.get(i++);
        this.ball=rows.get(i++);
        this.batsman=rows.get(i++);
        this.non_striker=rows.get(i++);
        this.bowler=rows.get(i++);
        this.is_super_over=rows.get(i++);
        this.wide_runs=rows.get(i++);
        this.bye_runs=rows.get(i++);
        this.legbye_runs=rows.get(i++);
        this.noball_runs=rows.get(i++);
        this.penalty_runs=rows.get(i++);
        this.batsman_runs=rows.get(i++);
        this.extra_runs=rows.get(i++);
        this.total_runs=rows.get(i++);
        this.player_dismissed=rows.get(i++);
        this.dismissal_kind=rows.get(i++);
        this.fielder=rows.get(i++);

    }
    public String getMatch_id() {
        return match_id;
    }

    public String getBowling_team() {
        return bowling_team;
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
