package favmovieslibrary.omdb.services;

import favmovieslibrary.omdb.domain.FilmDetails;

public interface FilmDetailsService {
    FilmDetails getFilm(String id);
}
