public class VHS extends  Video{
    public  VHS(String movieTitle, double lengthOfMovie , boolean status) {
        this.movieTitle = movieTitle;
        this.lengthOfMovie = lengthOfMovie;
        this.status = status;
        this.setPriceOfVideo();
    }

}
