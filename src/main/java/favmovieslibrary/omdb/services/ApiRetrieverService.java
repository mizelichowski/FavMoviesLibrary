package favmovieslibrary.omdb.services;

import favmovieslibrary.omdb.domain.FilmDetails;
import favmovieslibrary.omdb.domain.FilmList;

public interface ApiRetrieverService {

    FilmList searchApiRetriever(String url);
    FilmDetails detailsApiRetriever(String id);

}
