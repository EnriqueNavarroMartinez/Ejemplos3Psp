package org.example;

public class App {

    public static void main(String[] args) throws InterruptedException {

        CompteBancari compteA = new CompteBancari(2100, 1450);
        CompteBancari compteB = new CompteBancari(7400, 2700);

        System.out.println("[Programa principal inici ] + INICI CompteA "+compteA.getIdConter()+" amb saldo de "+ compteA.getSaldo());
        System.out.println("[Programa principal inici ] + INICI CompteA "+compteB.getIdConter()+" amb saldo de "+ compteB.getSaldo());


        CaixerBanc obj1 = new CaixerBanc(compteA, 1,compteB );
        CaixerBanc obj2 = new CaixerBanc(compteB, 2,compteA );

        //
        Thread fil1 = new Thread(()->{
            try{
                obj1.transferirDinersOK(compteA, compteB, 200);
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "Hombre");

        Thread fil2 = new Thread(()->{
            try{
                obj2.transferirDinersOK(compteB, compteA, 100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "Mujer");

        fil1.start();
        fil2.start();
        fil1.join();
        fil2.join();

        System.out.println("Programa principal: Finalizacion del programa principal "+ compteA.getIdConter() +" con saldo "+compteA.getSaldo());

        System.out.println("Programa principal: Finalizacion del programa principal "+ compteB.getIdConter() +" con saldo "+compteB.getSaldo());

    }
}
