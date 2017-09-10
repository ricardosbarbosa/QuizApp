package com.github.ricardosbarbosa.quizapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    public static final int MAX_SCORE = 4;

    private EditText editTextQuastion1;

    private CheckBox checkBoxBrigadeio;
    private CheckBox checkBoxteChocolate;
    private CheckBox checkBoxCupcake;
    private CheckBox checkBoxDonut;
    private CheckBox checkBoxIceCream;
    private CheckBox checkBoxPacoca;

    private RadioButton radioButtonAstroboy;
    private RadioButton radioButtonBugroid;
    private RadioButton radioButtonEve;

    private RadioButton radioButton2006;
    private RadioButton radioButton2007;
    private RadioButton radioButton2008;
    private RadioButton radioButton2009;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editTextQuastion1 = (EditText) findViewById(R.id.edittext_question1);
        checkBoxBrigadeio = (CheckBox) findViewById(R.id.check_brigadeiro);
        checkBoxteChocolate = (CheckBox) findViewById(R.id.check_chocolate);
        checkBoxCupcake = (CheckBox) findViewById(R.id.check_cupcake);
        checkBoxDonut = (CheckBox) findViewById(R.id.check_donut);
        checkBoxIceCream = (CheckBox) findViewById(R.id.check_icecream);
        checkBoxPacoca = (CheckBox) findViewById(R.id.check_paçoca);
        radioButtonAstroboy = (RadioButton) findViewById(R.id.radio_astroboy);
        radioButtonBugroid = (RadioButton) findViewById(R.id.radio_bugroid);
        radioButtonEve = (RadioButton) findViewById(R.id.radio_eve);
        radioButton2006 = (RadioButton) findViewById(R.id.radio_2006);
        radioButton2007 = (RadioButton) findViewById(R.id.radio_2007);
        radioButton2008 = (RadioButton) findViewById(R.id.radio_2008);
        radioButton2009 = (RadioButton) findViewById(R.id.radio_2009);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = validateForm();

                if (result != null && result.isEmpty())
                    result = checkScore();

                Snackbar.make(view, result, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private String checkScore() {
        Integer score = 0;

        if (editTextQuastion1.getText().toString().toUpperCase().equals(getString(R.string.answer_question_1).toUpperCase()))
            score += 1;

        if (checkBoxCupcake.isChecked() && checkBoxDonut.isChecked() && checkBoxIceCream.isChecked() &&
            !checkBoxBrigadeio.isChecked() && !checkBoxteChocolate.isChecked()&& !checkBoxPacoca.isChecked())
            score += 1;

        if (radioButtonBugroid.isChecked())
            score += 1;

        if (radioButton2008.isChecked())
            score += 1;

        return String.format(Locale.getDefault(), "Seu score é %d de %d", score, MAX_SCORE);
    }

    private String validateForm() {
        StringBuilder result = new StringBuilder();

        //question 1
        if (editTextQuastion1.getText().toString().trim().isEmpty())
            result.append(getString(R.string.question1_validate));

        //question 2
        else if (!checkBoxBrigadeio.isChecked() &&
                !checkBoxteChocolate.isChecked() &&
                !checkBoxCupcake.isChecked() &&
                !checkBoxDonut.isChecked() &&
                !checkBoxIceCream.isChecked() &&
                !checkBoxPacoca.isChecked())
            result.append(getString(R.string.question2_validate));

        //question 3
        else if (!radioButtonAstroboy.isChecked() &&
                !radioButtonBugroid.isChecked() &&
                !radioButtonEve.isChecked())
            result.append(getString(R.string.question3_validate));

        //question 4
        else if (!radioButton2006.isChecked() &&
                !radioButton2007.isChecked() &&
                !radioButton2008.isChecked() &&
                !radioButton2009.isChecked())
            result.append(getString(R.string.question4_validate));

        return result.toString();
    }
}
