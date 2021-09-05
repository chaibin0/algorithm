package problems.q43;

class Solution {
    public String multiply(String num1, String num2) {

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int num1Length = num1.length();
        int num2Length = num2.length();

        String answer = "0";
        for (int i = 0; i < num1Length; i++) {
            for (int j = 0; j < num2Length; j++) {
                StringBuilder sb = new StringBuilder("");

                int length_0 = num1Length + num2Length - i - j - 2;
                int num1Value = Character.getNumericValue(num1.charAt(i));
                int num2Value = Character.getNumericValue(num2.charAt(j));

                sb.append(num1Value * num2Value);
                sb.append(get0(length_0));

                answer = plus(answer, sb.toString());
            }
        }

        return answer;
    }

    public String get0(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }

        return sb.toString();
    }

    public String plus(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int num1Length = num1.length();
        int num2Length = num2.length();

        int minSize = Math.min(num1Length, num2Length);
        boolean flag = false;
        int i;
        for (i = 0; i < minSize; i++) {
            int value = Character.getNumericValue(num1.charAt(num1Length - 1 - i)) + Character.getNumericValue(num2.charAt(num2Length - 1 - i)) + (flag ? 1 : 0);
            sb.append(value % 10);
            flag = value > 9 ? true : false;
        }

        while (i < num1.length()) {
            int value = Character.getNumericValue(num1.charAt(num1Length - 1 - i)) + (flag ? 1 : 0);
            sb.append(value % 10);
            flag = value > 9 ? true : false;
            i++;
        }

        while (i < num2.length()) {
            int value = Character.getNumericValue(num2.charAt(num2Length - 1 - i)) + (flag ? 1 : 0);
            sb.append(value % 10);
            flag = value > 9 ? true : false;
            i++;
        }

        if(flag){
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}