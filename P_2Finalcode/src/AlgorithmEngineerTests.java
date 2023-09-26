// --== CS400 Spring 2023 File Header Information ==--
// Name: <Hyeonmin Yang>
// Email: <hyang486@wisc.edu>
// Team: <BJ>
// TA: <Naman Gupta>
// Lecturer: <CS400 Lecture002>
// Notes to Grader: <optional extra notes>

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is for testing RBT is working well with data
 * This test will test if nodes are inserted in each RBT(yearRBT, titleRBT,
 * popularityRBT) or not
 * this test will test after inserting if the each RedBlacktree resolve the
 * property collision well or not
 * this test will test if the user can get specific nodethey want to see from
 * the each RBT or not
 * this test will test if the uer can get specific nodes with the range in the
 * RBT or not
 * this test will test after inserting the each node's color is right or not
 * the simple algorithm that inserting node is create movie object and insert it
 * to RBTLIST type
 * object and insert RBTLIST type node with specific insert method in tree class
 * and assigned
 * tree obejct to RedBlackTree object.
 */

public class AlgorithmEngineerTests {
    /**
     * Test with yearRBT the node is inserting with sorting by year with basic
     * insert case 1,2,3
     * when insert movie3 (case2 occured), insert movie4 (case3 occured), if teh
     * movie3 is located
     * right position then it means also case1 is succesfully resolved.
     * Check if the nodes are successfully inserted with comparing inorder and
     * levelorder
     * And also this method test if with the specific data from user it can return
     * specific node
     * And also this method test if with the range user input, it can return
     * specific nodes to user
     */
    @Test
    public void testYearRBT() {
        // make tree object to make yearRBT
        MovieRedBlackTree tree = new MovieRedBlackTree<>();
        // make movie obejct
        Movie movie1 = new Movie(5, 1, "A", "A", "A", "A", "A", 2, true);
        Movie movie2 = new Movie(3, 2, "B", "B", "B", "B", "B", 3, true);
        Movie movie3 = new Movie(4, 4, "C", "C", "C", "C", "C", 4, true);
        Movie movie4 = new Movie(2, 2, "D", "D", "D", "D", "D", 4, true);

        // 1. make movie object to node
        // 2. make node (RBTList) with the value that what value this RBT sorking thd
        // nodes with
        // 3. insert node to yearRBT
        RBTList<Integer> list1 = new RBTList<Integer>(5);
        list1.add(movie1);
        tree.insertByYear(list1);

        RBTList<Integer> list2 = new RBTList<Integer>(3);
        list2.add(movie2);
        tree.insertByYear(list2);

        RBTList<Integer> list3 = new RBTList<Integer>(4);
        list3.add(movie3);
        tree.insertByYear(list3);

        RBTList<Integer> list4 = new RBTList<Integer>(2);
        list4.add(movie4);
        tree.insertByYear(list4);

        // set tree object to yearRBT with getter method
        RedBlackTree yearRBT = tree.getYearRBT();

        // make expectedInorder/Levelorder to compare with real data.
        // with year Data, inOrder should be 2,3,4,5 and levelOrder should be 4,3,5,2
        String expectedInorder = "[ [movieObject - [year: 2, runtime: 2, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 4, wonAwards: true]], [movieObject - [year: 5, runtime: 1, title: 'A', category: 'A', leadActor: 'A', leadActress: 'A', director: 'A', popularity: 2, wonAwards: true]] ]";

        String expectedLevelorder = "[ [movieObject - [year: 4, runtime: 4, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 1, title: 'A', category: 'A', leadActor: 'A', leadActress: 'A', director: 'A', popularity: 2, wonAwards: true]], [movieObject - [year: 2, runtime: 2, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]] ]";

        // test if nodes are inserted with righ way or not
        // with year data, inOrder should be 2,3,4,5 and levelOrder should be 4,3,5,2
        assertEquals(expectedInorder, yearRBT.toInOrderString(), "Test failed (Inorder)");
        assertEquals(expectedLevelorder, yearRBT.toLevelOrderString(), "Test failed(LevelOrder)");

        // test if getDataByYear is working well or not
        assertEquals(list1, tree.getDataByYear(5));

        // test if getRangeData is working well for the yearRBT or not
        ArrayList<RBTList<Integer>> range = new ArrayList<>();
        range = tree.getRangeData(3, 4, true);
        String data = range.toString();
        String expectedOutput = "[[movieObject - [year: 3, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 4, wonAwards: true]]]";
        assertEquals(expectedOutput, data, "Test2 failed (Inorder)");
    }

