package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import app.MyHash;

class MyHashTest {
    final int elementsCount = 100;
    final int bucketsCount = elementsCount / 10;
    public MyHash h1 = new MyHash(bucketsCount);

    public MyHashTest() {
        for(int i = 0; i < elementsCount; ++i) {
            h1.add(i);
        }
    }

    @Test
    public void size_returnsCorrectValue() {
        assert h1.size() == elementsCount;
    }

    @Test
    public void contains_returnsTrueForAllAddedElements() {
        for(int i = 0; i < elementsCount; ++i) {
            assert h1.contains(i);
        }
    }

    @Test
    public void contains_returnsFalseForAllElementsWhichWereNotAdded() {
        for(int i = elementsCount; i < elementsCount + 100; ++i) {
            assert ! h1.contains(i);
        }

        for(int i = -100; i < 0; ++i) {
            assert ! h1.contains(i);
        }        
    }

    @Test
    public void remove_removesCorrectly() {
        for(int i = 0; i < elementsCount; ++i) {
            h1.remove(i);
            assert ! h1.contains(i);
        }
    }

    @Test
    public void loadFactor_returnsCorrectValue() {
        assert h1.loadFactor() == bucketsCount;
    }
}