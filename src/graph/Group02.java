package graph;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Group02
{
//VARIABLES
    private int locColA;
    private int locColB;
    private int distVal;
    private String fileName;
    private char[] storeArr;
    public int[][] graph = new int[24][24];

//CONSTRUCTOR
    public Group02(String fileName){
        try
        {
            this.fileName = fileName;
            BufferedReader br = new BufferedReader(new FileReader(fileName)); //looks for file name sample.txt
            String line = br.readLine(); // reads every line of the file as a string

            while (line != null)
            {
                storeArr = line.toCharArray(); //store the line in the file into an array as chars
                locColA = ((int) storeArr[0])-97; //convert index i to int and store into locColA
                locColB = ((int) storeArr[2])-97;//convert index i+1 to int and store into locColB
                distVal = ((int) storeArr[4])-48;//convert index i+2 to int and store into distVal
                graph[locColA][locColB]= distVal;//store as a value in the 2D made up of locColA and locColB
                line = br.readLine();
            }

        }
        catch(IOException exception)
        {
            System.out.println("Error processing file: " + exception);
        }
    }

//MAIN
    public static void main(String[] args) // supplied command-line arguments as an array of String objects
    {
        Group02 mygraph = new Group02(args[0]); // created a java object using classname
        //mygraph.shortestPath(args[1].charAt(0)); //calling the shortestPath class as an object
        System.out.println(mygraph.checkGraphCreation());
    }

    private void shortestPath(char c) {
        //General Dijkstra algo


    }

    // check to see if the fileReader works by printing the 2D array
    private String checkGraphCreation()
    {
        String output = "";
        for(int r = 0; r < graph.length; r+=1)
        {
            for(int c = 0; c < graph[r].length; c +=1)
            {
                output += graph[r][c] + " ";
            }
            output += "\n";
        }
        return output;
    }

}

//TODO: get dijkstra code works