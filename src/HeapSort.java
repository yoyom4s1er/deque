// Реализация пирамидальной сортировки на Java
public class HeapSort
{
    public static void sort(Deque deque)
    {
        int n = deque.size();

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(deque, n, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = deque.getValue(0);
            deque.setNode(0, deque.getValue(i));
            deque.setNode(i, temp);

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(deque, i, 0);
        }

    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    private static void heapify(Deque deque, int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && deque.getValue(l) > deque.getValue(largest))
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && deque.getValue(r) > deque.getValue(largest))
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = deque.getValue(i);

            deque.setNode(i, deque.getValue(largest));
            //System.out.println("swap " + swap.getValue() + " left " + swap.getPreviousNode().getValue() + " right " + swap.getNextNode().getValue());
            deque.setNode(largest, swap);

            //System.out.println(deque);

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(deque, n, largest);
        }
    }
}