    /**
     * Test with titleRBT the node is inserting with sorting by title with basic
     * insert case 1,2,3
     * when insert movie8 (case2 occured), insert movie9 (case3 occured), if then
     * movie8 is located
     * right position then it means also case1 is succesfully resolved.
     * Check if the nodes are successfully inserted with comparing inorder and
     * levelorder
     * And also this method test if with the specific data from user it can return
     * specific node
     * And also this method test if with the range user input, it can return
     * specific nodes to user
     */
    @Test
    public void testTitleRBT() {
        // create tree object to make titleRBT
        MovieRedBlackTree tree = new MovieRedBlackTree<>();
        // make a movie object to store in the node
        Movie movie6 = new Movie(5, 5, "E", "E", "E", "E", "E", 2, true);
        Movie movie7 = new Movie(3, 3, "C", "C", "C", "C", "C", 3, true);
        Movie movie8 = new Movie(4, 4, "D", "D", "D", "D", "D", 4, true);
        Movie movie9 = new Movie(2, 2, "B", "B", "B", "B", "B", 4, true);

        // 1. make a node with the data what titleRBT is going to sorting with
        // 2. store the movie object to the node
        // 3. insert node with specific insert method that can insert in to titleRBT
        RBTList<String> list1 = new RBTList<String>("E");
        list1.add(movie6);
        tree.insertByTitle(list1);

        RBTList<String> list2 = new RBTList<String>("C");
        list2.add(movie7);
        tree.insertByTitle(list2);

        RBTList<String> list3 = new RBTList<String>("D");
        list3.add(movie8);
        tree.insertByTitle(list3);

        RBTList<String> list4 = new RBTList<String>("B");
        list4.add(movie9);
        tree.insertByTitle(list4);

        // create RedBlackTree object and make it to be assigned to titleRBT
        RedBlackTree titleRbt = tree.getTitleRBT();

        // make expectedInorder/Levelorder to compare with real data.
        // with title data, inOrder should be 2,3,4,5 and levelOrder should be 4,3,5,2
        String expectedInorder = "[ [movieObject - [year: 2, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 3, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 5, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 2, wonAwards: true]] ]";

        String expectedLevelorder = "[ [movieObject - [year: 4, runtime: 4, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 3, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 5, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 2, wonAwards: true]],"
                +
                " [movieObject - [year: 2, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 4, wonAwards: true]] ]";

        // test if the nodes are inserted with right way or not
        assertEquals(expectedInorder, titleRbt.toInOrderString(), "Test failed (Inorder)");
        assertEquals(expectedLevelorder, titleRbt.toLevelOrderString(), "Test failed(LevelOrder)");

        // check if the getDataByTitle is return rigth node or not
        assertEquals(list1, tree.getDataByTitle("E"));

    }

    /**
     * Test with popularityRBT the node is inserting with sorting by popularity with
     * basic
     * insert case 1,2,3
     * when insert movie3 (case2 occured), insert movie4 (case3 occured), if then
     * movie3 is located
     * right position then it means also case1 is succesfully resolved.
     * Check if the nodes are successfully inserted with comparing inorder and
     * levelorder
     * And also this method test if with the specific data from user it can return
     * specific node
     * And also this method test if with the range user input, it can return
     * specific nodes to user
     */
    @Test
    public void testPopularity() {
        // create tree object to make popularity Object
        MovieRedBlackTree tree = new MovieRedBlackTree<>();
        // make a movie object to store in the node
        Movie moviePopularity1 = new Movie(5, 5, "E", "E", "E", "E", "E", 5, true);
        Movie moviePopularity2 = new Movie(3, 3, "C", "C", "C", "C", "C", 3, true);
        Movie moviePopularity3 = new Movie(4, 4, "D", "D", "D", "D", "D", 4, true);
        Movie moviePopularity4 = new Movie(2, 2, "B", "B", "B", "B", "B", 2, true);

        // 1. make movie object to node
        // 2. make node (RBTList) with the value that what value this RBT sorting
        // nodes with
        // 3. insert node to yearRBT
        RBTList<Integer> list1 = new RBTList<Integer>(5);
        list1.add(moviePopularity1);
        tree.insertByPopularity(list1);

        RBTList<Integer> list2 = new RBTList<Integer>(3);
        list2.add(moviePopularity2);
        tree.insertByPopularity(list2);

        RBTList<Integer> list3 = new RBTList<Integer>(4);
        list3.add(moviePopularity3);
        tree.insertByPopularity(list3);

        RBTList<Integer> list4 = new RBTList<Integer>(2);
        list4.add(moviePopularity4);
        tree.insertByPopularity(list4);

        // create RedBlackTree object and make it to be assigned to popularityRBT
        RedBlackTree popularityRBT = tree.getPopularityRBT();

        // make expectedInorder/Levelorder to compare with real data.
        // with popularity data, inOrder should be 2,3,4,5 and levelOrder should be
        // 4,3,5,2
        String expectedInorder = "[ [movieObject - [year: 2, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 2, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 3, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 5, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 5, wonAwards: true]] ]";

        String expectedLevelorder = "[ [movieObject - [year: 4, runtime: 4, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 3, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 5, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 5, wonAwards: true]],"
                +
                " [movieObject - [year: 2, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 2, wonAwards: true]] ]";

        // test if the nodes are inserted with rigth way or not
        assertEquals(expectedInorder, popularityRBT.toInOrderString(), "Test failed (Inorder)");
        assertEquals(expectedLevelorder, popularityRBT.toLevelOrderString(), "Test failed(LevelOrder)");

        // test if getDataByYear is working well or not
        assertEquals(list1, tree.getDataByPopularity(5));

        // test if getRangeData's output is rigth with specific input
        ArrayList<RBTList<Integer>> range = new ArrayList<>();
        range = tree.getRangeData(3, 4, false);
        String data = range.toString();
        String expectedOutput = "[[movieObject - [year: 3, runtime: 3, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]]]";
        assertEquals(expectedOutput, data, "Test2 failed (Inorder)");

    }

