import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IdenticalDistribution {
    public static int cardPackets(List<Integer> cardTypes) {
        int smallestDifference = Integer.MAX_VALUE;
        List<Integer> primeNumber = primeNumbersTill(500);
        System.out.println(primeNumber);
        for (int i = 0; i < primeNumber.size(); i++) {
            int additionalCards = 0;
            for (int card : cardTypes) {
                if (card > primeNumber.get(i)) {
                    if (card % primeNumber.get(i) != 0) {
                        int division = card / primeNumber.get(i);
                        int difference = primeNumber.get(i) * (division + 1) - card;
                        additionalCards += difference;
                    }
                } else {
                    additionalCards += (primeNumber.get(i) - card);
                }
            }
            if (additionalCards == 1) {
                return 1;
            }

            if (additionalCards < smallestDifference) {
                smallestDifference = additionalCards;
            }
        }
        return smallestDifference;
    }

    public static List<Integer> primeNumbersTill(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(x -> isPrime(x)).boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

    public static void main(String args[]) {
        List<Integer> cardTypes = new ArrayList<>();
        cardTypes.add(3);
        cardTypes.add(9);
        cardTypes.add(7);
        cardTypes.add(6);
        cardTypes.add(5);
        cardTypes.add(2);
        System.out.println(cardPackets(cardTypes));
    }
}
