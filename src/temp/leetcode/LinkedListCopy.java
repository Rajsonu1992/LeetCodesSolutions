package temp.leetcode;


class Node {
    Node next;
    int value;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListCopy {
    Node head;

    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void reverseList() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Save the next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to the current node
            current = next; // Move current to the next node
        }

        // Update the head of the reversed list
        head = prev;
    }


    public void print() {
        Node node = head;

        while (node != null) {
            System.out.println(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
