package main.java;

public class LockerLockedException extends Throwable {
    public LockerLockedException(String error) {
        super("Box locked");
    }
}
