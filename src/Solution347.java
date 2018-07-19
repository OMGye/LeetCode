import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by upupgogogo on 2018/7/10.下午1:05
 */
public class Solution347 {

    private class Fq implements Comparable<Fq>{
        public int key, fq;

        public Fq(int key, int fq) {
            this.key = key;
            this.fq = fq;
        }

        @Override
        public int compareTo(Fq anther) {
            if (this.fq < anther.fq)
                return -1;
            if (this.fq > anther.fq)
                return 1;
            return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums){
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        PriorityQueue<Fq> priorityQueue = new PriorityQueue();
        for (int key : map.keySet()){
            if (priorityQueue.size() < k)
                priorityQueue.add(new Fq(key,map.get(key)));
            else {
                if (priorityQueue.peek().fq < map.get(key)){
                    priorityQueue.poll();
                    priorityQueue.add(new Fq(key,map.get(key)));
                }
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty())
            res.add(priorityQueue.poll().key);
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0 ; i < 9; i ++)
            priorityQueue.add(i);
        System.out.println(priorityQueue);
    }
}
