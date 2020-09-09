
package Hilos;
import javax.swing.JLabel;
import vista.*;

public class HiloPequeño extends Thread {
    private Caida_pequeña cp;
    private JLabel imagen;
    boolean opcion=true;

    public HiloPequeño(Caida_pequeña cp, JLabel imagen) {
        this.cp = cp;
        this.imagen = imagen;
    }
    
    public double posicion(int y, double g, int t){
        return y+(g*t*t)/2;
    }
    
    @Override
    public void run(){
        int ap=0;
        int tiempo=0;
        //animacion de caida pequeña
        try{
            while (opcion) { 
                sleep(10);
                tiempo++;
                ap= cp.getCaida().getLocation().y;
                imagen.setLocation(100, ap + ((int)posicion(ap, Double.parseDouble(cp.getTxtGravedad().getText()), tiempo))/1000);
                cp.repaint();
                if(ap>=500){
                   opcion=false;
                }
            }                       
        }catch(Exception e){}        
    }
}