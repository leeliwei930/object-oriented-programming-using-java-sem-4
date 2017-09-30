public class CustomerNotAvailException extends  Exception{
    public String customerName;

    public CustomerNotAvailException(String customerName){
        this.customerName = customerName;
    }

    public String getErrorMessage(){
        return this.customerName + " is not founded in our database";
    }

}
