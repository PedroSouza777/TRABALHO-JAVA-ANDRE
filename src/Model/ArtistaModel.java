package Model;

import java.util.ArrayList;
import java.util.List;

public class Artista extends EntidadeBase {
    private static final long serialVersionUID = 1L;

    private String genero;
    private final List<Musica> musicas = new ArrayList<>();

    public Artista(String nome, String genero) {
        super(nome);
        setGenero(genero);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            throw new IllegalArgumentException("Genero e obrigatorio.");
        }
        this.genero = genero.trim();
    }

    public void adicionarMusica(Musica musica) {
        if (musica != null && !musicas.contains(musica)) {
            musicas.add(musica);
        }
    }

    public List<Musica> getMusicas() {
        return new ArrayList<>(musicas);
    }

    @Override
    public String resumo() {
        return "#" + getId() + " Artista: " + getNome() + " | Genero: " + genero + " | Musicas: " + musicas.size();
    }
}