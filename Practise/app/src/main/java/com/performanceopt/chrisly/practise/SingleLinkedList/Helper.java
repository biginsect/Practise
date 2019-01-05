package com.performanceopt.chrisly.practise.SingleLinkedList;

/**
 * @author big insect
 * @date 2019/1/5.
 */
public class Helper {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        linkedList.insertNode(n1);
        linkedList.insertNode(n2);
        linkedList.insertNode(n3);
        linkedList.insertNode(n4);
        linkedList.insertNode(n5);
        System.out.println(linkedList.length());
//        linkedList.printList();

//        linkedList.deleteAt(6);
//        linkedList.printList();
//        linkedList.deleteNode("3");
//        linkedList.printList();
        Node head = LinkedList.reverseList(linkedList.header);
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
