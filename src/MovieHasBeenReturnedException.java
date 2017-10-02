public class MovieHasBeenReturnedException extends Exception{

    String movieTitle;
    int errorCode;
    public MovieHasBeenReturnedException(String movieTitle , int errorCode){
        this.movieTitle = movieTitle;
        this.errorCode = errorCode;
    }

    public String getErrorMessage(){
        String errMsg;
        switch (this.errorCode) {
            case 1:
            errMsg =  "The movie " + movieTitle + " have been returned.";
            break;
            case 2:
            errMsg ="The movie " + movieTitle + " that you have entered is not a part inside our movie library." ;
            break;
            default:
                errMsg = "Unknown error code, cant throw specific error message";
        }

        return errMsg;
    }
}
