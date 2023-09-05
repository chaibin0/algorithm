package leetcode.problems.q1810;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class GridMaster {
    boolean canMove(char direction) {
        return false;
    }

    int move(char direction) {
        return 0;
    }

    boolean isTarget() {
        return false;
    }
}

class Solution {

    private static final char[] DIRECTIONS = {'U', 'D', 'L', 'R'};
    private static final char[] REVERSE_DIRECTIONS = {'D', 'U', 'R', 'L'};

    private static final int[][] POSITIONS = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };

    private Map<int[], Integer> cached;
    private Set<int[]> visited;
    private int answer = Integer.MAX_VALUE;

    public int findShortestPath(GridMaster master) {

        this.cached = new HashMap<>();
        this.visited = new HashSet<>();

        this.visited.add(new int[]{0, 0});
        dfs(master, 0, 0, 0);
        return this.answer != Integer.MAX_VALUE ? this.answer : -1;
    }

    private void dfs(GridMaster master, int r, int c, int sum){

        if(this.visited.contains(new int[]{r, c})){
            return;
        }

        this.visited.add(new int[]{r, c});

        if(master.isTarget()){
            this.answer = Math.min(this.answer, sum);
            return;
        }

        if(cached.containsKey(new int[]{r, c}) && cached.get(new int[]{r, c}) <= sum){
            return;
        }

        cached.put(new int[]{r, c}, sum);

        for(int i=0;i<4;i++){
            if(master.canMove(DIRECTIONS[i])){
                int denoted = master.move(DIRECTIONS[i]);
                dfs(master, r + POSITIONS[i][0], c + POSITIONS[i][1], sum + denoted);
                master.move(REVERSE_DIRECTIONS[i]);
            }
        }

        this.visited.remove(new int[]{r, c});
    }
}
