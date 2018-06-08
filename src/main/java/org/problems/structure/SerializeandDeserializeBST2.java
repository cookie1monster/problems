package org.problems.structure;

//https://leetcode.com/problems/serialize-and-deserialize-bst/description/
public class SerializeandDeserializeBST2 {

    static class Codec {

        private void bstToArr(TreeNode node, StringBuilder data) {
            if (node == null) {
                data.append("# ");
                return;
            }

            data.append(node.val + " ");
            bstToArr(node.left, data);
            bstToArr(node.right, data);
        }

        private TreeNode arrToBST(String[] data, int[] index) {
            if ("#".equals(data[index[0]]))
                return null;

            TreeNode node = new TreeNode(Integer.parseInt(data[index[0]]));
            index[0]++;
            node.left = arrToBST(data, index);
            index[0]++;
            node.right = arrToBST(data, index);
            return node;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder data = new StringBuilder();
            bstToArr(root, data);
            return data.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] tree = data.split("\\s+");
            return arrToBST(tree, new int[1]);
        }
    }

    public static void main(String[] args) {

        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(3);
        TreeNode r3 = new TreeNode(4);
        TreeNode rr3 = new TreeNode(6);
        l1.left = l2;
        l1.right = r2;
        l2.left = l3;
        l2.right = r3;
        r2.right = rr3;
        Codec codec = new Codec();
        String str = codec.serialize(l1);
        TreeNode newRoot = codec.deserialize(str);
        System.out.println(str);
    }

}
