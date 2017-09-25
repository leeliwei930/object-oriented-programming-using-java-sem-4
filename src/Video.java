public  abstract class  Video {
    public  int numberOfDvd = 100;
    protected String movieTitle;
    protected double lengthOfMovie;
    protected boolean status;
    protected double priceOfVideo;
    protected char movieRating;
    protected String director;
// Default Constructor
    public Video() {
        this.movieTitle = null;
        this.status = true;
        this.lengthOfMovie = 0;
        this.priceOfVideo = 0;
        this.movieRating = 'n';
        this.director = null;

    }
//Overloaded Constructor






    public void rentVideo() throws CantBorrowDVDException{
        if(!this.status){

            throw new CantBorrowDVDException(this.movieTitle);
        } else {
            this.status = false;
        }

    }



    public void returnVideo() {

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

    public char getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(char newMovieRating){
        this.movieRating = newMovieRating;
    }
    public double getPriceOfVideo() {


        return priceOfVideo;
    }



    /**
     * VCD each 10.00, if movie rating is A price considered as 20.00
     * VHS each 12.00
     * DVD each 50
     * */
     abstract void setPriceOfVideo();
    public String getDirector() {
        return director;
    }

    public void setDirector(String newDirector) {
        this.director = newDirector;
    }

    public boolean getTypeOfVideo(String mediumType){
        boolean check;
       switch (mediumType){
           case "DVD":
               check = (this instanceof DVD);
               break;
           case "VCD":
               check = (this instanceof VCD);
               break;
           case "VHS":
               check = (this instanceof  VHS);
               break;
            default:
                check = false;
       }
       return check;

    }
}


