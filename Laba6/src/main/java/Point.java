package main.java;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
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
        return Math.sqrt(Math.pow(point.x - this.x, 2.0) + Math.pow(point.y - this.y, 2.0) + Math.pow(point.z - this.z, 2.0));
    }

    public PolarPoint toPolar() {
        double rho = Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0));
        double phi = convertToPhi();
        return new PolarPoint(rho, phi);
    }

    public CylindricalPoint toCylindrical() {
        double rho = Math.sqrt(Math.pow(this.x, 2.0) + Math.pow(this.y, 2.0));
        double phi = convertToPhi();
        return new CylindricalPoint(rho, phi, this.z);
    }

    public static boolean isOneStraightLine(Point first, Point send, Point third) {
        if ((first.x - third.x) * (send.y - third.y) - (send.x - third.x) * (first.y - third.y) == 0) {
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

    private double convertToPhi() {

        if (x < 0) {
            return Math.atan2(y, x) + Math.PI;
        } else if (x > 0 && y < 0) {
            return Math.atan2(y, x) + 2 * Math.PI;
        } else if (x > 0 && y >= 0) {
            return Math.atan2(y, x);
        } else if (x == 0 && y > 0) {
            return Math.PI / 2;
        } else if (x == 0 && y < 0) {
            return 3 * Math.PI / 2;
        }

        return -1d;
    }

}