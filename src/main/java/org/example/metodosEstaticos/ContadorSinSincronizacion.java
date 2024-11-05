package org.example.metodosEstaticos;

import org.w3c.dom.ls.LSOutput;

public class ContadorSinSincronizacion {

    private static int contador = 0;

        //metodo estatico sin sincronizacion

//    public synchronized static  void incrementar(){
//        contador++;
//        System.out.println("contador sin sincronizacino" );
//    }

    public static void incrementar(){
        System.out.println("Preparando para incrementar ...");

        synchronized (ContadorSinSincronizacion.class){
            contador++;
            System.out.println("contador con sincronizacion en el bloque "+ contador);
        }
        System.out.println("incremento completado");
    }

    public static int obtenerContador(){
        return contador;
    }


    }
class TestSincronizacionSin{

    public static void main(String[] args) {

        Runnable tareaIncremento = () -> {
            for (int i = 0; i < 10; i++) {
                ContadorSinSincronizacion.incrementar();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread hilo1 =  new Thread(tareaIncremento);
        Thread hilo2 =  new Thread(tareaIncremento);
        Thread hilo3 =  new Thread(tareaIncremento);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("valor fin al del contador sin sincronizacion "+ ContadorSinSincronizacion.obtenerContador());
    }




}
