package algo.bfs_dfs;

public class 타겟_넘버 {
    public int solution(int[] numbers, int target) {
        return calc(numbers, target, 0, 0);
    }

    private int calc(int[] numbers, int target, int cur, int i) {
        if (i == numbers.length) {
            return cur == target ? 1 : 0;
        }

        return calc(numbers, target, cur + numbers[i], i + 1) + calc(numbers, target, cur - numbers[i], i + 1);
    }
}
