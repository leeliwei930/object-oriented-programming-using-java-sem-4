public final class VHS extends  Video{
    public  VHS(String movieTitle, double lengthOfMovie , boolean status) {
        this.movieTitle = movieTitle;
        this.lengthOfMovie = lengthOfMovie;
        this.status = status;
        this.setPriceOfVideo();
    }

    public void setPriceOfVideo(){
        this.priceOfVideo = 12.00;

    }
    public boolean equals(String movieTitle , String Type){
        return  (this.movieTitle.equals(movieTitle) && this.getClass().getName().equals(Type));
    }
    public double getActualPrice(Customer customer) throws NotAvailException{

        return priceOfVideo;

    }

}
