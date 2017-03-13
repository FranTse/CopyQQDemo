package an.com.copyqqdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView textView = (TextView)findViewById(R.id.second_activity_text);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("key"));
    }
}
