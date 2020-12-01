package google.example.com;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LauncherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.calc1_btn:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.calc2_btn:
                Intent intent1 = new Intent(this, NumbersActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
