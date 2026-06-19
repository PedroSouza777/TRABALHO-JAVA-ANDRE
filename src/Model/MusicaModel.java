package Model;

public class Musica extends EntidadeBase {
    private static final long serialVersionUID = 1L;

    private ArtistaModel artista;
    private int duracaoSegundos;

    public Musica(String nome, ArtistaModel artista, int duracaoSegundos) {
        super(nome);
        if (artista == null) {
            throw new IllegalArgumentException("Artista e obrigatorio.");
        }
        this.artista = artista;
        setDuracaoSegundos(duracaoSegundos);
    }

    public ArtistaModel getArtista() {
        return artista;
    }

    public void setArtista(ArtistaModel artista) {
        if (artista == null) {
            throw new IllegalArgumentException("Artista e obrigatorio.");
        }
        this.artista = artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos <= 0) {
            throw new IllegalArgumentException("Duracao deve ser maior que zero.");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    @Override
    public String resumo() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return "#" + getId() + " Musica: " + getNome() + " | " + artista.getNome() + " | " + minutos + "m" + segundos + "s";
    }
}