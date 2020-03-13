package problems.twosum;

import java.util.HashMap;
import java.util.Map;

/*
    2개의 합 구하기
    hashMap 이용
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = toMap(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int value = target - nums[i];
            // 값이 존재할경우 2개 인덱스 저장하고 반환
            if (map.containsKey(value) && map.get(value) != i) {
                return saveAnswer(i, map.get(value));
            }
        }

        return null;
    }

    /**
     * @return 2개의 값을 int 배열로 초기화후 반환
     */
    public int[] saveAnswer(int firstIndex, int secondIndex) {
        return new int[]{firstIndex, secondIndex};
    }

    /***
     * (value, index) 형태로 Map에 저장
     */
    public Map<Integer, Integer> toMap(final int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            map.put(nums[index], index);
        }

        return map;
    }

}
