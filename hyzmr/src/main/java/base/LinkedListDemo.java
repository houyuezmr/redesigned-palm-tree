package base;

interface ILink<E>{
    public void add(E e);
    public int size();
    public boolean isEmpty();
    public Object[] toArray();
    public E getData(int index);
    public void set(int index,E data);
    public boolean contains(E data);
    public void remove(E data);
    public void clean();
}

/**
 * @Description: TODO
 * @author: mike
 * @date: 2020年11月27日 9:12
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        ILink<String> all=new LinkImpl<String>();
        all.add("123");
        all.add("456");
        System.out.println(all.size());
        Object[] ob=all.toArray();
        for (Object o:
             ob) {
            System.out.println(o);
        }
        System.out.println(all.getData(1));
        all.set(1,"1234");
        System.out.println(all.getData(1));
        System.out.println(all.contains("124"));
    }
}

class LinkImpl<E> implements ILink<E>{

    private Node root;
    private int count;
    private int foot;
    private Object[] returnData;

    @Override
    public void add(E e) {
        if(e==null) {
            return;
        }
        Node node=new Node(e);
        if(this.root==null){
            this.root=node;
        }else{
            this.root.addNode(node);
        }
        this.count++;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count==0;
    }

    @Override
    public Object[] toArray() {
        if(this.isEmpty()){
            return  null;
        }
        this.foot=0;
        this.returnData=new Object[this.count];

        this.root.toArrayNode();
        return returnData;
    }

    @Override
    public E getData(int index) {
        if(index >= this.count){
            return null;
        }
        this.foot=0;
        return this.root.getNode(index);
    }

    @Override
    public void set(int index, E data) {
        if(index >= this.count){
            return;
        }
        this.foot=0;
        this.root.setNode(index,data);
    }

    @Override
    public boolean contains(E data) {
        if(data==null){
            return  false;
        }
       return this.root.containsNode(data);
    }

    @Override
    public void remove(E data) {
        if(this.contains(data)){
            if(this.root.data.equals(data)){
                this.root=this.root.next;

            }
            this.root.next.removeNode(this.root,data);

            this.count--;
        }
    }

    @Override
    public void clean() {
        this.root=null;
        this.count=0;
    }

    private class Node{
        private E data;
        private Node next;

        public Node(E data){
            this.data=data;
        }
        //第一次调用：
        public void addNode(Node node){
            if(this.next==null){
                this.next=node;
            }else{
                this.next.addNode(node);
            }

        }
        public void toArrayNode(){
            LinkImpl.this.returnData[LinkImpl.this.foot++]=this.data;
            if(this.next!=null){
                this.next.toArrayNode();
            }
        }
        public E getNode(int index){
            if(LinkImpl.this.foot++==index){
                return this.data;
            }else{
                return this.next.getNode(index);
            }
        }
        public void setNode(int index,E data){
            if(LinkImpl.this.foot++==index){
                this.data=data;
            }else{
                this.next.setNode(index,data);
            }
        }
        public boolean containsNode(E data){
            if(this.data.equals(data)){
                return true;
            }else if(this.next==null){
                return false;
            }else {
                return this.next.containsNode(data);
            }
        }
        public void removeNode(Node previous,E data){
            if(this.data.equals(data)){
                previous.next=this.next;
            }else{
                if(this.next!=null){
                    this.next.removeNode(this,data);
                }
            }
        }
    }
}
