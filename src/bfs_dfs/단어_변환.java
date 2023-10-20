package bfs_dfs;

public class 단어_변환 {
    private int answer;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        swap(begin, target, words, 0);

        return answer;
    }

    private void swap(String cur, String target, String[] words, int count) {
        if (cur.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && diff(cur, words[i]) == 1) {
                visited[i] = true;
                swap(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    private int diff(String s1, String s2) {
        int numDiff = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                numDiff++;
            }
        }

        return numDiff;
    }
}
