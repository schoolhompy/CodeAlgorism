package Step20AddTwoNumbersLinkedList;

/**
 * 20.LinkedList의 각 노드에 저장된 숫자를 합쳐서 동일한 레벨로 결과물 만들기
 * Node1  2-4-3
 * Node2  5-6-2
 * Sum    7-0-6  (+1 추가됨)
 * 순회떄마다 2+5=7, 4+6=10(carry발생), 3+2=5(+1 carry추가해야됨)
 *
 * 응용예제 [linkedlist]
 */

class MyListNode {
    int val;
    MyListNode next;
    MyListNode(int val) {
        this.val = val;
    }
}

class DataSource{
    MyListNode[] getAllDatas() {
        MyListNode oneNum = new MyListNode(2);
        oneNum.next = new MyListNode(4);
        oneNum.next.next = new MyListNode(3);

        MyListNode twoNum = new MyListNode(5);
        twoNum.next = new MyListNode(6);
        twoNum.next.next = new MyListNode(2);

        return new MyListNode[]{oneNum, twoNum};
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    MyListNode AddTwoNumbersLinkedList() {
        //input
        MyListNode[] data = this.dataSource.getAllDatas();
        MyListNode oneNum = data[0];
        MyListNode twoNum = data[1];
        //output
        MyListNode result = new MyListNode(0);
        //process
        MyListNode calcNum = result;
        int sumValue = 0;

        while(oneNum != null || twoNum !=null) {
            if (oneNum != null) {
                sumValue += oneNum.val;
                oneNum = oneNum.next;
            }
            if (twoNum != null) {
                sumValue += twoNum.val;
                twoNum = twoNum.next;
            }
            calcNum.next = new MyListNode(sumValue%10);
            calcNum = calcNum.next;

            sumValue /= 10;
        }
        if (sumValue == 1) {
            calcNum.next = new MyListNode(1);
        }

        return result.next;

    }
}


public class Step20AddTwoNumbersLinkedList {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        MyListNode myListNode = model.AddTwoNumbersLinkedList();
        while (myListNode != null) {
            System.out.println(myListNode.val);
            myListNode = myListNode.next;
        }
    }
}
