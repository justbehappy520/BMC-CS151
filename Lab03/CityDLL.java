public class CityDLL {
    private Node head;
    private Node tail;
    private int size;

    public CityDLL() {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    private class Node {
        public City data;
        public Node next;
        public Node prev;

        public Node() {
            this.next = null;
            this.prev = null;
        }

        public Node(City data) {
            this.data = data;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (head.next == tail) {
            return true;
        }
        return false;
    }

    public City first() {
        return head.next.data;
    }

    public City last() {
        return tail.prev.data;
    }
    
    public void insertFirst(City data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;

        size++;
    }

    public void insertBack(City data) {
        Node newNode = new Node(data);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;

        size++;
    }

    public String toString() {
        Node node = head;
        String cities = "";

        while (node.next != null && node.next != tail) {
            cities += node.next.data;
            node = node.next;
            if (node.next != tail) {
                cities += ", ";
            }
        }
        return cities;
    }

    public void insertBefore(City data, Node someNode) {
        Node newNode = new Node(data);
        System.out.println(":)");
        
        if (someNode != null) {
            Node node = someNode.prev;
            node.next = newNode;
            someNode.prev = newNode;
            newNode.prev = node;
            newNode.next = someNode;

            size++;
            return;
        }
    }

    public void insertSortedAlpha(City data) {
        Node newNode = new Node(data);
        Node node = head.next;

        if (isEmpty()) {
            insertFirst(data);
        }
        while (node.data != null) {
            if (newNode.data.getName().compareTo(node.data.getName()) < 0) {
                insertBefore(data, node);
                return;
            }
            node = node.next;
        }
        if (newNode.data.getName().compareTo(tail.prev.data.getName()) > 0) {
            insertBefore(data, tail);
        }
    }

    public void insertSortedPop(City data) {
        Node newNode = new Node(data);
        Node node = head.next;

        if (isEmpty()) {
            insertFirst(data);
        }
        while (node.data != null) {
            if (newNode.data.getPopulation() < node.data.getPopulation()) {
                insertBefore(data, node);
                break;
            }
            node = node.next;
        }
        if (newNode.data.getPopulation() > tail.prev.data.getPopulation()) {
            insertBefore(data, tail);
        }
    }
}
