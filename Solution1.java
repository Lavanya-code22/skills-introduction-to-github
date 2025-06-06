import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class Solution1 {
    public TreeNode createBST(int nums[], int x, int y) {
        if (x > y) return null;
        int mid = (x + y) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, x, mid - 1);
        root.right = createBST(nums, mid + 1, y);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    // Level-order serialization with nulls included for missing children
    public static List<String> serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add("null");
                continue;
            }
            res.add(String.valueOf(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }

        // Remove trailing "null"s for cleaner output
        int i = res.size() - 1;
        while (i >= 0 && res.get(i).equals("null")) {
            res.remove(i);
            i--;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sorted array elements (space-separated):");
        String inputLine = scanner.nextLine();

        String[] inputStrings = inputLine.trim().split("\\s+");
        int[] nums = new int[inputStrings.length];
        for (int i = 0; i < inputStrings.length; i++) {
            nums[i] = Integer.parseInt(inputStrings[i]);
        }

        Solution1 sol = new Solution1();
        TreeNode root = sol.sortedArrayToBST(nums);

        List<String> serializedTree = serialize(root);
        System.out.println(serializedTree);
    }
}


