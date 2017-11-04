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

    public CylindricalPoint toCaresian() {
        double rho = Math.sqrt(Math.pow(this.rho, 2) + Math.pow(this.phi, 2));
        double phi = Math.atan(this.phi / this.rho);
        this.rho = rho;
        this.phi = phi;
        return this;
    }
}
