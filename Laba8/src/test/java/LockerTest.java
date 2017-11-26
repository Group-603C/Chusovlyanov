package test.java;

import main.java.Locker;
import main.java.LockerLockedException;
import org.junit.Test;

import static org.junit.Assert.*;

public class LockerTest {

    @Test(expected = LockerLockedException.class)
    public void lock() throws LockerLockedException {
        Locker number = new Locker(10);
        number.lock();
        number.setValue(15);
    }

    @org.junit.Test
    public void setValue() throws  LockerLockedException {
        Locker number = new Locker(10);
        assertEquals(10, number.getValue());
    }

    @org.junit.Test
    public void unlock() throws  LockerLockedException {
        Locker number = new Locker(10);
        number.lock();
        number.unlock();
        number.setValue(15);
        assertEquals(15, number.getValue());
    }

}