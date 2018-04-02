package org.problems.structure;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class LinkedListCycleTest {

    @Test
    public void shouldHasNoCycle() {
        assertSame(false, LinkedListCycle.hasCycle(new LinkedListCycle.ListNode(1)));
    }

    @Test
    public void shouldHasNoCycleForNull() {
        assertSame(false, LinkedListCycle.hasCycle(null));
    }

    @Test
    public void shouldHasCycle() {
        LinkedListCycle.ListNode l1 = new LinkedListCycle.ListNode(1);
        LinkedListCycle.ListNode l2 = new LinkedListCycle.ListNode(2);
        LinkedListCycle.ListNode l3 = new LinkedListCycle.ListNode(3);
        LinkedListCycle.ListNode l4 = new LinkedListCycle.ListNode(4);
        LinkedListCycle.ListNode l5 = new LinkedListCycle.ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;

        assertSame(true, LinkedListCycle.hasCycle(l1));
    }
}
