package uk.co.beevorwhite.sixnationsfinal2017;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static uk.co.beevorwhite.sixnationsfinal2017.R.id.name_team_a;
import static uk.co.beevorwhite.sixnationsfinal2017.R.id.name_team_b;
import static uk.co.beevorwhite.sixnationsfinal2017.R.id.team_a_score;
import static uk.co.beevorwhite.sixnationsfinal2017.R.id.team_b_score;

public class MainActivity extends AppCompatActivity {

    TextView scoreViewA;
    TextView scoreViewB;
    Spinner spinner1;
    Spinner spinner2;
    ImageView itemImage1;
    ImageView itemImage2;

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by id
        scoreViewA = (TextView) findViewById(team_a_score);
        scoreViewB = (TextView) findViewById(team_b_score);
        spinner1 = (Spinner) findViewById(name_team_a);
        spinner2 = (Spinner) findViewById(name_team_b);
        itemImage1 = (ImageView) findViewById(R.id.logo_team_a);
        itemImage2 = (ImageView) findViewById(R.id.logo_team_b);

        // Array of team crests
        final TypedArray images = getResources().obtainTypedArray(R.array.team_logo);

        // Array of team names
        ArrayAdapter<CharSequence> teamName = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        teamName.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(teamName);
        spinner2.setAdapter(teamName);

        // spinner for selecting first team
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemImage1.setImageResource(images.getResourceId(spinner1.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //spinner for selecting second team
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                itemImage2.setImageResource(images.getResourceId(spinner2.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    // saved instance state when device is rotated
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("scoreA", scoreTeamA);
        savedInstanceState.putInt("scoreB", scoreTeamB);
    }

    // restore saved instance state when device is rotated
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int scoreA = savedInstanceState.getInt("scoreA");
        int scoreB = savedInstanceState.getInt("scoreB");

        scoreViewA.setText(String.valueOf(scoreA));
        scoreViewB.setText(String.valueOf(scoreB));
    }

    // Displays the given score for Team A.
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

    // Displays the given score for Team B.
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

    // This method is called when the RESET button is clicked. All scores are reset to zero
    public void Reset(View view) {
        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
        spinner1.setSelection(0);
        spinner2.setSelection(0);
    }

}
