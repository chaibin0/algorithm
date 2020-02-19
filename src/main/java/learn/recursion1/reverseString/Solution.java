package learn.recursion1.reverseString;

public class Solution {

    public void reverseString(char[] s) {
        subRoutine(0, s);
    }

    //subRoutine을 start end로도 가능하다.
    public void subRoutine(int index, char[] s) {
        if (index == s.length / 2) {
            return;
        }

        int lastIndex = s.length - index - 1;
        swap(index, lastIndex, s);
        subRoutine(index + 1, s);
    }

    public void swap(int first, int second, char[] s) {
        char temp = s[first];
        s[first] = s[second];
        s[second] = temp;
    }
}
