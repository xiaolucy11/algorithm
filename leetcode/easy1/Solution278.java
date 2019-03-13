package interview.easy1;

/**
 * Created by Administrator on 2018/6/28 0028.
 */
public class Solution278 {
    public  boolean isBadVersion(int n){
        return  false;
    }

    //timeout
    public int firstBadVersion(int n){
        for(int index = n; index > 1; index--){
            if(isBadVersion(index) && !isBadVersion(index-1)){
                return  index;
            }
        }
        return 1;
    }

    public int help(int start, int end){
        if(end - start == 1){
            if(isBadVersion(start)){return  start;}
            else {return  end;}
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)){
            return  help(start, mid);
        }else {
            return help(mid+1, end);
        }
    }
    //timeout
    public  int firstBadVersion1(int n){
        return help(1,n);
    }

    //Accepted
    public int firstBadVersion2(int n){
        int left = 1, right = n;
        while( (right - left != 1) && (right != left)){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if(isBadVersion(left)){return  left;}
        else {return  right;}
    }
}
