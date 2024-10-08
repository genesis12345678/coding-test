package Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * <a href = "https://www.acmicpc.net/problem/13913">백준 13913번 - 그래프 탐색 : 숨바꼭질 4</a>
 * <br>
 * <a href = "https://velog.io/@jky00914/%EB%B0%B1%EC%A4%80-13913%EB%B2%88-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88-4">velog</a>
 * @since 2024-09-06
 */
public class BJ_13913 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] path = new int[100_001];
        boolean[] visit = new boolean[100_001];

        Queue<Integer> qu = new ArrayDeque<>();
        qu.offer(n);

        visit[n] = true;

        while (!qu.isEmpty()) {

            int now = qu.poll();

            if (now == k) {
                break;
            }

            if (now - 1 >= 0 && !visit[now - 1]) {
                qu.offer(now - 1);
                visit[now - 1] = true;
                path[now - 1] = now;
            }
            if (now + 1 <= 100_000 && !visit[now + 1]) {
                qu.offer(now + 1);
                visit[now + 1] = true;
                path[now + 1] = now;
            }
            if (now * 2 <= 100_000 && !visit[now * 2]) {
                qu.offer(now * 2);
                visit[now * 2] = true;
                path[now * 2] = now;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();

        int now = k;

        while (now != n) {
            stack.push(now);
            now = path[now];
        }

        System.out.println(stack.size());

        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}
