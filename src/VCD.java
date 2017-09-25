import java.util.Date;

public class VCD extends Video{
    private char movieRating;
    private Date yearMade;

    public VCD(String movieTitle, double lengthOfMovie , boolean status,  char movieRating){
        this.movieTitle = movieTitle;
        this.lengthOfMovie = lengthOfMovie;
        this.status = status;
        this.movieRating = movieRating;
        this.setPriceOfVideo();

    }

    public void setPriceOfVideo(){

        switch(this.getMovieRating()){
            case 'A':
                this.priceOfVideo = 20.00;
                break;
            default:
                this.priceOfVideo = 10.00;
        }
        this.priceOfVideo = 20.00;

    }
}
