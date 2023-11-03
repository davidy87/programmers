package PCCP_모의고사;

public class 유전법칙 {

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = search(queries[i][0], queries[i][1]);
        }

        return answer;
    }

    private String search(int n, int p) {
        if (n == 1) {
            return "Rr";
        }

        int numPerGen = (int) Math.pow(4, n - 1);
        int numPerPea = numPerGen / 4;

        if (p <= numPerPea) {
            return "RR";
        } else if (p > numPerPea * 3) {
            return "rr";
        } else if (n == 2) {
            return "Rr";
        } else if (p <= numPerGen / 2) {
            return search(n - 1, p - numPerPea);
        }

        return search(n - 1, p - numPerGen / 2);
    }
}
