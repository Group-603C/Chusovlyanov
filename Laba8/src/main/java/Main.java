package main.java;

public class Main {
    public static void main(String[] args) throws LockerLockedException {
        try {

            Locker in = new Locker();
            in.setValue(10);
            System.out.println(in.getValue());
            in.lock();
            in.setValue(15);
            System.out.println(in.getValue());
        }catch (LockerLockedException e){
            System.out.println("23e");
        }
    }
}
