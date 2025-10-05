public class CitySLL {
    private class Node {
        public City data;
        public Node next;

        public Node() {
            this.next = null;
        }

        public Node(City data) {
            this.data = data;
        }
    }
    private Node head;
    private int size;

    public CitySLL() {
        head = new Node();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (head.next == null) {
            return true;
        }
        return false;
    }

    public City first() {
        if (head.next != null) {
            return head.next.data;
        }
        return null;
    }

    public City last() {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node.data;
    }
    
    public void insertFirst(City data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void insertBack(City data) {
        Node newNode = new Node(data);
        Node curNode = head;

        while(curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = newNode;
        size++;
    }

    public String toString() {
        Node node = head;
        String cities = "";

        while (node.next != null) {
            cities += node.next.data;
            node = node.next;
            if (node.next != null) {
                cities += ", ";
            }
        }
        return cities;
    }
}
