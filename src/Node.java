public class Node<K, V> {
    K key;
    V value;
    int hashKey;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.hashKey = key.hashCode();
    }
}
