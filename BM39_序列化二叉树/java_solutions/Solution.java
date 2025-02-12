package BM39_序列化二叉树.java_solutions;

public class Solution {
    public String Serialize(TreeNode root) {
        if(root == null) return "#";

        StringBuilder strBuilder = new StringBuilder();
        serializeFunction(root, strBuilder);
        return strBuilder.toString();
    }

    private void serializeFunction(TreeNode root, StringBuilder strBuilder){
        if(root == null) {
            strBuilder.append("#");
            return;
        }

        strBuilder.append(root.val).append("!");
        serializeFunction(root.left, strBuilder);
        serializeFunction(root.right, strBuilder);
    }


    private int index = 0;

    public TreeNode Deserialize(String str) {
        if(str.equals("#")) return null;

        index = 0;
        return deserializeFunction(str);
    }

    private TreeNode deserializeFunction(String str){
        if(index == str.length()) return null;
        
        if(str.charAt(index) == '#') {
            index++;
            return null;
        }

        int num = 0;
        while (index < str.length() && str.charAt(index) != '!') {
            num = num*10 + (str.charAt(index) - '0');
            index++;
        }
        TreeNode root = new TreeNode(num);

        index++;
        root.left = deserializeFunction(str);
        root.right = deserializeFunction(str);

        return root;
    }
}