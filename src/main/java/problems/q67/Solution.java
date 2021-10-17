package problems.q67;

class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int minLength = Math.min(aLength, bLength);
        int i;
        boolean isTwo = false;
        for (i = 0; i < minLength; i++) {
            int aNum = Character.getNumericValue(a.charAt(aLength - i - 1));
            int bNum = Character.getNumericValue(b.charAt(bLength - i - 1));

            int sum = aNum + bNum + (isTwo ? 1 : 0);
            if (sum > 1) {
                sb.append(sum - 2);
                isTwo = true;
            } else {
                sb.append(sum);
                isTwo = false;
            }
        }

        while (i < aLength) {
            int aNum = Character.getNumericValue(a.charAt(aLength - i - 1));
            int sum = aNum + (isTwo ? 1 : 0);
            if (sum > 1) {
                sb.append(sum - 2);
                isTwo = true;
            } else {
                sb.append(sum);
                isTwo = false;
            }
            i++;
        }

        while (i < bLength) {
            int bNum = Character.getNumericValue(b.charAt(bLength - i - 1));
            int sum = bNum + (isTwo ? 1 : 0);
            if (sum > 1) {
                sb.append(sum - 2);
                isTwo = true;
            } else {
                sb.append(sum);
                isTwo = false;
            }
            i++;
        }

        if (isTwo) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}