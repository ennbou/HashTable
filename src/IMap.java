public interface IMap<K, V> {
    void add(K k, V v);
    V get(K k);
}
