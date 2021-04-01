// recursive code
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> kthSmallest = inorder(root, new ArrayList<Integer>());
        return kthSmallest.get(k-1);
    }
    
    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}

// iterative code (Inorder traversal)
//O(N) time complexity since you look at all elements. You can't do it faster than this time - you don't know what the tree looks like before traversing.
//O(k) space complexity since maximum k items will be in the q at any given time.
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> que = new LinkedList<>();
        
        que.offer(root);
        while(!que.isEmpty()) {
            TreeNode node = que.poll();
            pq.offer(node.val);  // preorder --> node.val --> node.left-->node.right
            if(node.left != null) {
                que.offer(node.left);
            }
            
            if(node.right != null) {
                que.offer(node.right);
            }
        }
        return getKthSmallest(pq, k);
    }
    private int getKthSmallest(PriorityQueue<Integer> pq ,  int k) {
        while(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
