package Baekjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * <a href = "https://www.acmicpc.net/problem/28707">백준 28707번 - 해시 : 배열 정렬</a>
 * <br>
 * <a href = "https://velog.io/@jky00914/%EB%B0%B1%EC%A4%80-28707%EB%B2%88-%EB%B0%B0%EC%97%B4-%EC%A0%95%EB%A0%AC">velog</a>
 *
 * @since 2024-10-04
 */
public class BJ_28707 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] init = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            init[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[][] op = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            op[i][0] = Integer.parseInt(st.nextToken()) - 1;
            op[i][1] = Integer.parseInt(st.nextToken()) - 1;
            op[i][2] = Integer.parseInt(st.nextToken());
        }

        int[] target = init.clone();
        Arrays.sort(target);

        PriorityQueue<State> qu = new PriorityQueue<>();
        qu.offer(new State(init, 0));

        HashMap<String, Integer> visit = new HashMap<>();
        visit.put(Arrays.toString(init), 0);

        //다익스트라 수행
        while (!qu.isEmpty()) {

            State now = qu.poll();

            if (Arrays.equals(target, now.arr)) {
                System.out.println(now.cost);
                return;
            }

            for (int[] o : op) {
                int l = o[0];
                int r = o[1];
                int c = o[2];

                int[] clone = now.arr.clone();

                //l번째와 r번째 swap
                int temp = clone[l];
                clone[l] = clone[r];
                clone[r] = temp;

                int newCost = now.cost + c;
                String newState = Arrays.toString(clone);

                if (!visit.containsKey(newState) || visit.get(newState) > newCost) {
                    qu.offer(new State(clone, newCost));
                    visit.put(newState, newCost);
                }
            }
        }

        System.out.println(-1);
    }

    static class State implements Comparable<State> {

        int[] arr;
        int cost;

        public State(int[] arr, int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        @Override
        public int compareTo(State o) {
            return this.cost - o.cost;
        }
    }
}