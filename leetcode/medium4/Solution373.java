package algorithm.medium4;

import org.junit.Test;

import java.util.*;

/**
 * Created by youlu on 2018/9/24.
 */
public class Solution373 {
    public class  Node{
        int sum;
        int x;
        int y;
        Node(int _sum, int _x, int _y){
            sum = _sum;
            x = _x;
            y = _y;
        }
    }
    //Accepted ---- 116ms
    /*
        brute solution
        time complexity O(mn)
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k){
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                Node node = new Node(nums1[i] + nums2[j], nums1[i], nums2[j]);
                list.add(node);
            }
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.sum < o2.sum){
                    return -1;
                }else if(o1.sum > o2.sum){
                    return 1;
                }else {
                    if(o1.x < o2.x){
                        return -1;
                    }else if(o1.x > o2.x){
                        return  1;
                    }else {
                        if(o1.y < o2.y){
                            return -1;
                        }else if(o1.y > o2.y){
                            return 1;
                        }else {
                            return 0;
                        }
                    }
                }
            }
        });
        List<int[]> result = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(count == k){
                break;
            }
            int[] arr = new int[2];
            arr[0] = list.get(i).x;
            arr[1] = list.get(i).y;
            result.add(arr);
            count++;
        }
        return result;
    }

    /*
        can use priority queue, to decreae runnint time
     */
    public List<int[]> kSmallestPairs1(int[] nums1, int[] nums2, int k){
        return  new ArrayList<>();
    }


    @Test
    public  void  test(){
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        long startTime = System.currentTimeMillis();
        List<int[]> list = kSmallestPairs(nums1, nums2,k);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i)[0] + "  :  " + list.get(i)[1]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("runnint time : " + (endTime - startTime));

    }
}
