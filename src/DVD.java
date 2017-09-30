public final class DVD extends Video{
    public DVD(String movieTitle, double lengthOfMovie, boolean status,  String director){
        this.movieTitle = movieTitle;
        this.lengthOfMovie = lengthOfMovie;
        this.status = status;
        this.director = director;
        this.setPriceOfVideo();

    }

    public void setPriceOfVideo(){
        this.priceOfVideo = 50;
    }

    public boolean equals(String movieTitle , String Type){
        return  (this.movieTitle.equals(movieTitle) && this.getClass().getName().equals(Type));
    }
}
