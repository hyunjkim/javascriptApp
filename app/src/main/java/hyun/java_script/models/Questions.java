package hyun.java_script.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Hyun on 10/11/17.
 */

public class Questions {

    private Map<String,String> questionMap = new HashMap<>();
    private Random random = new Random();
    private List <String> questionList = QuestionBank.getQuestionList();
    private List <String> answerList = QuestionBank.getAnswerList();
    private String answer = "";


    public Questions(){

    }

    public String questions(){
        int len = questionList.size();
        int index = random.nextInt(len);
        String theQuestion = questionList.get(index);
        String theAnswer = answerList.get(index);

        questionMap.put(theQuestion,theAnswer);

        return theQuestion;
    }

    public String getAnswer(String theQuestion) {

        for(String key : questionMap.keySet()) {
            if(key.equals(theQuestion)) {
                answer = questionMap.get(key);
            }
        }
        return answer;
    }

    //TODO: fix up the hint a little!
   public String getHint(String question) {
        String mAnswer = getAnswer(question);
        String[] split = mAnswer.split(" ");
        StringBuilder mHint = new StringBuilder();

        if(split.length > 4) {
           for(int i = 0 ; i < 4 ; i++){
               mHint.append(split[i]).append(" ");
           }
        }
        return (mHint.length() <= 0)? "No Hint" : mHint.toString();
    }
}
