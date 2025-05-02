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

    public LinkedList reverseLinkedList()
    {
        LinkedListNode previousNode=null;
        LinkedListNode currentNode=this.first;
        LinkedListNode nextNode;
        while(currentNode!=null)
        {
            nextNode=currentNode.nextNode;
            currentNode.nextNode=previousNode;
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return new LinkedList(previousNode);
    }


    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        Integer[] endNumbers={4,5,6,7,8,9,10};
        for(Integer number:endNumbers)
        {
            linkedList.insert_at_end(number);
        }
        linkedList.display();
        Integer[] beginNumbers={3,2,1,0,-1};
        for (Integer number:beginNumbers)
        {
            linkedList.insert_at_begin(number);
        }
        linkedList.display();
        linkedList.delete_at_begin();
        linkedList.display();
        linkedList.delete_at_end();
        linkedList.display();
        linkedList.insert_at_pos(4,11);
        linkedList.display();
        linkedList.delete_at_pos(4);
        linkedList.display();
        LinkedList reverse=linkedList.reverseLinkedList();
        reverse.display();
    }

}
