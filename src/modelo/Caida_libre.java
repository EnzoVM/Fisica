
package modelo;

public class Caida_libre {
    private int hi;
    private int hf;
    private double g;

    public Caida_libre(int hi, int hf, double g) {
        this.hi = hi;
        this.hf = hf;
        this.g = g;
    }
    
    public double tiempo(){
        return Math.sqrt((hi-hf)*2/g);
    }
    
    public double velocidad(){
        return g*tiempo();
    }
    
    public int getHi() {
        return hi;
    }

    public void setHi(int hi) {
        this.hi = hi;
    }

    public int getHf() {
        return hf;
    }

    public void setHf(int hf) {
        this.hf = hf;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }
    
    
}
