/*
 * 692. Top K Frequent Words
 */

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ret = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ret;
        }

        Map<String, Integer> freq = new HashMap<String, Integer>();
        for (String s : words) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> top = new PriorityQueue<>(k,
                (x, y) -> x.getValue() != y.getValue() ? y.getValue() - x.getValue()
                        : x.getKey().compareTo(y.getKey()));
        for (Map.Entry<String, Integer> set : freq.entrySet()) {
            top.add(set);
        }

        while (k > 0) {
            ret.add(top.poll().getKey());
            k--;
        }
        return ret;
    }
}