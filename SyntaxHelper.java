import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SyntaxHelper {
    public static void main(String[] args) {
        // HASH MAPS
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        frequencies.merge(1, 1, Integer::sum);
        frequencies.put(1, frequencies.getOrDefault(1, 0) + 1);

        String s = "abcabcbb";
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // HEAPS
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
                //(a, b) -> Integer.compare(a.getValue(), b.getValue())
        );

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > 3) minHeap.poll();
        }

        // INT ARRAYS
        int[] intArray = minHeap.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
        int[] keys = frequencies.keySet().stream().mapToInt(Integer::intValue).toArray();
        int[] ds = new int[24];
        int[] ds2 = new int[]{1, 2, 3, 4, 5};

        // CHARACTERS
        boolean equalityCheck = s.charAt(0) == ')';
        boolean isAlphaNumerical = Character.isLetterOrDigit(s.charAt(0));
    }
}
