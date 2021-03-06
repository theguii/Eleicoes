package br.ufsc.ine5605.trabalho1.entidade;

import java.io.Serializable;

public class Candidato implements Serializable {

    private int numero;
    private String nome;
    private Cidade cidade;
    private Cargo cargo;
    private Partido partido;

    public Candidato(int numero, String nome, Cargo cargo, Cidade cidade, Partido partido) {
        this.numero = numero;
        this.nome = nome;
        this.cargo = cargo;
        this.cidade = cidade;
        this.partido = partido;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        try {
            if (numero > 1 && numero < 99) {
                this.numero = numero;
            }
        } catch (Exception e) {

        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;

    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public boolean equals(Object p) {
        if (p instanceof Candidato) {
            Candidato p1 = (Candidato) p;
            return p1.getNumero() == numero;
        }
        return false;
    }
}
