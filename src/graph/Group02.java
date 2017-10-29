package graph;

public class Group02
{
    public int[][] graph = new int[10][10];

    public static void main(String[] args)
    {
        Group02 mygraph = new Group02(args[0]);
        mygraph.shortestPath(args[1].get(0));

        this.storeData('a', 'o', 1);
        this.storeData('b', 'a', 7);
        this.storeData('b', 'c', 3);
        this.storeData('c', 'b', 6);
        this.storeData('d', 'r', 8);
        this.storeData('e', 'a', 8);
        this.storeData('e', 'b', 7);
        this.storeData('e', 'h', 8);
        this.storeData('f', 'i', 5);
        this.storeData('f', 'j', 4);
        this.storeData('g', 'j', 3);
        this.storeData('g', 'k', 1);
        this.storeData('h', 'a', 5);
        this.storeData('h', 'e', 5);
        this.storeData('h', 'i', 4);
        this.storeData('h', 'o', 5);
        this.storeData('j', 'f', 1);
        this.storeData('j', 'k', 5);
        this.storeData('j', 'm', 7);
        this.storeData('k', 'n', 8);
        this.storeData('k', 'r', 4);
        this.storeData('l', 'h', 4);
        this.storeData('l', 'p', 9);
        this.storeData('m', 'n', 5);
        this.storeData('o', 'p', 9);
        this.storeData('p', 'm', 3);
        this.storeData('p', 'r', 2);
        this.storeData('r', 'k', 4);
    }
}
