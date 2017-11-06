package main.java;

public class CylindricalPoint {
    private double rho;
    private double phi;
    private double z;

    public CylindricalPoint(double rho, double phi, double z) {
        this.rho = rho;
        this.phi = phi;
        this.z = z;
    }

    public double getRho() {
        return this.rho;
    }

    public double getPhi() {
        return this.phi;
    }

    public double getZ() {
        return this.z;
    }

    public Point toCartesian() {
        double x =this.rho*Math.cos(this.phi);
        double y = this.rho*Math.sin(this.phi);
        return new Point(x,y,this.z);
    }
}
