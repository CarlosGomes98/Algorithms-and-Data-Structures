import java.lang.Integer;

public class TestList{
    public static void main(String[] args){
        LinkedList<Integer> primes = new LinkedList<Integer>();

        primes.insertOrdered(3);
        primes.insertOrdered(14);
        primes.insertOrdered(12);
        primes.insertOrdered(1);

        if(primes.has(12))
            System.out.println("Primes has 12");
        if (primes.has(2))
            System.out.println("Primes has 2");
    }
}