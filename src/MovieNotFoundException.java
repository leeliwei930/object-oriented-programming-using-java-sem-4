public class MovieNotFoundException extends Exception{
    private String inputMovieTitle;
    private String inputMovieType;
    private int errorCode;

    public MovieNotFoundException( String newinputMovieTitle, String newinputMovieType, int errorCode){
        this.inputMovieTitle = newinputMovieTitle;
        this.inputMovieType = newinputMovieType;
        this.errorCode = errorCode;
    }
    public String getRelatedMediumTypeNotFoundMessage(){
        return "The movie " + inputMovieTitle + " doesn't have the " + inputMovieType + " type medium";
    }

    public String getMovieNotFoundMessage(){
        return "The movie " + inputMovieTitle + " is not available";
    }
    public String getErrorMessage(){
//        if (this.errorCode == 1){
//          return   getMovieNotFoundMessage();
//        } else if(this.errorCode == 2) {
//            return getRelatedMediumTypeNotFoundMessage();
//        } else {
//            return "Error Code Mistmatch";
//        }
        String message;
        switch (this.errorCode){
            case 1:
                message = "The movie " + inputMovieTitle + " is not available in our movie Library";
                break;
            case 2:
                message =  "The movie " + inputMovieTitle + " doesn't have the " + inputMovieType + " type medium";
            break;
            default:
                message= "";
        }
        return message;
    }
}
