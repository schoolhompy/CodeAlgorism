package Step22ReverseLinkedList;

/**
 * 22.Linkedlist 역전
 * Node1  3-2-1
 *
 * 1.  NextNode에 Current.next를 저장(1-2) -> Current.next에 result저장(current 1-null) -> result에 current저장((1-null) -> current에 NextNode복귀(2-3)
 * 2.  NextNode에 Current.next를 저장(2-3) -> Current.next에 result저장(current 2-1) -> result에 current저장((2-1) -> current에 NextNode복귀(3-4)
 * 3.  NextNode에 Current.next를 저장(3-4) -> Current.next에 result저장(current 3-2) -> result에 current저장((3-2) -> current에 NextNode복귀(4-null)
 * 4.  NextNode에 Current.next를 저장(4-null) -> Current.next에 result저장(current 4-3) -> result에 current저장((4-3) -> current에 NextNode복귀(4-null)
 *
 * 응용예제 [linkedlist역전]
 */

class MyListNode {
    int val;
    MyListNode next;
    MyListNode(int val) {
        this.val = val;
    }
}

class DataSource{
    MyListNode getAllDatas() {
        MyListNode oneNum = new MyListNode(1);
        oneNum.next = new MyListNode(2);
        oneNum.next.next = new MyListNode(3);
        oneNum.next.next.next = new MyListNode(4);



        return oneNum;
    }
}

class Model {
    private DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    MyListNode reverseLinkedList() {
        //input
        MyListNode node = this.dataSource.getAllDatas();
        //output
        MyListNode result = null;
        //process
        MyListNode next = null;

        while(node != null) {
            next = node.next;
            node.next = result;
            result = node;
            node = next;
        }
        return result;

    }
}


public class Step22ReverseLinkedList {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());

        MyListNode myListNode=  model.reverseLinkedList();

        while (myListNode != null) {
            System.out.println(myListNode.val);
            myListNode = myListNode.next;
        }
    }
}
