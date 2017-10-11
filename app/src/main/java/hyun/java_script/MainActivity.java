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
        System.out.println("line 32" +  aQuestion);
        switch(v.getId()){
            case R.id.randomBtn:
                Toast.makeText(getApplicationContext(),"QUESTION!!",Toast.LENGTH_LONG).show();
                questionTv.setText(aQuestion);
                break;
            case R.id.hintBtn:
                Toast.makeText(getApplicationContext(),"DON'T WORK", Toast.LENGTH_LONG).show();
                break;
            case R.id.giveupBtn:
                answerDialog(aQuestion);
                break;
        }
    }

    public void answerDialog(String theQuestion) {
        Alert alert = new Alert();
        String answer = getAnswer(theQuestion);
        System.out.println("LINE62" + answer);
        alert.passMessage(answer);
        DialogFragment newFragment = new Alert();
        System.out.println("LINE65" + answer);
        newFragment.show(getSupportFragmentManager(), "Question");
    }

    private String getAnswer(String theQuestion) {
        String answer = questions.getAnswer(theQuestion);
        System.out.println("line 71 - main - answer" +  answer);
        return answer;
    }
}
