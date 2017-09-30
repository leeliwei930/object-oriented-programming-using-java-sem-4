public class NotAvailException extends  Exception{
    private String movieTitle;

 public NotAvailException(String movieTitle){

     this.movieTitle = movieTitle;
 }
 public String getErrorMessage(int errorCode){
     String message;
     switch (errorCode){
         case 1:
             message =  "The Movie " + movieTitle + " is rented out";
             break;
         case 2:
            message =  "The Movie " + movieTitle + " is rented out, and cannot be purchased";
            break;
        default:
            message =  "Unknown Error Code: Please Check For NotAvailException.java on line:16";

     }
     return message;
 }
}
