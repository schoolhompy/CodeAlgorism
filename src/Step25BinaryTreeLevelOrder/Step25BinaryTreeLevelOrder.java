package Step25BinaryTreeLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 25.이진트리 탐색
3----4----5
     -6-7
 * 1. 3을 가져가서 left, right가 있는지 확인하고 있으면 queue 에 둘다 넣음.
 * 2. left, right 에 담긴 queue데이터를 확인해서 left,right가 있는지 확인을 반복
 *
 *
 * 응용예제 [이진트리탐색 ]
 */


class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

class DataSource {
    TreeNode getAllData() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left= new TreeNode(4);
        treeNode.right= new TreeNode(5);
        treeNode.left.left= new TreeNode(6);
        treeNode.left.right= new TreeNode(7);
        return treeNode;
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    List<List<Integer>> getBinaryTreeLevelOrder() {
        TreeNode treeNode = this.dataSource.getAllData();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0; i< size; i ++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(list);
        }
        return result;

    }
}

public class Step25BinaryTreeLevelOrder {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.print(model.getBinaryTreeLevelOrder());
    }
}
