package Step21MergeNSortedList;

import java.util.PriorityQueue;

/**
 * 21.LinkedList를 통합하여 정렬하기
 * Node1  1-4-5
 * Node2  1-3-4
 * Node3  2-6
 * priorityQueue를 사용해서 작은값순으로 정렬된 맨위노드를 가져와서 정렬한다.
 * 1. 1(N1),1(N2),2(N3) 에서 1(N1)을 가져옴
 * 2. 1(N2),2(N3),4(N1) 에서 1(N2)을 가져옴
 * 3. 2(N3),3(N2),4(N1) 에서 2(N3)을 가져옴
 * 4. 3(N2),4(N1),6(N3) 에서 3(N2)을 가져옴
 * 5. 4(N1),4(N2),6(N3) 에서 4(N1)을 가져옴
 * 6. 4(N2),6(N3),5(N1) 에서 4(N2)을 가져옴
 * 7. 6(N3),5(N1) 에서 5(N1)을 가져옴
 * 8. 6(N3) 에서 6(N3)을 가져옴
 *
 * 숫자일때는 sort
 * 객체의 속성을 기준으로 할떄는 priorityQueue
 *
 * 응용예제 [여러학급생 성적순(또는 키높이순)정렬,  ]
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
        MyListNode oneNum = new MyListNode(1);
        oneNum.next = new MyListNode(4);
        oneNum.next.next = new MyListNode(5);

        MyListNode twoNum = new MyListNode(1);
        twoNum.next = new MyListNode(3);
        twoNum.next.next = new MyListNode(4);

        MyListNode threeNum = new MyListNode(2);
        threeNum.next = new MyListNode(6);

        return new MyListNode[]{oneNum, twoNum, threeNum};
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    MyListNode MergeNSortedList() {
        //input
        MyListNode[] data = this.dataSource.getAllDatas();
        //output
        MyListNode result = new MyListNode(0);
        //process
        MyListNode currentNode = result;

        PriorityQueue<MyListNode> queue = new PriorityQueue<MyListNode>((a,b)->a.val-b.val);
        for (MyListNode node:data) {
            queue.offer(node);
        }

        while(!queue.isEmpty()) {
            MyListNode node = queue.poll();
            currentNode.next = node;
            currentNode = currentNode.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return result.next;

    }
}
public class Step21MergeNSortedList {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        MyListNode myListNode=  model.MergeNSortedList();

        while (myListNode != null) {
            System.out.println(myListNode.val);
            myListNode = myListNode.next;
        }
    }
}
