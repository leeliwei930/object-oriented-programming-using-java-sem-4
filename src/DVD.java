public class DVD extends Video{
    private String director;
    public DVD(String movieTitle, double lengthOfMovie, boolean status,  String director){
        this.movieTitle = movieTitle;
        this.lengthOfMovie = lengthOfMovie;
        this.status = status;
        this.director = director;
        this.setPriceOfVideo();

    }
}
