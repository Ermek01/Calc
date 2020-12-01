package google.example.com;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.tvControl);

        Intent intent = getIntent();
        ArrayList<Integer> numbers = intent.getIntegerArrayListExtra("numbers");
        ArrayList<String> operations = intent.getStringArrayListExtra("operations");

        Integer result = numbers.get(0);
        for (int i = 0; i < numbers.size() - 1; i++){
            switch (operations.get(i)){
                case "+":
                    result += numbers.get(i + 1);
                    break;
                case "-":
                    result -= numbers.get(i + 1);
                    break;
                case "/":
                    result /= numbers.get(i + 1);
                    break;
                case "*":
                    result *= numbers.get(i + 1);
                    break;
            }
        }
        textView.setText(PrettyResult.convert(numbers, operations) + " = " + result.toString());
    }
}
