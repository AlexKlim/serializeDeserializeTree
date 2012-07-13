
public class TreeTest {
	public static void main(String[] args) {
		Stream stream = new Stream();

		TreeNode root = new TreeNode();
		root.value = 10;

		FillTree(root);

		serialize(root, stream);
		System.out.println("src Root");
		stream.Print();

		TreeNode newRoot = desirialize(stream);

		Stream newStream = new Stream();
		serialize(newRoot, newStream);
		System.out.println("new Root");
		newStream.Print();
	}

	static void FillTree(TreeNode root) {
		TreeNode n = new TreeNode();
		n.value = 4;
		AddNode(root, n);

		n = new TreeNode();
		n.value = 8;
		AddNode(root, n);

		n = new TreeNode();
		n.value = 1;
		AddNode(root, n);

		n = new TreeNode();
		n.value = 6;
		AddNode(root, n);

		n = new TreeNode();
		n.value = 9;
		AddNode(root, n);

		n = new TreeNode();
		n.value = 12;
		AddNode(root, n);

		n = new TreeNode();
		n.value = 15;
		AddNode(root, n);
	}

	static void serialize(TreeNode root, Stream stream) {
		SaveNode(root, stream);
		stream.WriteInt(-1);
	}

	static void SaveNode(TreeNode root, Stream stream) {
		stream.WriteInt(root.value);

		if (null != root.left) {
			SaveNode(root.left, stream);
		}
		if (null != root.right) {
			SaveNode(root.right, stream);
		}
	}

	static TreeNode desirialize(Stream stream) {
		TreeNode root = null;

		int value = stream.ReadInt();
		while (-1 != value) {
			TreeNode node = new TreeNode();
			node.value = value;

			if (null == root) {
				root = node;
			} else {
				AddNode(root, node);
			}
			value = stream.ReadInt();
		}

		return root;
	}

	static void AddNode(TreeNode root, TreeNode node) {
		if (root.value < node.value) {
			if (null == root.right) {
				root.right = node;
			} else {
				AddNode(root.right, node);
			}
		} else {
			if (null == root.left) {
				root.left = node;
			} else {
				AddNode(root.left, node);
			}
		}
	}
}