    /**
     * The three test above is passed, then it means Algorithm is working well with
     * just basic insert case 1,2 and 3
     * This test is test if the algoritm can handle multiple case 1,2 ,3 and can
     * reslove the propoerty violation after
     * resolving the case 3. And also with multiple property violation, check if the
     * algorithm can work well in
     * get specific node with specific data amd also can get nodes with the specific
     * ranges with yearRBT
     * <p>
     * case 1 -> inserting movie3, movie5, movie7
     * case 2 -> inserting movie 8
     * case 3 -> inserting movie4, movie6, movie9
     * resolving after case 3 : after resolvign inserting movie9
     */
    @Test
    public void testRBTPropertyResolving() {
        // make tree object to make a RBT
        MovieRedBlackTree tree = new MovieRedBlackTree<>();
        // make movie objects to insert to each nodes
        Movie movie1 = new Movie(1, 1, "A", "A", "A", "A", "A", 2, true);
        Movie movie2 = new Movie(2, 2, "B", "B", "B", "B", "B", 3, true);
        Movie movie3 = new Movie(3, 3, "C", "C", "C", "C", "C", 4, true);
        Movie movie4 = new Movie(4, 4, "D", "D", "D", "D", "D", 4, true);
        Movie movie5 = new Movie(5, 5, "E", "E", "E", "E", "E", 4, true);
        Movie movie6 = new Movie(6, 6, "F", "F", "F", "F", "F", 4, true);
        Movie movie7 = new Movie(7, 7, "G", "G", "G", "G", "G", 4, true);
        Movie movie8 = new Movie(9, 9, "H", "H", "H", "H", "H", 4, true);
        Movie movie9 = new Movie(8, 8, "I", "I", "I", "I", "I", 4, true);

        // 1. create RBTList type node with the value what RBT will sorting with
        // 2. then add this movie to each node
        // 3. then insert each node to specific insert method of yearRBT
        RBTList<Integer> list1 = new RBTList<Integer>(1);
        list1.add(movie1);
        tree.insertByYear(list1);

        RBTList<Integer> list2 = new RBTList<Integer>(2);
        list2.add(movie2);
        tree.insertByYear(list2);

        RBTList<Integer> list3 = new RBTList<Integer>(3);
        list3.add(movie3);
        tree.insertByYear(list3);

        RBTList<Integer> list4 = new RBTList<Integer>(4);
        list4.add(movie4);
        tree.insertByYear(list4);

        RBTList<Integer> list5 = new RBTList<Integer>(5);
        list5.add(movie5);
        tree.insertByYear(list5);

        RBTList<Integer> list6 = new RBTList<Integer>(6);
        list6.add(movie6);
        tree.insertByYear(list6);

        RBTList<Integer> list7 = new RBTList<Integer>(7);
        list7.add(movie7);
        tree.insertByYear(list7);

        RBTList<Integer> list8 = new RBTList<Integer>(9);
        list8.add(movie8);
        tree.insertByYear(list8);

        RBTList<Integer> list9 = new RBTList<Integer>(8);
        list9.add(movie9);
        tree.insertByYear(list9);

        // create RedBlackTree object and make it to be assigned to yearRBT
        RedBlackTree yearRBT = tree.getYearRBT();

        // make expectedInorder/Levelorder to compare with real data.
        // with just yearData, inOrder shoud be 1,2,3,4,5,6,7,8,9 and LevelOrder should
        // be 4,2,6,1,3,5,8,7,9
        String expectedInorder = "[ [movieObject - [year: 1, runtime: 1, title: 'A', category: 'A', leadActor: 'A', leadActress: 'A', director: 'A', popularity: 2, wonAwards: true]],"
                +
                " [movieObject - [year: 2, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 3, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 5, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 6, runtime: 6, title: 'F', category: 'F', leadActor: 'F', leadActress: 'F', director: 'F', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 7, runtime: 7, title: 'G', category: 'G', leadActor: 'G', leadActress: 'G', director: 'G', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 8, runtime: 8, title: 'I', category: 'I', leadActor: 'I', leadActress: 'I', director: 'I', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 9, runtime: 9, title: 'H', category: 'H', leadActor: 'H', leadActress: 'H', director: 'H', popularity: 4, wonAwards: true]] ]";

        String expectedLevelorder = "[ [movieObject - [year: 4, runtime: 4, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 2, runtime: 2, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 6, runtime: 6, title: 'F', category: 'F', leadActor: 'F', leadActress: 'F', director: 'F', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 1, runtime: 1, title: 'A', category: 'A', leadActor: 'A', leadActress: 'A', director: 'A', popularity: 2, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 3, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 5, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 8, runtime: 8, title: 'I', category: 'I', leadActor: 'I', leadActress: 'I', director: 'I', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 7, runtime: 7, title: 'G', category: 'G', leadActor: 'G', leadActress: 'G', director: 'G', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 9, runtime: 9, title: 'H', category: 'H', leadActor: 'H', leadActress: 'H', director: 'H', popularity: 4, wonAwards: true]] ]";

        // test if nodes are inserted with right way or not
        assertEquals(expectedInorder, yearRBT.toInOrderString(), "Test2 failed (Inorder)");
        assertEquals(expectedLevelorder, yearRBT.toLevelOrderString(), "Test2 failed(LevelOrder)");

        // test if getDataByYear is working well or not
        assertEquals(list6, tree.getDataByYear(6));

        // test if getRangeData is working well for the yearRBT or not
        ArrayList<RBTList<Integer>> range = new ArrayList<>();
        range = tree.getRangeData(3, 5, true);
        String data = range.toString();
        String expectedOutput = "[[movieObject - [year: 3, runtime: 3, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 5, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 4, wonAwards: true]]]";
        assertEquals(expectedOutput, data, "Test2 failed (Inorder)");

    }

