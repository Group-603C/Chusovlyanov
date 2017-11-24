package main.java;

public class LockerLockedException extends Throwable {
    public LockerLockedException() {
        super("Box locked");
    }
}
