public class CantBorrowDVDException  extends  Exception{
    private String movieTitle;

 public  CantBorrowDVDException(String movieTitle){
        this.movieTitle = movieTitle;
 }
 public String getErrorMessage(){
     return "The Movie " + movieTitle + " is rented out";
 }
}
