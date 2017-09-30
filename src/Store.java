
import java.util.*;
import java.io.*;

public class Store {

    public static void main(String[] args){
        String customerFilePath = "/Users/LeeLiWei/IdeaProjects/Assignment 2 Semester 4/src/database/customers.data";
        String videoFilePath = "";

        int newMovieCounter = 8;
        boolean optionValidation = false;
        char option = ' ';
        Customer customerList[] = new Customer[100];
        int customerReadCounter = 0;
        try {
            FileReader readCustomerFile = new FileReader(customerFilePath);
            Scanner customerFileScan = new Scanner(readCustomerFile);
            while (customerFileScan.hasNextLine())
            {
                String customerName = customerFileScan.nextLine();
                String mobileNumber = customerFileScan.nextLine();
                int cutomerAge = Integer.parseInt(customerFileScan.nextLine());

                customerList[customerReadCounter++] = new Customer(customerName,mobileNumber,cutomerAge);
            }
        } catch(FileNotFoundException customerDBNotFoundException){
            System.err.print("Customer Database File cannot be found, please check the customer database file path at line:17 on Store.java");
            customerDBNotFoundException.printStackTrace();
        }

        Video[] movie = new Video[100];
        movie[0] = new DVD("Start Wars", 3.5, true, "Lucas");
        movie[1] = new DVD("Death Note", 2.5, true, "Tarantino");
        movie[2] = new VCD("Death Note", 1.5, true, 'A', 2006);
        movie[3] = new DVD("Shrek", 2, true, "Agogo");
        movie[4] = new VHS("Transformers", 3.25, true);
        movie[5] = new VHS("The Eye", 3, true);
        movie[6] = new VCD("Fantastic 4", 2, true, 'B' , 2004);
        movie[7] = new VCD("Shampoo", 2, true, 'B' , 2007);
        // Option for switch and user input choice

        do {
            Scanner _scn = new Scanner(System.in);

            do {
                try {
                    System.out.println("Choose an option:");
                    System.out.println("a) Rent a Video");
                    System.out.println("b) Return a Video");
                    System.out.println("c) Buy a video");
                    System.out.println("d) Print out customer information");
                    System.out.println("e) Add a video");
                    System.out.println("f) Print out video information");
                    System.out.println("g) Exit the program");


                    System.out.print("Your Choice: ");


                    option = _scn.nextLine().charAt(0);
                    optionValidation = true;
                } catch (Exception exception) {
                    System.err.println("Option cannot be empty, please choose the options based on the menu");
                }
            } while (!optionValidation);

            switch (option) {
                case 'a':
                case 'A':
                    option = ' ';
                    System.out.println("Rent a DVD");

                    //Select the character index start from 0
                    int indexNumber;
                    boolean rentVideovalidation = false;

                    String rentMovieTitle;
                    do {
                        boolean requestedMediumTypeAvailable = false;
                        boolean movieAvailable = false;
                        try {
                            System.out.println("[ 0000 = Back To Menu ]");
                            System.out.print("Please enter movie title you wish to rent: ");

                            rentMovieTitle = _scn.nextLine();

                            if (rentMovieTitle.equals("0000")) {
                                rentVideovalidation = true;
                                break;
                            }
                            System.out.print("Please enter the medium type: ");
                            String mediumType = _scn.nextLine();
                            indexNumber = 0;
                            //indexNumber for while loop condition

                            //initiate search result to false

                            while (indexNumber <= newMovieCounter - 1) {

                                //if the movie that user input is valid break the statement and movie index number is located.
                                if ((movie[indexNumber].equals(rentMovieTitle, mediumType))) {
                                    movieAvailable = true;

                                    requestedMediumTypeAvailable = true;

                                    break;
                                } else if ((movie[indexNumber].getMovieTitle()).equals(rentMovieTitle) && !(movie[indexNumber]).getTypeOfVideo(mediumType))
                                    movieAvailable = true;

                                requestedMediumTypeAvailable = false;

                                {

                                    indexNumber++;
                                }

                            }

                            if (!movieAvailable) {
                                throw new MovieNotFoundException(rentMovieTitle, mediumType, 1);

                            }
                            if (!requestedMediumTypeAvailable) {
                                throw new MovieNotFoundException(rentMovieTitle, mediumType, 2);
                            } else {
                                try {
                                    movie[indexNumber].rentVideo();
                                    System.out.println("You have rented " + movie[indexNumber].getMovieTitle());
                                    rentVideovalidation = true;
                                } catch (NotAvailException exception) {
                                    System.err.println(exception.getErrorMessage(1));

                                }
                            }
                        } catch (MovieNotFoundException exception) {

                            System.err.println(exception.getErrorMessage());

                        }
                    } while (!rentVideovalidation);


//
                    break;
                case 'b':
                case 'B':
                    option = ' ';

                    boolean found;
                    //Return DVD Option
                    System.out.println("Return a DVD");
                    System.out.print("Please enter movie title you wish to return: ");
                    String returnMovieTitle = _scn.nextLine();
                    System.out.print("Please enter the movie medium type that you want to return: ");
                    String returnMediumType = _scn.nextLine();
                    indexNumber = 0;
                    found = false;
                    while (indexNumber <= newMovieCounter - 1) {
                        // if movie is found based on user input
                        if ((movie[indexNumber].getMovieTitle()).equals(returnMovieTitle) && movie[indexNumber].equals(returnMovieTitle, returnMediumType)) {
                            found = true;
                            break;
                        }
                        indexNumber++;
                    }
                    if (found) {
                        // If Movie has been rented out allow it return back to library
                        //rented status boolean OUT = false , IN = true;
                        if (!movie[indexNumber].getStatus()) {
                            movie[indexNumber].returnVideo();
                            //Call return method
                            System.out.println("You have returned " + movie[indexNumber].getMovieTitle());
                        } else {
                            System.out.println("The movie " + movie[indexNumber].getMovieTitle() + " have been returned.");
                        }
                    } else {
                        System.out.println("The movie " + returnMovieTitle + " that you have entered is not a part inside our movie library.");
                    }
                    break;
                case 'c':
                case 'C':
                    option = ' ';

                    //Buy Video
                    boolean customerValidation = false;
                    boolean customerFound = false;
                    int customerFindIndexCounter = 0;
                    String customerName = "";
                    int purchaseMovieFindIndex;

                    do {

                    try {

                            System.out.println("[Back = 0000]");
                            System.out.print("Please enter your customer name:");
                            customerName = _scn.nextLine();
                            while (customerFindIndexCounter <= customerReadCounter - 1){
                                if(customerList[customerFindIndexCounter].customerName.equals(customerName)){
                                    customerFound = true;
                                    break;
                                }
                                customerFindIndexCounter++;
                            }
                            if(!customerFound && !customerName.equals("0000")){
                                throw new CustomerNotAvailException(customerName);
                            } else {
                                customerValidation = true;
                            }
                    } catch (CustomerNotAvailException customerNotFoundException){
                        System.err.println(customerNotFoundException.getErrorMessage());
                    }
                    } while (!customerFound && !customerName.equals("0000"));
                    boolean movieFound = false;
                    String moviePurchase;
                    String purchaseMovieMediumType;
                    int movieSearchIndex = 0;
                    if(customerValidation) {
                            do {
                                System.out.print("Please enter the movie title that you want to purchase:");
                               moviePurchase = _scn.nextLine();
                                System.out.print("Please enter your medium type:");
                               purchaseMovieMediumType = _scn.nextLine();
                               while(movieSearchIndex <= newMovieCounter -1){
                                    if(movie[movieSearchIndex].movieTitle.equals(moviePurchase)&& movie[movieSearchIndex].equals(movie[movieSearchIndex].movieTitle,purchaseMovieMediumType)){
                                        movieFound = true;
                                        break;
                                    }
                                   movieSearchIndex++;
                               }
                               } while(!movieFound && (!moviePurchase.equals("0000") || !purchaseMovieMediumType.equals("0000")));
                            if(movieFound){
                                try {
                                    movie[movieSearchIndex].purchase(customerList[customerFindIndexCounter]);
                                    movie[movieSearchIndex].status = false;
                                    System.out.println("The movie " + moviePurchase + " purchased successfully");
                                } catch (NotAvailException notAvailableToPurchaseException){
                                    System.err.println(notAvailableToPurchaseException.getErrorMessage(2));
                                }
                            }
                    }


                    break;
                case 'd':
                case 'D':
                    option = ' ';

                    // print out customer information
//                    for(int i = 0; i < customerReadCounter; i++){
//                        System.out.println(customerList[i].getCustomerName());
//                        System.out.println(customerList[i].totalPurchaseAmount);
//                    }
                    boolean customerInfoFound = false;

                    do {
                        int searchCustomerInfoIndex = 0;
                        System.out.print("Please Enter Customer Name: ");
                        String customerNameInfoSearch = _scn.nextLine();
                        try {


                            while (searchCustomerInfoIndex <= customerReadCounter -1) {
                                if (customerList[searchCustomerInfoIndex].customerName.equals(customerNameInfoSearch)) {
                                    customerInfoFound = true;
                                    break;
                                }
                                searchCustomerInfoIndex ++;
                            }
                            if (customerInfoFound) {
                                System.out.println("Customer Name: " + customerList[searchCustomerInfoIndex].customerName);
                                System.out.println("Customer Age: " + customerList[searchCustomerInfoIndex].age);
                                System.out.println("Customer Mobile Number: " + customerList[searchCustomerInfoIndex].mobileNumber);
                                System.out.println("Customer Total Purchase Amount: " + customerList[searchCustomerInfoIndex].totalPurchaseAmount);
                            } else {
                                throw new CustomerNotAvailException(customerNameInfoSearch);
                            }
                        } catch (CustomerNotAvailException customerNotFoundException) {
                            System.err.print(customerNotFoundException.getErrorMessage());
                        }
                    } while(!customerInfoFound);
                    break;
                case 'e':
                case 'E':
                    option = ' ';
                    boolean addMovieValidation = false;
                    do {
                    String newMovieMediumType;
                    //Add a video
                    System.out.println("Add a new video to library");
                        System.out.println("[ Back = 0000 ]");

                        System.out.print("New Movie Title: ");
                    String newMovieTitle = _scn.nextLine();
                    if(newMovieTitle.equals("0000")){
                        break;
                    }
                    System.out.print("New Movie medium type:");
                     newMovieMediumType = _scn.nextLine();
                    System.out.print("New Movie duration: ");
                    double newMovieLength = _scn.nextDouble();
                    _scn.nextLine();
                    switch (newMovieMediumType) {
                        case "DVD":
                        case "dvd":
                            System.out.print("Please enter the new Movie - " + newMovieTitle + "'s director name: ");
                            String newMovieDirectorName = _scn.nextLine();

                            movie[newMovieCounter] = new DVD(newMovieTitle, newMovieLength, true, newMovieDirectorName);
                            System.out.println("The movie " + newMovieTitle + " has created successfully.");
                            newMovieCounter++;
                            addMovieValidation = true;

                            break;
                        case "VCD":
                        case "vcd":
                            System.out.print("Please enter the year made: ");
                            int newMovieYearMadeDate = _scn.nextInt();
                            System.out.print("Please enter the new movie " + newMovieTitle + "'s rating: ");
                            char newMovieRating = _scn.nextLine().charAt(0);
                            movie[newMovieCounter] = new VCD(newMovieTitle, newMovieLength, true, newMovieRating, newMovieYearMadeDate);
                            newMovieCounter++;
                            System.out.println("The movie " + newMovieTitle + " has created successfully.");
                            addMovieValidation = true;
                            break;
                        case "VHS":
                        case "vhs":
                            movie[newMovieCounter] = new VHS(newMovieTitle, newMovieLength, true);
                            newMovieCounter++;
                            System.out.println("The movie " + newMovieTitle + " has created successfully.");
                            addMovieValidation = true;

                            break;
                        default:
                            System.err.println("Invalid Medium Type. Please try again.");

                    }
                    } while(!addMovieValidation);
                    break;

                case 'f':
                case 'F':
                    option = ' ';

                    String movieInformationMediumType;
                    String movieInformationTitle;
                    boolean movieInformationFounded = false;
                    boolean exit = false;
                    do {
                        System.out.println("[Back =  0000]");
                        System.out.print("Please Enter the movie Title: ");
                   movieInformationTitle = _scn.nextLine();
                        if(movieInformationTitle.equals("0000")) {
                            exit = true;
                            break;
                        }
                        System.out.print("Please Enter the medium Type: ");
                      movieInformationMediumType = _scn.nextLine();


                        try {
                            int searchMovieInformationCounter = 0;

                            while (searchMovieInformationCounter <= newMovieCounter -1 ) {

                                    if (movie[searchMovieInformationCounter].equals(movieInformationTitle, movieInformationMediumType)) {
                                    movieInformationFounded = true;
                                    break;
                                }
                                searchMovieInformationCounter++;

                            }
                            if(!movieInformationFounded) {
                                throw new MovieNotFoundException(movieInformationTitle, movieInformationMediumType, 1);
                            }
                            else if(movie[searchMovieInformationCounter].movieTitle.equals(movieInformationTitle) && !movie[searchMovieInformationCounter].equals(movieInformationTitle, movieInformationMediumType)) {

                                throw new MovieNotFoundException(movieInformationTitle, movieInformationMediumType , 2);
                            } else {
                                System.out.println("Movie Title: " + movie[searchMovieInformationCounter].movieTitle);
                                System.out.println("Medium Type: " + movie[searchMovieInformationCounter].getClass().getName());
                                System.out.println("Movie Length: " + movie[searchMovieInformationCounter].lengthOfMovie);
                                System.out.println("Movie Status: " + movie[searchMovieInformationCounter].status);
                            }

                        } catch (MovieNotFoundException movieNotFoundException){
                            System.err.println(movieNotFoundException.getErrorMessage());
                        }

                    } while(!movieInformationFounded && !exit);
                    //user entered the movie title and movie type and display all the information about the video

                    break;
                case 'g':
                case 'G':
                    option = ' ';

                    break;
//                case 'h':
//                    try {
//                        for(int n = 0 ; n < customerReadCounter; n++) {
//                            System.out.println(customerList[n].getCustomerName());
//                            System.out.println(customerList[n].mobileNumber);
//                            System.out.println(customerList[n].age);
//
//                        }
//                    } catch (NullPointerException e){
//                        e.printStackTrace();
//                    }
//                    break;
                default:
                    // Print out invalid choice message
                    System.out.println("Sorry! Incorrect option... ");

            }


            // Exit Code
        } while (option != 'g');
        System.out.println("Thank you for your patronage. Please come again.");
        System.out.println("Press any key to continue...");
        System.exit(0);
    }

    public static void print(Video[] movie) {
        //                    List ALl Information for all DVD
        System.out.println("Information on all DVDs");
        //better use printf  to align the output
        System.out.printf("%-15s %15s %15s %n", "DVD Title", "Duration(Hours)", "Status");
        // foreach loop printout all the movie title, length and status
        for (Video aMovie : movie) {
            System.out.printf("%-15s %15s %15s %n", aMovie.getMovieTitle(), aMovie.getLengthOfMovie(), (aMovie.getStatus()) ? "IN" : "OUT");
        }
    }
}