    /**
     * with 4 test above we check the algorithem can handle all the cases of
     * property violation after inserting node
     * THis method test if the each nodes has rigth color or not with basic test
     * (check inserting with inorder, level order)
     * and also check algorithem can return specific node with specific data and can
     * return specific nodes with range from the user
     * with titleRBT
     */
    @Test
    public void testRBTColor() {
        // make tree obect to make titleRBT
        MovieRedBlackTree tree = new MovieRedBlackTree<>();
        // create movie obejcts to insert each ndoe
        Movie movie1 = new Movie(5, 5, "A", "A", "A", "A", "A", 2, true);
        Movie movie2 = new Movie(3, 3, "B", "B", "B", "B", "B", 3, true);
        Movie movie3 = new Movie(4, 4, "C", "C", "C", "C", "C", 4, true);
        Movie movie4 = new Movie(6, 6, "D", "D", "D", "D", "D", 4, true);
        Movie movie5 = new Movie(9, 9, "E", "E", "E", "E", "E", 4, true);
        Movie movie6 = new Movie(4, 4, "F", "F", "F", "F", "F", 4, true);
        Movie movie7 = new Movie(7, 7, "G", "G", "G", "G", "G", 4, true);
        Movie movie8 = new Movie(1, 1, "I", "I", "I", "I", "I", 4, true);
        Movie movie9 = new Movie(2, 2, "H", "H", "H", "H", "H", 4, true);

        // 1. creat node with the value what the RBT going to sorting with
        // 2. insert movie object to each node
        // 3. insert node with specific insert method that can insert in to titleRBT
        RBTList<String> list1 = new RBTList<String>("A");
        list1.add(movie1);
        tree.insertByTitle(list1);

        RBTList<String> list2 = new RBTList<String>("B");
        list2.add(movie2);
        tree.insertByTitle(list2);

        RBTList<String> list3 = new RBTList<String>("C");
        list3.add(movie3);
        tree.insertByTitle(list3);

        RBTList<String> list4 = new RBTList<String>("D");
        list4.add(movie4);
        tree.insertByTitle(list4);

        RBTList<String> list5 = new RBTList<String>("E");
        list5.add(movie5);
        tree.insertByTitle(list5);

        RBTList<String> list6 = new RBTList<String>("F");
        list6.add(movie6);
        tree.insertByTitle(list6);

        RBTList<String> list7 = new RBTList<String>("G");
        list7.add(movie7);
        tree.insertByTitle(list7);

        RBTList<String> list8 = new RBTList<String>("I");
        list8.add(movie8);
        tree.insertByTitle(list8);

        RBTList<String> list9 = new RBTList<String>("H");
        list9.add(movie9);
        tree.insertByTitle(list9);

        // create RBT object and make it to be assigned titleRBT with getter method
        RedBlackTree titleRbt = tree.getTitleRBT();

        // create String object to compare with real data
        // with just title data, inorder should be : A,B,C,D,E,F,G,H,I and levelorder
        // should be D,B,F,A,C,E,H,G,I
        String expectedInorder = "[ [movieObject - [year: 5, runtime: 5, title: 'A', category: 'A', leadActor: 'A', leadActress: 'A', director: 'A', popularity: 2, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 3, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 6, runtime: 6, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 9, runtime: 9, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'F', category: 'F', leadActor: 'F', leadActress: 'F', director: 'F', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 7, runtime: 7, title: 'G', category: 'G', leadActor: 'G', leadActress: 'G', director: 'G', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 2, runtime: 2, title: 'H', category: 'H', leadActor: 'H', leadActress: 'H', director: 'H', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 1, runtime: 1, title: 'I', category: 'I', leadActor: 'I', leadActress: 'I', director: 'I', popularity: 4, wonAwards: true]] ]";

        String expectedLevelorder = "[ [movieObject - [year: 6, runtime: 6, title: 'D', category: 'D', leadActor: 'D', leadActress: 'D', director: 'D', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 3, runtime: 3, title: 'B', category: 'B', leadActor: 'B', leadActress: 'B', director: 'B', popularity: 3, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'F', category: 'F', leadActor: 'F', leadActress: 'F', director: 'F', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 5, runtime: 5, title: 'A', category: 'A', leadActor: 'A', leadActress: 'A', director: 'A', popularity: 2, wonAwards: true]],"
                +
                " [movieObject - [year: 4, runtime: 4, title: 'C', category: 'C', leadActor: 'C', leadActress: 'C', director: 'C', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 9, runtime: 9, title: 'E', category: 'E', leadActor: 'E', leadActress: 'E', director: 'E', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 2, runtime: 2, title: 'H', category: 'H', leadActor: 'H', leadActress: 'H', director: 'H', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 7, runtime: 7, title: 'G', category: 'G', leadActor: 'G', leadActress: 'G', director: 'G', popularity: 4, wonAwards: true]],"
                +
                " [movieObject - [year: 1, runtime: 1, title: 'I', category: 'I', leadActor: 'I', leadActress: 'I', director: 'I', popularity: 4, wonAwards: true]] ]";

        // test if the nodes are inserted with right way or not
        assertEquals(expectedInorder, titleRbt.toInOrderString(), "Test2 failed (Inorder)");
        assertEquals(expectedLevelorder, titleRbt.toLevelOrderString(), "Test2 failed(LevelOrder)");

        // check each nodes color
        // black node -> D,A,C,E,H
        // red node -> B,F,G,I
        assertEquals(1, titleRbt.root.blackHeight, "root's color is not black ");
        assertEquals(0, titleRbt.root.context[1].blackHeight,
                "root.context[1]'s color is not red");
        assertEquals(0, titleRbt.root.context[2].blackHeight,
                "root.context[2]'s color is not red");
        assertEquals(1, titleRbt.root.context[1].context[1].blackHeight,
                "root.context[1].context[1]'s color is not black");
        assertEquals(1, titleRbt.root.context[1].context[2].blackHeight,
                "root.context[1].context[2]'s color is not black");
        assertEquals(1, titleRbt.root.context[2].context[1].blackHeight,
                "root.context[2].context[1]'s color is not balck");
        assertEquals(1, titleRbt.root.context[2].context[2].blackHeight,
                "root.context[2].context[2]'s color is not balck");
        assertEquals(0, titleRbt.root.context[2].context[2].context[1].blackHeight,
                "root.context[2].context[2].context[1]'s color is not black");
        assertEquals(0, titleRbt.root.context[2].context[2].context[2].blackHeight,
                "root.context[2].context[2].context[1]'s color is not black");

    }

