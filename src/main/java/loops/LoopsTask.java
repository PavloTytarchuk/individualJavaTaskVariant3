package loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoopsTask {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            numbers.add(Integer.parseInt(reader.readLine()));
        }

        Collections.sort(numbers);
        System.out.println("Minimal number is: " + numbers.get(0));

        int counter = 0;
        int position = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) >= 0) {
                counter++;
                if (counter == 2) {
                    position = i + 1;
                    break;
                }
            }
        }
        System.out.println("Position of the second positive number is: " + position);
    }

}


