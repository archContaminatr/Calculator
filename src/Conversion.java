import java.util.Map;
import java.util.Set;

public class Conversion {
    static Map<String, Integer> numbers = Map.ofEntries(
            Map.entry("I", 1),
            Map.entry("II", 2),
            Map.entry("III", 3),
            Map.entry("IV", 4),
            Map.entry("V", 5),
            Map.entry("VI", 6),
            Map.entry("VII", 7),
            Map.entry("VIII", 8),
            Map.entry("IX", 9),
            Map.entry("X", 10));

     public static Integer toArabic(String numRoman) throws Exception {
        if (numbers.get(numRoman) == null) {
            throw new Exception("Kolya pi");
        } else {return numbers.get(numRoman);}
    }

    public static String toRoman(Integer numArabic) {
        StringBuilder answer = new StringBuilder();
//        String answer = ""; // stringBuilder (append(), toString())
        if (numArabic/100 > 0) {
            int k = numArabic/100;
            numArabic %= 100;
            for (int i = 0; i < k; i++) {
                answer.append("C");
            }
        }
        if (numArabic/90 > 0) {
            int k = numArabic/90;
            numArabic %= 90;
            for (int i = 0; i < k; i++) {
                answer.append("XC");
            }
        }
        if (numArabic/50 > 0) {
            int k = numArabic/50;
            numArabic %= 50;
            for (int i = 0; i < k; i++) {
                answer.append("L");
            }
        }
        if (numArabic/40 > 0) {
            int k = numArabic/40;
            numArabic %= 40;
            for (int i = 0; i < k; i++) {
                answer.append("XL");
            }
        }
        if (numArabic/10 > 0) {
            int k = numArabic/10;
            numArabic %= 10;
            for (int i = 0; i < k; i++) {
                answer.append("X");
            }
        }
        Set<String> keys = numbers.keySet();
        for (String currentKey: keys) {
            if (numArabic.equals(numbers.get(currentKey))) {
                answer.append(currentKey);
            }
        }
        return answer.toString();
    }
}
