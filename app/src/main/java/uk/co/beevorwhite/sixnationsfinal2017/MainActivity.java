package uk.co.beevorwhite.sixnationsfinal2017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import static uk.co.beevorwhite.sixnationsfinal2017.R.id.name_team_a;
import static uk.co.beevorwhite.sixnationsfinal2017.R.id.name_team_b;
import static uk.co.beevorwhite.sixnationsfinal2017.R.id.team_a_score;
import static uk.co.beevorwhite.sixnationsfinal2017.R.id.team_b_score;

public class MainActivity extends AppCompatActivity {

    TextView scoreViewA;
    TextView scoreViewB;
    TextView nameTeamA;
    TextView nameTeamB;

    int scoreTeamA = 0;
    int scoreTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewA = (TextView) findViewById(team_a_score);
        scoreViewB = (TextView) findViewById(team_b_score);
        nameTeamA = (TextView) findViewById(name_team_a);
        nameTeamB = (TextView) findViewById(name_team_b);
        // Get a reference to the AutoCompleteTextView in the layout
        AutoCompleteTextView textViewA = (AutoCompleteTextView) findViewById(R.id.name_team_a);
        AutoCompleteTextView textViewB = (AutoCompleteTextView) findViewById(R.id.name_team_b);
        // Get the string array
        String[] teamName = getResources().getStringArray(R.array.teams);
        // Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamName);
        textViewA.setAdapter(adapter);
        textViewB.setAdapter(adapter);
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

        nameTeamA.setText(R.string.team_name);
        nameTeamB.setText(R.string.team_name);
    }

}
