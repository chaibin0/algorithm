package kick.start2011.round_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int testSize = Integer.parseInt(br.readLine());
            for (int i = 0; i < testSize; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                String S = br.readLine();
                System.out.printf("Case #%d: %d\n", i + 1, solve(N, K, S));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int n, int k, String s) {
        int count = 0;
        int size = n / 2;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                count++;
            }
        }

        return Math.abs(count - k);
    }
}
