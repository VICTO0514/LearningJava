import java.util.Objects;

public class MyHashMap<K, V> {

    // ===============================
    // 🔹 Basic Configuration
    // ===============================
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int TREEIFY_THRESHOLD = 8; // (ignored for now)

    // ===============================
    // 🔹 Node Structure (LinkedList)
    // ===============================
    static class Node<K, V> {
        final int hash;    // precomputed hash value
        final K key;
        V value;
        Node<K, V> next;   // next node reference

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final String toString() {
            return key + "=" + value;
        }
    }

    // ===============================
    // 🔹 Instance Fields
    // ===============================
    Node<K, V>[] table;      // main array (bucket table)
    int size;                // total number of entries
    int threshold;           // resize limit
    final float loadFactor;  // 0.75 by default

    // ===============================
    // 🔹 Constructor
    // ===============================
    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    // ===============================
    // 🔹 Hash Function
    // ===============================
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // ===============================
    // 🔹 PUT Method (Main logic)
    // ===============================
    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    private V putVal(int hash, K key, V value) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;

        // Step 1️⃣: Table initialize if null
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;

        // Step 2️⃣: Find index
        i = (n - 1) & hash;

        // Step 3️⃣: If empty slot, insert new node
        if ((p = tab[i]) == null)
            tab[i] = new Node<>(hash, key, value, null);
        else {
            Node<K, V> e;
            K k;

            // Step 4️⃣: If same key found — update value
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                e = p;
            }
            // Step 5️⃣: Else collision → traverse linked list
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = new Node<>(hash, key, value, null);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }

            // Step 6️⃣: If same key found, replace value
            if (e != null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        // Step 7️⃣: Increment size & resize check
        if (++size > threshold)
            resize();

        return null;
    }

    // ===============================
    // 🔹 RESIZE (Rehashing)
    // ===============================
    final Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int newCap = (oldCap == 0) ? DEFAULT_INITIAL_CAPACITY : oldCap * 2;

        @SuppressWarnings("unchecked")
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;

        threshold = (int) (newCap * loadFactor);

        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else { // rehash linked list nodes
                        Node<K, V> next;
                        do {
                            next = e.next;
                            int i = e.hash & (newCap - 1);
                            e.next = newTab[i];
                            newTab[i] = e;
                            e = next;
                        } while (e != null);
                    }
                }
            }
        }
        return newTab;
    }

    // ===============================
    // 🔹 GET Method
    // ===============================
    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    final Node<K, V> getNode(int hash, Object key) {
        Node<K, V>[] tab;
        Node<K, V> first, e;
        int n;
        K k;

        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {

            if (first.hash == hash &&
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;

            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    // ===============================
    // 🔹 REMOVE Method
    // ===============================
    public V remove(Object key) {
        Node<K, V> e = removeNode(hash(key), key);
        return (e == null) ? null : e.value;
    }

    final Node<K, V> removeNode(int hash, Object key) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, index;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (p = tab[index = (n - 1) & hash]) != null) {

            Node<K, V> node = null, e;
            K k;
            V v;

            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                node = p;
            else if ((e = p.next) != null) {
                Node<K, V> prev = p;
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k)))) {
                        node = e;
                        break;
                    }
                    prev = e;
                } while ((e = e.next) != null);

                if (node != null)
                    prev.next = node.next; // unlink node
            }

            if (node != null) {
                if (node == p)
                    tab[index] = node.next;
                --size;
                return node;
            }
        }
        return null;
    }

    // ===============================
    // 🔹 Size & Display
    // ===============================
    public int size() {
        return size;
    }

    public void printMap() {
        System.out.println("=== HashMap Contents ===");
        if (table == null) {
            System.out.println("Empty!");
            return;
        }
        for (int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];
            if (node != null) {
                System.out.print("Bucket " + i + " -> ");
                while (node != null) {
                    System.out.print(node + "  ");
                    node = node.next;
                }
                System.out.println();
            }
        }
    }
}

