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

    public Questions(){

    }

    public static String questions(){
        int len = questionList.size();
        int index = random.nextInt(len);
        String theQuestion = questionList.get(index);

        questionMap.put(questionList.get(index),answerList.get(index));
        return theQuestion;
    }

    public static String getAnswer(String theQuestion) {
        String answer = "" ;

        for(String key : questionMap.keySet()) {
            System.out.println("LINE 57 TRUTHY: " + key.equals(theQuestion));
            if(key.equals(theQuestion)) {
                System.out.println("LINE 57- MAP-SETTING" + questionMap.get(key));
                answer = questionMap.get(key);
            }
        }
        System.out.println("LINE 56 - QUESTION'S ANSWER" + answer);
        return answer;
    }
    //TODO: make the hint button work!
   public String getHint(String theQuestion) {
        String hint = "";

        return hint;
    }
}
