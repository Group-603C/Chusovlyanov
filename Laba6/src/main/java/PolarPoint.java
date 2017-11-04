package main.java;

public class PolarPoint {
    private double rho;
    private double phi;

    public PolarPoint(double rho, double phi) {
        this.rho = rho;
        this.phi = phi;
    }

    public double getRho() {
        return this.rho;
    }

    public double getPhi() {
        return this.phi;
    }

    public PolarPoint toCartesian() {
        double rho = Math.sqrt(Math.pow(this.rho, 2) + Math.pow(this.phi, 2));
        double phi = Math.atan(this.phi / this.rho);
        this.rho = rho;
        this.phi = phi;
        return this;
    }
}
