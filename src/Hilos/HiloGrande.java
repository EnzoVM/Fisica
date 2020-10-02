
package Hilos;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.Caida_grande;

public class HiloGrande extends Thread{
    private Caida_grande cg;
    private JLabel imagen;
    boolean opcion=true;
    boolean opcion1=true;

    public HiloGrande(Caida_grande cg, JLabel imagen) {
        this.cg = cg;
        this.imagen = imagen;
    }

    public double posicion(int y, double g, int t){
        return y+(g*t*t)/2;
    }
    
    @Override
    public void run(){
        cg.imagen1();
        int ap=0;
        int tiempo=0;
        //animacion de caida pequeña
        try{
            while (opcion) { 
                sleep(40);
                tiempo++;
                ap= cg.getCaida().getLocation().y;
                imagen.setLocation(150, ap + ((int)posicion(ap, Double.parseDouble(cg.getTxtGravedad().getText()), tiempo))/1000);
                cg.repaint();
                if(ap>=400){
                   opcion=false;
                   cg.imagen2();
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
                sleep(90);
                tiempo++;
                ac= cg.getCaida().getLocation().y;
                imagen.setLocation(150, ac + ((int)posicion(ac, Double.parseDouble(cg.getTxtGravedad().getText()), tiempo))/1000);
                cg.repaint();
                if(ac>=520){
                   opcion1=false;
                }
            }
        }catch(Exception e){}
    }
    
}
