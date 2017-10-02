import com.sun.tools.corba.se.idl.constExpr.Not;

public  abstract class  Video {
    protected String movieTitle;
    protected double lengthOfMovie;
    protected boolean status;
    protected double priceOfVideo;
    protected char movieRating;
    protected String director;
    protected int yearMade;
    protected boolean isPurchased = false;
// Default Constructor
    public Video() {
        this.movieTitle = null;
        this.status = true;
        this.lengthOfMovie = 0;
        this.priceOfVideo = 0;
        this.movieRating = 'n';
        this.director = null;
        this.yearMade = 0;

    }
//Overloaded Constructor






    public void rentVideo() throws NotAvailException {
        if(!this.status){

            throw new NotAvailException(this.movieTitle);
        } else {
            this.status = false;
        }

    }



    public void returnVideo() throws MovieHasBeenReturnedException{

        if(this.status){
            throw new MovieHasBeenReturnedException(this.movieTitle , 1);
        } else {
            this.status = true;

        }
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
    public abstract boolean equals(String movieTitle , String Type);

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
//
//    public boolean checkAvailableToPurchase(){
//        if(!this.status){
//
//            throw new NotAvailException(this.movieTitle);
//        } else {
//            this.status = false;
//        }
//
//    }
    public double getActualPrice(Customer customer) throws NotAvailException{

        if(!this.status){
            throw new NotAvailException(this.movieTitle);
        } else {
            if(customer.totalPurchaseAmount >= 100.00){
                this.priceOfVideo = this.priceOfVideo * 0.9;
            }
        }

        return priceOfVideo;

    }


    public void purchase(Customer customer)throws NotAvailException{
        double purchaseAmount;
        if(!this.status){
            throw new NotAvailException(this.movieTitle);
        } else {


            purchaseAmount = this.getActualPrice(customer);
            customer.totalPurchaseAmount = purchaseAmount + customer.totalPurchaseAmount;
            this.movieTitle = "";
            this.status = false;
            this.lengthOfMovie = 0;
            this.priceOfVideo = 0;
            this.movieRating = 'n';
            this.director =  " ";
            this.yearMade = 0;

        }
    }
}


