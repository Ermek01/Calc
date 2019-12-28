package google.example.com;

import java.util.ArrayList;

public class PrettyResult {
    static public String convert(ArrayList<Integer> numbers, ArrayList<String> operations){
        String result = "";
        for (int i = 0; i < numbers.size(); i++){
            result += numbers.get(i);
            if (i < operations.size()){
                result += operations.get(i);
            }
        }
        return result;
    }
}
