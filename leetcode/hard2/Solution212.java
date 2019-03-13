package algorithm.hard2;

import org.junit.Test;
import java.util.*;

public class Solution212 {
    public  Set<String> result;
    public  class Point{
        int row;
        int col;
        Point(int _x, int _y){
            row = _x;
            col = _y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row &&
                    col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public  Set<String> construct(char ch, Map<Integer,Set<String>> map,Map<Integer,Set<String>> subStrMap,Set<String> wordsSet,
                                  int flag,int direction){
        Set<String> res = new HashSet<>();
        for(Integer key : map.keySet()){
            if((direction == 0 && key == 1) || (direction == 1 && key == 0) ||
                    (direction == 2 && key == 3) || (direction == 3 && key == 2)){
                continue;
            }
            for(String str: map.get(key)) {
                StringBuilder sb = new StringBuilder(str);
                if (flag == 0) {
                    sb.insert(0, ch);
                } else {
                    sb.append(ch);
                }
                String input = sb.toString();
                if(subStrMap.get(input.length()).contains(input)) {
                    res.add(input);
                    if (wordsSet.contains(input)) {
                        result.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }

    /*
        pass 34 /37 test cast
     */
    public List<String> findWords(char[][] board,String[] words){
        Set<String> set = new HashSet<>();
        int maxLenght = 0;
        Map<Integer,Set<String>> subStrMap = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String subStr = words[i].substring(0,j+1);
                if(subStrMap.containsKey(subStr.length())){
                    Set<String> subSet = subStrMap.get(subStr.length());
                    subSet.add(subStr);
                    subStrMap.put(subStr.length(), subSet);
                }else {
                    Set<String> subSet = new HashSet<>();
                    subSet.add(subStr);
                    subStrMap.put(subStr.length(), subSet);
                }
                set.add(words[i]);
                maxLenght = Math.max(maxLenght, words[i].length());
            }
        }

        Map<Point,Map<Integer,Set<String>>> map = new HashMap<>();
        Map<Point,Map<Integer,Set<String>>> reverseMap = new HashMap<>();
         result = new HashSet<>();
        int count = 1;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(set.contains(Character.toString(board[i][j]))){
                    result.add(Character.toString(board[i][j]));
                }
                Set<String> set1 = new HashSet<>();
                set1.add(Character.toString(board[i][j]));
                Map<Integer,Set<String>> singleCharMap = new HashMap<>();
                singleCharMap.put(1, set1);
                singleCharMap.put(2,set1);
                singleCharMap.put(0,set1);
                singleCharMap.put(3,set1);
                map.put(new Point(i,j), singleCharMap);

                reverseMap.put(new Point(i,j), singleCharMap);
            }
        }

        maxLenght = Math.min(maxLenght, board.length * board[0].length);
        while (count < maxLenght){
            Map<Point, Map<Integer,Set<String>>> newMap = new HashMap<>();
            Map<Point, Map<Integer,Set<String>>> newReverseMap = new HashMap<>();
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    Map<Integer,Set<String>> curMap = new HashMap<>();
                    Map<Integer,Set<String>> reverseCurMap = new HashMap<>();

                    //right ----1
                    if(j+1 < board[0].length){
                        curMap.put(1,construct(board[i][j], map.get(new Point(i,j+1)),subStrMap,set,0,1));
                        reverseCurMap.put(1,construct(board[i][j], reverseMap.get(new Point(i,j+1)),subStrMap, set,1,1));
                    }

                    //left -----0
                    if(j - 1 >= 0){
                        curMap.put(0,construct(board[i][j], map.get(new Point(i, j-1)),subStrMap, set,0,0));
                        reverseCurMap.put(0,construct(board[i][j],reverseMap.get(new Point(i,j-1)),subStrMap, set,1,0));
                    }

                    //up ------2
                    if(i - 1 >= 0){
                        curMap.put(2,construct(board[i][j], map.get(new Point(i - 1, j)),subStrMap, set,0,2));
                        reverseCurMap.put(2,construct(board[i][j],reverseMap.get(new Point(i-1, j)),subStrMap, set,1,2));
                    }

                    //down ------3
                    if (i + 1 < board.length){
                        curMap.put(3,construct(board[i][j], map.get(new Point(i+1, j)),subStrMap, set,0,3));
                        reverseCurMap.put(3,construct(board[i][j], reverseMap.get(new Point(i+1,j)),subStrMap, set,1,3));
                    }
                    newMap.put(new Point(i,j),curMap);
                    newReverseMap.put(new Point(i,j), reverseCurMap);
                }
            }
            count++;
            map = newMap;
            reverseMap = newReverseMap;
        }

        List<String> list = new ArrayList<>();
        for(String str : result){
            list.add(str);
        }
        return list;
    }


    /*
        set b[x][y] = '\0' is very aweasom
     */
    public boolean helper(String s,char[][] b, int i, int rows,int cols,int x,int y){
        if(i==s.length()) return true;
        if(x<0 || x>rows||y<0 ||y>cols||b[x][y]!=s.charAt(i)) return false;
        char c = b[x][y];
        b[x][y]='\0';
        boolean res = helper(s,b,i+1,rows,cols,x+1,y)||
                helper(s,b,i+1,rows,cols,x-1,y)||
                helper(s,b,i+1,rows,cols,x,y+1)||
                helper(s,b,i+1,rows,cols,x,y-1);

        return res;
    }

    /*
        code from other
     */
    public List<String> findWords1(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) return res;
        Set<String> set = new HashSet<>();
        for (String s : words) {
            outerloop:
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == s.charAt(0)) {
                        if (helper(s, board, 0, board.length - 1, board[0].length - 1, i, j)) {
                            set.add(s);
                            break outerloop;
                        }
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }



        @Test
    public  void  test() {
       /* char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'i', 'f', 'l', 'v'}
    };
        String[] words = {"oath","pea","eat","rain"};
*/
    /*   char[][] board = {{'a','b'},{'a','a'}};
       String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};*/

    char[][] board = {{'b','a','a','b','a','b'},{'a','b','a','a','a','a'},{'a','b','a','a','a','b'},
        {'a','b','a','b','b','a'},{'a','a','b','b','a','b'},{'a','a','b','b','b','a'},
        {'a','a','b','a','a','b'}};
    String[] words= {"bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba",
                "babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab",
                "bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba",
                "aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba",
                "abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa",
                "aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb",
                "baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb",
                "aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba",
                "bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba",
                "aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb",
                "aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"};

//        String[] res = {"aabbbbabbaababaaaabababbaaba","abaabbbaaaaababbbaaaaabbbaab","ababaababaaabbabbaabbaabbaba"};
        long startTime = System.currentTimeMillis();
        List<String> result = findWords1(board,words);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i) );
        }
        System.out.println();
        System.out.println("running time : " + (endTime - startTime));
    }


}
