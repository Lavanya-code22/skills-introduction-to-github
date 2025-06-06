import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val; this.left = left; this.right = right;
    }
}

public class Solution3 {
    ArrayList<TreeNode> list;

    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        return recursive(0, list.size() - 1);
    }

    public TreeNode recursive(int l, int h) {
        if (l > h) return null;
        int mid = (l + h) / 2;
        TreeNode head = list.get(mid);
        head.left = recursive(l, mid - 1);
        head.right = recursive(mid + 1, h);
        return head;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    // Build tree from level order input with "null" as empty nodes
    public TreeNode buildTreeFromLevelOrder(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < nodes.length) {
            TreeNode current = queue.poll();
            if (current == null) continue;

            // left child
            if (i < nodes.length && !nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            // right child
            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Inorder print
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Serialize tree to level order with "null" for missing nodes
    public List<String> serializeLevelOrder(TreeNode root) {
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
                continue;
            }
            result.add(String.valueOf(node.val));
            queue.add(node.left);
            queue.add(node.right);
        }

        // Remove trailing nulls
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution3 sol = new Solution3();

        System.out.println("Enter BST nodes in level order (use 'null' for empty nodes), separated by spaces:");
        String line = sc.nextLine();
        String[] nodes = line.trim().split("\\s+");

        TreeNode root = sol.buildTreeFromLevelOrder(nodes);
        TreeNode balancedRoot = sol.balanceBST(root);

        System.out.println("Inorder traversal of balanced BST:");
        sol.printInorder(balancedRoot);
        System.out.println();

        System.out.println("Level order serialization of balanced BST:");
        List<String> serialized = sol.serializeLevelOrder(balancedRoot);
        System.out.println(serialized);

        sc.close();
    }
}