    /*
     * This is the test for Integration that when the user Load a file and enter Q.
     * Store each string that should be appear depends on user input, then check
     * if the output contians or not
     */
    @Test
    public void IntergrationTest1() {
        try {
            // create the MovieReader object to read a file
            MovieReader reader = new MovieReader();
            // store the all user input to TextUITest object
            TextUITester integration1 = new TextUITester(
                    "L\nmoviescsvfile.csv\nQ\n");
            Scanner input = new Scanner(System.in);
            // create backend and frontend object
            MovieSearchInterface backend = new MovieSearch();
            MovieSearchAppInterface movieSearchApp = new MovieSearchApp(backend, input);
            movieSearchApp.runCommandLoop();
            String output = integration1.checkOutput();

            // expectation1 shoule be in checkPutput() -> starting point
            String expectation1 = "----------------------------------------\n" +
                    "Welcome to the BEST!! movies of all time\n" +
                    "would you like to:\n" +
                    "[L] - Load a dataset\n" +
                    "[T] - Search Movies by Title?\n" +
                    "[Y] - Search Movies by Year?\n" +
                    "[P] - Search Movies by Popularity?\n" +
                    "[Q] - Quit\n" +
                    "----------------------------------------";
            // after expectation1, the user try to load a file and program should ask
            // expectation2
            String expectation2 = "File name to load:";
            // if the file is loaded succesfully, then expectation3 should be appear.
            String expectation3 = "File loaded";
            // After user press Q then expectation4 should be shown
            String expectation4 = "I hope we could help with all of your movie needs!\n";

            // with Junit, check if the output contains each expectation string
            assertEquals(output.contains(expectation1), true);
            assertEquals(output.contains(expectation2), true);
            assertEquals(output.contains(expectation3), true);
            assertEquals(output.contains(expectation4), true);
        } catch (Exception e) {
            assertFalse(true);
        }

    }

