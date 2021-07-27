import java.util.List;
import java.util.LinkedList;

public class MyHash {
    
    List<Integer> [] buckets;
    int elementsCount = 0;

    public MyHash(int bucketsCount) {
        buckets = new LinkedList[bucketsCount];

        for(int i = 0; i < buckets.length; ++i) {
            buckets[i] = new LinkedList<Integer>();
        }

    }

    private int hash(Integer value) {
        return Math.abs(value) % buckets.length;
    }

    public void add(Integer value) {
        int h = hash(value);

        if(! contains(value)) {
            buckets[h].add(value);
            ++elementsCount;
        }
    }

    public boolean contains(Integer value) {
        int h = hash(value);
        return buckets[h].contains(value);
    }

    public void remove(Integer value) {
        int h = hash(value);

        if(contains(value)) {
            buckets[h].remove(value);
            --elementsCount;
        }        
    }

    public int size() {
        return elementsCount;
    }

    public int loadFactor() {
        int max = 0;
        for(int i = 0; i < buckets.length; ++i) {
            if(buckets[i].size() > max) {
                max = buckets[i].size();
            }
        }
        return max;
    }
}
