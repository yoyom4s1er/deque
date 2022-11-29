public class Deque {

    private Node firstNode;
    private Node lastNode;
    private int size;

    public Deque() {
    }

    public void addFirst(int value) {
        Node node = new Node(value);

        if (firstNode != null) {
            firstNode.setPreviousNode(node);
            node.setNextNode(firstNode);
        }

        firstNode = node;
        size++;

        if (size == 1) {
            lastNode = firstNode;
        }

        if (size == 2) {
            lastNode = firstNode.getNextNode();
        }
    }

    public void addLast(int value) {
        Node node = new Node(value);

        if (lastNode != null) {
            lastNode.setNextNode(node);
            node.setPreviousNode(lastNode);
        }

        lastNode = node;
        size++;

        if (size == 1) {
            firstNode = lastNode;
        }

        if (size == 2) {
            firstNode = lastNode.getPreviousNode();
        }
    }

    public void deleteFirst() {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            firstNode = null;
            lastNode = null;
            size--;
            return;
        }
        firstNode = firstNode.getNextNode();
        firstNode.setPreviousNode(null);

        size--;
    }

    public void deleteLast() {
        if (size == 0) {
            return;
        }

        if (size == 1) {
            firstNode = null;
            lastNode = null;
            size--;
            return;
        }
        lastNode = lastNode.getPreviousNode();
        lastNode.setNextNode(null);

        size--;
    }

    public int[] getValues() {
        if (size == 0) {
            return new int[0];
        }

        int[] array = new int[size];

        Node bufferedNode = firstNode;
        for (int i = 0; i < size; i++) {
            array[i] = bufferedNode.getValue();
            bufferedNode = bufferedNode.getNextNode();
        }

        return array;
    }

    public void sort() {
        /*int[] array = HeapSort.sort(getValues());
        firstNode = null;
        lastNode = null;*/
    }

    public int getValue(int n) {
        if (n < 0 || n >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node bufferedNode = firstNode;
        int number = 0;

        for (int i = 0; i < size; i++) {
            if (i == n) {
                number = bufferedNode.getValue();
                break;
            }
            bufferedNode = bufferedNode.getNextNode();
        }

        return number;
    }

    public Node getNode(int n) {
        if (n < 0 || n >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node bufferedNode = firstNode;
        Node node = null;

        for (int i = 0; i < size; i++) {
            if (i == n) {
                node = bufferedNode;
                break;
            }
            bufferedNode = bufferedNode.getNextNode();
        }

        return node;
    }

    public void setNode(int n, int value) {
        if (n < 0 || n >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node bufferedNode = firstNode;

        for (int i = 0; i < size; i++) {
            if (i == n) {
                Node bufferedPreviousNode = bufferedNode.getPreviousNode();
                Node bufferedNextNode = bufferedNode.getNextNode();

                bufferedNode.setPreviousNode(null);
                bufferedNode.setNextNode(null);

                Node cloneNode = new Node(value);

                cloneNode.setPreviousNode(bufferedPreviousNode);
                cloneNode.setNextNode(bufferedNextNode);

                if (bufferedPreviousNode != null) {
                    bufferedPreviousNode.setNextNode(cloneNode);
                }
                if (bufferedNextNode != null) {
                    bufferedNextNode.setPreviousNode(cloneNode);
                }

                if (i == 0) {
                    firstNode = cloneNode;
                }
                if (i == size - 1) {
                    lastNode = cloneNode;
                }

                break;
            }
            bufferedNode = bufferedNode.getNextNode();
        }
    }


    @Override
    public String toString() {
        if (size == 0) {
            return "deque[]";
        }

        StringBuilder stringBuilder = new StringBuilder("deque[");
        stringBuilder.append(firstNode.getValue());

        Node bufferedNode = firstNode;
        while (bufferedNode.getNextNode() != null) {
            bufferedNode = bufferedNode.getNextNode();
            stringBuilder.append(", ").append(bufferedNode.getValue());
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    public int size() {
        return size;
    }
}
