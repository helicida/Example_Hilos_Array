package ArrayThreads;

/**
 * Created by 46465442z on 15/10/15.
 */

import java.util.*;

public class ControladorFils{

    public static int arrayNumeros[] = new int[1000]; //Array de 1000 posicions on seràn els numeros
    public static Thread[] arrayThreads; //Instanciamos el array de Threads
    public static int index = 0;
    public static int nombresPerFil;
    public static int numThreads;

    public static void main(String[] args){

        while (true){

            Scanner teclat = new Scanner(System.in);

            System.out.println("Introdueix el nombre de threads que vols fer servir - Ha de ser divisible de 1000");
                numThreads = teclat.nextInt();

            if (1000 % numThreads == 0){
                break;   // Fins que el nombre no sigui divisible, no deixarà de demanar
            }
            else{
                System.out.println("Nombre incorrecte. Introdueix un divisible de 1000");
            }
        }

        //Creem un array de threads amb la quantitat que ha introduit el usuari
        arrayThreads = new Fil[numThreads];
        nombresPerFil = 1000/numThreads;    //aqui designem quants numeros escriura cada fil

        //Amb aquest for asignem un thread a cada posicio del array de Fils
        for (int iterador = 0; iterador < numThreads; iterador++){
            arrayThreads[iterador]= new Fil();
        }

        //Ara fem les iteracions correspnents on s'executa cada Thread i es mostra per pantalla quin thread ha escrit quin numero i a quina posició
        for (int iteradorThreads = 0; iteradorThreads < numThreads; iteradorThreads++){
            for (int iteradorNombres = 0; iteradorNombres < nombresPerFil; iteradorNombres++){
                arrayThreads[iteradorThreads].run();
                System.out.println("  Thread " + iteradorThreads + " ha afegit el Nº " + arrayNumeros[index] + " al Array de Numeros a la posició [" + index + "]");
                System.out.println(" ----------------------------------------------------------------------------------------------------");
                index++;
            }
        }
    }

    //Funcio que cridarem desde el fil
    public static void afegirNombre(){
        arrayNumeros[index] = (int) (Math.random() * 1000 + 1); //Generem un numero aleatori que asignem al array de fils
    }

    // Getters

    public static int[] getArrayNumeros() {
        return arrayNumeros;
    }

    public static Thread[] getArrayThreads() {
        return arrayThreads;
    }

    public static int getIndex() {
        return index;
    }

    public static int getNombresPerFil() {
        return nombresPerFil;
    }

    public static int getNumThreads() {
        return numThreads;
    }

    // Setters

    public static void setArrayNumeros(int[] arrayNumeros) {
        ControladorFils.arrayNumeros = arrayNumeros;
    }

    public static void setArrayThreads(Thread[] arrayThreads) {
        ControladorFils.arrayThreads = arrayThreads;
    }

    public static void setIndex(int index) {
        ControladorFils.index = index;
    }

    public static void setNombresPerFil(int nombresPerFil) {
        ControladorFils.nombresPerFil = nombresPerFil;
    }

    public static void setNumThreads(int numThreads) {
        ControladorFils.numThreads = numThreads;
    }
}
