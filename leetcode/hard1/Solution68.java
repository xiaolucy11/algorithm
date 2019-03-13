package algorithm.hard1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youlu on 2018/12/8.
 */
public class Solution68 {

    public  List<String> list;

    public  void greedySearch(String[] words, int maxWidth, int index) {
        if (index == words.length) {
            return;
        }
        int totalLength = 0;
        int wordsCount = 0;
        StringBuilder sb = new StringBuilder();

        int i = index;
        while (i < words.length) {
            if (totalLength + words[i].length() <= maxWidth) {
                totalLength += words[i].length();
                if (totalLength < maxWidth) {
                    totalLength++;
                }
                wordsCount++;
                i++;
            } else {
                break;
            }
        }

        if (i == words.length) {
            for (int j = index; j < i; j++) {
                sb.append(words[j]);
                if(j != i - 1) {
                    sb.append(' ');
                }
            }

            int lastLineSpace = maxWidth - sb.length();
            while (lastLineSpace > 0) {
                sb.append(' ');
                lastLineSpace--;
            }
            list.add(sb.toString());
            return;
        } else if (wordsCount == 1) {
            sb.append(words[i - 1]);
            int lastLineSpace = maxWidth - sb.length();
            while (lastLineSpace > 0) {
                sb.append(' ');
                lastLineSpace--;
            }

            list.add(sb.toString());
            greedySearch(words, maxWidth, i);
        } else {

            int currentLength = 0;
            for (int j = index; j < i; j++) {
                currentLength += words[j].length();
            }
            int averageSpace = (maxWidth - currentLength) / (wordsCount - 1);
            int moreSpace = maxWidth - currentLength - (wordsCount - 1) * averageSpace;
            StringBuilder temp = new StringBuilder();
            for (int m = 0; m < averageSpace; m++) {
                temp.append(' ');
            }

            for (int j = index; j < i; j++) {
                sb.append(words[j]);
                if (j != i - 1) {
                    sb.append(temp);
                }
                if (moreSpace > 0) {
                    sb.append(' ');
                    moreSpace--;
                }
            }

            list.add(sb.toString());
            greedySearch(words, maxWidth, i);
        }
    }




    //Accepted ----1ms
    /*
        greedy algorithm
     */
    public List<String> fullJustify(String[] words, int maxWidth){
        list = new ArrayList<>();

        greedySearch(words, maxWidth,0);
        return list;
    }

    @Test
    public  void  test(){
       /* String[] words = {"This","is","an","example","of","text","justification."};
        int maxWidth = 16;*/

     /*  String[] words = {"What","must","be","acknowledgement","shall","be"};
        int maxWidth = 16;*/

    /* String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;*/

    String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you",
                "can","do","for","your","country"};
        int maxWidth = 16;

        long startTime = System.currentTimeMillis();
        List<String> result = fullJustify(words,maxWidth);
        long endTime = System.currentTimeMillis();

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        System.out.println("running time : " + (endTime - startTime));
    }
}
