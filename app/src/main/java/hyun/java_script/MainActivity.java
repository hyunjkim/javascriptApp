package hyun.java_script;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import hyun.java_script.models.Alert;
import hyun.java_script.models.Questions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionTv;
    private Button randomBtn,hintBtn,giveUpBtn;
    private Questions questions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }


    private void setViews() {
        questionTv = (TextView) findViewById(R.id.questionsTV);

        randomBtn = (Button) findViewById(R.id.randomBtn);
        hintBtn = (Button) findViewById(R.id.hintBtn);
        giveUpBtn = (Button) findViewById(R.id.giveupBtn);

        randomBtn.setOnClickListener(this);
        hintBtn.setOnClickListener(this);
        giveUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String aQuestion = questions.questions();
        String displayedQuestion = questionTv.getText().toString();

        switch(v.getId()){
            case R.id.randomBtn:
                Toast.makeText(getApplicationContext(),"QUESTION!!",Toast.LENGTH_LONG).show();
                questionTv.setText(aQuestion);
                break;
            case R.id.hintBtn:
                Toast.makeText(getApplicationContext(),"DON'T WORK", Toast.LENGTH_LONG).show();
                answerDialog(displayedQuestion,"hint");
                break;
            case R.id.giveupBtn:
                System.out.println("LINE54 - DISPLAYED QUESTIONS" + displayedQuestion);
                answerDialog(displayedQuestion,"answer");
                break;
        }
    }

    public void answerDialog(String theQuestion, String display) {
        Alert alert = new Alert();
        DialogFragment newFragment = new Alert();
        String answer;
        String hint;

        if(display == "answer") {
            answer = getAnswer(theQuestion);
            alert.passMessage(answer);
        } else {
            hint = questions.getHint(theQuestion);
            alert.passMessage(hint);
        }
        newFragment.show(getSupportFragmentManager(), "Question");
    }

    private String getAnswer(String theQuestion) {
        return questions.getAnswer(theQuestion);
    }
}
