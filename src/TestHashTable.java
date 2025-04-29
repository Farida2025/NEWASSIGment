import java.util.Random;

public class TestHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(100000));
            table.put(key, "Value" + i);
        }

        System.out.println("Number of elements in each bucket:");
        for (int i = 0; i < 11; i++) {
            int count = 0;
            Object head = table.getChainArray()[i];
            while (head != null) {
                count++;
                head = ((MyHashTable.HashNode<?, ?>) head).next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
