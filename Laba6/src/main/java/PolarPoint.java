package main.java;

public class PolarPoint {
    private double rho;
    private double phi;

    public PolarPoint(double rho, double phi) {
        while (phi >= 2 * Math.PI){
            phi -= 2 * Math.PI;
        }
        while (phi < 0){
            phi += 2 * Math.PI;
        }
        this.rho = rho;
        this.phi = phi;
    }

    public double getRho() {
        return this.rho;
    }

    public double getPhi() {
        return this.phi;
    }

    public Point toCartesian() {
        double x =this.rho*Math.cos(this.phi);
        double y = this.rho*Math.sin(this.phi);
        return new Point(x,y);
    }
}
