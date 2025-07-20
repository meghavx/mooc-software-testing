package tudelft.roman;

import java.util.*;

public class RomanNumeral {

    private static final Map<Character, Integer> symbToNumMap;
    private static final Map<Integer, String> numToSymbMap;

    static {
        symbToNumMap = new HashMap<>();
        symbToNumMap.put('I', 1);
        symbToNumMap.put('V', 5);
        symbToNumMap.put('X', 10);
        symbToNumMap.put('L', 50);
        symbToNumMap.put('C', 100);
        symbToNumMap.put('D', 500);
        symbToNumMap.put('M', 1000);
        
        numToSymbMap = new TreeMap<>(Collections.reverseOrder());
        numToSymbMap.put(1, "I");
        numToSymbMap.put(4, "IV");
        numToSymbMap.put(5, "V");
        numToSymbMap.put(9, "IX");
        numToSymbMap.put(10, "X");
        numToSymbMap.put(40, "XL");
        numToSymbMap.put(50, "L");
        numToSymbMap.put(90, "XC");
        numToSymbMap.put(100, "C");
        numToSymbMap.put(400, "CD");
        numToSymbMap.put(500, "D");
        numToSymbMap.put(900, "CM");
        numToSymbMap.put(1000, "M");
    }

    public int convert(String s) {
        int convertedNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = symbToNumMap.get(s.charAt(i));
            int next = i + 1 < s.length() ? symbToNumMap.get(s.charAt(i + 1)) : 0;

            // Usually, you add symbol values left to right.
            // BUT: if a smaller numeral comes before a larger
            // one, you subtract it instead. Examples:
            // VI = 5 + 1 = 6
            // IV = 5 - 1 = 4
            // IX = 10 - 1 = 9

            // So, you look ahead just to decide if current is
            // + or -. The next is still added on its own turn.
            convertedNumber += (next <= curr) ? curr : -curr;
        }
        return convertedNumber;
    }

    public String convert(int num) {
        StringBuilder convertedStr = new StringBuilder();

        while (num > 0) {
            for (Integer val : numToSymbMap.keySet()) {
                if (val > num) continue;
                convertedStr.append(numToSymbMap.get(val));
                num -= val;
                break;
            }
        }
        return convertedStr.toString();
    }
}
