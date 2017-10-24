package hyun.java_script.models.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hyun on 10/24/17.
 */

public interface JavascriptQuestions {

    @GET("javascript")
    Call<List<JSQuestions>> getJSQuestions();

    @GET("javascript/answers")
    Call<List<JSAnswers>> getJSAnswers();
}
