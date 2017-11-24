package main.java;

public class Locker {
    private int value;
    private boolean look;

    public Locker(int value) {
        this.value = value;
    }

    public void setValue(int value) throws LockerLockedException {
        if (look == false) {
            this.value = value;
        } else {
            throw new LockerLockedException();
        }
    }

    public int getValue() {
        return value;

    }

    public void lock() {
        look = true;
    }

    public void unlock() {
        look = false;
    }


}
