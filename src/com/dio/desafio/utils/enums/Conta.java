package com.dio.desafio.utils.enums;

// Apenas para *simular* um login
public enum Conta {
    DEV("Dev"),
    ADMIN("Admin");

    private final String conta;

    Conta(String conta){
        this.conta = conta;
    }

    @Override
    public String toString(){
        return this.conta;
    }
}
