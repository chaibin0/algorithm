package kick.start2011.round_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionFailed {

    private static int R;
    private static int C;

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCase = Integer.parseInt(br.readLine());

            for (int test = 1; test <= testCase; test++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                R = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                int[][] graph = new int[R][C];

                for (int i = 0; i < R; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < C; j++) {
                        graph[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                int result = solve(graph);
                System.out.printf("Case #%d: %d\n", test, result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int[][] graph) {

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != 1) {
                    continue;
                }
                answer += getLShape(i, j, graph);
            }
        }

        return answer;
    }

    private static int getLShape(int r, int c, int[][] graph) {
        int count = 0;
        int rowLength;
        int columnLength;

        // 아래 오른쪽
        rowLength = 1;
        for (int i = r + 1; i < R; i++) {
            if (graph[i][c] != 1) {
                break;
            }

            rowLength++;
            columnLength = 1;
            int maxRowLength = rowLength * 2;
            for (int j = c + 1; j < maxRowLength; j++) {
                if (graph[i][j] != 1) {
                    break;
                }

                columnLength++;

                if (rowLength * 2 == columnLength || columnLength * 2 == rowLength) {
                    count++;
                }
            }
        }

        // 아래 왼쪽
        rowLength = 1;
        for (int i = r + 1; i < R; i++) {
            if (graph[i][c] != 1) {
                break;
            }

            rowLength++;
            columnLength = 1;
            int maxRowLength = rowLength * 2;

            for (int j = c - 1; j >= C - maxRowLength; j--) {
                if (graph[i][j] != 1) {
                    break;
                }

                columnLength++;

                if (rowLength * 2 == columnLength || columnLength * 2 == rowLength) {
                    count++;
                }
            }
        }

        // 위 왼쪽
        rowLength = 1;
        for (int i = r - 1; i >= 0; i--) {
            if (graph[i][c] != 1) {
                break;
            }

            rowLength++;
            int maxRowLength = rowLength * 2;
            columnLength = 1;
            for (int j = c - 1; j >= C - maxRowLength; j--) {
                if (graph[i][j] != 1) {
                    break;
                }

                columnLength++;

                if (rowLength * 2 == columnLength || columnLength * 2 == rowLength) {
                    count++;
                }
            }
        }

        // 위 오른쪽
        rowLength = 1;
        for (int i = r - 1; i >= 0; i--) {
            if (graph[i][c] != 1) {
                break;
            }

            rowLength++;
            columnLength = 1;
            int maxRowLength = rowLength * 2;
            for (int j = c + 1; j < maxRowLength; j++) {
                if (graph[i][j] != 1) {
                    break;
                }

                columnLength++;

                if (rowLength * 2 == columnLength || columnLength * 2 == rowLength) {
                    count++;
                }
            }
        }

        return count;
    }
}
