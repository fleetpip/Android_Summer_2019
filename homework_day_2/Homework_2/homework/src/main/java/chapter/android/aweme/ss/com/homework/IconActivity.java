package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IconActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icon_page);
        final TextView mTv = findViewById(R.id.text1);
        Button mBt = findViewById(R.id.button2);
        mBt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String data = getIntent().getStringExtra("data");
                Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
            }
        });
    }
}
