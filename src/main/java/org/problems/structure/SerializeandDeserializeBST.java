package org.problems.structure;

import java.util.Arrays;

//https://leetcode.com/problems/serialize-and-deserialize-bst/description/
public class SerializeandDeserializeBST {

    static class Codec {

        private Integer[] bstToArr(TreeNode node, Integer[] tree, int index) {
            if (node == null)
                return tree;
            if (tree.length <= index) {
                tree = Arrays.copyOf(tree, index + 1);
            }

            tree[index] = node.val;
            tree = bstToArr(node.left, tree, 2 * index + 1);
            tree = bstToArr(node.right, tree, 2 * index + 2);
            return tree;
        }

        private TreeNode arrToBST(String[] tree, int index) {
            if (index >= tree.length || tree[index].length() == 0)
                return null;

            TreeNode node = new TreeNode(Integer.parseInt(tree[index]));
            node.left = arrToBST(tree, 2 * index + 1);
            node.right = arrToBST(tree, 2 * index + 2);
            return node;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Integer[] tree = new Integer[8];
            tree = bstToArr(root, tree, 0);
            StringBuilder data = new StringBuilder(3 * tree.length);
            for (Integer val : tree) {
                if (val != null)
                    data.append(String.valueOf(val));
                data.append('#');
            }
            return data.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] tree = data.split("#");
            return arrToBST(tree, 0);
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
