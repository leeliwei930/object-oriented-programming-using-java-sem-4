import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner _scn = new Scanner(System.in);
        String[][] movieLibrary = {
                {"Iron Man", "3.50"},
                {"Death Note", "2.50"},
                {"Shrek", "2.00"},
                {"Transformers", "3.25"},
                {"The Eye", "3.00"},
                {"Fantastic 4", "4.00"}
        };
        DVD[] movie = new DVD[6];
        // Create 6 object called movie
        for (int i = 0; i < movieLibrary.length; i++) {
            // Assignned each DVD movie title and length duration into movie object array, from two dimensional array movieLibrary
            movie[i] = new DVD(movieLibrary[i][0], Double.parseDouble(movieLibrary[i][1]), true);
        }

        //Option for switch and user input choice
        char option;
        do {
            System.out.println("Choose an option:");
            System.out.println("a) Renting a DVD");
            System.out.println("b) Returning a DVD");
            System.out.println("c) Printing out information for all the DVDs");
            System.out.println("d) Exit Program");
            System.out.print("Your Choice: ");
            option = _scn.nextLine().charAt(0);
            //Select the character index start from 0
            int indexNumber;
            boolean found;
            switch (option) {
                case 'a':
                    System.out.println("Rent a DVD");
                    System.out.print("Please enter movie title you wish to rent: ");
                    String rentMovieTitle = _scn.nextLine();
                    indexNumber = 0;
                    //indexNumber for while loop condition
                    found = false;
                    //initiate search result to false
                    while (indexNumber < movie.length) {
                        //if the movie that user input is valid break the statement and movie index number is located.
                        if ((movie[indexNumber].getMovieTitle()).equals(rentMovieTitle)) {
                            found = true;
                            break;
                        }
                        indexNumber++;
                    }
                    if (found) {
                        //if found the specific movie
                        if (movie[indexNumber].getStatus()) {
                            //if the status is true also known as the movie can be rented out
                            movie[indexNumber].rentDVD();
                            // called the rentDVD method targeted array movie object based on index
                            System.out.println("You have rented " + movie[indexNumber].getMovieTitle());
                            //Print notification message
                        } else {
                            //if the movie has been rented out show the notification
                            System.out.println("The movie " + movie[indexNumber].getMovieTitle() + " has been rented out.");

                        }
                    } else {
                        //When user input movie title is invalid.
                        System.out.println("The movie " + rentMovieTitle + " that you have entered is not available right now.");
                    }
                    break;
                case 'b':
                    //Return DVD Option
                    System.out.println("Return a DVD");
                    System.out.print("Please enter movie title you wish to return: ");
                    String returnMovieTitle = _scn.nextLine();
                    indexNumber = 0;
                    found = false;
                    while (indexNumber < movie.length) {
                        // if movie is found based on user input
                        if ((movie[indexNumber].getMovieTitle()).equals(returnMovieTitle)) {
                            found = true;
                            break;
                        }
                        indexNumber++;
                    }
                    if (found) {
                        // If Movie has been rented out allow it return back to library
                        //rented status boolean OUT = false , IN = true;
                        if (!movie[indexNumber].getStatus()) {
                            movie[indexNumber].returnDVD();
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
//                    List ALl Information for all DVD
                    System.out.println("Information on all DVDs");
                    //better use printf  to align the output
                    System.out.printf("%-15s %15s %15s %n", "DVD Title", "Duration(Hours)", "Status");
                    // foreach loop printout all the movie title, length and status
                    for (DVD aMovie : movie) {
                        System.out.printf("%-15s %15s %15s %n", aMovie.getMovieTitle(), aMovie.getLengthOfMovie(), (aMovie.getStatus()) ? "IN" : "OUT");
                    }
                    break;
                default:
                    // Print out invalid choice message
                    System.out.println("Sorry! Incorrect option... ");

            }
            // Exit Code
        } while (option != 'd');
        System.out.println("Thank you for your patronage. Please come again.");
        System.out.println("Press any key to continue...");
        System.exit(0);
    }
}
