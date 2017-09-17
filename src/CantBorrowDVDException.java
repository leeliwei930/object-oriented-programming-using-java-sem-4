public class CantBorrowDVDException  extends  Exception{
    private boolean dvdStatus;
    private String movieTitle;

 public  CantBorrowDVDException(boolean dvdStatus, String movieTitle){
        this.dvdStatus = dvdStatus;
        this.movieTitle = movieTitle;
 }
 public boolean getStatus(){
    return dvdStatus;
 }
 public String getErrorMessage(){
     return "The Movie " + movieTitle + " is rented out";
 }
}
