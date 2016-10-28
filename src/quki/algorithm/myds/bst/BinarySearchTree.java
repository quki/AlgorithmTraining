package quki.algorithm.myds.bst;

public class BinarySearchTree {

	public Node root; // key ����

	public BinarySearchTree() {
		this.root = null;
	}

	/**
	 * Ž�� root node ����
	 */
	public boolean find(int toFind) {
		Node current = root; // current�� root�� ���� ���� ��������
		while (current != null) {

			if (current.getData() == toFind)
				return true;

			if (current.getData() > toFind)
				current = current.getLeft(); // ������ current�� root�� �ٸ� ���� ���� ����

			if (current.getData() < toFind)
				current = current.getRight();

		}
		return false;
	}

	/**
	 * ���� Ž�������� ����
	 */
	public void insert(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root; // ����!
		Node parent = null;
		while (true) {
			parent = current;
			if (data < current.getData()) {
				current = current.getLeft();
				if (current == null) {
					parent.setLeft(newNode); // parent�� set
					return;
				}
			} else {
				current = current.getRight();
				if (current == null) {
					parent.setRight(newNode); // parent�� set
					return;
				}
			}
		}
	}

	/**
	 * ����
	 */
	public Node remove(int toBeRemoved) {
		Node current = root;
		Node parent = null;

		if (!find(toBeRemoved)) {
			System.out.println("�ش� ���� �����ϴ�");
		}

		// �����Ǵ� node(current)�� �θ����忡�� �����ڽ����� check!
		boolean isLeftChild = false; // ���������ϴ� node�� �θ� ���� ���ʿ� �ִ°�
		while (current.getData() != toBeRemoved) {
			parent = current; // �θ� update!
			if (current.getData() < toBeRemoved) {
				current = current.getRight();
				isLeftChild = false;
			}

			if (current.getData() > toBeRemoved) {
				current = current.getLeft();
				isLeftChild = true;
			}

		}

		// 1. sub tree�� �ϳ��� ���� ���
		if (current.getLeft() == null && current.getRight() == null) {

			if (current == root)
				root = null;

			if (isLeftChild) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}

			// 2. sub tree�� �Ѵ� �ִ� ���
		} else if (current.getLeft() != null && current.getRight() != null) {

			Node replacingNode = getReplaceNode(current);
			if (current == root) { // root�� ���
				root = replacingNode;
			} else if (isLeftChild) {
				parent.setLeft(replacingNode);
			} else {
				parent.setRight(replacingNode);
			}

			// sub tree �޾��ֱ�
			replacingNode.setLeft(current.getLeft());
			replacingNode.setRight(current.getRight());

			// 3. sub tree�� �ϳ��� �ִ� ���
		} else if (current.getLeft() != null) {

			if (current == root) { // root�� ���
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}

		} else if (current.getRight() != null) {

			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		}
		return current;
	}

	/**
	 * �������� node�� �����ʿ� �ִ� ���� ���� ���� ã�´� ���� �ڷᱸ�� å ����
	 */
	private Node getReplaceNode(Node current) {
		Node parent = null;
		current = current.getRight();
		while (current != null) {
			parent = current;
			current = current.getLeft();
		}

		// parent�� parent�� left �����ϴ� �κ� �����ض�!
		return parent;
	}

	/**
	 * ��ȸ (Traverse) ���� ��ȸ
	 */
	private void inorder(Node node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getData() + " ");
			inorder(node.getRight());
		}
	}

	public void print() {
		inorder(root);
		System.out.println();
	}

	/**
	 * Node getter, setter
	 */
	public class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.setData(data);
			setLeft(null);
			setRight(null);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}

}
