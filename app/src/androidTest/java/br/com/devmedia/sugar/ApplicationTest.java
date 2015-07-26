package br.com.devmedia.sugar;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import br.com.devmedia.sugar.model.Autor;
import br.com.devmedia.sugar.model.Editora;
import br.com.devmedia.sugar.model.Livro;
import br.com.devmedia.sugar.model.Obra;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testDb() {
        Autor autor = new Autor("Nelson", "Glauber");
        Editora editora = new Editora("Novatec");

        autor.save();
        editora.save();

        Livro livro = new Livro("Dominando o Android - Do Básico ao Avançado",
                "Dominando o Android aborda desde os conceitos mais " +
                        "básicos até as técnicas mais avançadas no " +
                        "desenvolvimento de aplicativos para plataforma " +
                        "mobile do Google. ",
                "978-85-7522-412-0", editora);
        livro.save();

        Obra obra = new Obra(autor, livro);
        obra.save();

        for (Livro liv : Livro.listAll(Livro.class)) {
            Log.d("SUGAR", "Título: " + liv.getTitulo());
            Log.d("SUGAR", "Descrição: " + liv.getDescricao());
            Log.d("SUGAR", "Editora: " + liv.getEditora().getNome());

            for (Autor aut : liv.getAutores()) {
                Log.d("SUGAR", "Autor: " + aut.getSobreNome() + ", " + aut.getNome());
            }
        }
    }
}