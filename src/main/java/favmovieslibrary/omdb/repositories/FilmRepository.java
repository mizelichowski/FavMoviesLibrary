package favmovieslibrary.omdb.repositories;

import favmovieslibrary.omdb.domain.DBFilm;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<DBFilm, Long> {
}
