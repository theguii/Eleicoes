package br.ufsc.ine5605.trabalho1.entidade;

import java.io.Serializable;

public class Cidade implements Serializable {

    private String nome;
    private final int codigo;

    public Cidade(String nome) {
        this.nome = nome;
        this.codigo = hashCode();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object p) {
        if (p instanceof Cidade) {
            Cidade p1 = (Cidade) p;
            return p1.getCodigo() == codigo;
        }
        return false;
    }
}
