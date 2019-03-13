package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  - 'B'
 *  第一题：给一个string，是一篇小说内容，比如"Jimmy has an apple, it is on the table" 再给一个exclude word list，比如 "an" "a" "is" "the"，让你给出这个string里出现频率最高的单词
 * @author Michael Liu
 */
public class WordFreqency
{
  public static void main(String[] args)
  {
    String novel = "table Jimmy table good many an has an apple, it is on mother's the 'table's";
    List<String> excludeWords = Arrays.asList("an", "a", "is", "the");

    final String[] words = novel.replaceAll("'s|\\W", " ").split("\\s+");

    Map<String, Integer> freqMap = new HashMap<>();

    int maxFreq = 0;
    String maxWord = "";

    for (String word : words)
    {
      if (!excludeWords.contains(word))
      {
        if (freqMap.containsKey(word))
        {
          int freq = freqMap.get(word) + 1;
          if(maxFreq < freq)
          {
             maxFreq  =  freq;
             maxWord = word;
          }
          freqMap.put(word, freq);
        }
        else
          freqMap.put(word, 1);
      }
    }

    List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

    Collections.sort(entryList, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

    System.out.println(maxFreq + " " + maxWord);
    System.out.println(entryList.get(0).getKey() + "  -  " + entryList.get(0).getValue());

  }
}
