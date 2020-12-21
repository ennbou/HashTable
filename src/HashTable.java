import java.util.Arrays;

public class HashTable<K, V> implements IMap<K,V>{

    private int arrSize = 10;

    private int size = 0;

    private Node<K, V>[] elements;

    public HashTable(){
        elements = new Node[arrSize];
    }

    public void resize(int newSize){
        if(size == arrSize){
            Node<K, V>[] newElements =  Arrays.copyOf(elements, size);
            arrSize += arrSize >> 1;
            elements = new Node[arrSize];
            size = 0;
            for(Node<K,V> n: newElements){
                add(n.key, n.value);
            }
        }
    }

//   [ , , , ]
    @Override
    public void add(K k, V v) {

        resize(size);

        int index = prepareIndex(k);

        while (elements[index] != null){
            index++;
            if(index == arrSize) index = 0;
        }

        elements[index] = new Node<>(k, v);

        size++;
    }


    // [Y,X, ,]
    @Override
    public V get(K k) {

        int hashIndex = prepareIndex(k);
        int hash = k.hashCode();

        while (elements[hashIndex] != null){
            if(hash == elements[hashIndex].hashKey){
                return elements[hashIndex].value;
            }
            hashIndex++;
            if(hashIndex == arrSize) hashIndex = 0;
        }

        return null;
    }

    public int prepareIndex(K k){
        return k.hashCode() % arrSize;
    }
}
