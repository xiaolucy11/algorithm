package interview.easy5;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2018/8/6 0006.
 */
public class Solution874 {
    public  int xDirection;
    public  int yDirection;
    public  int pointX;
    public  int pointY;
    public  boolean obstacleFlag = false;
    public Map<Integer, List<Integer>> map;


    public void  init(int[][] obstacles){
        map = new HashMap<>();
        for(int i = 0; i < obstacles.length; i++){
            int row = obstacles[i][0];
            int col = obstacles[i][1];
            if(map.containsKey(row)){
                List<Integer> list = map.get(row);
                list.add(col);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(col);
                map.put(row, list);
            }
        }
    }
   /* public  void  range(int[][] obstables){
        for(int i = 0; i < obstables.length; i++){
            if(obstables[i][0] < 0 && obstables[i][0] > negetiveMaxX){
                negetiveMaxX = obstables[i][0];
            }
            if(obstables[i][0] > 0 && obstables[i][0] < positiveMinX){
                positiveMinX = obstables[i][0];
            }
            if(obstables[i][1] < 0 && obstables[i][1] > negetiveMaxY){
                obstables[i][1] = negetiveMaxX;
            }
            if(obstables[i][1] > 0 && obstables[i][1] < positiveMinY){
                obstables[i][1] = positiveMinY;
            }
        }
    }*/
   public  boolean  find(List<Integer> list, int value){
       for(int i = 0; i < list.size(); i++){
           if (list.get(i) == value){
               return true;
           }
       }
       return  false;
   }

    public  boolean existObstacles(int x, int y){
       /* if((pointX > negetiveMaxX && pointX < positiveMinX) &&
                (pointY > negetiveMaxX && pointY < positiveMinY)){
            return  false;
        }*/
       if(map.containsKey(x) && find(map.get(x), y) ){
           return  true;
       }else {
           return  false;
       }
    }

    public  void  changeDirection( int commond){
        obstacleFlag = false;
        if(xDirection == 0 && yDirection == 1){
            if(commond == -2){
                xDirection = -1;
                yDirection = 0;
            }
            if(commond == -1){
                xDirection = 1;
                yDirection = 0;
            }
        }else if(xDirection == 0 && yDirection == -1){
            if(commond == -2){
                xDirection = 1;
                yDirection = 0;
            }
            if(commond == -1){
                xDirection = -1;
                yDirection = 0;
            }
        }else if(xDirection == 1 && yDirection == 0){
            if(commond == -1){
                xDirection = 0;
                yDirection = -1;
            }
            if(commond == -2){
                xDirection = 0;
                yDirection = 1;
            }
        }else {
            if(commond == -2){
                xDirection = 0;
                yDirection = -1;
            }
            if (commond == -1){
                xDirection = 0;
                yDirection = 1;
            }
        }
    }
    public  void  forwardByOneStep(int[][] obstacles){
        if(xDirection == 0 && yDirection == 1){
            pointY++;
            if(existObstacles(pointX, pointY)){
                pointY--;
                obstacleFlag = true;
            }
        }else if(xDirection == 0 && yDirection == -1){
            pointY--;
            if(existObstacles(pointX, pointY)){
                pointY++;
                obstacleFlag  = true;
            }
        }else if(xDirection == 1 && yDirection == 0){
            pointX++;
            if(existObstacles(pointX, pointY)){
                pointX--;
                obstacleFlag = true;
            }
        }else{
            pointX--;
            if(existObstacles(pointX, pointY)){
                pointX++;
                obstacleFlag = true;
            }
        }
    }

    //Accepted -------32ms
    public  int robotSim(int[] commands, int[][] obstacles){
         xDirection = 0;
         yDirection = 1;
         pointX = 0;
         pointY = 0;
        init(obstacles);
        int maxDistance = 0;

        for(int i = 0; i < commands.length; i++){
            if(commands[i] < 0){
               changeDirection( commands[i]);
            }else {
                int steps = commands[i];
                while (steps > 0){
                    steps--;
                    forwardByOneStep(obstacles);
                    int value = pointX * pointX + pointY * pointY;
                    if(value > maxDistance){
                        maxDistance = value;
                    }
                    if(obstacleFlag){
                        break;
                    }
                }
            }
        }
        return  maxDistance;
    }

    @Test
    public  void  test(){
        int[] commands = {7,-2,-2,-7,5};
        int[][] obstacles = {{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
        System.out.print(robotSim(commands, obstacles));
    }
}
