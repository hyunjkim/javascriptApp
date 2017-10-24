package hyun.java_script.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Hyun on 10/11/17.
 */

public class Questions {

    private static List <String> questionList = new ArrayList<>(
            Arrays.asList(
                    "Can you name two programming paradigms important for JavaScript app developers?",
                    "What is functional programming?",
                    "What is the difference between classical inheritance and prototypal inheritance?",
                    "What is JavaScript?",
                    "What are the the primitive datatypes?",
                    "Difference between function overloading and overriding.",
                    "Space complexity and best time complexity of the merge sort.",
                    "Name 3 methods that enable us to manipulate the context of the keyword 'this'"
                    )
    );
    private static List <String> answerList = new ArrayList<>(
            Arrays.asList(
                    "Prototypal inheritance (also: prototypes, OLOO) or Functional programming (also: closures, first class functions, lambdas)",
                    "Pure functions/Haskell/first-class functions, higher order functions, functions as arguments/values",
                    "In JavaScript, prototypal inheritance is simpler & more flexible than class inheritance.",
                    "JavaScript is a programming language that is run by most modern browsers",
                    "Boolean, Null, Undefined, Number, String, Symbol",
                    "Overloading: Same function name, but different signature(s). Overriding: Same function name and signature(s), but different function definition.",
                    "Both are O(nlog(n))",
                    "Bind, call, and apply"
                    )
    );
    private static Map<String,String> questionMap = new HashMap<>();
    private static Random random = new Random();
    private static String answer = "" ;


    public Questions(){

    }

    public static String questions(){
        int len = questionList.size();
        int index = random.nextInt(len);
        String theQuestion = questionList.get(index);
        String theAnswer = answerList.get(index);

        questionMap.put(theQuestion,theAnswer);

        return theQuestion;
    }

    public static String getAnswer(String theQuestion) {

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
        StringBuffer mHint = new StringBuffer();
        if(split.length > 4) {
           for(int i = 0 ; i < 4 ; i++){
               mHint.append(split[i] + " ");
           }
        }
        return (mHint.length()<=0)? "No Hint" : mHint.toString();
    }
}
