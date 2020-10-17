
package Hilos;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.*;

public class HiloPequeño extends HiloPrincipal {
    private Caida_pequeña cp;

    public HiloPequeño(JLabel imagen, Caida_pequeña cp) {
        super(imagen);
        this.cp = cp;
    }
   
    @Override
    public void run(){
        cp.imagen1();
        int ap=0;
        int tiempo=0;
        //animacion de caida pequeña
        try{
            while (super.isOpcion()) { 
                sleep(15);
                tiempo++;
                ap= cp.getCaida().getLocation().y;
                super.getImagen().setLocation(150, ap + ((int)posicion(ap, Double.parseDouble(cp.getTxtGravedad().getText()), tiempo))/1000);
                cp.repaint();
                if(ap>=400){
                   super.setOpcion(false);
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
            while (super.isOpcion1()) { 
                sleep(80);
                tiempo++;
                ac= cp.getCaida().getLocation().y;
                super.getImagen().setLocation(150, ac + ((int)posicion(ac, Double.parseDouble(cp.getTxtGravedad().getText()), tiempo))/1000);
                cp.repaint();
                if(ac>=520){
                   super.setOpcion1(false);
                }
            }
        }catch(Exception e){}
    }
}