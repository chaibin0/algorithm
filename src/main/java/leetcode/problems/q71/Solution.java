package leetcode.problems.q71;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

class Solution {

    private final static String DIRECTORY_UP = "..";
    private final static String CURRENT_DIRECTORY = ".";

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(path, "/");

        while (st.hasMoreTokens()) {
            String nextPath = st.nextToken();

            switch (nextPath) {
                case DIRECTORY_UP:
                    deque.pollLast();
                    break;
                case CURRENT_DIRECTORY:
                    break;
                default:
                    deque.addLast(nextPath);
            }
        }

        StringJoiner answer = new StringJoiner("/");
        answer.add("");
        for (String directoryName : deque) {
            answer.add(directoryName);
        }

        return !answer.toString().isEmpty() ? answer.toString() : "/";
    }
}


