package org.example;

import java.io.IOError;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CaixerBanc implements Runnable{

    private CompteBancari compte;
    private int operacioAFer;

    public CompteBancari getCompte() {
        return compte;
    }

    public CaixerBanc(CompteBancari compte, int operacioAFer) {
        this.compte = compte;
        this.operacioAFer = operacioAFer;
    }

    public void setCompte(CompteBancari compte) {
        this.compte = compte;
    }

    public int getOperacioAFer() {
        return operacioAFer;
    }

    public void setOperacioAFer(int operacioAFer) {
        this.operacioAFer = operacioAFer;
    }


    //metodo ingresar
    public void ingresar (float diners)throws Exception{
        this.compte.ingresar(diners, Thread.currentThread().getName());
    }

    //metodo treure
    public void treure (float diners)throws Exception{
        this.compte.treure(diners, Thread.currentThread().getName());
    }

    //metodo ingresar
    public void ingresar (CompteBancari compte, float diners)throws Exception{
        this.compte.ingresar(diners, Thread.currentThread().getName());
    }

    //metodo treure
    public void treure (CompteBancari compte, float diners)throws Exception{
        this.compte.treure(diners, Thread.currentThread().getName());
    }



    private CompteBancari compteOpcional; //Interbloqueo

    public CaixerBanc(CompteBancari compte1, int operacioAFer1, CompteBancari compteOpcional1) {
        this.compte = compte1;
        this.operacioAFer = operacioAFer1;
        this.compteOpcional = compteOpcional1;
    }


    //tenemos aue hacer transferencias entre 2 cuentas

    public void transferirDiners(CompteBancari compteOrigen, CompteBancari compteDesti, float quantitat) throws Exception {
        synchronized (compteOrigen){
            System.out.println(Thread.currentThread().getName()+" a bloquedo la cuenta origen"+ compteOrigen.getIdConter());

            Thread.sleep(1000);

            synchronized (compteDesti){
                System.out.println(Thread.currentThread().getName()+" a bloquedo la cuenta destino" + compteDesti.getIdConter());

                Thread.sleep(1000);

                //codigo sincronzado para realizar la transferencia

                if( compteOrigen.getSaldo() >= quantitat){
                    compteOrigen.treure(quantitat,Thread.currentThread().getName());
                    compteDesti.ingresar(quantitat, Thread.currentThread().getName());
                }
            }

        }
    }

    //interbloqueo solucion
    //establecer orden en la sincronizacion, creamos 2 objetos de tipo CuentaBancario y asignarle un
    //orde en funcion de su orden numerico para que el bloqueo se haga siempre en el mismo orden independientemente de la llamada al metodo

    public void transferirDinersOK(CompteBancari cOrigen, CompteBancari cDesti, float quantitat) throws Exception {
        CompteBancari compteA = null;
        CompteBancari compteB = null;

        if(cOrigen.getIdConter() < cDesti.getIdConter()){
            compteA = cOrigen;
            compteB = cDesti;
        }else if(cOrigen.getIdConter() > cDesti.getIdConter()){
            compteA = cDesti;
            compteB = cOrigen;
        }else{
            return;
        }

        //syncronizacin ordenada
        synchronized (compteA){
            synchronized (compteB){
                if(cOrigen.getSaldo()>=quantitat){
                    cOrigen.treure(quantitat, Thread.currentThread().getName());
                    cDesti.ingresar(quantitat, Thread.currentThread().getName());
                }
            }
        }

        }

    public void run(){
        //Java permet sincronizar nomes una part del codi dins d'un metode
        //S'executa en exclusio mutua
        try {
            switch (operacioAFer) {
                    case 1:
                        synchronized(compte) {//refrenciar un objecte
                        System.out.println("[" + Thread.currentThread().getName() + "] (1/2) Ingressant 400");
                        ingresar(400);
                        System.out.println("[" + Thread.currentThread().getName() + "] (1/2) Treure 200");
                        treure(200);
                        break;
                }
                    default:


                        System.out.println("[" + Thread.currentThread().getName() + "] (1/2) sacando 600");
                        treure(600);
                        System.out.println("[" + Thread.currentThread().getName() + "] (1/2) ingresar 200");
                        ingresar(200);
                        break;
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}