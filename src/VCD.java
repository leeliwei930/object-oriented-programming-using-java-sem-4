
public final class VCD extends Video{


    public VCD(String movieTitle, double lengthOfMovie , boolean status,  char movieRating, int yearMade){
        this.movieTitle = movieTitle;
        this.lengthOfMovie = lengthOfMovie;
        this.status = status;
        this.movieRating = movieRating;
        this.yearMade = yearMade;
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

    public boolean equals(String movieTitle , String Type){
      return  (this.movieTitle.equals(movieTitle) && this.getClass().getName().equals(Type));
    }
}
