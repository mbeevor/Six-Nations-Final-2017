package uk.co.beevorwhite.sixnationsfinal2017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static uk.co.beevorwhite.sixnationsfinal2017.R.id.team_a_score;
import static uk.co.beevorwhite.sixnationsfinal2017.R.id.team_b_score;

public class MainActivity extends AppCompatActivity {

    TextView scoreViewA;
    TextView scoreViewB;

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewA = (TextView) findViewById(team_a_score);
        scoreViewB = (TextView) findViewById(team_b_score);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("scoreA", scoreTeamA);
        savedInstanceState.putInt("scoreB", scoreTeamB);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int scoreA = savedInstanceState.getInt("scoreA");
        int scoreB = savedInstanceState.getInt("scoreB");

        TextView scoreViewA = (TextView) findViewById(team_a_score);
        scoreViewA.setText(String.valueOf(scoreA));
        scoreTeamA = scoreA;

        TextView scoreViewB = (TextView) findViewById(team_b_score);
        scoreViewB.setText(String.valueOf(scoreB));
        scoreTeamB = scoreB;

    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int scoreA) {
        scoreViewA.setText(String.valueOf(scoreA));
    }


    public void teamATry(View view) {
        scoreTeamA = scoreTeamA + 5;
        displayForTeamA(scoreTeamA);
    }

    public void teamAConversion(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void teamAPenalty(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void teamADropGoal(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }


    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int scoreB) {
        scoreViewB.setText(String.valueOf(scoreB));
    }


    public void teamBTry(View view) {
        scoreTeamB = scoreTeamB + 5;
        displayForTeamB(scoreTeamB);
    }

    public void teamBConversion(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void teamBPenalty(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void teamBDropGoal(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method is called when the RESET button is clicked.
     */
    public void Reset(View view) {
        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
    }
}
