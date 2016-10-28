package quki.algorithm.myds.linkedlist;
/**
 * https://opentutorials.org/module/1335/8941
 * Iterator ����
 * 
 * @author quki
 *
 */
public class DoublyLinkedList {
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

		if (head != null)
			head.prev = newNode;

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
			newNode.prev = tail;
			tail = newNode;
			size++;
		}
	}

	/**
	 * Ư�� index�� node �߰�
	 */
	public void add(int index, Object input) {

		if (index == 0) {
			addFirst(input);
		} else {
			Node prevNode = getNode(index - 1);
			Node newNode = new Node(input);

			newNode.next = prevNode.next;
			prevNode.next.prev = newNode;

			prevNode.next = newNode;
			newNode.prev = prevNode;

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
		head.prev = null; // head ������ ����Ű�� node, 
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

		Node prevNode = getNode(index - 1); // ���������ϴ� ���� node
		Node tobeRemoved = prevNode.next; // ���������ϴ� node�� ����Ű���ִ�
		Object returnData = tobeRemoved.data; // data ����
		
		prevNode.next = tobeRemoved.next;
		tobeRemoved.next.prev = prevNode;

		// ������ ����Ű�� �ִ� instance�� �ּҰ��� �����Ƿ�
		// Garbage collector�� instance ȸ��
		tobeRemoved = null;

		size--;
		if (prevNode.next == null)
			tail = prevNode;

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
	 * Ư�� index�� node ã��. size / 2�� ��������
	 */
	private Node getNode(int index) {
		Node temp;
		if (index < size / 2) {
			temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			temp = tail;
			for (int i = size - 1; i > index; i--) {
				temp = temp.prev;
			}
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
	 */
	private class Node {

		private Object data;
		private Node prev;
		private Node next;

		Node(Object input) {
			this.data = input;
			this.prev = null;
			this.next = null;
		}

		// ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		public String toString() {
			return String.valueOf(this.data);
		}

	}
}
