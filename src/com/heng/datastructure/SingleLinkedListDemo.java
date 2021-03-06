package com.heng.datastructure;

public class SingleLinkedListDemo {


    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "黑暗游侠", "小黑");
        HeroNode hero2 = new HeroNode(3, "黑暗贤者", "兔子");
        HeroNode hero3 = new HeroNode(7, "魅惑魔女", "小鹿");
        HeroNode hero4 = new HeroNode(8, "魅惑魔", "小鹿");
        HeroNode hero5 = new HeroNode(4, "魅惑", "小鹿");
        HeroNode hero6 = new HeroNode(9, "魅", "小鹿");
        HeroNode hero7 = new HeroNode(9, "魅魔", "小鹿");
        SingleLinkedList list = new SingleLinkedList();
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.insert(hero4);
        list.insert(hero5);
        list.insert(hero6);
        list.update(hero7);
        list.delete(hero4);
        list.delete(hero1);
        list.delete(hero7);
        list.show();
    }
}
class SingleLinkedList{
    //filed
    private HeroNode head;
    private HeroNode tail;
    int size;
    public SingleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public void add(HeroNode node){
        if(head == null){
            head = node;
            tail = node;
            size++;
        }else{
            tail.next = node;
            size++;
            tail = node;
        }
    }
    public void show(){
        HeroNode temp = head;
        while(temp != null){
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void insert(HeroNode newNode){
        //corner case
        if(head == null ){
            head = newNode;
            tail = newNode;
            size++;
            return;
        }else if(head.no > newNode.no){
            newNode.next = head;
            tail = head;
            head = newNode;
            size++;
            return;
        }
        HeroNode cur = head;
        while(cur != null){
            if(cur.next!=null && cur.next.no > newNode.no){
                newNode.next = cur.next;
                cur.next = newNode;
                size++;
                return;
            }else if(cur.no == newNode.no){
                throw new RuntimeException("id exist");
            }else if(cur.next == null && cur.no < newNode.no){
                cur.next = newNode;
                tail = newNode;
                size++;
                return;
            }
            cur = cur.next;
        }
    }
    public void update(HeroNode newNode){
        if(isEmpty()){
            System.out.println("empty List");
        }
        HeroNode cur = head;
        while(cur != null){
            if(cur.no == newNode.no){
                cur.name = newNode.name;
                cur.nickName = newNode.nickName;
                return;
            }
            cur = cur.next;
        }
        System.out.println("no such node exist");
    }
    public void delete(HeroNode node){
        if(isEmpty()){
            throw new RuntimeException("empty list");
        }
        if(size == 1 && head.no == node.no){
            head = null;
            tail = null;
            size = 0;
            return;
        }
        if(head.no == node.no){
            head = head.next;
            size--;
        }

        HeroNode cur = head.next;
        HeroNode pre = head;
        while(cur != null){
            HeroNode next = cur.next;
            if(cur.no == node.no && cur.next == null){
                pre.next = null;
                tail = pre;
                size--;
                return;
            }
            if(cur.no == node.no){
                pre.next = next;
                size--;
            }
            pre = cur;
            cur = cur.next;

        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode(){};
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    @Override
    public String toString(){
        return String.format("HeroNode [no = %d, name = %s, nickName = %s",no, name, nickName);
    }
}