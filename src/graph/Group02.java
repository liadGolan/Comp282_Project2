package graph;

public class Group02
{

    public int[][] graph;

    public static void main(String[] args)
    {
        int rows = 18;
        int columns = 18;


                             //a   b    c   d   e   f   g   h   i   j   k   l   m   n   o   p   q   r
        int[][]graph_temp ={{100,100,100,100,100,100,100,100,100,100,100,100,100,100,1,100,100,100}, //a
                             {7,3,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100},// b
                             {100,6,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100},//c
                             {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,8},//d
                             {8,7,100,100,100,100,8,100,100,100,100,100,100,100,100,100,100,100},//e
                             {100,100,100,100,100,100,100,100,5,4,100,100,100,100,100,100,100,100},//f
                             {100,100,100,100,100,100,100,100,100,3,1,100,100,100,100,100,100,100}, //g
                             {5,100,100,100,5,100,100,100,4,100,100,100,100,100,5,100,100,100}, //h
                             {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100}, //i
                             {100,100,100,100,100,1,100,100,100,100,5,100,7,100,100,100,100,100},//j
                             {100,100,100,100,100,100,100,100,100,100,100,100,100,8,100,100,100,100},//k
                             {100,100,100,100,100,100,100,4,100,100,100,100,100,100,100,9,100,100},//l
                             {100,100,100,100,100,100,100,100,100,100,100,100,100,5,100,100,100,100},//m
                             {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100},//n
                             {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,9,100,100},//o
                             {100,100,100,100,100,100,100,100,100,100,100,100,3,100,100,100,100,100},//p
                             {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100},//q
                             {100,100,100,100,100,100,100,100,100,100,4,100,100,100,100,100,100,100}};//r
                for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<columns; j++)
            {
                System.out.print(graph_temp[i][j]);
            }
            System.out.println();



    };

    }
     //   Group02 mygraph = new Group02(args[0]);
        //mygraph.shortestPath();
//        this.storeData('a', 'o', 1);
//        this.storeData('b', 'a', 7);
//        this.storeData('b', 'c', 3);
//        this.storeData('c', 'b', 6);
//        this.storeData('d', 'r', 8);
//        this.storeData('e', 'a', 8);
//        this.storeData('e', 'b', 7);
//        this.storeData('e', 'h', 8);
//        this.storeData('f', 'i', 5);
//        this.storeData('f', 'j', 4);
//        this.storeData('g', 'j', 3);
//        this.storeData('g', 'k', 1);
//        this.storeData('h', 'a', 5);
//        this.storeData('h', 'e', 5);
//        this.storeData('h', 'i', 4);
//        this.storeData('h', 'o', 5);
//        this.storeData('j', 'f', 1);
//        this.storeData('j', 'k', 5);
//        this.storeData('j', 'm', 7);
//        this.storeData('k', 'n', 8);
//        this.storeData('k', 'r', 4);
//        this.storeData('l', 'h', 4);
//        this.storeData('l', 'p', 9);
//        this.storeData('m', 'n', 5);
//        this.storeData('o', 'p', 9);
//        this.storeData('p', 'm', 3);
//        this.storeData('p', 'r', 2);
//        this.storeData('r', 'k', 4);
//    }
    public void shortestPath( int graph[][],int origin){

    }


    public void storeData(char col1, char col2, int val){
        int locColA = ((int) col1)-97;
        int locColB = ((int) col2)-97;
        graph [locColA][locColB] = val;
    }
}
