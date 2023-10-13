package tree;

import java.util.*;

public class 길_찾기_게임 {

    private int idx = 0;

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Arrays.sort(nodes, (n1, n2) -> n1.y == n2.y ? n1.x - n2.x : n2.y - n1.y);
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            makeTree(root, nodes[i]);
        }

        int[][] answer = new int[2][nodes.length];
        preorder(answer, root);
        idx = 0;
        postorder(answer, root);

        return answer;
    }

    private void postorder(int[][] answer, Node curNode) {
        if (curNode != null) {
            postorder(answer, curNode.left);
            postorder(answer, curNode.right);
            answer[1][idx++] = curNode.value;
        }
    }

    private void preorder(int[][] answer, Node curNode) {
        if (curNode != null) {
            answer[0][idx++] = curNode.value;
            preorder(answer, curNode.left);
            preorder(answer, curNode.right);
        }
    }

    private void makeTree(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                makeTree(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                makeTree(parent.right, child);
            }
        }
    }

    private static class Node {
        int x, y, value;
        Node left, right;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
