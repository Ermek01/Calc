package google.example.com;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<String> operations = new ArrayList<>();

    Integer number;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        textView = findViewById(R.id.tvControl);

        Intent intent = getIntent();
        ArrayList<Integer> numbers2 = intent.getIntegerArrayListExtra("numbers");
        ArrayList<String> operations2 = intent.getStringArrayListExtra("operations");

        if (numbers2 != null){
            numbers = numbers2;
        }

        if (operations2 != null){
            operations = operations2;
        }

        textView.setText(PrettyResult.convert(numbers, operations));
    }

    public void onNumersClick(View v){
        switch (v.getId()){
            case R.id.btn_zero:
                number = 0;
                break;
            case R.id.btn_one:
                number = 1;
                break;
            case R.id.btn_two:
                number = 2;
                break;
            case R.id.btn_three:
                number = 3;
                break;
            case R.id.btn_four:
                number = 4;
                break;
            case R.id.btn_five:
                number = 5;
                break;
            case R.id.btn_six:
                number = 6;
                break;
            case R.id.btn_seven:
                number = 7;
                break;
            case R.id.btn_eight:
                number = 8;
                break;
            case R.id.btn_nine:
                number = 9;
                break;
            case R.id.plus:
                numbers.add(number);
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("numbers", numbers);
                intent.putExtra("operations", operations);
                startActivity(intent);
                break;
        }
    }

    public void onNextClick(View v){
        numbers.add(number);
        Intent intent = new Intent(this, OperationsActivity.class);
        intent.putExtra("numbers", numbers);
        intent.putExtra("operations", operations);
        startActivity(intent);
    }
}
