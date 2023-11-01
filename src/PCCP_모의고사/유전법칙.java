package PCCP_모의고사;

public class 유전법칙 {

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int n = queries[i][0];
            int p = queries[i][1];
            answer[i] = n == 1 ? "Rr" : search(n, p);
        }

        return answer;
    }

    public String search(int n, int p) {
        int numPerGen = (int) Math.pow(4, n - 1);

        if (p <= numPerGen / 4) {
            return "RR";
        } else if (p > numPerGen / 4 * 3) {
            return "rr";
        } else if (n == 2) {
            return "Rr";
        } else if (p > numPerGen / 4 && p <= numPerGen / 2) {
            return search(n - 1, p - numPerGen / 4);
        }

        return search(n - 1, p - numPerGen / 2);
    }
}
