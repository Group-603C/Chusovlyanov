package main.java;

public class Locker {
    private int value;
    private boolean lock;

    public Locker(int value) {
        this.value = value;
        this.lock=false;
    }

    public void setValue(int value) throws LockerLockedException {
        if (!lock) {
            this.value = value;
        } else {
            throw new LockerLockedException();
        }
    }

    public int getValue() {
        return value;

    }

    public void lock() {
        lock = true;
    }

    public void unlock() {
        lock = false;
    }


}
