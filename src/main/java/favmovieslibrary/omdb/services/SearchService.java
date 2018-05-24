package favmovieslibrary.omdb.services;

import favmovieslibrary.omdb.domain.FilmList;

public interface SearchService {
    FilmList getList(String title);
}
