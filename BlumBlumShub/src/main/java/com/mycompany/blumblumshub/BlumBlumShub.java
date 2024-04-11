/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.blumblumshub;

/**
 *
 * @author agata
 */

// p <- 10007
// q <-  10009
// s <- 101

import java.math.BigInteger;

public class BlumBlumShub {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger s;

    public BlumBlumShub(BigInteger p, BigInteger q, BigInteger s) {
        this.p = p;
        this.q = q;
        this.n = p.multiply(q);
        this.s = s;
    }

    //implementa a fórmula do Blum Blum Shub: s = (s^2) mod n. 
    //atualiza o valor de s e retorna o novo valor como um número pseudoaleatório.
    public BigInteger nextRandom() {
        s = s.modPow(BigInteger.valueOf(2), n);
        return s;
    }
    //Em um loop, são gerados 10 números pseudoaleatórios.
    public static void main(String[] args) {
        //Escolhi dois números primos grandes, p e q, maiores que 10.000
        BigInteger p = new BigInteger("10007");
        BigInteger q = new BigInteger("10009"); 

        // Calculando n = p * q
        BigInteger n = p.multiply(q);

        // Escolhendo um número relativamente primo a n (nesse caso, um número primo)
        //s e n não têm fatores em comum além de 1.
        BigInteger s = new BigInteger("101");

        BlumBlumShub bbs = new BlumBlumShub(p, q, s);

        // Gerando alguns números pseudoaleatórios
        for (int i = 0; i < 10; i++) {
            System.out.println(bbs.nextRandom());
        }

        // Mostrando os valores de p, q e s
        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("s: " + s);
    }
}

