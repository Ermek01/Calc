package google.example.com;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button zero, one, two, three, four, five, six, seven, eight, nine, clear, equal,
    minus, plus, divide, multiply;
    TextView tvResult;
    Double val1;
    Double val2;
    String operation;
    Double result;
    String rawOperand = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = findViewById(R.id.btn_zero);
        one = findViewById(R.id.btn_one);
        two = findViewById(R.id.btn_two);
        three = findViewById(R.id.btn_three);
        four = findViewById(R.id.btn_four);
        five = findViewById(R.id.btn_five);
        six = findViewById(R.id.btn_six);
        seven = findViewById(R.id.btn_seven);
        eight = findViewById(R.id.btn_eight);
        nine = findViewById(R.id.btn_nine);
        minus = findViewById(R.id.btn_minus);
        plus = findViewById(R.id.btn_plus);
        divide = findViewById(R.id.btn_div);
        multiply = findViewById(R.id.btn_multiply);
        equal = findViewById(R.id.btn_equal);
        tvResult = findViewById(R.id.tvResult);
        clear = findViewById(R.id.btn_clear);

        if (savedInstanceState != null) {
            val1 = savedInstanceState.getDouble("first");
            val2 = savedInstanceState.getDouble("second");
            operation = savedInstanceState.getString("oper");
            rawOperand = savedInstanceState.getString("rawOper");
            result = savedInstanceState.getDouble("result");
        }


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (val1 != null){
            outState.putDouble("first", val1);
        } if (val2 != null){
            outState.putDouble("second", val2);
        } if (rawOperand != null){
            outState.putString("rawOper", rawOperand);
        } if (operation != null){
            outState.putString("oper", operation);
        } if (result != null ){
            outState.putDouble("result", result);
        }
    }

    public void onNumberClick(View v) {
        switch (v.getId()) {
            case R.id.btn_zero:
                enterNumber("0");
                break;
            case R.id.btn_one:
                enterNumber("1");
                break;
            case R.id.btn_two:
                enterNumber("2");
                break;
            case R.id.btn_three:
                enterNumber("3");
                break;
            case R.id.btn_four:
                enterNumber("4");
                break;
            case R.id.btn_five:
                enterNumber("5");
                break;
            case R.id.btn_six:
                enterNumber("6");
                break;
            case R.id.btn_seven:
                enterNumber("7");
                break;
            case R.id.btn_eight:
                enterNumber("8");
                break;
            case R.id.btn_nine:
                enterNumber("9");
                break;
            default:
                break;

        }
    }

    public void enterNumber(String number) {
        tvResult.append(number);
        rawOperand += number;
    }

    public void onOperationClick(View v) {
        try {
            if (val1 == null) {
                val1 = Double.parseDouble(rawOperand);
            } else {
                val2 = Double.parseDouble(rawOperand);
            }
            rawOperand = "";
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (v.getId()) {
            case R.id.btn_plus:
                enterOperation("+");
                break;
            case R.id.btn_multiply:
                enterOperation("*");
                break;
            case R.id.btn_div:
                enterOperation("/");
                break;
            case R.id.btn_minus:
                enterOperation("-");
                break;
            case R.id.btn_equal:
                if (operation != null) {
                    switch (operation) {
                        case "+":
                            result = val1 + val2;
                            tvResult.append("=" + result);
                            break;
                        case "*":
                            result = val1 * val2;
                            tvResult.append("=" + result);
                            break;
                        case "/":
                            result = val1 / val2;
                            tvResult.append("=" + result);
                            break;
                        case "-":
                            result = val1 - val2;
                            tvResult.append("=" + result);
                            break;
                        default:
                            break;
                    }
                }
            case R.id.btn_clear:
                if (tvResult.getText().length() > 0) {
                    CharSequence number = tvResult.getText().toString();
                    tvResult.setText(number.subSequence(0, number.length()-1));
                }
            default:
                break;
        }

    }

    public void enterOperation(String operation) {
        tvResult.append(operation);
        this.operation = operation;
    }
}
