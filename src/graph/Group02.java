package graph;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class Group02 {
    //VARIABLES
    private int locColA;
    private int locColB;
    private int distVal;
    private String fileName;
    private char[] storeArr;
    private int[][] graph = new int[24][24];


//CONSTRUCTOR

    public Group02(String fileName) {
        try {
            this.fileName = fileName;
            BufferedReader br = new BufferedReader(new FileReader(fileName)); //looks for file name sample.txt
            String line = br.readLine(); // reads every line of the file as a string

            while (line != null) {
                storeArr = line.toCharArray(); //store the line in the file into an array as chars
                locColA = ((int) storeArr[0]) - 97; //convert index i to int and store into locColA
                locColB = ((int) storeArr[2]) - 97;//convert index i+1 to int and store into locColB
                distVal = ((int) storeArr[4]) - 48;//convert index i+2 to int and store into distVal
                graph[locColA][locColB] = distVal;//store as a value in the 2D made up of locColA and locColB
                line = br.readLine();
            }


        } catch (IOException exception) {
            System.out.println("Error processing file: " + exception);
        }

    }


    //MAIN
    public static void main(String[] args) // supplied command-line arguments as an array of String objects
    {

        Group02 mygraph = new Group02(args[0]); // created a java object using classname
        mygraph.shortestPath(args[1].charAt(0)-97); //calling the shortestPath class as an object

        mygraph.shortestPath(2);

    }

    /*Dijkstra algorithm. Takes in a graph and int c which represents the starting index*/

    private void shortestPath(int vertex) {



        /**Array setup*/
        boolean marked[] = new boolean[graph.length]; // Keeps track of vertices that have been visited
        int parent[] = new int[graph.length]; //parent graph just like the one in powerpoint
        int weight[] = new int[graph.length]; //set that will hold the weight of each vertices

        for (int i = 0; i < marked.length; i++) { //creation of arrays that will keep dijkstra going
            marked[i] = false;
            parent[i] = -1;
            weight[i] = Integer.MAX_VALUE;
        }

        int root = vertex;
        int currentVertex = vertex;
        weight[currentVertex] = 0;
        marked[currentVertex] = false;

        /**Traversing through the graph */
        do { //dijkstra's will continue until all vertices in the graph are marked

            marked[currentVertex] = true; //marking the vertex as visited

            //changing parent array
            for (int i = 0; i < parent.length; i++) {
                if (graph[currentVertex][i] != 0 && !marked[i] && weight[i] > weight[currentVertex] + graph[currentVertex][i]) {
                    parent[i] = currentVertex;
                }
            }
            //changing array weights
            for (int i = 0; i < weight.length; i++) {
                if (graph[currentVertex][i] != 0 && weight[i] > weight[currentVertex] + graph[currentVertex][i]) {
                    weight[i] = weight[currentVertex] + graph[currentVertex][i];
                }
            }
            //changing marked array; The following section is used to determine what vertex will be visited next:
            int minimumWeight = Integer.MAX_VALUE;//used to determine which vertex to pick
            int nextMinimumVertex;
            for (int i = 0; i < weight.length; i++) {
                if (weight[i] < minimumWeight && !marked[i]) {

                    minimumWeight = weight[i];

                }
            }
            nextMinimumVertex = getArrayIndex(weight, minimumWeight);//gets the index (vertex) with smallest weight

            if (nextMinimumVertex != root) {
                currentVertex = nextMinimumVertex;
            } else {
                weight[root] = 0;
            }
        } while (!(markedCheck(marked, weight)));
        System.out.println(((char) (vertex + 97)) + " origin");
        for (int i = 0; i < graph.length; i++) {
            if (weight[i] != Integer.MAX_VALUE) {
                System.out.println((char) (i + 97) + " " + weight[i] + " " + vertexPath(parent,root, i));
            }
        }
    }

    /**
     * Method used to obtain path
     */
    private static String vertexPath(int parent[], int root, int end) {

        int i = end;
        String output = "";
        if (i != root  ) {
            do {
                output += ((char) (parent[i] + 97));

                i = parent[i];
            } while (parent[i] != -1);
            return new StringBuilder(output).reverse().toString();

        } else {
            return " ";
        }


    }
    /**
     * method used to obtain array index
     **/
    private static int getArrayIndex(int[] arr, int value) {

        int k = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                k = i;
                break;
            }
        }
        return k;
    }//end of getArrayIndex

    /*the following method is used to stop dijkstra's after all vertices are visited */
    private static boolean markedCheck(boolean[] markedGraph, int[] weight) {
        boolean check = true;
        for (int i = 0; i < markedGraph.length; i++) {
            if (!markedGraph[i] && (weight[i] != Integer.MAX_VALUE)) {
                check = false;
            }
        }
        return check;
    } //end of markedCheck



}








