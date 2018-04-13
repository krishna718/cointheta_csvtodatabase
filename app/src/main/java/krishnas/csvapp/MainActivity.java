package krishnas.csvapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public TextView txtv;
    public Button bt;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtv=(TextView) findViewById(R.id.textView2);
        bt=(Button) findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senddatatodatabase();
            }
        });
    }
    //the data is read into the list and this list as a row is parsed to the database
    public List<data> csvdata = new ArrayList<>();

    public void senddatatodatabase() {
        InputStreamReader is = null;
        try {
            is = new InputStreamReader(getAssets().open("filename1.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(is);
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                Log.d("MyActivity", "Line :" + line);
                Toast.makeText(MainActivity.this, "The file is being read", Toast.LENGTH_SHORT).show();
                String[] variable = line.split(",");
                data data1 = new data();
                data1.setId(variable[0]);
                data1.setName(variable[1]);
                data1.setCollege(variable[2]);
                data1.setContact_no(Long.parseLong(variable[3]));
                data1.setAddress(variable[4]);
                data1.setSelected(variable[5]);
                csvdata.add(data1);

                Sendtodb bw = new Sendtodb(this);
                bw.execute(data1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

