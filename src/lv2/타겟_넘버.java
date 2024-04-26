package lv2;

public class 타겟_넘버 {

    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target);
    }

    private int dfs(int[] numbers, int i, int target) {
        if (i == numbers.length) {
            return target == 0 ? 1 : 0;
        }

        return dfs(numbers, i + 1, target + numbers[i]) + dfs(numbers, i + 1, target - numbers[i]);
    }
}
