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

    /*Dijkstra algorithm. Takes in a graph and int c which represents the starting index*/
    private static void  shortestPath(int[][] graph, int index) {
        //General Dijkstra algo

        boolean marked[] = new boolean[graph.length]; //shortest path tree set. Keeps track of vertices
       //that have been visited
        int parent[] = new int[graph.length]; //parent graph just like the one in powerpoint
        int weight[] = new int[graph.length]; //set that will hold the weight of each vertices

        for (int i = 0;i<marked.length;i++){ //creation of arrays that will keep dijkstra going
            marked[i] =false;
            parent[i] = -1;
            weight[i] =100;
        }
        marked[index] = true; //marking the beginning vertex as visited


        //changing parent array
        for (int i = 0;i<graph.length;i++){
            if(graph[index][i] !=100){
                parent[i] = index;
            }
        }
        //changing array weights
        for (int i =0;i<graph.length;i++){
            if(graph[index][i] != 100){
                weight[i] = graph[index][i];
            }
        }
        //changing marked array:
        int nextMinimumIndex = 100; //variable will be used to determine which vertex will follow
        //if it has the minumum weight and
        //it is unmarked, pick it next
        for (int i = 0; i<marked.length;i++){
            if(weight[i]< nextMinimumIndex){
                nextMinimumIndex = weight[i];
            }
            if(!marked[i]){

            }

        }






/********************************************************************************************************************/
        //printing results after each change
        System.out.println("Marked graph: ");
        for (int i = 0; i<marked.length;i++){
            System.out.print(marked[i] + " ");
        }
        System.out.println();
        System.out.println("Parent:");
        for (int i = 0; i<marked.length;i++){
            System.out.print(parent[i]+ " ");
        }
        System.out.println();
        System.out.println("Weight: ");
        for (int i = 0; i<weight.length;i++){
            System.out.print(weight[i]+ " ");
        }
        System.out.println();
        System.out.println();
        System.out.println((char)(index+97) + " origin");

        for (int i =0;i<graph.length;i++){
            System.out.println((char)(i+97) +" " +weight[i]);
        }


    } //end of dijkstra

    /*the following method is used to stop dijkstra's after all vertices are visited */
    private static boolean markedCheck(boolean []markedGraph){
        boolean check = false;
        for (int i = 0;i<markedGraph.length;i++){
            if(markedGraph[i]){
                check =true;
            }
        }
        return check;
    } //end of markedCheck

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





//TODO: check to see if the fileReader works by printing the 2D array
//TODO: get dijkstra code works


