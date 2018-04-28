package com.varshayadv.finalquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.varshayadv.finalquizapp.R.drawable.a;

public class MainActivity extends AppCompatActivity {

    CheckBox first, second, third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (CheckBox) findViewById(R.id.checkbox1);
        second = (CheckBox) findViewById(R.id.checkbox2);
        third = (CheckBox) findViewById(R.id.checkbox3);
    }

    public void answer1(View view) {
        TextView editTextView = (TextView) findViewById(R.id.edit_text_view);

        EditText nameField = (EditText) findViewById(R.id.edit_text);
        String name = nameField.getText().toString();

        String msg = " ";
        if (name.equalsIgnoreCase("d")) {
            msg = "right";
        } else {
            msg = "wrong";
        }
        editTextView.setText(msg);
    }

    public void answer2(View view) {
        EditText nameField = (EditText) findViewById(R.id.edit_text2);
        String name = nameField.getText().toString();
        String msg = " ";
        if (name.equalsIgnoreCase("y")) {
            msg = "right";
        } else {
            msg = "wrong";
        }
        question2(msg);
    }

    public void question2(String msg) {
        TextView editTextView = (TextView) findViewById(R.id.edit_text_view2);
        editTextView.setText(msg);
    }

    public void answer3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        TextView text = (TextView) findViewById(R.id.radio_text_view);

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio1:
                if (checked) {
                    text.setText("right");
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
            msg = "right";
        else {
            msg = "wrong";
        }
        return msg;
    }

    public void display(String msg) {
        TextView checkbox = (TextView) findViewById(R.id.checkbox_text_view);
        checkbox.setText(msg);
    }

}


