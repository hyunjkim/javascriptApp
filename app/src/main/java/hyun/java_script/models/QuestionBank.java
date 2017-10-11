package hyun.java_script.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hyun on 10/11/17.
 */

public class QuestionBank {

    public QuestionBank(){

    }

    public static List<String> getQuestionList(){
     List<String> questionList = new ArrayList<>(
            Arrays.asList(
                    "Can you name two programming paradigms important for JavaScript app developers?",
                    "What is functional programming?",
                    "What is the difference between classical inheritance and prototypal inheritance?",
                    "What is JavaScript?",
                    "What are the primitive Datatypes?"

            ));
     return questionList;
    }
    public static List<String> getAnswerList(){
        List <String> answerList = new ArrayList<>(
                Arrays.asList(
                        "Prototypal inheritance (also: prototypes, OLOO) or Functional programming (also: closures, first class functions, lambdas)",
                        "Pure functions/Haskell/first-class functions, higher order functions, functions as arguments/values",
                        "In JavaScript, prototypal inheritance is simpler & more flexible than class inheritance.",
                        " is a programming language that is run by most modern browsers",
                        "Boolean, Null, Undefined, Number, String, Symbol"
                )
        );
     return answerList;
    }
}
