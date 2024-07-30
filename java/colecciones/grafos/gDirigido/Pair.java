package grafos.gDirigido;

public class Pair<K, V> {
    private K key;
    private V peso;

    public Pair(K key, V peso) {
        this.key = key;
        this.peso = peso;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return peso;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!key.equals(pair.key)) return false;
        return peso.equals(pair.peso);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + peso.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "(" + key + ", peso: " + peso + ")";
    }
}
