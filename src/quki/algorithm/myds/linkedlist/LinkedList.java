package quki.algorithm.myds.linkedlist;

public class LinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	/**
	 * ���� ù��° ��ġ�� node�� �߰���
	 * 
	 * @param input
	 */
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head; // ������ ������� node�� �����Ѿ���, ������ head�� ����ִ�
		head = newNode; // head ������ ���� ������� node�� ����Ŵ
		size++;
		if (head.next == null) { // head.next�� head ������ ����Ű�� �ִ� node�� ���� node
			tail = head;
		}
	}

	/**
	 * ���� ������ ��ġ�� node�� �߰���
	 * 
	 * @param input
	 */
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if (size == 0) { // node�� �ϳ��� ���� ���
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	/**
	 * Ư�� index�� node �߰�
	 * 
	 * @param index
	 * @param input
	 */
	public void add(int index, Object input) {

		if (index == 0) {
			addFirst(input);
		} else {
			Node prev = getNode(index - 1);
			Node newNode = new Node(input);
			newNode.next = prev.next;
			prev.next = newNode;
			size++;

			if (newNode.next == null) { // �������� �߰��ȴٸ�, tail ����
				tail = newNode;
			}
		}

	}

	/**
	 * ù��° node ����
	 * 
	 * @return ������ node�� �����ִ� data ����
	 */
	public Object removeFirst() {
		Node tobeRemoved = head;
		Object returnData = tobeRemoved.data;
		head = tobeRemoved.next;
		tobeRemoved = null;
		size--;
		return returnData;
	}

	/**
	 * Ư�� index node ����
	 * 
	 * @param index
	 * @return ������ node�� �����ִ� data ����
	 */
	public Object remove(int index) {
		if (index == 0)
			return removeFirst();

		Node prev = getNode(index - 1); // ���������ϴ� ���� node
		Node tobeRemoved = prev.next; // ���������ϴ� node�� ����Ű���ִ�
		Object returnData = tobeRemoved.data; // data ����
		prev.next = tobeRemoved.next;

		// ������ ����Ű�� �ִ� instance�� �ּҰ��� �����Ƿ�
		// Garbage collector�� instance ȸ��
		tobeRemoved = null;

		size--;
		if (prev.next == null)
			tail = prev;

		return returnData;
	}

	/**
	 * �־��� �����! ���ʷ� �� ���� �˻��ؾ���! �ֳ��ϸ� tail ���� node�� �˰� �־�� �ϱ� ����.
	 * 
	 * @return
	 */
	public Object removeLast() {
		return remove(size - 1);
	}

	public Object get(int index) {
		Node temp = getNode(index);
		return temp.data;
	}

	public int size() {
		return size;
	}

	/**
	 * Ư�� index�� node ã��. ���ʷ� �˻��ؾ��ϹǷ� ������ node�� �����ϸ� �־��� ���. ���ο��� ���� Node ��ü��
	 * �ܺο� �������� �ȵ�.
	 */
	private Node getNode(int index) {
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * ���
	 */
	public String toString() {
		if (head == null) {
			return "[]";
		}

		Node temp = head;
		String str = "[";
		// ���� ��尡 ���� ������ �ݺ����� ����
		// ������ ���� ���� ��尡 ���� ������ �Ʒ��� ������ ������ ���� ���ܵ˴ϴ�.
		while (temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		// ������ ��带 ��°���� ����.
		str += temp.data + "]";
		return str;
	}

	/**
	 * ���ο��� ���� class�� ��������� �ܺο��� ���̸� �ȵ�.
	 *
	 */
	private class Node {

		private Object data;
		private Node next;

		Node(Object input) {
			this.data = input;
			this.next = null;
		}

		// ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		public String toString() {
			return String.valueOf(this.data);
		}

	}

}
