package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <a href = "https://www.acmicpc.net/problem/16935">백준 16935번 - 구현 : 배열 돌리기 3</a>
 * <br>
 * <a href = "https://velog.io/@jky00914/%EB%B0%B1%EC%A4%80-16935%EB%B2%88-%EB%B0%B0%EC%97%B4-%EB%8F%8C%EB%A6%AC%EA%B8%B0-3">velog</a>
 * @since 2025-01-05
 */
public class BJ_16935 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < r; i++) {
            int num = Integer.parseInt(st.nextToken());

            arr = solve(num, arr, n, m);

            n = arr.length;
            m = arr[0].length;
        }

        StringBuilder sb = new StringBuilder();

        for (int[] row : arr) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int[][] solve(int num, int[][] arr, int n, int m) {

        int[][] newArr = new int[n][m];

        switch (num) {
            case 1:
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        newArr[j][i] = arr[n - j - 1][i];
                    }
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        newArr[i][j] = arr[i][m - j - 1];
                    }
                }
                break;
            case 3:
                newArr = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        newArr[i][j] = arr[n - j - 1][i];
                    }
                }
                break;
            case 4:
                newArr = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        newArr[i][j] = arr[j][m - i - 1];
                    }
                }
                break;
            case 5:
                //1->2
                for (int i = 0; i < n / 2; i++) {
                    for (int j = m / 2; j < m; j++) {
                        newArr[i][j] = arr[i][j - m / 2];
                    }
                }
                //2->3
                for (int i = n / 2; i < n; i++) {
                    for (int j = m / 2; j < m; j++) {
                        newArr[i][j] = arr[i - n / 2][j];
                    }
                }
                //3->4
                for (int i = n / 2; i < n; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        newArr[i][j] = arr[i][m / 2 + j];
                    }
                }
                //4->1
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        newArr[i][j] = arr[i + n / 2][j];
                    }
                }
                break;
            case 6:
                //1->4
                for (int i = n / 2; i < n; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        newArr[i][j] = arr[i - n / 2][j];
                    }
                }
                //4->3
                for (int i = n / 2; i < n; i++) {
                    for (int j = m / 2; j < m; j++) {
                        newArr[i][j] = arr[i][j - m / 2];
                    }
                }
                //3->2
                for (int i = 0; i < n / 2; i++) {
                    for (int j = m / 2; j < m; j++) {
                        newArr[i][j] = arr[i + n / 2][j];
                    }
                }
                //2->1
                for (int i = 0; i < n / 2; i++) {
                    for (int j = 0; j < m / 2; j++) {
                        newArr[i][j] = arr[i][m / 2 + j];
                    }
                }
                break;
        }

        return newArr;
    }
}