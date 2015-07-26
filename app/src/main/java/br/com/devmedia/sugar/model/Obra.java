package br.com.devmedia.sugar.model;
import com.orm.SugarRecord;

public class Obra extends SugarRecord {
    private Autor autor; /* Relacionamento */
    private Livro livro; /* many-to-many   */

    public Obra() {
        /* Mantenha sempre o construtor padrão */
    }

    public Obra(Autor autor, Livro livro) {
        setAutor(autor);
        setLivro(livro);
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