    /**
     * This is Integration test 2 when user load the file and
     * try to find a movie with title (Tie Me Up! Tie Me Down!), And then user try
     * to search movie with Year 1963
     * and this test doesn't contains the String about menuPrompt becasue we already
     * tested it in the IntegrationTest1
     * And store the expect Strings and check if the output contains those output or
     * not
     */
    @Test
    public void IntegrationTest2() {
        try {
            // create the MovieReader object to read a file
            MovieReader reader = new MovieReader();
            // store the all user input to TextUITest object
            TextUITester integration2 = new TextUITester(
                    "L\nmoviescsvfile.csv\nT\nTie Me Up! Tie Me Down!\nY\n1963\nQ\n");
            Scanner input = new Scanner(System.in);
            // create backend and frontend object
            MovieSearchInterface backend = new MovieSearch();
            MovieSearchAppInterface movieSearchApp = new MovieSearchApp(backend, input);
            movieSearchApp.runCommandLoop();
            String output = integration2.checkOutput();

            // if the file loaded successfully, expectation1 should be printed
            String expectation1 = "File loaded\n";
            // Because use press T to find movie with title, expecatation2 should be printed
            String expectation2 = "Please enter the title(s) you'd like to search by, with each\n"
                    + "individual title separated by a '/' character.";
            String expectation3 = "The output for your current search is:";
            // The information about Movie Tie Me Up! Tie Me Down should be printed
            String expectation4 = "movieObject - [year: 1990, runtime: 111, title: 'Tie Me Up! Tie Me Down!'," +
                    " category: 'Comedy', leadActor: 'Banderas, Antonio', leadActress: 'Abril, Victoria'," +
                    " director: 'Almod�var, Pedro', popularity: 68, wonAwards: false]";

            // After user saw the information about moivie, menuPrompt should be appear
            // again for next order
            String expectation5 = "----------------------------------------\n" +
                    "Welcome to the BEST!! movies of all time\n" +
                    "would you like to:\n" +
                    "[L] - Load a dataset\n" +
                    "[T] - Search Movies by Title?\n" +
                    "[Y] - Search Movies by Year?\n" +
                    "[P] - Search Movies by Popularity?\n" +
                    "[Q] - Quit\n" +
                    "----------------------------------------";
            // Because user press Y to find movie with year, expecatation6 should be printed
            String expectation6 = "Please enter the year(s) you'd like to search by, with each\n" +
                    "individual year separated by a '/' character.";
            String expectation7 = "The output for your current search is:";
            // The informatino about Movie that published 1963 should be printed
            String expectation8 = "movieObject - [year: 1963, runtime: 109, title: 'Donovan's Reef', category: 'Comedy',"
                    + " leadActor: 'Wayne, John', leadActress: 'Allen, Elizabeth', director: 'Ford, John',"
                    + " popularity: 62, wonAwards: false]";
            String expectation9 = "I hope we could help with all of your movie needs!\n";

            // with Junit, check if the output contains each expectation string
            assertEquals(output.contains(expectation1), true);
            assertEquals(output.contains(expectation2), true);
            assertEquals(output.contains(expectation3), true);
            assertEquals(output.contains(expectation4), true);
            assertEquals(output.contains(expectation5), true);
            assertEquals(output.contains(expectation6), true);
            assertEquals(output.contains(expectation7), true);
            assertEquals(output.contains(expectation8), true);
            assertEquals(output.contains(expectation9), true);
        } catch (Exception e) {
            assertFalse(true);
        }

    }


