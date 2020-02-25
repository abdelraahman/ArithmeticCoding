import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Node
{
    char data;
    double upper;
    double lower;

}
public class Arithmetic {
    static Node lowerHead = new Node();
    static Node upperHead = new Node();
    static Vector <Node> vecNode = new Vector<Node>();
    static Double result =0.0;
    public static void main(String[] args)
    {

        lowerHead.lower = 0.0;
        upperHead.upper = 1.0;
        String input="";
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        Vector<Double> inp = new Vector<Double>();
        for(int i=0;i<input.length();i++)
        {
            inp.add(scan.nextDouble());
        }
        for(int i=0;i<input.length();i++)
        {
            Node Newnode = new Node();
            Newnode.data = input.charAt(i);
            if(i==0) Newnode.lower = 0.0;
            else Newnode.lower = vecNode.get(i-1).upper;
            Newnode.upper = Newnode.lower +inp.get(i) ;
            vecNode.add(Newnode);

        }
        for(int i=0 ; i<vecNode.size();i++)
        System.out.println(vecNode.get(i).data +" "+ vecNode.get(i).lower +" "+ vecNode.get(i).upper);

        for(int i=0;i<inp.size();i++)
        {
            inp.set(i,vecNode.get(i).upper);
        }
        String StreamOfInput ="";
        System.out.println("Enter the stream of input: ");
        Scanner scan1 = new Scanner(System.in);
        StreamOfInput = scan1.nextLine();

        for(int i=0;i<StreamOfInput.length();i++)
        {
            for(int y=0;y<vecNode.size();y++)
            {
                if(vecNode.get(y).data == StreamOfInput.charAt(i))
                {
                    lowerHead.lower = vecNode.get(y).lower;
                    upperHead.upper = vecNode.get(y).upper;
                    for(int z=0;z<input.length();z++)
                    {
                        if(z==0) {
                            vecNode.get(z).lower = lowerHead.lower;
                            vecNode.get(z).upper = lowerHead.lower+(upperHead.upper-lowerHead.lower)*inp.get(z);

                        }else {
                            vecNode.get(z).lower = vecNode.get(z - 1).upper;
                            vecNode.get(z).upper = lowerHead.lower + (upperHead.upper - lowerHead.lower) * inp.get(z);
                        }
                    }

                }
            }
        }

        for (int y=0;y<vecNode.size();y++)
        {
            if(StreamOfInput.charAt(StreamOfInput.length()-1)== vecNode.get(y).data)
            {
                Double low = vecNode.get(y).lower;
                Double high = vecNode.get(y).upper;
                result = (high-low)+ low;
            }
        }
        for(int i=0 ; i<vecNode.size();i++)
            System.out.println(vecNode.get(i).data +" "+ vecNode.get(i).lower +" "+ vecNode.get(i).upper);

        System.out.println("pick any value in range = "+result);

    }
}
