import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieSearchApp implements MovieSearchAppInterface {
  Scanner scanner = new Scanner(System.in);
  public MovieSearchInterface backend = new MovieSearch();
  /**
   * This loop is in charge of everything and running/managing all the commands. 
   * It'll take the alllowed inputs and run commands
   */
  public MovieSearchApp(MovieSearchInterface backend, Scanner input){
    this.backend = backend;
    this.scanner = scanner;

  }

  @Override
  public void runCommandLoop() {
    String currentInput;
    char currentCommand = mainMenuPrompt();
    switch(currentCommand) {
      
      case 'L':
        resetMenu();
        loadData();
        resetMenu();
        runCommandLoop();
        break;
      case 'T':
        resetMenu();
        System.out.println("Please enter the title(s) you'd like to search by, with each\n"
            + "individual title separated by a \'/\' character. \n");
        currentInput = scanner.nextLine();
        List<String> titles = new ArrayList<String>(Arrays.asList(currentInput.split("/")));
        searchTitleCommand(titles);
        
        runCommandLoop();
        break;
      case 'Y':
        List<String> startRangeY = new ArrayList<String>();
        List<String> endRangeY = new ArrayList<String>();
        resetMenu();
        System.out.println("Please enter the year(s) you'd like to search by, with each\n"
            + "individual year separated by a '/' character. \n"
            + "If you want to search for a range use a - symbol");
        currentInput = scanner.nextLine();
        resetMenu();
        List<String> years = new ArrayList<String>(Arrays.asList(currentInput.split("/")));
        for( int i = 0; i < years.size(); i++) {

          if(years.get(i).contains("-")) {
            startRangeY.add(years.get(i).split("-")[0]);
            endRangeY.add(years.get(i).split("-")[1]);
            years.remove(i);
            i--;
          }
        }
        if(startRangeY.size()>0) {
          searchYearRange(startRangeY, endRangeY);
        }
        else {

          searchYearCommand(years);
        }
        
        runCommandLoop();
        break;
      case 'P':
        List<String> startRangeP = new ArrayList<String>();
        List<String> endRangeP = new ArrayList<String>();
        resetMenu();
        System.out.println("Please enter the Popularity(s) you'd like to search by, with each\n"
            + "individual year separated by a '/' character. \n"
            + "If you want to search for a range use a - symbol");
        currentInput = scanner.nextLine();
        List<String> popularities = new ArrayList<String>(Arrays.asList(currentInput.split("/")));
        
        resetMenu();
        for( int i = 0; i < popularities.size(); i++) {

          if(popularities.get(i).contains("-")) {
            startRangeP.add(popularities.get(i).split("-")[0]);
            endRangeP.add(popularities.get(i).split("-")[1]);
            popularities.remove(i);
            i--;
          }
        }
        if(startRangeP.size()>0) {
          searchPopularityRange(startRangeP, endRangeP);
        } else {
          searchPopularityCommand(popularities);
        }
        runCommandLoop();
        break;
      case 'Q':
        resetMenu();
        System.out.println("I hope we could help with all of your movie needs!");
        break;
     default: resetMenu(); runCommandLoop();
    }
  }
/**
 * This prompt will return a character that can be used in the runCommandLoop() method
 */
  @Override
  public char mainMenuPrompt() {
    String menu = 
        "----------------------------------------\n"
      + "Welcome to the BEST!! movies of all time\n"
      + "would you like to:\n"
      + "[L] - Load a dataset\n"
      + "[T] - Search Movies by Title?\n"
      + "[Y] - Search Movies by Year?\n"
      + "[P] - Search Movies by Popularity?\n"
      + "[Q] - Quit\n"
      + "----------------------------------------\n";
    System.out.println(menu);
    String currentInput = scanner.nextLine().toUpperCase();
    if(!currentInput.equals("T")&&!currentInput.equals("Y")&&!currentInput.equals("Q")&&!currentInput.equals("L")&&!currentInput.equals("P")) {
      while(!currentInput.equals("T")&&!currentInput.equals("Y")&&!currentInput.equals("Q")&&!currentInput.equals("L")&&!currentInput.equals("P")) {
        resetMenu();
        System.out.println("It appears that you typed in an invalid option, please try again!\n"
      +menu);
        currentInput = scanner.nextLine().toUpperCase();
      }
    }
    
    return currentInput.charAt(0);
  }

    //This will load all the data eventually
  @Override
  public void loadData() {

    System.out.println("File name to load: ");
    String filename = scanner.nextLine().trim();

    if (backend.loadData(filename)) {
      System.out.println("File loaded");
    }
    else {
      System.out.println("The provided file cannot be loaded");
    }

  }
  

 
  /**
   * This method will check for all movies made in given years
   */
  @Override
  public void searchYearCommand(List<String> year) {
    List<String> current = new ArrayList<String>();
    List<MovieInterface> output = new ArrayList<MovieInterface>();
    for(int i = 0; i < year.size(); i++) {
      current.add(pruneInput(year.get(i)));
    }
    //This puts all the movies together
    for(int i = 0; i < current.size(); i++) {
      
      List<MovieInterface> myList = backend.getMoviesByYear(Integer.parseInt(current.get(i)));
      if(myList!= null) {
      for (int j = 0; j < myList.size(); j++) {
        output.add(myList.get(j));
      }
      }
    }
    //This prints all the output movies
    if(output.size()>0) {
      System.out.println("The output for your current search is:");
      for(int i = 0; i < output.size(); i++) {
        System.out.println(output.get(i));
      }
    }else {
      System.out.println("There are no other items under your search criteria");
    }
    
    
  }
  /**
   * This method checks for individual movie titles
   */
  @Override
  public void searchTitleCommand(List<String> words) {

    List<String> current = new ArrayList<String>();
    List<MovieInterface> output = new ArrayList<MovieInterface>();
    for(int i = 0; i < words.size(); i++) {
      current.add(pruneInput(words.get(i)));
    }
    for(int i = 0; i < current.size(); i++) {
    //This collects all the movies and stores them in an output
      List<MovieInterface> myList = backend.getMoviesByTitle(current.get(i));
      if(myList!= null) {
        for (int j = 0; j < myList.size(); j++) {
          output.add(myList.get(j));
        }
        
      }
      else {
      }
    }
    //This will print out all the movies
    if(output.size()>0) {
      System.out.println("The output for your current search is:");
      for(int i = 0; i < output.size(); i++) {
        System.out.println(output.get(i));
      }
    }else {
      System.out.println("There are no other items under your search criteria");
    }
  }

  //This will just get rid of spaces at the front and back
  private String pruneInput(String input) {
    String prunedInput = input;
    if(prunedInput.length()>1) {
      if(prunedInput.charAt(0)==' ') {
        
        prunedInput = prunedInput.substring(1);
      }
      if(prunedInput.charAt(prunedInput.length()-1)==' '&&prunedInput.length()>1) {
        prunedInput = prunedInput.substring(0, prunedInput.length()-1);
      }
    }
    
    
    
    return prunedInput;
  }

  //This method just pushes us down so we don't see the old outputs
  private void resetMenu() {
    System.out.print("\n\n\n\n");
    //System.out.print("\n\n\n\n\n\n\n\n\n\n");

  }
 
  //This will search for any movies with the given popularity ranges
  @Override
  public void searchPopularityCommand(List<String> words) {

    List<String> current = new ArrayList<String>();
    List<MovieInterface> output = new ArrayList<MovieInterface>();
    for(int i = 0; i < words.size(); i++) {
      current.add(pruneInput(words.get(i))); //This removes excess spaces to be read
    }
    //This puts them all the movies together into an output
    for(int i = 0; i < current.size(); i++) {
      
      List<MovieInterface> myList = backend.getMoviesByPopularity(Integer.parseInt(current.get(i)));

      if(myList!= null) {
      for (int j = 0; j < myList.size(); j++) {
        output.add(myList.get(j));
      }
      }
    }
    
    //This prints all the outputs that have been added together
    if(output.size()>0) {
      System.out.println("The output for your current search is:");
      for(int i = 0; i < output.size(); i++) {
        System.out.println(output.get(i));
      }
    }else {
      System.out.println("There are no other items under your search criteria");
    }
  }
  /**
   * The purpose of this method is to get the values of all the movies within the popularity ranges
   */
  @Override
  public void searchPopularityRange(List<String> rangeMin, List<String> rangeMax) {
    ArrayList<RBTList<Integer>> output = new ArrayList<RBTList<Integer>>();


    ArrayList<RBTList<Integer>> current = backend.getMoviesByPopularityRange(Integer.parseInt(pruneInput(rangeMin.get(0))),
          Integer.parseInt(pruneInput(pruneInput(rangeMax.get(0)))));
      if(current!= null) {
        for(int j = 0; j<current.size();j++) {
          output.add(current.get(j));
        }
      }

    //This command adds all the outputs together and sends them out
    if(output.size()>0) {
      System.out.println("The output for your current search is:");
      for(int i = 0; i < output.size(); i++) {
        System.out.println(output.get(i));
      }
    }else {
    }
    
  }
/**
 * This will take sets of ranges and search for them
 */
  @Override
  public void searchYearRange(List<String> rangeMin, List<String> rangeMax) {
    ArrayList<RBTList<Integer>> output = new ArrayList<RBTList<Integer>>();
    //This will collate all the individual ranges together and get the values
      System.out.println(rangeMin.size());
      ArrayList<RBTList<Integer>> current =
          backend.getMoviesByYearRange(Integer.parseInt(pruneInput(rangeMin.get(0))),
              Integer.parseInt(pruneInput(rangeMax.get(0))));

      if (current != null) {
        for (int j = 0; j < current.size(); j++) {
          output.add(current.get(j));
        }
      }

    //This will print it all out to be seen
    if (output.size() > 0) {
      System.out.println("The output for your current search is:");
      for (int i = 0; i < output.size(); i++) {
        System.out.println(output.get(i));
      }
    } else {
    }
  }
}
