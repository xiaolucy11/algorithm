package interview.easy2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/9 0009.
 */
public class Solution447 {
    public  int distance(int p1X, int p1Y, int p2X, int p2Y){
        return  (p1X - p2X) * (p1X - p2X) + (p1Y - p2Y) * (p1Y - p2Y);
    }


    public  int numberOfBoomerangs(int[][] points){
        int length  = points.length;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                int dis = distance(points[i][0],points[i][1], points[j][0], points[j][1]);
                if(map.containsKey(dis)){
                    map.put(dis, map.get(dis) + 1);
                }else {
                    map.put(dis, 1);
                }
            }
            for(Integer key : map.keySet()){
                if(map.get(key) > 1){
                    result += (map.get(key) - 1)*map.get(key);
                }
            }
            map.clear();

        }
        return result;
    }

    @Test
    public void  test(){
        int[][] points = {{0,0},{1,0}, {2, 0},{3,0}};
        System.out.print(numberOfBoomerangs(points));
    }
}
