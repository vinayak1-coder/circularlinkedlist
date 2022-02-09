public class circularlinkedlist {
    class Node{
        int element;
        Node next;
        public Node(int e,Node n){
            element = e;
            next = n;
        }

    }
    private Node head;
    private Node tail;
    private int size;
    public circularlinkedlist(){
        head = null;
        tail = null;
        size  = 0;
    }
    public int lenght(){
        return size;
    }
    public boolean isempty(){
        return size==0;
    }
    // add in last
    public void addlast(int e){
        Node newest = new Node (e,null);
        if(isempty()){
            newest.next=head;
            head=newest;
        }
        else{
            newest.next=tail.next;
            tail.next=newest;
        }
        size=size+1;
        tail=newest;

    }
    // add in first
    public void addfir(int e){
        Node newest = new Node(e,null);
        if(isempty()){
            newest.next=head;
            head= newest;
            tail=newest;
        }
        else{
            tail.next=newest;
            newest.next=head;
            head=newest;
        }
        size=size+1;
    }
    //add at any position
    public void addany(int e,int pos){
        if(pos<=0 || pos>=size)
            System.out.println("invalid pos");
        Node newest = new Node(e,null);
        Node p=head;
        int i=1;
        while(i<pos-1){
            p=p.next;
            i=i+1;
        }
        newest.next=p.next;
        p.next=newest;
        size=size+1;

    }
    // remove first
    public int removefir(){
        if(isempty())
            System.out.println("invalid");
        int e = head.element;
        tail.next = head.next;
        head = head.next;
        size = size - 1;
        if(isempty()) {
            head = null;
            tail = null;
        }
        return e;

    }
    //remove last
    public int removeLast() {
        if(isempty()) {
            System.out.println("Circular List is Empty");
            return -1;
        }
        Node p = head;
        int i = 1;
        while(i <lenght()-1) {
            p = p.next;
            i = i + 1;
        }
        tail = p;
        p = p.next;
        tail.next = head;
        int e = p.element;
        size = size - 1;
        return e;
    }
//remove any
    public int removeAny(int position) {
        if(position <= 0 || position >= size-1) {
            System.out.println("Invalid Position");
            return -1;
        }
        Node p = head;
        int i = 1;
        while(i < position-1) {
            p = p.next;
            i = i + 1;
        }
        int e = p.next.element;
        p.next = p.next.next;
        size = size - 1;
        return e;
    }
    // fot display
    public void display(){
        Node p=head;
        int i=0;
        while(i<lenght()){
            System.out.print(p.element+" ");
            p=p.next;
            i=i+1;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        circularlinkedlist l = new circularlinkedlist();
        l.addlast(3);
        l.addlast(4);
        l.addlast(5);
        l.display();
        System.out.println("size "+l.lenght());
        l.addfir(1);
        l.addfir(2);
        l.display();
        System.out.println("size "+l.lenght());
        l.addany(5,3);
        l.display();
        System.out.println("size"+l.lenght());
    }
}
