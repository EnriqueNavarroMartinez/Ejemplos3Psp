package org.example.sincronize;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CompteBancari {

        //cuneta bancaria

        //un banco que dispone de una cuenta determinada


            private float saldo;

            public float getSaldo() {
                return saldo;
            }

            public void setSaldo(float saldo) {
                this.saldo = saldo;
            }

            public CompteBancari(float saldoInicial){
                this.setSaldo(saldoInicial);
            }

            //metodos ingresar dinero

    //sincronizamos los metodos del objeto compartido
    //sincronizamos el metodo. Añadir sincronice en seccion critica
            public synchronized void ingresar (float diners, String nomFil) throws Exception {

                float aux;
                System.out.println("["+ nomFil+"]" + " Ingressant "+ diners+ " €");
                aux = getSaldo();
                System.out.println("["+ nomFil+"]" + aux+ "=getSaldo()"+diners+" €");
                aux = aux + diners;
                System.out.println("["+ nomFil+"]" + "setSaldo ("+ aux +")");
                setSaldo(aux);
            }

            //metodos retirar dinero
            public synchronized void treure (float diners, String nomFil) throws Exception {

                float aux;
                System.out.println("["+ nomFil+"]" + " Ingressant "+ diners+ " €");
                aux = getSaldo();
                System.out.println("["+ nomFil+"]" + aux+ "=getSaldo()"+diners+" €");
                aux = aux - diners;
                System.out.println("["+ nomFil+"]" + "setSaldo ("+ aux +")");
                setSaldo(aux);
            }

            //garantizar que nigun otro hilo pueda acceder a los metodos
    //sincronizados del mismo hilo, El hilo bloquea el metodo hasta finalizar ejecucion

        }


