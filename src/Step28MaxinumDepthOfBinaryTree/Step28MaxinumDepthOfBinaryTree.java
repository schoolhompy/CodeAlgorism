package Step28MaxinumDepthOfBinaryTree;

/**
 * 28.재귀에 의한 Binarytree Max depth
 *
 * 1.  재귀에 의해 left 와 right 를 파고들어 탐색한다.
 * 2.  결국 맨밑의 하위노드가 없어서 0을 내뱉으면 +1을 하여 1단계로 친다.
 * 3.  한단계 위로 올라가서 안쪽 노드가 없는 경우거나, 한쪽 노드에 1보다 큰값이 있다면 그값을 더하고 +1 을 한다. 즉. 맨하위노드에서 1이 올라오고 한단계올라갔을때
 *     다른쪽노드(왼쪽이던 오른쪽이던) 가 있으면 해당값과max비교해서 큰값을 취하고, 다른쪽노드가 없다면 1에 +1을 하여 2단계라고 한다.
 *     위로 올라가면서 계속 반복하면 최상위 노드에서는 왼쪽과 오른쪽에서 최상위로 올라온 애들만 알게되므로 이걸 max 해서 높은 값만 취하면 된다.
 *
 * 응용예제 [랭킹시스템]
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

    Model(DataSource  dataSource){
        this.dataSource = dataSource;
    }

    int maxinumDepthOfBinaryTree() {
        TreeNode treenode =this.dataSource.getAllData();
        return getMaxDepth(treenode);

    }

    private int getMaxDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int leftMax = getMaxDepth(treeNode.left);
        int rightMax = getMaxDepth(treeNode.right);
        return Math.max(leftMax, rightMax) +1;
    }
}

public class Step28MaxinumDepthOfBinaryTree {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.maxinumDepthOfBinaryTree());
    }
}
