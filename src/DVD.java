public class DVD {
    public  int numberOfDvd = 100;
    private String movieTitle;
    private double lengthOfMovie;
    private boolean status;

// Default Constructor
    public DVD() {
        this.movieTitle = null;
        this.status = true;

    }
//Parameter Constructor
    public DVD(String movieTitle, double lengthOfMovie , boolean status) {
        this.movieTitle = movieTitle;
        this.lengthOfMovie = lengthOfMovie;
        this.status = status;
    }


    public void rentDVD() {
        this.status = false;

    }

    public void returnDVD() {

        this.status = true;
    }
//Getter
    public String getMovieTitle() {
        return movieTitle;
    }

    public boolean getStatus() {
        return status;
    }

    public double getLengthOfMovie() {
        return lengthOfMovie;
    }

    //Setter
    public void setLengthOfMovie(double lengthOfMovie) {
        this.lengthOfMovie = lengthOfMovie;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }




}