    /**
     * This Integration tests when user try to fine the movie with the ranged
     * year(ex) trying to find movie that published
     * 1961 ~ 1963). And store each string that should be printed with input and
     * test if the output contains those String object or not with Junit
     */
    @Test
    public void IntegrationTest3() {
        try {
            // create the MovieReader object to read a file
            MovieReader reader = new MovieReader();
            // store the all user input to TextUITest object
            TextUITester integration2 = new TextUITester(
                    "L\nmoviescsvfile.csv\nY\n1962-1963\nQ\n");
            Scanner input = new Scanner(System.in);
            // create backend and frontend object
            MovieSearchInterface backend = new MovieSearch();
            MovieSearchAppInterface movieSearchApp = new MovieSearchApp(backend, input);
            movieSearchApp.runCommandLoop();
            String output = integration2.checkOutput();

            // if the file loaded successfully, expectation1 should be printed
            String expectation1 = "File loaded\n";
            // Becuase user wants to find movie with year data, expectation2 should be
            // printed
            String expectation2 = "Please enter the year(s) you'd like to search by, with each\n" +
                    "individual year separated by a '/' character.";
            // the movie that published year is start from 1962 to 1963
            String expectation3 = "[movieObject - [year: 1962, runtime: 91, title: 'Through a Glass Darkly', category: 'Drama', leadActor: 'Bj�rnstrand, Gunnar', leadActress: 'Andersson, Harriet', director: 'Bergman, Ingmar', popularity: 64, wonAwards: false],"
                    +
                    " movieObject - [year: 1962, runtime: 0, title: 'Dr. No', category: 'Action', leadActor: 'Connery, Sean', leadActress: 'Andress, Ursula', director: 'Young, Terence', popularity: 7, wonAwards: false]]\n"
                    +
                    "[movieObject - [year: 1963, runtime: 109, title: 'Donovan's Reef', category: 'Comedy', leadActor: 'Wayne, John', leadActress: 'Allen, Elizabeth', director: 'Ford, John', popularity: 62, wonAwards: false]]";

            // with Junit, check if the output contains each expectation string
            assertEquals(output.contains(expectation1), true);
            assertEquals(output.contains(expectation2), true);
            assertEquals(output.contains(expectation3), true);
        } catch (Exception e) {
            assertFalse(true);
        }
    }

    /**
     * This test is test if the program print movies when user trying to find movie
     * with popularity. and Store the String that shoule be printed and check if
     * the output contains those String or not.
     */
    @Test
    public void IntegrationTest4() {
        try {
            // create the MovieReader object to read a file
            MovieReader reader = new MovieReader();
            // store the all user input to TextUITest object
            TextUITester integration2 = new TextUITester(
                    "L\nmoviescsvfile.csv\nP\n62\nQ\n");
            Scanner input = new Scanner(System.in);
            // create backend and frontend object
            MovieSearchInterface backend = new MovieSearch();
            MovieSearchAppInterface movieSearchApp = new MovieSearchApp(backend, input);
            movieSearchApp.runCommandLoop();
            String output = integration2.checkOutput();

            // if theh file loaded succesfully, then expectation1 should be appeared
            String expectation1 = "File loaded\n";
            // Because user wants to fidn movie with popularity, expectation2 should be
            // printed
            String expectation2 = "Please enter the Popularity(s) you'd like to search by, with each\n" +
                    "individual year separated by a '/' character.";
            // User want to find movie that has 62 popularity score, it should print 2
            // movies
            String expectation3 = "movieObject - [year: 1963, runtime: 109, title: 'Donovan's Reef', category: 'Comedy', leadActor: 'Wayne, John', leadActress: 'Allen, Elizabeth', director: 'Ford, John', popularity: 62, wonAwards: false]";
            // with Junit, check if the output contains each expectation string
            assertEquals(output.contains(expectation1), true);
            assertEquals(output.contains(expectation2), true);
            assertEquals(output.contains(expectation3), true);
        } catch (Exception e) {
            assertFalse(true);
        }
    }

