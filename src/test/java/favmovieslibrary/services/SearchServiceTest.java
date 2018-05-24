package favmovieslibrary.services;

import favmovieslibrary.filmsForTest.FilmForTest;
import favmovieslibrary.omdb.domain.FilmList;
import favmovieslibrary.omdb.services.ApiRetrieverServiceImpl;
import favmovieslibrary.omdb.services.SearchServiceImp;
import favmovieslibrary.omdb.services.URLApiService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchServiceTest {

    @Mock
    private URLApiService urlApi;
    @InjectMocks
    private SearchServiceImp searchService;
    @InjectMocks
    private ApiRetrieverServiceImpl apiRetrieverService;


    FilmList filmList;

    @Before
    public void init() {
        FilmForTest filmForTest = new FilmForTest();
        filmList = filmForTest.filmList();
    }


    @Test
    public void getListTest() {
        when(urlApi.getSearchURL("good bye my")).thenReturn("http://www.omdbapi.com/?apikey=588de52d&s=good bye my");
        assertEquals(filmList, searchService.getList("good bye my"));
    }
}
