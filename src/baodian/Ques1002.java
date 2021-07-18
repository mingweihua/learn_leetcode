package baodian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ques1002 {


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String ele : strs){
            int[] chars = new int[26];
            for (int i = 0; i < ele.length(); i++) {
                chars[ele.charAt(i)- 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                key.append((char)('a'+i));
                key.append(chars[i]);
            }
            String keystr = key.toString();
            List<String> list = map.getOrDefault(keystr,new ArrayList<>());
            list.add(ele);
            map.put(keystr,list);
        }

        for (Map.Entry<String,List<String>> ele : map.entrySet()){
            res.add(ele.getValue());
        }

        return res;
    }
}
