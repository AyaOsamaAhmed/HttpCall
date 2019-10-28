package com.example.httpcall;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;




//https://www.youtube.com/watch?v=X91Jp19cgyw
public class VolleyClass extends AppCompatActivity {

    @BindView(R.id.text_result)
    TextView textResult;

    DataModel   dataModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_class);
        ButterKnife.bind(this);
        dataModel = new DataModel();
// Instantiate the RequestQueue.
        final RequestQueue queue = Volley.newRequestQueue(VolleyClass.this);
        String url = "http://hwsrv-434369.hostwindsdns.com/api/CarModels/GetAllCarModels?brandId=10";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textResult.setText("Response is: " + response.substring(0, 500));
                        queue.stop();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textResult.setText("That didn't work!");
                error.printStackTrace();
                queue.stop();
            }
        });

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            dataModel.setStatus(response.getString("status"));
                            dataModel.setStatus(response.getString("message"));
                            dataModel.setStatus(response.getString("result"));
                            setData();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest);

    }

    private void setData() {


    }
}
