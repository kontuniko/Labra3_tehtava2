package fi.mobtietoliikenne.labra3_tehtava2volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etAddressInput;
    TextView tvDataOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartNavigation).setOnClickListener(this);
        tvDataOutput = (TextView) findViewById(R.id.tvDataOutput);
    }

    @Override
    public void onClick(View view) {
        DownloadTask task = new DownloadTask();
        EditText editText = findViewById(R.id.etAddress);
        try {
            String vastaus = task.execute(editText.getText().toString()).get();
            tvDataOutput.setText(vastaus);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
