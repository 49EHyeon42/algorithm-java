class Solution {
    
    public List<Integer> preorder(Node root) {
        return dfs(root, new ArrayList<>());
    }

    private List<Integer> dfs(Node root, List<Integer> list) {
        if (root == null) {
            return list;
        }

        list.add(root.val);

        for (Node child : root.children) {
            list = dfs(child, list);
        }
        
        return list;
    }
}
