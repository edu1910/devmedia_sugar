package br.com.devmedia.sugar.model;
import com.orm.SugarRecord;
import java.util.ArrayList;
import java.util.List;

public class Livro extends SugarRecord {
    private String titulo;
    private String descricao;
    private String codigoISBN;

    private Editora editora; /* Relacionamento many-to-one */

    public Livro() {
        /* Mantenha sempre o construtor padrão */
    }

    public Livro(String titulo, String descricao, String codigoISBN,
                 Editora editora) {
        setTitulo(titulo);
        setDescricao(descricao);
        setCodigoISBN(codigoISBN);
        setEditora(editora);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(String codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Autor> getAutores() {
        List<Autor> autores = new ArrayList<>();

        for (Obra obra : Obra.find(Obra.class, "livro = ?",
                String.valueOf(getId()))) {
            autores.add(obra.getAutor());
        }

        return autores;
    }
}
