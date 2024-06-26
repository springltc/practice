package com.example.coding.lec热题100.简单.链表;

import com.example.coding.lec经典150.链表.model.ListNode;

/**
 * @author liutc
 * @date 2024/5/30 17:04
 */

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) { //4
        //1->2->3->4->5
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }

    public ListNode reverseList2(ListNode head) { //4
        //1->2->3->4->5
        if (head == null || head.next == null) {
            /*
                直到当前节点的下一个节点为空时返回当前节点
                由于5没有下一个节点了，所以此处返回节点5
             */
            return head;
        }
        //递归传入下一个节点，目的是为了到达最后一个节点
        ListNode newHead = reverseList(head.next); //5
        //ListNode newHead = reverseList(1);
        //ListNode newHead = reverseList(2);
        //ListNode newHead = reverseList(3); --> 1->2->3<-4<-5
        //ListNode newHead = reverseList(4); --> 1->2->3->4<-5  head为4
        //ListNode newHead = reverseList(5); -->head为5
                /*
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         */
        head.next.next = head; //5->4
        head.next = null;      //4->null
        return newHead;
    }
}
