package com.varshayadv.finalquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.attr.name;
import static android.R.attr.right;
import static android.R.attr.x;
import static com.varshayadv.finalquizapp.R.drawable.a;
import static com.varshayadv.finalquizapp.R.id.radio1;

public class MainActivity extends AppCompatActivity {

    CheckBox first, second, third;
    TextView checkbox,editTextView1,editTextView,text;
    EditText nameField;
    String name,name1;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (CheckBox) findViewById(R.id.checkbox1);
        second = (CheckBox) findViewById(R.id.checkbox2);
        third = (CheckBox) findViewById(R.id.checkbox3);
    }

    public void answer1(View view) {
        editTextView = (TextView) findViewById(R.id.edit_text_view);

        EditText nameField = (EditText) findViewById(R.id.edit_text);
        name = nameField.getText().toString();

        String msg = " ";
        if (name.equalsIgnoreCase("d")) {
            msg = "right";
            x=1;
        } else {
            msg = "wrong";
        }
        editTextView.setText(msg);
    }

    public void answer2(View view) {
        nameField = (EditText) findViewById(R.id.edit_text2);
        name1 = nameField.getText().toString();
        String msg = " ";
        if (name1.equalsIgnoreCase("y")) {
            msg = "right";
            x=x+1;

        } else {
            msg = "wrong";
        }
        question2(msg);
    }

    public void question2(String msg) {
        editTextView1 = (TextView) findViewById(R.id.edit_text_view2);
        editTextView1.setText(msg);
    }

    public void answer3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        text = (TextView) findViewById(R.id.radio_text_view);

        // Check which radio button was clicked
        switch (view.getId()) {
            case radio1:
                if (checked) {
                    text.setText("right");
                    x=x+1;
                }
                break;
            case R.id.radio2:
                if (checked) {
                    text.setText("wrong");
                }
                break;
        }
    }

    public void answer4(View view) {
        boolean firstCheckbox = first.isChecked();
        boolean secondCheckox = second.isChecked();
        boolean thirdCheckbox = third.isChecked();

        String ans = answerchk(firstCheckbox, secondCheckox, thirdCheckbox);
        display(ans);
    }

    public String answerchk(boolean afirst, boolean asecond, boolean athird) {
        String msg = " ";

        if (afirst && asecond)
            msg = "wrong";
        else if (asecond && athird)
           msg = "wrong";
       else if (afirst && athird)
        { msg = "right";
        x=x+1;
       }
        else {
            msg = "wrong";
        }
        return msg;
    }

    public void display(String msg) {
        checkbox = (TextView) findViewById(R.id.checkbox_text_view);
        checkbox.setText(msg);
    }

    public void score(View view){
        TextView score=(TextView)findViewById(R.id.score_text_view);
        score.setText("SCORE = "+x);}}

