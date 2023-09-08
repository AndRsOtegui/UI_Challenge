package UItest;

import Pages.*;



import org.testng.Assert;
import org.testng.annotations.Test;



public class Tests extends Hooks {


    @Test
    public void loginTest() {


        String username = "Andr3sOtegui";
        String password = "12401034a";
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.goLogin();
        ProfilePage profilePage = loginPage.enterCredentials(username,password);
        Assert.assertTrue(profilePage.getLoggedIn());

    }

    @Test
    public void failLoginTest() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = mainPage.goLogin();
        String colorRed = "rgba(212, 2, 66, 1)";
        String errorMessage = "There was a problem";
        loginPage.wrongCredentials();
        Assert.assertEquals(loginPage.getColorBlock(),colorRed);
        Assert.assertTrue(loginPage.getTextTitle().contains(errorMessage));
        Assert.assertTrue(loginPage.getErrorMessages());
    }

    @Test
    public void searchMovie(){
        String userSearch = "Fight Club";
        MainPage mainPage = new MainPage(driver);
        SearchPage searchPage = mainPage.searchMovie(userSearch);
        Assert.assertTrue(searchPage.getFirstResult().contains(userSearch));

    }

    @Test
    public void movieGenreFilter(){
        String genreFilter = "Action";
        MainPage mainPage = new MainPage(driver);
        TopRatedPage topRatedPage = mainPage.goTopRatedMovies();
        MovieInfoPage movieInfoPage = topRatedPage.filterActionGenre();
        Assert.assertTrue(movieInfoPage.getMovieGenre().contains(genreFilter));


    }

    @Test
    public void validateActingTimeline(){
        MainPage mainPage = new MainPage(driver);
        MovieInfoPage movieInfoPage = mainPage.goToMovie();
        String movieName = movieInfoPage.getMovieTittle();
        ActorInfoPage actorInfoPage = movieInfoPage.selectActor();
        Assert.assertTrue(actorInfoPage.searchMovieActorTimeline(movieName));
    }

    @Test
    public void sortTopMoviesAscendingTimeOrder(){
        MainPage mainPage = new MainPage(driver);
        TopRatedPage topRatedPage = mainPage.goTopRatedMovies();
        Assert.assertTrue(topRatedPage.orderAscendingReleaseDate());
    }





}
