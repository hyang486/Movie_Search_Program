import java.util.ArrayList;
import java.util.List;

public interface MovieSearchInterface {
  // public MovieSearch();
  boolean loadData(String filename);
  List<MovieInterface> getMoviesByTitle(String title);
  List<MovieInterface> getMoviesByPopularity(int popularity);
  List<MovieInterface> getMoviesByYear(int year);
  List<List<MovieInterface>> compareMoviesByYear(int year1, int year2);
  public ArrayList<RBTList<Integer>> getMoviesByYearRange(int year1, int year2);

  public ArrayList<RBTList<Integer>> getMoviesByPopularityRange(int year1, int year2);


}
