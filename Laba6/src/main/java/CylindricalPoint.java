package main.java;

public class CylindricalPoint extends PolarPoint {
    private double z;

    public CylindricalPoint(double rho, double phi, double z) {
        super(rho, phi);
        this.z = z;
    }

    public double getRho() {
        return super.getRho();
    }

    public double getPhi() {
        return super.getPhi();
    }

    public double getZ() {
        return this.z;
    }

    public Point toCartesian() {
        double x = super.getRho() * Math.cos(super.getPhi());
        double y = super.getRho() * Math.sin(super.getPhi());
        return new Point(x, y, this.z);
    }
}
