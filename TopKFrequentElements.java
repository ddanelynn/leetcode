import java.util.*;

class TopKFrequentElements {
    public static void main(String args[]) {
        int[] nums = new int[] {5,2,5,3,5,3,1,1,3};
        topKFrequent(nums, 2);

        // ArrayList<Integer> arr = new ArrayList<>(3);
        // arr.add(0, 4);
        // arr.add(2, 4);
        // System.out.println(arr.get(0) == null);
    }

    // public static int[] topKFrequent(int[] nums, int k) {
    //     HashMap<Integer, Integer> hMap = new HashMap<>();
    //     for (int num : nums) {
    //         if (hMap.containsKey(num)) {
    //             hMap.put(num, hMap.get(num) + 1);
    //         } else {
    //             hMap.put(num, 1);
    //         }
    //     }

    //     PriorityQueue<Element> pq = new PriorityQueue<>(new ElementComparator());

        

    //     Set<Integer> keySet = hMap.keySet();
    //     for (int element : keySet) {
    //         pq.add(new Element(element, hMap.get(element)));
    //     }

    //     int[] resultArr = new int[k];
    //     int index = k;
    //     while (index != 0) {
    //         resultArr[k - index] = pq.poll().number;
    //         index--;
    //     }
    //     return resultArr;
    // }

    // public static class Element {
    //     int number;
    //     int frequency;
    //     public Element(int number, int frequency) {
    //         this.number = number;
    //         this.frequency = frequency;
    //     }
    // }

    // public static class ElementComparator implements Comparator<Element> {
    //     @Override
    //     public int compare(Element el1, Element el2) {
    //         return el2.frequency - el1.frequency;
    //     }
    // }

    public static int[] topKFrequent(int[] nums, int k) {
        ArrayList<Queue<Integer>> bucket = new ArrayList<>();

        for (int i = 0; i < nums.length + 1; i++) {
            bucket.add(null);
        }

        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int num : nums) {
            if (hMap.containsKey(num)) {
                hMap.put(num, hMap.get(num) + 1);
            } else {
                hMap.put(num, 1);
            }
        }

        Set<Integer> keySet = hMap.keySet();

        for (int element : keySet) {
            if (bucket.get(hMap.get(element)) == null) {
                Queue<Integer> arr = new LinkedList<>();
                arr.add(element);
                bucket.set(hMap.get(element), arr);

            } else {
                bucket.get(hMap.get(element)).add(element);
            }
        }

        int[] result = new int[k];
        int index = k;
        for (int i = bucket.size() - 1; i >= 0; i--) {
            if (index > 0 && bucket.get(i) != null) {
                while (!bucket.get(i).isEmpty() && index > 0) {
                    result[k - index] = bucket.get(i).poll();
                    index--;
                }
            }
        }
        return result;
    }
}