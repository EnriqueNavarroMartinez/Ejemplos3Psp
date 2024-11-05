package org.example;

import java.io.IOException;

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
            public void ingresar (float diners, String nomFil) throws Exception {

                float aux;
                System.out.println("["+ nomFil+"]" + " Ingressant "+ diners+ " €");
                aux = getSaldo();
                System.out.println("["+ nomFil+"]" + aux+ "=getSaldo()"+diners+" €");
                aux = aux + diners;
                System.out.println("["+ nomFil+"]" + "setSaldo ("+ aux +")");
                setSaldo(aux);
            }

            //metodos retirar dinero
            public void treure (float diners, String nomFil) throws Exception {

                float aux;
                System.out.println("["+ nomFil+"]" + " Ingressant "+ diners+ " €");
                aux = getSaldo();
                System.out.println("["+ nomFil+"]" + aux+ "=getSaldo()"+diners+" €");
                aux = aux - diners;
                System.out.println("["+ nomFil+"]" + "setSaldo ("+ aux +")");
                setSaldo(aux);
            }

        }


