
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Node {
	int nodeData;
	Node left, right;

	public Node(int nodeData) {
		this.nodeData = nodeData;
		left = right = null;
	}
}

public class PairSum {
	Node root;

	Node insert(Node node, int key) {
		// if tree is empty return new Node;
		if (node == null) {
			node = new Node(key);
			return node;
		}
		// otherwise recur down the tree
		if (key < node.nodeData) {
			node.left = insert(node.left, key);
		} else if (key > node.nodeData) {
			node.right = insert(node.right, key);
		}
		return node;
	}

	public static void main(String[] args) {
		PairSum tree = new PairSum();
		tree.root = tree.insert(tree.root, 40);
		tree.insert(tree.root, 20);
		tree.insert(tree.root, 60);
		tree.insert(tree.root, 10);
		tree.insert(tree.root, 30);
		tree.insert(tree.root, 50);
		tree.insert(tree.root, 70);
		// tree.inOrder(tree.root);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Sum:");
		int sum = sc.nextInt();
		System.out.println();
		tree.findPairWithGivenSum(tree.root, sum);
	}

	private void findPairWithGivenSum(Node root, int sum) {
		Set<Integer> set = new HashSet<>();
		if (!findPairUtil(root, sum, set))
			System.out.print("Nodes are not found." + "\n");

	}

	private boolean findPairUtil(Node root, int sum, Set<Integer> set) {
		if (root == null)
			return false;
		if (findPairUtil(root.left, sum, set))
			return true;
		int diff = sum - root.nodeData;
		if (set.contains(diff)) {
			System.out.println("Pair is found (" + (sum - root.nodeData) + ", " + root.nodeData + ")");
			return true;
		} else {
			set.add(root.nodeData);
		}

		return findPairUtil(root.right, sum, set);
	}

}