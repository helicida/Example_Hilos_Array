package ArrayThreads;

/**
 * Created by 46465442z on 15/10/15.
 */
public class Fil extends Thread{

    public static int numeroDexecucio = 0;  //Numero d'execucions dels fils

    public void run(){
        ControladorFils.afegirNombre();
        System.out.print("Execució " + numeroDexecucio + " | ");
        numeroDexecucio++;
    }
}
