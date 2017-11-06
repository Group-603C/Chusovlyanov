package test.java;

import main.java.Locker;
import main.java.LockerLockedException;
import org.junit.Test;

import static org.junit.Assert.*;

public class LockerTest {

    @Test(expected = LockerLockedException.class)
    public void lock() throws Exception, LockerLockedException {
        Locker in = new Locker();
        in.setValue(10);
        in.lock();
        in.setValue(15);
    }
    @org.junit.Test
    public void setValue() throws Exception, LockerLockedException {
        Locker in = new Locker();
        in.setValue(10);
        assertEquals(10,in.getValue());
    }

    @org.junit.Test
    public void unlock() throws Exception, LockerLockedException {
        Locker in = new Locker();
        in.setValue(10);
        in.lock();
        in.unlock();
        in.setValue(15);
        assertEquals(15,in.getValue());
    }

}