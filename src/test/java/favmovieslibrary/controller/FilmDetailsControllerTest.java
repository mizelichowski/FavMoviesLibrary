package favmovieslibrary.controller;

import favmovieslibrary.filmsForTest.DetailsFilmForTest;
import favmovieslibrary.omdb.controllers.FilmDetailsController;
import favmovieslibrary.omdb.domain.FilmDetails;
import favmovieslibrary.omdb.services.FilmDetailsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class FilmDetailsControllerTest {
    private MockMvc mockMvc;
    private FilmDetails film;
    private DetailsFilmForTest filmDetails;

    @InjectMocks
    private FilmDetailsController controller;

    @Mock
    private FilmDetailsService service;

    @Before
    public void init() {
        filmDetails = new DetailsFilmForTest();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        film = filmDetails.detailsFilm();
        Mockito.when(service.getFilm("dknc32")).thenReturn(film);
    }

    @Test
    public void startTest() throws Exception {
        String iD = "dknc32";
        mockMvc.perform(MockMvcRequestBuilders.get("/details").
                param("iD", iD))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("film", film))
                .andExpect(view().name("movieDetails"));
    }


}
