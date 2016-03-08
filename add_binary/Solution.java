// A simple but slow version, took 25ms
public class Solution {
    public String addBinary(String a, String b) {
        String[] a_array;
        String[] b_array;
        // make sure than a is the longer one, which is used as outer loop
        if (a.length() > b.length()) {
            a_array = a.split("");
            b_array = b.split("");
        } else {
            a_array = b.split("");
            b_array = a.split("");
        }
        int a_len = a_array.length;
        int b_len = b_array.length;
        int carry_bit = 0;
        int result_bit = 0;
        int m, n; // used for index through bits
        List<String> result = new ArrayList();
        for (int i = 0; i < a_len; i++) {
            m = a_len - 1 - i;
            if (i < b_len) {
                n = b_len - 1 - i;
                int temp = Integer.parseInt(a_array[m]) + Integer.parseInt(b_array[n]) + carry_bit;
                carry_bit = temp / 2;
                result_bit = temp - carry_bit * 2;
            } else {
                int temp = Integer.parseInt(a_array[m]) + carry_bit;
                carry_bit = temp / 2;
                result_bit = temp - carry_bit * 2;
            }
            result.add(0, Integer.toString(result_bit));
        }
        if (carry_bit == 1) {
            result.add(0, Integer.toString(carry_bit));
        }
        return String.join("", result);
    }
}