package algo.bfs_dfs;

public class 단어_변환 {

    private int answer;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        search(words, 0, begin, target);
        return answer;
    }

    private void search(String[] words, int count, String cur, String target) {
        if (cur.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && diff(cur, words[i]) == 1) {
                visited[i] = true;
                search(words, count + 1, words[i], target);
                visited[i] = false;
            }
        }
    }

    private int diff(String a, String b) {
        int numDiff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                numDiff++;
            }
        }

        return numDiff;
    }
}
