package br.com.devmedia.sugar.model;
import com.orm.SugarRecord;

public class Editora extends SugarRecord {
    private String nome;

    public Editora() {
        /* Mantenha sempre o construtor padrão */
    }

    public Editora(String nome) {
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
