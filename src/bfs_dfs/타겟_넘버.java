package bfs_dfs;

public class 타겟_넘버 {
    private int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;
        calc(numbers, target, 0, 0);

        return answer;
    }

    private void calc(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            answer += sum == target ? 1 : 0;
            return;
        }

        calc(numbers, target, idx + 1, sum - numbers[idx]);
        calc(numbers, target, idx + 1, sum + numbers[idx]);
    }
}
