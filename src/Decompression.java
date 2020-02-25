import java.util.Scanner;
import java.util.Vector;

public class Decompression {
    public Decompression(){
        GUI g = new GUI();
        Vector<Character> chars = new Vector<>();
        Vector<Double> originalProbs = new Vector<>();
        Vector<Double> probs = new Vector<>();
        double lower , upper;
        String decomp = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Characters : ");
        String inputChar = scanner.nextLine();
        System.out.print("Probabilities : ");
        for(int i=0; i<inputChar.length(); i++) {
            originalProbs.add(scanner.nextDouble());
            chars.add(inputChar.charAt(i));
        }
        System.out.print("Number of Characters : ");
        int inputNum = scanner.nextInt();
        System.out.print("Code : ");
        double code = scanner.nextDouble();
        probs.addAll(originalProbs);
        for(int i=1; i<originalProbs.size(); i++)
            originalProbs.set(i,originalProbs.get(i-1)+originalProbs.get(i));
        for(int i=0; i<inputNum; i++){
            int j;
            for(j=0; j<probs.size(); j++){
                if(code <= probs.get(j)){
                    decomp += chars.get(j);
                    break;
                }
            }
            if(j == 0){ lower = 0;}
            else lower = probs.get(j-1);
            upper = probs.get(j);
            for(int k=0; k<probs.size(); k++) {
                probs.set(k, lower + ((upper - lower) * originalProbs.get(k)));
            }
        }
        System.out.println("Output : " + decomp);
    }
}
