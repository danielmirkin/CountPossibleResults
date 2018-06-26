import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CountPossibleResults {
    public static void main(String[] args) {
        Map <Integer,Integer> totalResultsMap = new HashMap<Integer,Integer>();
        int x = 1;
        int res[] = {0, 1, 3};
        while (totalResultsMap.size() < 40) {
            int[] myIntArray = new int[4];
            for (int j = 1; j <= 3; j++) {
                int[] myTempArray = new int[4];
                myTempArray[0] = (getRandom(res));
                if (myTempArray[0] == 0)
                    myTempArray[j] = 3;
                else if (myTempArray[0] == 1)
                    myTempArray[j] = 1;
                else if (myTempArray[0] == 3)
                    myTempArray[j] = 0;
                myIntArray[0] += myTempArray[0];
                myIntArray[j] += myTempArray[j];
            }

            for (int j = 2; j <= 3; j++) {
                int[] myTempArray = new int[4];
                myTempArray[1] = (getRandom(res));
                if (myTempArray[1] == 0)
                    myTempArray[j] = 3;
                else if (myTempArray[1] == 1)
                    myTempArray[j] = 1;
                else if (myTempArray[1] == 3)
                    myTempArray[j] = 0;
                myIntArray[1] += myTempArray[1];
                myIntArray[j] += myTempArray[j];
            }

            int[] myTempArray = new int[4];
            myTempArray[2] = (getRandom(res));
            if (myTempArray[2] == 0)
                myTempArray[3] = 3;
            else if (myTempArray[2] == 1)
                myTempArray[3] = 1;
            else if (myTempArray[2] == 3)
                myTempArray[3] = 0;
            myIntArray[2] += myTempArray[2];
            myIntArray[3] += myTempArray[3];
            Arrays.sort(myIntArray);
            /**
             * The reason for such an ugly number calculation, is because if i will check that the int[] value
             * doesn't contain within the hashMap it will use equals() which will always return false, since it compares two array objects and not their values
             */
            int number = 1000*myIntArray[0] + 100*myIntArray[1] + 10*myIntArray[2] + myIntArray[3];
            if (!totalResultsMap.containsValue(number)) {
                totalResultsMap.put(x, number);
                System.out.println(x + ": " + Arrays.toString(myIntArray));
                x++;
            }
        }
    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}