import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			// Number of test cases
			int t = sc.nextInt();

			for (int i = 0; i < t; i++) {
				// size of array
				int n = sc.nextInt();
				// jump length
				int m = sc.nextInt();

				// array content
				List<Integer> list = new ArrayList<>(n);
				for (int j = 0; j < n; j++) {
					list.add(sc.nextInt());
				}

				boolean[] visited = new boolean[n];
				if (hasReached(list, 0, m, visited)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	public static boolean hasReached(List<Integer> list, int currIndex, int m, boolean[] visited) {
		if (currIndex >= list.size()) {
			return true;
		} else if (currIndex < 0 || list.get(currIndex) != 0 || visited[currIndex]) {
			return false;
		} else {
			visited[currIndex] = true;
			return hasReached(list, currIndex - 1, m, visited) || hasReached(list, currIndex + 1, m, visited)
					|| hasReached(list, currIndex + m, m, visited);
		}
	}
}
