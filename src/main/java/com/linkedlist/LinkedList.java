package com.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {

        private int value;
        private Node next;

        public  Node(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    private Node first;
    private Node last;
    public int size;

    public void addLast(int item) {

        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;

    }

    public void addFirst(int item) {

        Node node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {

        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index ++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {

        emptyListException();

        if (first == last)
            first = last = null;
        else {

            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {

        emptyListException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    private void emptyListException() {
        if (isEmpty())
            throw new NoSuchElementException();
    }

    public Node getPrevious(Node node) {

        var current = first;
        while(current.next != null) {
            if (current.next == node) return current;
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {

        int[] array  = new int[size];

        var current = first;
        int index = 0;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {

        if (isEmpty()) return;

        var previous = first;
        var current = first.next;

        while (current != null) {

            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheLast(int k) {

        if (isEmpty())
            throw new IllegalStateException();

        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;

            if(b == null)
                throw new IllegalStateException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }
}
