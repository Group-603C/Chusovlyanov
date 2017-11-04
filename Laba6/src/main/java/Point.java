package main.java;

public class Point {
    private double x;
    private double y;
    private double z = 0;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2) + Math.pow(point.z - this.z, 2));
    }

    public PolarPoint toPolar() {
        PolarPoint point = new PolarPoint(x, y);
        return point.toCartesian();
    }

    public CylindricalPoint toCylindrical() {
        CylindricalPoint point = new CylindricalPoint(x, y, z);
        return point.toCaresian();
    }

    public static boolean isOneStraightLine(Point first, Point send, Point third) {
        if ((1 / 2 * (first.x - third.x) * (send.y - third.y) - (send.x - third.x) * (first.y - third.y)) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isOnePlane(Point first, Point send, Point third, Point fourth) {
        double mas[] = new double[9];
        mas[0] = send.x - first.x;
        mas[1] = send.y - first.y;
        mas[2] = send.z - first.z;
        mas[3] = third.x - send.x;
        mas[4] = third.y - send.y;
        mas[5] = third.z - send.z;
        mas[6] = fourth.x - third.x;
        mas[7] = fourth.y - third.y;
        mas[8] = fourth.z - third.z;
        if (((mas[0] * mas[4] * mas[8]) - (mas[0] * mas[5] * mas[7]) - (mas[1] * mas[3] * mas[8]) + (mas[1] * mas[5] * mas[6]) + (mas[2] * mas[3] * mas[7]) - (mas[2] * mas[4] * mas[6])) == 0) {
            return true;
        }
        return false;
    }


}