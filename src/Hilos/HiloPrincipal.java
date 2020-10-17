
package Hilos;

import javax.swing.JLabel;

public abstract class HiloPrincipal extends Thread{
    private JLabel imagen;
    private boolean opcion=true;
    private boolean opcion1=true;

    public HiloPrincipal(JLabel imagen) {
        this.imagen = imagen;
    }
    
    public double posicion(int y, double g, int t){
        return y+(g*t*t)/2;
    }
    
    @Override
    public abstract void run();
    public abstract void run2(int tiempo);

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public boolean isOpcion() {
        return opcion;
    }

    public void setOpcion(boolean opcion) {
        this.opcion = opcion;
    }

    public boolean isOpcion1() {
        return opcion1;
    }

    public void setOpcion1(boolean opcion1) {
        this.opcion1 = opcion1;
    }  
}
