package lv3;

public class 단어_변환 {

    private int answer = 0;
    private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        search(begin, target, words, 0);
        return answer;
    }

    private void search(String cur, String target, String[] words, int count) {
        if (cur.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int diff = 0;

            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
            }

            if (diff == 1) {
                visited[i] = true;
                search(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }
}
