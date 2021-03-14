package Step30MaximumDepthOfBinaryBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 30.BFS Binarytree Max depth (queue)
 *
 * 1.  Stask을 이용해서 하위left right노드가 있으면 스택에 넣고, levelcount를 1증가해서 스택에 넣는다.
 * 2.  스택에서 한개를 꺼내서 하위left right노드가 있으면 스택에 넣고, levelcount를 1증가해서 스택에 넣는다.
 * 3.  스택에서 levelcount를 꺼내서 현재 저장된 탑레벨모다 큰지 비교한다.
 *
 * 응용예제 [스코어계산]
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
        treeNode.left= new TreeNode(1);
        treeNode.right= new TreeNode(4);
        treeNode.left.left= new TreeNode(5);
        treeNode.left.right= new TreeNode(8);
        treeNode.left.right.left= new TreeNode(10);
        treeNode.left.right.left.left= new TreeNode(4);
        treeNode.left.right.left.left.left= new TreeNode(14);
        treeNode.left.left.left= new TreeNode(7);
        return treeNode;
    }
}

class Model {
    private final DataSource dataSource;

    Model(DataSource dataSource){
        this.dataSource = dataSource;
    }

    int maxinumDepthOfBinaryTree() {
        TreeNode treenode =this.dataSource.getAllData();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treenode);

        int maxDepth =0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i< size; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            maxDepth++;
        }


        return maxDepth;

    }
}

public class S30MaximumDepthOfBinaryBFS {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.maxinumDepthOfBinaryTree());
        
    }
}
