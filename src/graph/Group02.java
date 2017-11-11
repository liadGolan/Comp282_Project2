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
    public int[][] graph = new int[10][10];


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
                for (int i = 0; i < storeArr.length; i++) //for every index in the array of storeArr...
                {
                    locColA = ((int) storeArr[i])-97; //convert index i to int and store into locColA
                    locColB = ((int) storeArr[i+1])-97;//convert index i+1 to int and store into locColB
                    distVal = ((int) storeArr[i+2])-97;//convert index i+2 to int and store into distVal
                    graph[locColA][locColB]= distVal;//store as a value in the 2D made up of locColA and locColB
                }
            }



        }
        catch(IOException exception)
        {
            System.out.println("Error processing file: " + exception);
        }
    }





//MAIN
    public static void main(String [] args) // supplied command-line arguments as an array of String objects
    {

        // Group02 mygraph = new Group02(args[0]); // created a java object using classname
        //mygraph.shortestPath(0);
        //mygraph.shortestPath(args[1].charAt(0)); //calling the shortestPath class as an object

        //manually created graphs to test dijkstra's:
        int[][] graph_temp = {{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 1, 100, 100, 100}, //a
                {7, 3, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100},// b
                {100, 6, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100},//c
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 8},//d
                {8, 7, 100, 100, 100, 100, 8, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100},//e
                {100, 100, 100, 100, 100, 100, 100, 100, 5, 4, 100, 100, 100, 100, 100, 100, 100, 100},//f
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 3, 1, 100, 100, 100, 100, 100, 100, 100}, //g
                {5, 100, 100, 100, 5, 100, 100, 100, 4, 100, 100, 100, 100, 100, 5, 100, 100, 100}, //h
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}, //i
                {100, 100, 100, 100, 100, 1, 100, 100, 100, 100, 5, 100, 7, 100, 100, 100, 100, 100},//j
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 8, 100, 100, 100, 100},//k
                {100, 100, 100, 100, 100, 100, 100, 4, 100, 100, 100, 100, 100, 100, 100, 9, 100, 100},//l
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 5, 100, 100, 100, 100},//m
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100},//n
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 9, 100, 100},//o
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 3, 100, 100, 100, 100, 100},//p
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100},//q
                {100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 4, 100, 100, 100, 100, 100, 100, 100}};//r

        int [][]testGraph = {{100,1,100,100},
                {100,100,10,100},
                {100,100,100,5},
                {2,100,100,100}};

        shortestPath(testGraph,0  );
    }

    /*Dijkstra algorithm. Takes in a graph and int c which represents the starting index*/
    private static void  shortestPath(int[][] graph, int c) {
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
        marked[c] = true; //marking the beginning vertex as visited

        //changing parent array
        for (int i = 0;i<graph.length;i++){
            if(graph[c][i] !=100){
                parent[i] = c;
            }
        }

        //changing array weights
        for (int i =0;i<graph.length;i++){
            if(graph[c][i] != 100){
                weight[i] = graph[c][i];
            }
        }

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
        System.out.println((char)(c+97) + " origin");

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

}




//TODO: check to see if the fileReader works by printing the 2D array
//TODO: get dijkstra code works

