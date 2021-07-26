import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class HashingTest {
    public Hashing h1 = new Hashing("abcd");

    @Test
    public void indexInitializesCorrectly(){
        assert h1.key == 0;
        assert h1.getSize() == 1;
    }
    @Test
    public void get_returnsNonNull() throws Exception {
        assert Objects.isNull(h1.get(0));
    }

}