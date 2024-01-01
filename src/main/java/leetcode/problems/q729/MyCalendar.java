package leetcode.problems.q729;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

class MyCalendar {

    TreeMap<Integer, Integer> endToStartMap = new TreeMap<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> latestEndToStart = endToStartMap.lowerEntry(start + 1);

        if (Objects.isNull(latestEndToStart)) {
            endToStartMap.put(end, start);
            return true;
        }



        if (latestEndToStart.getValue() < end) {
            return false;
        }

        endToStartMap.put(end, start);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
