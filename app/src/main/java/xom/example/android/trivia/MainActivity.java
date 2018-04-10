package xom.example.android.trivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import xom.example.android.trivia.R;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the SUBMIT button is clicked.
     * This is where all the classes are called to check/evaluate/calculate the quiz questions.
     */
    public void submitQuiz(View view) {


        int question1Score = checkQuestion1();

        int question2Score = checkQuestion2();

        CheckBox carrieCheckBox = findViewById(R.id.carrie_checkbox);
        boolean hasCarrie = carrieCheckBox.isChecked();

        CheckBox starWarsCheckBox = findViewById(R.id.star_wars_checkbox);
        boolean hasStarWars = starWarsCheckBox.isChecked();

        CheckBox hillsHaveCheckBox = findViewById(R.id.hills_have_checkbox);
        boolean hasHillsHave = hillsHaveCheckBox.isChecked();

        CheckBox saturdayCheckBox = findViewById(R.id.saturday_checkbox);
        boolean hasSaturday = saturdayCheckBox.isChecked();

        CheckBox problemChildCheckBox = findViewById(R.id.problem_child_checkbox);
        boolean hasProblemChild = problemChildCheckBox.isChecked();

        CheckBox lastStarfighterCheckBox = findViewById(R.id.last_starfighter_checkbox);
        boolean hasLastStarfighter = lastStarfighterCheckBox.isChecked();

        CheckBox spaceCampCheckBox = findViewById(R.id.space_camp_checkbox);
        boolean hasSpaceCamp = spaceCampCheckBox.isChecked();

        CheckBox dennisCheckBox = findViewById(R.id.dennis_checkbox);
        boolean hasDennis = dennisCheckBox.isChecked();

        int checkBoxScore = calculateCheckBoxPoints(hasCarrie, hasStarWars, hasHillsHave, hasSaturday, hasProblemChild, hasLastStarfighter, hasSpaceCamp, hasDennis);

        EditText answerField5 = findViewById(R.id.ques_5_answer);
        String answer5Text = answerField5.getText().toString();
        int question5Score = checkQuestion5(answer5Text);

        EditText answerField6 = findViewById(R.id.ques_6_answer);
        String answer6Text = answerField6.getText().toString();
        int question6Score = checkQuestion6(answer6Text);


        score = question1Score + question2Score + checkBoxScore + question5Score + question6Score;

        Toast.makeText(this, "You scored " + score + " out of 8 points!", Toast.LENGTH_LONG).show();
    }

    /**
     * This method checks and scores Question #1
     * The correct answer is stored in "answer".The radiogroup is called and checks if what is
     * selected matches the same identifier as answer.
     *
     * @return is 1 or 0 points depending on if question was answered correctly or not.
     */

    private int checkQuestion1() {
        int question1Point = 0;
        int answer = R.id.ldl_false;

        RadioGroup ldlRadioGroup = findViewById(R.id.ldl_radiogroup);
        int selected = ldlRadioGroup.getCheckedRadioButtonId();
        if (selected == answer) {
            question1Point += 1;
        }

        return question1Point;
    }

    /**
     * This method checks and scores Question #2
     * The correct answer is stored in "answer".The radiogroup is called and checks if what is
     * selected matches the same identifier as answer.
     *
     * @return is 1 or 0 points depending on if question was answered correctly or not.
     */

    private int checkQuestion2() {
        int question2Point = 0;
        int answer = R.id.hdl_true;

        RadioGroup hdlRadioGroup = findViewById(R.id.hdl_radiogroup);
        int selected = hdlRadioGroup.getCheckedRadioButtonId();
        if (selected == answer) {
            question2Point += 1;
        }

        return question2Point;
    }

    /**
     * This method checks and scores the checkboxes that make up questions #3 - 4.
     * When a checkbox is checked the right answers get a point and wrong answers get nothing.
     *
     * @param addCarrie       is if the "Carrie" box is checked or not.
     * @param addStarWars is if the "Star Wars" box is checked or not.
     * @param addHillsHave      is if the "Hills Have Eyes" box is checked or not.
     * @param addSaturday       is if the "Saturday Night Fever" box is checked or not.
     * @param addProblemChild           is if the "Problem Child" box is checked or not.
     * @param addLastStarfighter       is if the "Last Starfighter" box is checked or not.
     * @param addSpaceCamp         is if the "Space Camp" box is checked or not.
     * @param addDennis        is if the "Dennis" box is checked or not.
     * @return the points scored by selecting the correct checkboxes.
     */

    private int calculateCheckBoxPoints(boolean addCarrie, boolean addStarWars,
                                        boolean addHillsHave, boolean addSaturday,
                                        boolean addProblemChild, boolean addLastStarfighter,
                                        boolean addSpaceCamp, boolean addDennis) {
        int checkBoxPoints = 0;

        if (addCarrie) {
        checkBoxPoints += 1;
        }

        if (addStarWars) {
            checkBoxPoints += 1;
        }

        if (addHillsHave) {
//            Incorrect answer - Don't count
        }

        if (addSaturday) {
//          Incorrect answer - Don't count
        }
        if (addProblemChild) {
//            Incorrect answer - Don't count
        }

        if (addLastStarfighter) {
            checkBoxPoints += 1;
        }

        if (addSpaceCamp) {
            //            Incorrect answer - Don't count

        }

        if (addDennis) {
            checkBoxPoints += 1;
        } else {
//            Incorrect answer - Don't count
        }

        return checkBoxPoints;
    }

    /**
     * This method checks and scores Question #5
     *
     * @param question5Answer is the input answer of Q5.
     * @return a point if the answer matches A. case is ignored.
     */

    private int checkQuestion5(String question5Answer) {
        int question5Point = 0;

        if ("7".equalsIgnoreCase(question5Answer)) {
            question5Point = 1;
        }
        return question5Point;
    }

    /**
     * This method checks and scores Question #6
     *
     * @param question6Answer is the input answer of Q6.
     * @return a point if the answer matches Psycho. case is ignored.
     */

    private int checkQuestion6(String question6Answer) {
        int question6Point = 0;

        if ("psycho".equalsIgnoreCase(question6Answer)) {
            question6Point = 1;
        }
        return question6Point;
    }
}