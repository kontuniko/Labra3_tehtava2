package fi.mobtietoliikenne.labra3_tehtava2volley;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.concurrent.ExecutionException;

import static com.android.volley.Request.Method.GET;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etAddressInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartNavigation).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

            etAddressInput = (EditText) findViewById(R.id.etAddress);
            final TextView tvDataOutput = (TextView) findViewById(R.id.tvDataOutput);

            RequestQueue queue = Volley.newRequestQueue(this);
            String url = etAddressInput.getText().toString();
            Log.d("DEBUG******", "url: " + url);


            //Request a string response from URL
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            //Display characters
                            tvDataOutput.setText(" " + response);
                            Log.d("DEBUG", "response: " + response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    tvDataOutput.setText("ERROR! Something went wrong");
                }
            });
            //Add Request
            queue.add(stringRequest);
        }
    }