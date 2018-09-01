package org.problems.structure;

import java.util.NoSuchElementException;

public class ImplementQueue {

    public static void main(String[] args) {
        System.out.println();
    }

    class MyQueue<T> {
        class Node<T> {
            T val;
            Node<T> next, prev;

            public Node(T val) {
                this.val = val;
            }
        }

        private Node<T> head, tail;

        public MyQueue() {

        }

        public void push(T x) {
            Node<T> node = new Node<>(x);
            if (tail == null) {
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
        }


        public T pop() {
            if (head == null)
                throw new NoSuchElementException();
            Node<T> node = head;
            head = head.next;
            if (head == null) {
                tail = null;
            } else {
                head.prev = null;
            }
            return node.val;
        }


        public T peek() {
            if (head == null)
                throw new NoSuchElementException();
            return head.val;
        }

        public boolean empty() {
            return head == null;
        }

    }
}
