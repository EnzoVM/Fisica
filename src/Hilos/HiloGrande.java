
package Hilos;

import static java.lang.Thread.sleep;
import vista.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HiloGrande extends HiloPrincipal{
    private Caida_grande cg;
    
    public HiloGrande(JLabel imagen, Caida_grande cg) {
        super(imagen);
        this.cg = cg;
    }
    
    @Override
    public void run() {
        cg.imagen1();
        int ap=0;
        int tiempo=0;
        //animacion de caida pequeña
        try{
            while (super.isOpcion()){ 
                sleep(50);
                tiempo++;
                ap= cg.getCaida().getLocation().y;
                super.getImagen().setLocation(150, ap + ((int)posicion(ap, Double.parseDouble(cg.getTxtGravedad().getText()), tiempo))/1000);
                cg.repaint();
                if(ap>=400){
                   super.setOpcion(false);
                   cg.imagen2();
                   JOptionPane.showMessageDialog(null, "Se ha hallado la velocidad y el tiempo en este punto");
                   run2(tiempo);
                }
            }
        }catch(Exception e){}
    }

    @Override
    public void run2(int tiempo) {
        int ac=0;
        //animacion de caida pequeña
        try{
            while (super.isOpcion1()) { 
                sleep(100);
                tiempo++;
                ac= cg.getCaida().getLocation().y;
                super.getImagen().setLocation(150, ac + ((int)posicion(ac, Double.parseDouble(cg.getTxtGravedad().getText()), tiempo))/1000);
                cg.repaint();
                if(ac>=520){
                   super.setOpcion1(false);
                }
            }
        }catch(Exception e){}
    } 
}
