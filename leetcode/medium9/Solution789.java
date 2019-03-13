package algorithm.medium9;

/**
 * Created by youlu on 2018/11/13.
 */
public class Solution789 {
    public  boolean escapeGhosts(int[][] ghosts, int[] target){
        int distance = Math.abs(target[0]) + Math.abs(target[1]);

        for(int i = 0; i < ghosts.length; i++){
            int minPath = Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]);
            if(minPath < distance){
                return  false;
            }
        }

        return  true;
    }
}
