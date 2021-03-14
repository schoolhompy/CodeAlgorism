package Step29MaxinumDepthOfBinaryTreeDFS;


import java.util.Stack;

/**
 * 29.DFS Binarytree Max depth (stack)
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

        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<Integer> depthLevelStack = new Stack<>();

        treeNodeStack.push(treenode);
        depthLevelStack.push(1);
        int maxResult = 0;

        while(!treeNodeStack.isEmpty()) {
            TreeNode node = treeNodeStack.pop();
            int count = depthLevelStack.pop();

            maxResult = Math.max(maxResult, count);
            if(node.left != null) {
                treeNodeStack.push(node.left);
                depthLevelStack.push(1+count);
            }
            if(node.right != null) {
                treeNodeStack.push(node.right);
                depthLevelStack.push(1+count);
            }
        }

        return maxResult;

    }
}


public class Step29MaxinumDepthOfBinaryTreeDFS {
    public static void main(String[] args) {
        Model model = new Model(new DataSource());
        System.out.println(model.maxinumDepthOfBinaryTree());
    }
}
