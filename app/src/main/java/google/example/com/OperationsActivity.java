package google.example.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class OperationsActivity extends AppCompatActivity {

    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<String> operations = new ArrayList<>();

    String operation;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);

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

        Log.d("ololo", numbers.toString());
        Log.d("ololo", operations.toString());
        textView.setText(PrettyResult.convert(numbers, operations));
    }

    public void onOperationsClick(View v){
        switch (v.getId()){
            case R.id.btn_plus:
                operation = "+";
                break;
            case R.id.btn_minus:
                operation = "-";
                break;
            case R.id.btn_div:
                operation = "/";
                break;
            case R.id.btn_multiply:
                operation = "*";
                break;
        }
    }

    public void onNextClick(View v){
        operations.add(operation);
        Intent intent = new Intent(this, NumbersActivity.class);
        intent.putExtra("numbers", numbers);
        intent.putExtra("operations", operations);
        startActivity(intent);
    }
}
