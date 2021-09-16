package org.myexample;


public class App {
    public static void main( String[] args ) {

        final NewMoviesDao movieDao = new NewMoviesDao ();
        final Movies droga_przez_meke = new Movies ( "Droga przez meke",1900,300 );
        final Movies savemovie = movieDao.save (droga_przez_meke, Movies.class);
        final Movies movieFromDB = movieDao.getById (savemovie.getId (),Movies.class );
        System.out.println ("MOVIE FROM DATA BASE WITH ID 1L" );
        System.out.println (movieFromDB );

        //final Movies Jak_jest_to_zrobione = new Movies ( "Jak_jest_to_zrobione",2015,15 );
        //movieDao.save (Jak_jest_to_zrobione);

        movieFromDB.setTitle ("droga_przez_meke");
        movieDao.update (movieFromDB);
        System.out.println ("MOVIE AFTER UPDATE: " + movieDao.getById (savemovie.getId ( ), Movies.class));


        //movieDao.remove (savemovie.getId ( ),Movies.class);

        //final Movies movie_remove = movieDao.remove (1L);
        //System.out.println ("MOVIE " + movie_remove + " removed" );


        final AuthorDao authorDao = new AuthorDao ();
        final Author author = new Author ("Juliusz", "Słowacki", 30 );
        //dodawanie filmu do Authora
        author.setMovies (movieFromDB);

        final Author Juliusz_Slowacki = authorDao.save (author,Author.class);

        //wyciagniecie z bazy danych
        //final Author

        System.out.println (Juliusz_Slowacki );

        //user
        System.out.println("USER!");
        final User user = new User("Mateusz", "Dark", "Mrok");
        final UserDao userDao = new UserDao();
        final User savedUser = userDao.save(user, User.class);
        userDao.save(new User("Bot1", "BotPasswrod", "bot"), User.class);

        movieFromDB.setUser (savedUser);
        movieDao.update(movieFromDB);

        System.out.println("PRINT ALL: !!!");
        userDao.getAll().forEach(System.out::println);


        //zamukamy cale polaczenie
        HibernateFactory.getSessionFactory ().close ();


    }
}
