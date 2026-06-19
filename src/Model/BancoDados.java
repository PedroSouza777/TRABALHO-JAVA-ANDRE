}

public Musica buscarMusicaPorNome(String nome) {
    for (Musica musica : musicas) {
        if (musica.getNome().equalsIgnoreCase(nome)) {
            return musica;
        }
    }
    return null;
}

public List<Usuario> getUsuarios() {
    return new ArrayList<>(usuarios);
}

public List<Plano> getPlanos() {
    return new ArrayList<>(planos);
}

public List<Artista> getArtistas() {
    return new ArrayList<>(artistas);
}

public List<Musica> getMusicas() {
    return new ArrayList<>(musicas);
}

public List<Historico> getHistoricos() {
    return new ArrayList<>(historicos);
}

public List<Playlist> getPlaylists() {
    return new ArrayList<>(playlists);
}

private void criarPlanosPadrao() {
    cadastrar(new Plano("Free", 0, 30));
    cadastrar(new PlanoPremium("Premium", 21.90, 30, true));
    cadastrar(new PlanoPremium("Familia", 34.90, 30, true));
}

@SuppressWarnings("unchecked")
private List<EntidadeBase> listaPorTipo(Class<? extends EntidadeBase> tipo) {
    if (tipo == Usuario.class) {
        return (List<EntidadeBase>) (List<?>) usuarios;
    }
    if (tipo == Plano.class || tipo == PlanoPremium.class) {
        return (List<EntidadeBase>) (List<?>) planos;
    }
    if (tipo == Artista.class) {
        return (List<EntidadeBase>) (List<?>) artistas;
    }
    if (tipo == Musica.class) {
        return (List<EntidadeBase>) (List<?>) musicas;
    }
    if (tipo == Historico.class) {
        return (List<EntidadeBase>) (List<?>) historicos;
    }
    if (tipo == Playlist.class) {
        return (List<EntidadeBase>) (List<?>) playlists;
    }
    throw new IllegalArgumentException("Tipo nao suportado: " + tipo.getSimpleName());
}

private static void criarDiretorio() {
    try {
        Files.createDirectories(DATA_DIR);
    } catch (IOException erro) {
        System.out.println("Nao foi possivel criar pasta de dados: " + erro.getMessage());
    }
}

public static void registrarLog(String mensagem) {
    criarDiretorio();
    String linha = LocalDateTime.now() + " - " + mensagem + System.lineSeparator();
    try {
        Files.write(LOG_FILE, linha.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    } catch (IOException erro) {
        System.out.println("Falha no log: " + erro.getMessage());
    }
}
}