package kakao.blind._2023.lv3;

public class 표현_가능한_이진트리 {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String fullBin = getFullBinary(numbers[i]);
            answer[i] = inorder(fullBin) ? 1 : 0;
        }

        return answer;
    }

    private boolean inorder(String bin) {
        int len = bin.length();

        if (len == 1) {
            return true;
        }

        String leftSubTree = bin.substring(0, len / 2);
        String rightSubTree = bin.substring(len / 2 + 1);

        char root = bin.charAt(len / 2);
        char leftChild = leftSubTree.charAt(leftSubTree.length() / 2);
        char rightChild = rightSubTree.charAt(rightSubTree.length() / 2);

        if (root == '0' && (leftChild == '1' || rightChild == '1')) {
            return false;
        }

        return inorder(leftSubTree) && inorder(rightSubTree);
    }

    private String getFullBinary(long n) {
        String bin = Long.toBinaryString(n);
        int numFullNodes = 1;
        int h = 1;

        while (numFullNodes < bin.length()) {
            h *= 2;
            numFullNodes += h;
        }

        return "0".repeat(numFullNodes - bin.length()) + bin;
    }
}
