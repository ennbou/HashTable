

public class App {
    public static void main(String[] args) throws InterruptedException {

        HashTable<Integer, Integer> hashTable = new HashTable<>();

        for (int i = 0; i < 30; i++) {
            hashTable.add(i, i*3);
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(hashTable.get(i));
        }
    }
}
