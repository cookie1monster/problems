package org.problems.structure;

//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
public class VerifyPreorderSerializationofBinaryTree {

    private static String isValidSerialization(String[] data, int[] index) {
        int rootIndex = index[0];
        if (rootIndex >= data.length)
            return null;
        if ("#".equals(data[rootIndex]) && rootIndex < data.length)
            return "#";
        ++index[0];
        String left = isValidSerialization(data, index);
        ++index[0];
        String right = isValidSerialization(data, index);

        if (left == null || right == null || "#".equals(data[rootIndex]))
            return null;

        return data[rootIndex];
    }

    public static boolean isValidSerialization(String preorder) {
        int[] index = new int[]{0};
        String[] data = preorder.split(",");
        return isValidSerialization(data, index) != null && index[0] == data.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("1,#"));
        System.out.println(isValidSerialization("9,#,#,1"));
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
