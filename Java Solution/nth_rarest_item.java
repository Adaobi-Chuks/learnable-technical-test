import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class nth_rarest_item {

    public static void main(String[] args) {

        int[] num = {4,4,4,4,3,3,3,2,2,1};
        System.out.println(nth_most_rate(num, 3));

    }
    
    public static int nth_most_rate (int[] list, int n) {

        //Get the list of occurred numbers
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            if (!numbers.contains(list[i])) {
                numbers.add(list[i]);
            }
        }

        //Link the occured numbers to the amount of occurance
        HashMap<Integer, Integer> occuranceAndNumber = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.length; j++) {
                if(numbers.get(i) == list[j]) {
                    count++;
                }
            }
            occuranceAndNumber.put(numbers.get(i), count);
        }

        //Arrange the amount of occurrance in ascending order
        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < occuranceAndNumber.size(); i++) {
            values.add(occuranceAndNumber.get(numbers.get(i)));
        }
        Collections.sort(values);

        //Return the number at the required position
        for (int i = 0; i < numbers.size(); i++) {
            if(values.get(n - 1) == occuranceAndNumber.get(numbers.get(i))) {
                return numbers.get(i);
            };
        }
        return 0;

    }

}
