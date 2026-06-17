package Model;

import java.util.ArrayList;
import java.util.List;

public class Playlist extends EntidadeBase {
    private static final long serialVersionUID = 1L;

    private Usuario dono;
    private final List<Musica> musicas = new ArrayList<>();

    public Playlist(String nome, Usuario dono) {
        super(nome);
        if (dono == null) {
            throw new IllegalArgumentException("Dono da playlist e obrigatorio.");
        }
        this.dono = dono;
    }

    public Usuario getDono() {
        return dono;
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
        return "#" + getId() + " Playlist: " + getNome() + " | Dono: " + dono.getNome() + " | Musicas: " + musicas.size();
    }
}