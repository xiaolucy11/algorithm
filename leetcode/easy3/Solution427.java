package interview.easy3;

import org.junit.Test;

/**
 * Created by Administrator on 2018/7/18 0018.
 */
public class Solution427 {
    public  class  Node{
        public  boolean val;
        public  boolean isLeaf;
        public  Node topLeft;
        public  Node topRight;
        public  Node  bottomLeft;
        public  Node bottomRight;

        public  Node(){}
        public  Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _buttomLeft, Node _buttonRight){
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _buttomLeft;
            bottomRight = _buttonRight;
        }
    }


    public boolean isSame(int[][] grid, int startRow, int endRow, int startCol, int endCol){
        for(int i = startRow; i <= endRow; i++){
            for(int j = startCol; j < endCol; j++){
                if(grid[i][j] != grid[startRow][startCol]){
                    return  false;
                }
            }
        }
        return  true;
    }


    public  Node constructQuadTree(int[][] grid, int startRow, int endRow, int startCol, int endCol){
        if(isSame(grid, startRow, endCol, startCol, endCol)){
            return  new Node(true, true, null, null,null,null);
        }
        int midRow = startRow + (endRow - startRow) / 2;
        int midCol = startCol + (endCol - startCol) / 2;
        Node topLeft = constructQuadTree(grid, startRow, midRow, startCol, midCol);
        Node topRight = constructQuadTree(grid, startRow, midRow, midCol+1, endCol);
        Node buttonLeft = constructQuadTree(grid, midRow+1, endRow, startCol, midCol);
        Node buttomRigth = constructQuadTree(grid, midRow+1, endRow, midCol+1, endCol);
        Node root = new Node(false, false, null, null, null, null);
        root.topLeft = topLeft;
        root.topRight = topRight;
        root.bottomLeft = buttonLeft;
        root.bottomRight = buttomRigth;
        return  root;
    }

    // not be Accepted ---- not to degug
    public  Node construct(int[][] grid){
        return  constructQuadTree(grid, 0, grid.length-1, 0, grid.length-1);
    }


    @Test
    public  void  test(){
        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
    }
}
