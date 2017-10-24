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

    // TODO: USER SHOULD ACCESS TO HINTS (3) TIMES A DAY?

    @Override
    public void onClick(View v) {
        String aQuestion = questions.questions();
        String displayedQuestion = questionTv.getText().toString();

        switch(v.getId()){
            case R.id.randomBtn:
                Toast.makeText(getApplicationContext(),"QUESTION!!",Toast.LENGTH_SHORT).show();
                questionTv.setText(aQuestion);
                break;
            case R.id.hintBtn:
                Toast.makeText(getApplicationContext(),"HINT", Toast.LENGTH_SHORT).show();
                answerDialog(displayedQuestion,"hint");
                break;
            case R.id.giveupBtn:
                Toast.makeText(getApplicationContext(),"GIVE UP", Toast.LENGTH_SHORT).show();
                answerDialog(displayedQuestion,"answer");
                break;
        }
    }

    public void answerDialog(String theQuestion, String display) {
        Alert alert = new Alert();
        DialogFragment newFragment = new Alert();
        String answer;
        String hint;

        if(display.equals("answer")) {
            answer = getAnswer(theQuestion);
            alert.passMessage(answer);
        } else {
            hint = questions.getHint(theQuestion);
            alert.passMessage(hint);
        }
        newFragment.show(getSupportFragmentManager(), "Question");
    }

    private String getAnswer(String theQuestion) {return questions.getAnswer(theQuestion);}
}
