
package Hilos;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.Caida_Objeto;

public class HiloObjeto extends HiloPrincipal{
    private Caida_Objeto co;

    public HiloObjeto(JLabel imagen, Caida_Objeto co) {
        super(imagen);
        this.co = co;
    }
    
    @Override
    public void run(){
        co.imagen();
        int ap=0;
        int tiempo=0;
        //animacion de caida pequeña
        try{
            while (super.isOpcion()) { 
                sleep(10);
                tiempo++;
                ap= co.getCaida().getLocation().y;
                super.getImagen().setLocation(150, ap + ((int)posicion(ap, Double.parseDouble(co.getTxtGravedad().getText()), tiempo))/1000);
                co.repaint();
                if(ap>=520){
                   super.setOpcion(false);
                   JOptionPane.showMessageDialog(null, "Ha Finalizado la simulación");
                }
            }
        }catch(Exception e){}
    }

    @Override
    public void run2(int tiempo) {}
    
}
