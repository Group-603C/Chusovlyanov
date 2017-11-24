package main.java;

public class Main {
    public static void main(String[] args) throws LockerLockedException {

            Locker in = new Locker(10);
            System.out.println(in.getValue());
            in.lock();
            in.setValue(15);
            System.out.println(in.getValue());
    }
}
