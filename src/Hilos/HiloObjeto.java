
package Hilos;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.Caida_Objeto;

public class HiloObjeto extends Thread{
    private Caida_Objeto co;
    private JLabel imagen;
    boolean opcion=true;
    boolean opcion1=true;

    public HiloObjeto(Caida_Objeto co, JLabel imagen) {
        this.co = co;
        this.imagen = imagen;
    }
    
    public double posicion(int y, double g, int t){
        return y+(g*t*t)/2;
    }
    
    @Override
    public void run(){
        co.imagen();
        int ap=0;
        int tiempo=0;
        //animacion de caida pequeña
        try{
            while (opcion) { 
                sleep(10);
                tiempo++;
                ap= co.getCaida().getLocation().y;
                imagen.setLocation(150, ap + ((int)posicion(ap, Double.parseDouble(co.getTxtGravedad().getText()), tiempo))/1000);
                co.repaint();
                if(ap>=520){
                   opcion=false;                  
                   JOptionPane.showMessageDialog(null, "Ha Finalizado la simulación");
                }
            }
        }catch(Exception e){}
    }
}
