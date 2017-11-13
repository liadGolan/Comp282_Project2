package graph;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;


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
        //mygraph.dijkstra(args[1].charAt(0)); //calling the shortestPath class as an object
        //System.out.println(mygraph.checkGraphCreation());


        int[][] powerpoint =
                {
                        {0, 8, 0, 4, 9},
                        {0, 0, 1, 0, 0},
                        {0, 2, 0, 0, 3},
                        {0, 0, 1, 0, 0},
                        {0, 0, 2, 7, 0}

                };
        int[][] sample = {{0, 1, 0, 0},
                {0, 0, 10, 0},
                {0, 0, 0, 5},
                {2, 0, 0, 0}};
        //mygraph.dijkstra(0);

        mygraph.shortestPath(0);

    }

    /*Dijkstra algorithm. Takes in a graph and int c which represents the starting index*/
    private void dijkstra(char c) {

    }


    private void shortestPath(int vertex) {

        //General Dijkstra algo
//        int[][] graph = {
//                {0, 8, 0, 4, 9},
//                {0, 0, 1, 0, 0},
//                {0, 2, 0, 0, 3},
//                {0, 0, 1, 0, 0},
//                {0, 0, 2, 7, 0}
//
//        };

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


/************PRINTING RESULTS AFTER EACH  VERTEX IS LOOKED AT *******************************************************************/


            System.out.println("Current Vertex: " + currentVertex);


            System.out.println("Marked graph: ");
            for (int i = 0; i < marked.length; i++) {
                System.out.print(marked[i] + " ");
            }
            System.out.println();
            System.out.println("Parent:");
            for (int i = 0; i < marked.length; i++) {
                System.out.print(((char) (parent[i] + 97) + " "));
            }
            System.out.println();
            System.out.println("Weight: ");
            for (int i = 0; i < weight.length; i++) {
                System.out.print(weight[i] + " ");
            }
            System.out.println();
            System.out.println();


            System.out.println("Marked graph: ");
            for (int i = 0; i < marked.length; i++) {
                System.out.print(marked[i] + " ");
            }
            System.out.println();
            System.out.println("Parent:");
            for (int i = 0; i < marked.length; i++) {
                System.out.print(((char) (parent[i] + 97) + " "));
            }
            System.out.println();
            System.out.println("Weight: ");
            for (int i = 0; i < weight.length; i++) {
                System.out.print(weight[i] + " ");
            }
            System.out.println();
            System.out.println();


            if (nextMinimumVertex != root) {
                currentVertex = nextMinimumVertex;
            } else {
                weight[root] = 0;
            }




            System.out.println("next minimum vertex: " + nextMinimumVertex);
            System.out.println("Current Vertex: " + currentVertex);

            System.out.println("VERTEX PATH: ");

            System.out.println("-----------------END OF ITERATION------------");
            System.out.println();
        } while (!(markedCheck(marked, weight)));
        System.out.println(((char)(vertex + 97)) + " origin");
        for (int i = 0; i < graph.length; i++) {
            if (weight[i] != Integer.MAX_VALUE) {
                System.out.println((char) (i + 97) + " " + weight[i] +" "+ vertexPath(parent, i));
            }
        }
    }

    /**
     * Method used to obtain path
     */
    private static String vertexPath(int parent[],int root){

     int i = root;
        String output = "";
if(root !=0) {
    do {
        output += ((char) (parent[i] + 97));

        i = parent[i];
    } while (parent[i] != -1);
   return new StringBuilder(output).reverse().toString();

}else{
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

    // check to see if the fileReader works by printing the 2D array
    private String checkGraphCreation() {
        String output = "";
        for (int r = 0; r < graph.length; r += 1) {
            for (int c = 0; c < graph[r].length; c += 1) {
                output += graph[r][c] + " ";
            }
            output += "\n";
        }
        return output;
    }


}