    /**
     * Integration5 Tests if the program print right informatino when user want to
     * find movie with ranged popularity (ex)User want to
     * find movie that has popularity score 61~62). and store the strigng that
     * should be printed, and check if the output contains
     * those string or not.
     */
    @Test
    public void IntegrationTest5() {
        try {
            // create the MovieReader object to read a file
            MovieReader reader = new MovieReader();
            // store the all user input to TextUITest object
            TextUITester integration2 = new TextUITester(
                    "L\nmoviescsvfile.csv\nP\n61-62\nQ\n");
            Scanner input = new Scanner(System.in);
            // create backend and frontend object
            MovieSearchInterface backend = new MovieSearch();
            MovieSearchAppInterface movieSearchApp = new MovieSearchApp(backend, input);
            movieSearchApp.runCommandLoop();
            String output = integration2.checkOutput();

            // if the file loaded succesfully then expectation1 should be printed
            String expectation1 = "File loaded\n";
            // Because user wants to see the movies that has popularity 61~62, 3 movies
            // shoule be appeard
            String expectation2 = "[movieObject - [year: 1987, runtime: 120, title: 'Fatal Attraction', category: 'Mystery', leadActor: 'Douglas, Michael', leadActress: 'Archer, Anne', director: 'Lyne, Adrian', popularity: 61, wonAwards: false]]\n"
                    +
                    "[movieObject - [year: 1963, runtime: 109, title: 'Donovan's Reef', category: 'Comedy', leadActor: 'Wayne, John', leadActress: 'Allen, Elizabeth', director: 'Ford, John', popularity: 62, wonAwards: false]";
            // with Junit, check if the output contains each expectation string
            assertEquals(output.contains(expectation1), true);
            assertEquals(output.contains(expectation2), true);
        } catch (Exception e) {
            assertFalse(true);
        }
    }

    /**
     * This test is for testing DataWrangular code is working well or not
     * Test if the class can catch fileNotFoundException or not when user
     * try to load wrong file. If the variable testResult is true, then it
     * means MovieReader can catch FileNotFoundException
     */
    @Test
    public void CodeReviewOfDataWrangler1() {
        // first initialize boolean variable to check the result of the test
        boolean testResult = false;
        // created MovieReader object for the test
        MovieReader reader = new MovieReader();
        try {
            // with useing readMovieData method, ty to read wrong file
            reader.readMovieData("moviescsvfile.....csv");
            // if the file is read then test result is failed
            testResult = false;
        } catch (FileNotFoundException e) {
            // if the method catch the FileNotFoundException,
            // then set testResult -> true;
            testResult = true;
        }

        // with Junit, check if the testResult is true or not
        assertEquals(testResult, true);
    }

    /**
     * this test is testing MovieReader can read all movies, So, first checked
     * csv file that how many movies stored and check with using size() method.
     */
    @Test
    public void CodeReviewOfDataWrangler2() {
        MovieReader reader = new MovieReader();
        List<MovieInterface> movies;
        try {
            // after read csv file and store it to movies object
            movies = reader.readMovieData("moviescsvfile.csv");
            // by csv file, there are 65 movies, so the size of movies shoule be 65
            assertEquals(65, movies.size());
        } catch (FileNotFoundException e) {
            System.out.println("File not found -  DataWrangularTest2");
        }
    }

    /**
     * this test check if the DW code can get information from the csv or not
     * first load csv file with MovieReader, then check it getter method of
     * year,runtime,title,category,Actor,Actress,Director, Popularity, awards
     * are stored correctly or not.
     */
    @Test
    public void CodeReviewOfDataWrangler3() {
        MovieReader reader = new MovieReader();
        List<MovieInterface> movies;
        try {
            // read csv file with MovieReader
            movies = reader.readMovieData("moviescsvfile.csv");
            // those are the information of a movies that is first line in csv file
            int year = 1990;
            int duration = 111;
            String title = "Tie Me Up! Tie Me Down!";
            String Category = "Comedy";
            String Actor = "Banderas, Antonio";
            String Actress = "Abril, Victoria";
            String Director = "Almod�var, Pedro";
            int popularity = 68;
            boolean awards = false;

            // with useing aseertEquals, compare with expected value and the value from the method.
            assertEquals(year, movies.get(0).getYear());
            assertEquals(duration, movies.get(0).getRuntime());
            assertEquals(title, movies.get(0).getTitle());
            assertEquals(Category, movies.get(0).getCategory());
            assertEquals(Actor, movies.get(0).getLeadActor());
            assertEquals(Actress, movies.get(0).getLeadActress());
            assertEquals(Director, movies.get(0).getDirector());
            assertEquals(popularity, movies.get(0).getPopularity());
            assertEquals(awards, movies.get(0).wonAwards());


        } catch (FileNotFoundException e) {
            System.out.println("File not found - DataWrangularTest3");
        }

    }

}