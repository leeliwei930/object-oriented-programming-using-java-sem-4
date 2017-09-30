
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

        Video[] movie = new Video[8];
        movie[0] = new DVD("Start Wars", 3.5, true, "Lucas");
        movie[1] = new DVD("Death Note", 2.5, true, "Tarantino");
        movie[2] = new VCD("Death Note", 1.5, true, 'A', 2006);
        movie[3] = new DVD("Shrek", 2, true, "Agogo");
        movie[4] = new VHS("Transformers", 3.25, true);
        movie[5] = new VHS("The Eye", 3, true);
        movie[6] = new VCD("Fantastic 4", 2, true, 'B' , 2004);
        movie[7] = new VCD("Shampoo", 2, true, 'B' , 2007);
        // Option for switch and user input choice
        Scanner _scn = new Scanner(System.in);

        do {
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
                } catch (StringIndexOutOfBoundsException exception) {
                    System.err.println("Option cannot be empty, please choose the options based on the menu");
                }
            } while (!optionValidation);

            switch (option) {
                case 'a':
                case 'A':

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

                            while (indexNumber < movie.length) {

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
                    boolean found;
                    //Return DVD Option
                    System.out.println("Return a DVD");
                    System.out.print("Please enter movie title you wish to return: ");
                    String returnMovieTitle = _scn.nextLine();
                    System.out.print("Please enter the movie medium type that you want to return: ");
                    String returnMediumType = _scn.nextLine();
                    indexNumber = 0;
                    found = false;
                    while (indexNumber < movie.length) {
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
                    //Buy Video
                    System.out.print("Please enter your customer name:");
                    String customerName = _scn.nextLine();
                    System.out.print("Please enter the movie title that you want to purchase:");
                    String moviePurchase = _scn.nextLine();
                    System.out.print("Please enter your medium type:");
                    String purchaseMovieMediumType = _scn.nextLine();
                    try {
                       for(int customerFindIndexCounter = 0; customerFindIndexCounter <= customerReadCounter; customerFindIndexCounter ++ ){

                       }
                    } catch(CustomerNotAvailException CustomerNaException){

                    }
                    break;
                case 'd':
                case 'D':
                    // print out customer information
                    break;
                case 'e':
                case 'E':
                    //Add a video
                    System.out.println("Add a new video to library");
                    System.out.print("New Movie Title: ");
                    String newMovieTitle = _scn.nextLine();
                    System.out.print("New Movie medium type:");
                    String newMovieMediumType = _scn.nextLine();
                    System.out.print("New Movie duration: ");
                    double newMovieLength = _scn.nextDouble();
                    switch (newMovieMediumType) {
                        case "DVD":
                        case "dvd":
                            System.out.print("Please enter the new Movie - " + newMovieTitle + "'s director name: ");
                            String newMovieDirectorName = _scn.nextLine();

                            movie[newMovieCounter] = new DVD(newMovieTitle, newMovieLength, true, newMovieDirectorName);
                            newMovieCounter++;
                            System.out.println("The movie " + newMovieTitle + " has created successfully.");
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

                            break;
                        case "VHS":
                        case "vhs":
                            movie[newMovieCounter] = new VHS(newMovieTitle, newMovieLength, true);
                            newMovieCounter++;
                            System.out.println("The movie " + newMovieTitle + " has created successfully.");

                            break;


                    }
                    break;

                case 'f':
                case 'F':
                    //user entered the movie title and movie type and display all the information about the video
                    break;
                case 'g':
                case 'G':

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
