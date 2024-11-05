package org.example;

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


    public void run(){
        try {
            switch (operacioAFer) {
                case 1:
                    System.out.println("[" + Thread.currentThread().getName() + "] (1/2) Ingressant 400");
                    ingresar(400);
                    break;
                default:

                case 2:
                    System.out.println("[" + Thread.currentThread().getName() + "] (1/2) sacando 200");
                    treure(200);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}