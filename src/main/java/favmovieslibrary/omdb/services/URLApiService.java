package favmovieslibrary.omdb.services;

public interface URLApiService {

    String getSearchURL(String title);

    String getDetailsURL(String id);
}


