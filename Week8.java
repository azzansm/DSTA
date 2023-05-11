public class Week8 {
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public static int totalNodes(Node root){
        if (root == null)
            return 0;

        int leftNodes = totalNodes(root.left);
        int rightNodes = totalNodes(root.right);

        return 1 + leftNodes + rightNodes;
    }

    public static void main(String args[]){
        Node root = new Node(6);
        root.right = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);

        System.out.println("Total Nodes = " + totalNodes(root));
    }
}
