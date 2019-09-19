package com.example.android.gsonapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.gsonapplication.Network.RetrofitClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // TextView.
    TextView Result;

    // Own Interface has methods [GET, POST, PUT, PATCH, DELETE].
    JsonPlaceHolderAPI jsonPlaceHolderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get TextView By ID.
        Result = (TextView) findViewById(R.id.txt_view_result);

        // Connect RetrofitClient Class that has 'Base URL' with Interface that has 'Relative URL' & methods.
        jsonPlaceHolderAPI = RetrofitClient.getClient().create(JsonPlaceHolderAPI.class);

        // Call method.
//        getPost();
        // Call method.
//        createPost();

        // Call method.
//        updatePost();

        // Call method.
         deletePost();
    }

    // getPost method.
    private void getPost() {
        /**
         * From jsonPlaceHolderAPI Interface, call getPost method to declare it here.
         *
         * There are 4 options, uncomment one and try it.
         **/

        // Get all data.
//        Call<List<PostClass>> call = jsonPlaceHolderAPI.getPost();

        // Get data of userId = 2 only send it into getPost() as a param.
//        Call<List<PostClass>> call = jsonPlaceHolderAPI.getPost(2);

        // Get data of userId = '2 & 4' only Sorted by 'id' Ordered by 'desc'  send it into getPost() as a params.
//        Call<List<PostClass>> call = jsonPlaceHolderAPI.getPost(new Integer[] {2, 4}, "id", "desc");

        // Get data from URL By Making HashMap take keys of url and its values
        //  key 'userId' with its value '1'
        //  key '_sort' with its  value 'id'
        //  key '_order' with its  value 'desc' & send it into getPost() as a param.
        Map<String, String> params = new HashMap<>();
        params.put("userId", "1");
        params.put("_sort", "id");
        params.put("_order", "desc");

        Call<List<PostClass>> call = jsonPlaceHolderAPI.getPost(params);


        // 'enqueue' method works in background thread, that mean it will not effect on UI.
        call.enqueue(new Callback<List<PostClass>>() {
            // When get response.
            @Override
            public void onResponse(Call<List<PostClass>> call, Response<List<PostClass>> response) {
                // Check if response not successful.
                if (!response.isSuccessful()) {
                    // setText by the code.
                    Result.setText("Code " + response.code());

                    // Stop.
                    return;
                }
                // Otherwise.
                // 'response.body()' get all data from response & convert it into List<PostClass>.
                List<PostClass> Posts = response.body();

                // 'for Each' to get all data.
                for (PostClass post : Posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "user ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    // 'append' To store all data into TextView
                    // but 'setText' will setText all the time of loop then will get last data only.
                    Result.append(content);
                }
            }

            // When get failure.
            @Override
            public void onFailure(Call<List<PostClass>> call, Throwable t) {
                // setText of error message.
                Result.setText(t.getMessage());
            }
        });
    }

    private void createPost() {
        /**
         * From jsonPlaceHolderAPI Interface, call createPost method to declare it here.
         *
         * There are 3 options, uncomment one and try it.
         **/

        // Send params (userId, title, text) into constructor of PostClass.. (id) is generated automatically.
//        PostClass postClass = new PostClass(24, "New Title", "New Body");
        // Send Constructor as a param to createPost method.
//        Call<PostClass> call = jsonPlaceHolderAPI.createPost(postClass);

        // Send data as params to createPost method directly.
//        Call<PostClass> call = jsonPlaceHolderAPI.createPost(28, "New Title", "New Body");

        // Post data to URL By Making HashMap take keys of url and its values
        //  key 'userId' with its value '25'
        //  key 'title' with its  value 'new Title'
        //  end it into createPost() as a param.
        Map<String, String> params = new HashMap<>();
        params.put("userId", "25");
        params.put("title", "new Title");

        Call<PostClass> call = jsonPlaceHolderAPI.createPost(params);

        // 'enqueue' method works in background thread, that mean it will not effect on UI.
        call.enqueue(new Callback<PostClass>() {
            @Override
            public void onResponse(Call<PostClass> call, Response<PostClass> response) {
                // Check if response not successful.
                if (!response.isSuccessful()) {
                    // setText by the code.
                    Result.setText("Code " + response.code());

                    // Stop.
                    return;
                }
                // Otherwise.
                // 'response.body()' get all data from response & convert it into List<PostClass>.
                PostClass PostRespose = response.body();


                String content = "";
                // If Code = 201 that mean data is Created.
                content += "Code: " + response.code() + "\n";
                content += "ID: " + PostRespose.getId() + "\n";
                content += "UserID: " + PostRespose.getUserId() + "\n";
                content += "Title: " + PostRespose.getTitle() + "\n";
                content += "Text: " + PostRespose.getText() + "\n\n";

                // 'setText' for displaying only one data.
                Result.setText(content);
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {
                // setText of error message.
                Result.setText(t.getMessage());
            }
        });
    }

    private void updatePost() {
        // Send params (userId, title, text) directly into constructor of PostClass.. (id) is generated automatically.
        PostClass postClass = new PostClass(20, "Android Developer", null);
        // Send ID & Constructor as a params to putPost or patchPost method.
        Call<PostClass> call = jsonPlaceHolderAPI.putPost(1, postClass);

//        // Send params (userId, title, text) directly into constructor of PostClass.. (id) is generated automatically.
//        PostClass postClass = new PostClass(20, "Android Developer", null);
//        // Send ID & Constructor as a params to putPost or patchPost method.
//        Call<PostClass> call = jsonPlaceHolderAPI.patchPost(1, postClass);

        // 'enqueue' method works in background thread, that mean it will not effect on UI.
        call.enqueue(new Callback<PostClass>() {
            @Override
            public void onResponse(Call<PostClass> call, Response<PostClass> response) {
                // Check if response not successful.
                if (!response.isSuccessful()) {
                    // setText by the code.
                    Result.setText("Code " + response.code());

                    // Stop.
                    return;
                }
                // Otherwise.
                // 'response.body()' get all data from response & convert it into List<PostClass>.
                PostClass PostRespose = response.body();


                String content = "";
                // If Code = 200 that mean data is Updated.
                content += "Code: " + response.code() + "\n";
                content += "ID: " + PostRespose.getId() + "\n";
                content += "UserID: " + PostRespose.getUserId() + "\n";
                content += "Title: " + PostRespose.getTitle() + "\n";
                content += "Text: " + PostRespose.getText() + "\n\n";

                // 'setText' for displaying only one data.
                Result.setText(content);
            }

            @Override
            public void onFailure(Call<PostClass> call, Throwable t) {
                // setText of error message.
                Result.setText(t.getMessage());
            }
        });
    }

    private void deletePost() {
        // Send ID deletePost method.
        Call<Void> call = jsonPlaceHolderAPI.deletePost(5);

        // 'enqueue' method works in background thread, that mean it will not effect on UI.
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                // Check if response not successful.
                if (!response.isSuccessful()) {
                    // setText by the code.
                    Result.setText("Code " + response.code());

                    // Stop.
                    return;
                }
                // Otherwise.
                // 'setText' for displaying only one data.
                // If Code = 200 that mean data is updated.
                Result.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // setText of error message.
                Result.setText(t.getMessage());
            }
        });
    }
}
