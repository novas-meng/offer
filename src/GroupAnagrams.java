import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mengfanshan on 2017/8/13.
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {
    public static void main(String[] agrs)
    {
        System.out.println((int)'a');
        String[] var={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(var));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] array=new int[26];
        HashMap<String,List<String>> stringListHashMap=new HashMap<>();
        for (int i=0;i<strs.length;i++)
        {
            for (int j=0;j<array.length;j++)
            {
                array[j]=0;
            }
            char[] chars=strs[i].toCharArray();
            for (int j=0;j<chars.length;j++)
            {
                array[chars[j]-97]++;
            }
            StringBuilder stringBuilder=new StringBuilder();
            for (int j=0;j<array.length;j++)
            {
                stringBuilder.append(array[j]);
            }
            if(stringListHashMap.containsKey(stringBuilder.toString()))
            {
                List<String> list=stringListHashMap.get(stringBuilder.toString());
                list.add(strs[i]);
                stringListHashMap.put(stringBuilder.toString(),list);
            }
            else
            {
                List<String> list=new ArrayList<>();
                list.add(strs[i]);
                stringListHashMap.put(stringBuilder.toString(),list);
            }
        }
        List<List<String>> lists=new ArrayList<>();
        for (Map.Entry<String,List<String>> entry:stringListHashMap.entrySet())
        {
            lists.add(entry.getValue());
        }
        return lists;
    }
}
