package com.performanceopt.chrisly.practise.SingleLinkedList;

/**
 * 单链表的操作类
 * @author big insect
 * @date 2019/1/5.
 */
public class LinkedList {

    public Node header;

    public LinkedList(){
        this.header = null;
    }

    /**
     * 插入结点，不允许插入具有相同数据的结点
     * @param newNode 对应结点
     * */
    public void insertNode(Node newNode){
        if (null == newNode){
            return;
        }

        if (header == null){
            header = newNode;
            return;
        }

        Node tmp = header;
        while (tmp.next != null){
            if (tmp.data.equals(newNode.data)){
                return;
            }
            tmp = tmp.next;
        }

        /**在尾部插入结点*/
        tmp.next = newNode;
    }

    /**
     * 删除指定位置的结点
     * @param index position
     * @return <code>true</code> if success, else <code>false</code>
     * */
    public boolean deleteAt(int index){
        if (index < 1 || index > length()){
            System.out.println("index is illegal");
            return false;
        }

        /**删除头结点*/
        if (index == 1){
            header = header.next;
            return true;
        }

        Node pre = header;
        Node current = pre.next;
        /**当前位置*/
        int i = 2;
        while (null != current){
            if (index == i){
                pre.next = current.next;
                return true;
            }else {
                pre = current;
                current = current.next;
                i ++;
            }
        }

        return false;
    }

    /**
     * 删除某结点，其数据为data
     * @return <code>true</code> if success, else <code>false</code>
     * */
    public boolean deleteNode(String data){
       if (length() == 0){
           System.out.println("list is empty");
           return false;
       }

       if (length() == 1){
           if (header.data.equals(data)){
               return true;
           }
       }

       Node pre = header;
       Node current = pre.next;
       while (null != current){
           if (current.data.equals(data)){
               pre.next = current.next;
               return true;
           }
           pre = current;
           current = current.next;
       }
        System.out.println("data not found");
       return false;
    }

    public int length(){
        int result = 0;
        Node node = header;
        while (null != node){
            result ++;
            node = node.next;
        }

        return result;
    }

    public void printList(){
        Node current = header;
        while (null != current){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 遍历法反转链表
     * */
    public static Node reverseList(Node head){

        if (null == head ){
            System.out.println("list is empty");
            return null;
        }

        if (null == head.next){
            System.out.println("list has only one element");
            return head;
        }

        Node pre = head;
        Node current = head.next;
        /**用于辅助current指针的移动*/
        Node tmp;
        while (null != current){
            tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }
        head.next = null;
        return pre;
    }

    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
    }
}
