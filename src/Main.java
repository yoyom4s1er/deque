import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Deque deque = new Deque();

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println(deque);
            System.out.println("Actions:");
            System.out.println("1.Add to the start");
            System.out.println("2.Add to the end");
            System.out.println("3.Delete from the start");
            System.out.println("4.Delete from the end");
            System.out.println("5.Sort");
            System.out.println("6.Exit");
            System.out.println();

            switch (scanner.nextInt()) {
                case 1: {
                    System.out.print("number: ");
                    deque.addFirst(scanner.nextInt());
                    break;
                }
                case 2: {
                    System.out.print("number: ");
                    deque.addLast(scanner.nextInt());
                    break;
                }
                case 3: {
                    deque.deleteFirst();
                    break;
                }
                case 4: {
                    deque.deleteLast();
                    break;
                }
                case 5: {
                    HeapSort.sort(deque);
                    break;
                }
                case 6: {
                    running = false;
                    break;
                }
            }
        }
    }
}