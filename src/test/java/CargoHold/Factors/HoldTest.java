package CargoHold.Factors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HoldTest {

    @Test
    void holdCost() {
        var hold = new Hold(10);
        assertEquals(7.5,hold.holdCost());
    }
}