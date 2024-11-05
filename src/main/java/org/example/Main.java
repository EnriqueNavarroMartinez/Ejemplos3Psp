package org.example;

import javax.print.attribute.standard.Compression;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CompteBancari compte = new CompteBancari(0);

        System.out.println("Programa princnipal"+ compte.getSaldo());

        CaixerBanc obj1 = new CaixerBanc(compte, 1);
        CaixerBanc obj2 = new CaixerBanc(compte, 2);

        Thread fil1= new Thread(obj1, "home");
        Thread fil2= new Thread(obj2, "home");

        fil1.start();
        fil2.start();
        fil1.join();
        fil2.join();

        System.out.println(" el saldo final es "+compte.getSaldo());

        //estos errores son debidos a condiciones de carrera
        //seccion critica son la zonas que acceden a un recurso compartido

        //para evitar estas cindiciones de carreras se tiene que ejecutar la exclusio mutua
        //eso se consigue en java sincronizando


    }
}
