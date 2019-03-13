package algorithm.medium8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/11/2.
 */
public class Solution712 {
    public List<String> list;

    //Memory Limit Exceed
    public  void  search(int[][] dp, String s1, String s2, int row, int col,String str){
        if(row == 0 || col == 0){
            list.add(str);
            return;
        }
        if(s1.charAt(row-1) == s2.charAt(col-1)){
            str += s1.charAt(row-1);
            search(dp, s1,s2, row-1, col-1, str);
        }else {
            if(dp[row-1][col] > dp[row][col-1]){
                search(dp, s1,s2,row-1, col, str);
            }else if(dp[row-1][col] < dp[row][col-1]){
                search(dp, s1,s2, row, col-1, str);
            }else {
                search(dp, s1,s2,row-1, col, str);
                search(dp, s1,s2, row, col-1, str);
                return;
            }
        }
    }

    public  void  search1(int[][] dp, String s1, String s2, int row, int col,String str){
        while (row > 0 && col > 0){
            if(s1.charAt(row-1) == s2.charAt(col-1)){
                str += s1.charAt(row-1);
                row--;
                col--;
            }else {
                if(dp[row-1][col] > dp[row][col-1]){
                    row--;
                }else if(dp[row-1][col] < dp[row][col-1]){
                    col--;
                }else {
                    if(s1.charAt(row-1) > s2.charAt(col-1)){
                        col--;
                    }else {
                        row--;
                    }
                }
            }
        }
        list.add(str);
    }

    public List<String> longestCommonSequence(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];

        for(int i = 0; i < len2+1; i++){
            dp[0][i] = 0;
        }
        for(int i = 0; i < len1+1; i++){
            dp[i][0] = 0;
        }

        int maxLength = 0;
        for(int i = 1; i < len1+1 ; i++){
            for(int j = 1; j < len2 + 1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                    }
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        list = new ArrayList<>();
        search1(dp, s1,s2, len1, len2,"");

        return  list;
    }



    public int computeSum(int[] arr1, int[] arr2, String str){
        int[] strArray = new int[26];
        for(int i = 0; i < str.length(); i++){
            int v = str.charAt(i) - 'a';
            strArray[v]++;
        }

        int sum = 0;
        for(int i = 0; i < 26; i++){
            sum += (i+97) * (arr1[i] - strArray[i]);
            sum += (i + 97) * (arr2[i] - strArray[i]);
        }

        return  sum;
    }

    public int minimumDeleteSum(String s1, String s2){
        int[] arr1 = new int[26];
        int[] arr2 = new  int[26];
        for(int i = 0; i < s1.length(); i++){
            int value = (int)(s1.charAt(i) - 'a');
            arr1[value]++;
        }
        for(int i = 0; i < s2.length(); i++){
            int value = (int)(s2.charAt(i) - 'a');
            arr1[value]++;
        }

        List<String> longestCommonStrList = longestCommonSequence(s1, s2);

        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < longestCommonStrList.size(); i++){
            int v = computeSum(arr1, arr2, longestCommonStrList.get(i));
            if(v < sum){
                sum = v;
            }
        }
        return  sum;
    }


    //Accepted -----44ms
    /*
        dp algorithm
     */
    public int minimumDeleteSum1(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        dp[0][0] = 0;
        for(int j = 1; j < s2.length() + 1; j++){
            dp[0][j] = dp[0][j-1] + (s2.charAt(j-1) - 'a' + 97);
        }

        for(int i = 1; i < s1.length()+1; i++){
            dp[i][0] = dp[i-1][0] + (s1.charAt(i-1) - 'a' + 97);
        }

        for(int i = 1; i < s1.length() + 1;i++){
            for(int j = 1; j < s2.length() + 1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1) - 'a' + 97,
                            dp[i][j-1] + s2.charAt(j-1) - 'a' + 97);
                }
            }
        }

        return  dp[s1.length()][s2.length()];
    }


    @Test
    public  void  test(){
      /*  String s1 = "sea";
        String s2 = "eat";*/

        /*String s1 = "delete";
        String s2 = "leet";*/

      String s1 = "sjfqkfxqoditw";
        String s2 = "fxymelgo";

  /*  String s1 = "igijekdtywibepwonjbwykkqmrgmtybwhwjiqudxmnniskqjfbkpcxukrablqmwjndlh" +
            "blxflgehddrvwfacarwkcpmcfqnajqfxyqwiugztocqzuikamtvmbjrypfqvzqiwooewpzcpwhdejm" +
            "uahqtukistxgfafrymoaodtluaexucnndlnpeszdfsvfofdylcicrrevjggasr" +
            "gdhwdgjwcchyanodmzmuqeupnpnsmdkcfszznklqjhjqaboikughrnxxggbfyjriuvdsusvmhiaszicfa";

        String s2 = "ikhuivqorirphlzqgcruwirpewbjgrjtugwpnkbrdfufjsmgzzjespzdcdjcoioaqybc" +
                "iofdzbdieegetnogoibbwfielwungehetanktjqjrddkrnsxvdmehaeyrpzxrxkhlepdgpwhgpnaat" +
                "kzbxbnopecfkxoekcdntjyrmmvppcxcgquhomcsltiqzqzmk" +
                "loomvfayxhawlyqxnsbyskjtzxiyrsaobbnjpgzmetpqvscyycutdkpjpzfokvi";*/

        long startTime = System.currentTimeMillis();
        int sum = minimumDeleteSum(s1,s2);
        long endTime = System.currentTimeMillis();

        System.out.println("result : " + sum);
        System.out.println("running time : " + (endTime - startTime));
    }


    @Test
    public  void  test1(){
       /* String s1 = "sea";
        String s2 = "eat";*/

       String s1  = "delete";
        String s2 = "leet";

        System.out.print(s1);
    }
}
