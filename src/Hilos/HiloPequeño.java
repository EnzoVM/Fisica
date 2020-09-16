
package Hilos;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.*;

public class HiloPequeño extends Thread {
    private Caida_pequeña cp;
    private JLabel imagen;
    boolean opcion=true;
    boolean opcion1=true;

    public HiloPequeño(Caida_pequeña cp, JLabel imagen) {
        this.cp = cp;
        this.imagen = imagen;
    }
    
    public double posicion(int y, double g, int t){
        return y+(g*t*t)/2;
    }
    
    @Override
    public void run(){
        cp.imagen1();
        int ap=0;
        int tiempo=0;
        //animacion de caida pequeña
        try{
            while (opcion) { 
                sleep(15);
                tiempo++;
                ap= cp.getCaida().getLocation().y;
                imagen.setLocation(150, ap + ((int)posicion(ap, Double.parseDouble(cp.getTxtGravedad().getText()), tiempo))/1000);
                cp.repaint();
                if(ap>=400){
                   opcion=false;
                   cp.imagen2();
                   JOptionPane.showMessageDialog(null, "Se ha hallado la velocidad y el tiempo en este punto");
                   run2(tiempo);
                }
            }
        }catch(Exception e){}
    }
    
    public void run2(int tiempo){
        int ac=0;
        //animacion de caida pequeña
        try{
            while (opcion1) { 
                sleep(500);
                tiempo++;
                ac= cp.getCaida().getLocation().y;
                imagen.setLocation(150, ac + ((int)posicion(ac, Double.parseDouble(cp.getTxtGravedad().getText()), tiempo))/1000);
                cp.repaint();
                if(ac>=520){
                   opcion1=false;
                }
            }
        }catch(Exception e){}
    }
}