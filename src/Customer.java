public final class Customer {
    protected String customerName;
    protected String mobileNumber;
    protected int age;
    protected double totalPurchaseAmount;

    public Customer(String customerName, String mobileNumber, int age){
        this.customerName = customerName;
        this.age = age;
        this.mobileNumber = mobileNumber;
        this.totalPurchaseAmount = 0.0;
    }

    public String getCustomerName(){
        return this.customerName;
    }

}
