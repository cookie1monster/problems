package org.problems.structure;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateBinarySearchTreeTest {

    @Test
    public void test1() {
        TreeNode l1 = new TreeNode(4);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(5);
        TreeNode l3 = new TreeNode(1);
        TreeNode r3 = new TreeNode(3);
        TreeNode rr3 = new TreeNode(6);
        l1.left = l2;
        l1.right = r2;
        l2.left = l3;
        l2.right = r3;
        r2.right = rr3;
        assertTrue(ValidateBinarySearchTree.isValidBST(l1));
        assertTrue(ValidateBinarySearchTree2.isValidBST(l1));
    }

    @Test
    public void test2() {
        TreeNode l1 = new TreeNode(10);
        TreeNode l2 = new TreeNode(5);
        TreeNode r2 = new TreeNode(15);
        TreeNode r22 = new TreeNode(6);
        TreeNode rr3 = new TreeNode(20);
        l1.left = l2;
        l1.right = r2;
        r2.right = rr3;
        r2.left = r22;
        assertFalse(ValidateBinarySearchTree.isValidBST(l1));
        assertFalse(ValidateBinarySearchTree2.isValidBST(l1));
    }


    @Test
    public void test22() {
        TreeNode l1 = new TreeNode(10);
        TreeNode l2 = new TreeNode(5);
        TreeNode r2 = new TreeNode(15);
        TreeNode r22 = new TreeNode(11);
        TreeNode rr3 = new TreeNode(20);
        l1.left = l2;
        l1.right = r2;
        r2.right = rr3;
        r2.left = r22;
        assertTrue(ValidateBinarySearchTree.isValidBST(l1));
        assertTrue(ValidateBinarySearchTree2.isValidBST(l1));
    }

    @Test
    public void test3() {
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(1);
        TreeNode r2 = new TreeNode(3);
        TreeNode rr2 = new TreeNode(2);
        l1.left = l2;
        l1.right = r2;
        l2.right = rr2;

        assertFalse(ValidateBinarySearchTree.isValidBST(l1));
        assertFalse(ValidateBinarySearchTree2.isValidBST(l1));
    }

    @Test
    public void test4() {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(1);
        l1.right = l2;

        assertFalse(ValidateBinarySearchTree.isValidBST(l1));
        assertFalse(ValidateBinarySearchTree2.isValidBST(l1));
    }
}
