package org.example;


class LinkedListNode
{
    Integer number;
    LinkedListNode nextNode;
    LinkedListNode(Integer number)
    {
        this.number=number;
        this.nextNode=null;
    }
}

public class LinkedList {
    LinkedListNode first;

    LinkedList() {
        this.first = null;
    }
    LinkedList(LinkedListNode node)
    {
        this.first=node;
    }
    public void insert_at_end(Integer number) {
        if (this.first == null) {
            this.first = new LinkedListNode(number);
        } else {
            LinkedListNode node = new LinkedListNode(number);
            LinkedListNode temp = this.first;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = node;
        }
    }

    public void insert_at_begin(Integer number) {
        if (this.first == null) {
            this.first = new LinkedListNode(number);
        } else {
            LinkedListNode node = new LinkedListNode(number);
            node.nextNode = this.first;
            this.first = node;
        }
    }

    public void delete_at_begin() {
        if (this.first == null) {
            System.out.println("Empty linked list. Cannot delete");
        } else {
            this.first = this.first.nextNode;
        }
    }

    public void delete_at_end() {
        if (this.first == null) {
            System.out.println("Empty linked list. Cannot delete");
        } else {
            LinkedListNode temp1 = this.first;
            LinkedListNode temp2 = temp1;
            while (temp1.nextNode != null) {
                temp2 = temp1;
                temp1 = temp1.nextNode;
            }
            temp2.nextNode = null;
        }
    }

    public void insert_at_pos(int position, Integer number) {
        LinkedListNode node = this.first;
        while (--position != 1)
            node = node.nextNode;
        LinkedListNode newNode = new LinkedListNode(number);
        newNode.nextNode = node.nextNode;
        node.nextNode = newNode;
    }

    public void delete_at_pos(int position) {
        LinkedListNode temp1 = this.first;
        LinkedListNode temp2 = temp1;
        while (--position != 0) {
            temp2 = temp1;
            temp1 = temp1.nextNode;
        }
        temp2.nextNode = temp1.nextNode;
    }

    public void display() {
        LinkedListNode temp = this.first;
        while (temp.nextNode != null) {
            System.out.print(temp.number + "->");
            temp = temp.nextNode;
        }
        System.out.println(temp.number);
    }

    public LinkedList reverseLinkedList() {
        if (this.first == null) {
            return new LinkedList(null); // Handle empty list
        }

        LinkedListNode originalCurrent = this.first;
        LinkedListNode newHead = null;

        while (originalCurrent != null) {
            // Create a new node with the same data
            LinkedListNode newNode = new LinkedListNode(originalCurrent.number);

            // Insert at the head of the new list (to reverse)
            newNode.nextNode = newHead;
            newHead = newNode;

            // Move to the next node in the original list
            originalCurrent = originalCurrent.nextNode;
        }

        return new LinkedList(newHead);
    }

    public String isPalindrome() {
        if(this.first==null)
            return "is Palindrome";
         LinkedListNode fast=this.first;
         LinkedListNode slow=this.first;
         if(fast.nextNode!=null)
         {
             fast=fast.nextNode;
         }
         else
         {
             return "is Palindrome";
         }
         while(fast!=null && fast.nextNode!=null)
         {
             fast=fast.nextNode.nextNode;
             slow=slow.nextNode;
         }
         fast=this.first;
         LinkedList reverse=new LinkedList(slow).reverseLinkedList();
         LinkedListNode reverseNode=reverse.first;
         while(reverseNode!=null)
         {
             if(!reverseNode.number.equals(fast.number))
             {
                 return "is not Palindrome";
             }
             reverseNode=reverseNode.nextNode;
             fast=fast.nextNode;
         }
        return "is Palindrome";
    }

    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        Integer[] endNumbers={4,5,6,7,8,9,10};
        for(Integer number:endNumbers)
        {
            linkedList.insert_at_end(number);
        }
        System.out.println("Insertion at the end");
        linkedList.display();
        Integer[] beginNumbers={3,2,1,0,-1};
        for (Integer number:beginNumbers)
        {
            linkedList.insert_at_begin(number);
        }
        System.out.println("Insertion at the begin");
        linkedList.display();
        linkedList.delete_at_begin();
        System.out.println("Deletion at the begin");
        linkedList.display();
        linkedList.delete_at_end();
        System.out.println("Deletion at the end");
        linkedList.display();
        Integer position=4;
        Integer position_number=11;
        linkedList.insert_at_pos(position,position_number);
        System.out.println("Insertion at the position "+position);
        linkedList.display();
        linkedList.delete_at_pos(position);
        System.out.println("Deletion at the position "+position);
        linkedList.display();
        LinkedList reverse=linkedList.reverseLinkedList();
        System.out.println("Linked List before reverse");
        linkedList.display();
        System.out.println("Linked List after reverse");
        reverse.display();
        LinkedList linkedList1=new LinkedList();
        Integer[] palindromeNumbers={3,2,1,2,3};
        for (Integer number:palindromeNumbers)
        {
            linkedList1.insert_at_begin(number);
        }
        System.out.println();
        linkedList1.display();
        System.out.println("Linked List "+linkedList1.isPalindrome());
        linkedList.display();
        System.out.println("Linked List "+linkedList.isPalindrome());
    }

}
