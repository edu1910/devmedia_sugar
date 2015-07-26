package br.com.devmedia.sugar.model;
import com.orm.SugarRecord;
import java.util.ArrayList;
import java.util.List;

public class Autor extends SugarRecord {
    private String nome;
    private String sobreNome;

    public Autor() {
        /* Mantenha sempre o construtor padrão */
    }

    public Autor(String nome, String sobreNome) {
        setNome(nome);
        setSobreNome(sobreNome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public List<Livro> getLivros() {
        List<Livro> livros = new ArrayList<>();

        for (Obra obra : Obra.find(Obra.class, "autor = ?",
                String.valueOf(getId()))) {
            livros.add(obra.getLivro());
        }

        return livros;
    }

    public static List<Autor> findBySobreNome(String sobreNome) {
        return Autor.find(Autor.class, "sobre_nome = ?", sobreNome);
    }
}
