import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Escape {
	public static void main(String[] args) {
		Escape t = new Escape();
		t.run();
	}
	void run() {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < T; i++) {
			int K = sc.nextInt();
			int W = sc.nextInt();
			int H = sc.nextInt();
			sc.skip("\n");
			char[][] grid = new char[H][W];
			HashMap<Character, Integer> diff = new HashMap<>();
			for(int j = 0; j < K; j++) {
				String c = sc.next();
				int temp = sc.nextInt();
				diff.put(c.charAt(0), temp);
			}
			sc.skip("\n");
			Integer[] startPos = {-1,-1};
			for(int row = 0; row < H; row++) {
				String s = sc.nextLine();
				for(int col = 0; col < W; col++) {
					grid[row][col] = s.charAt(col);
					if(s.charAt(col)=='E') {
						startPos[0] = row;
						startPos[1] = col;
					}
				}
			}
			boolean[][] visited = new boolean[H][W];
			int[][] cost = new int[H][W];
			visited[startPos[0]][startPos[1]] = true;
			PriorityQueue<Integer[]> q = new PriorityQueue<>(new comp());
			q.add(new Integer[] {0,startPos[0],startPos[1]});
			int minCost = Integer.MAX_VALUE;
			while(!q.isEmpty()) {
				Integer[] top = q.poll();
				int h = top[1];
				int w = top[2];
				if(h-1>=0) {
					if(!visited[h-1][w]) {
						visited[h-1][w] = true;
						cost[h-1][w] = cost[h][w]+diff.get(grid[h-1][w]);
						q.add(new Integer[] {cost[h-1][w],h-1,w});
					}
				} else {
					if(cost[h][w] < minCost) minCost = cost[h][w];
				}
				if(h+1<H) {
					if(!visited[h+1][w]) {
						visited[h+1][w] = true;
						cost[h+1][w] = cost[h][w]+diff.get(grid[h+1][w]);
						q.add(new Integer[] {cost[h+1][w],h+1,w});
					}
				} else {
					if(cost[h][w] < minCost) minCost = cost[h][w];
				}
				if(w-1>=0) {
					if(!visited[h][w-1]) {
						visited[h][w-1] = true;
						cost[h][w-1] = cost[h][w]+diff.get(grid[h][w-1]);
						q.add(new Integer[] {cost[h][w-1],h,w-1});
					}
				} else {
					if(cost[h][w] < minCost) minCost = cost[h][w];
				}
				if(w+1<W) {
					if(!visited[h][w+1]) {
						visited[h][w+1] = true;
						cost[h][w+1] = cost[h][w]+diff.get(grid[h][w+1]);
						q.add(new Integer[] {cost[h][w+1],h,w+1});
					}
				} else {
					if(cost[h][w] < minCost) minCost = cost[h][w];
				}
			}
			System.out.println(minCost);
		}
		sc.close();
	}

    static class comp implements Comparator<Integer[]>{

        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[0].compareTo(o2[0]);
        }

    }
}
