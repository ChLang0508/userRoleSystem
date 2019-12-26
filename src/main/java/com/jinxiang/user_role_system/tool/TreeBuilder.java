package com.jinxiang.user_role_system.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TreeBuilder {


    /**
     * 方法名称：Tree
     *
     * @param Pkey
     * @param Fkey
     * @param Depth
     * @param Ckey
     * @param Source
     */
    public static final void Tree(String Pkey,
                                  String Fkey,
                                  String Depth,
                                  String Ckey,
                                  List<Map<String, Object>> Source,
                                  Integer Level) {
        if (Level == null) Level = maxLevel(Source, Depth);
        if (Level <= 1) return;
        List<Map<String, Object>> temp = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> tp1 : Source) {
            if (tp1.get(Depth).equals(Level)) {
                for (Map<String, Object> tp2 : Source) {
                    if (tp1.get(Fkey) != null && tp1.get(Fkey).equals(tp2.get(Pkey))) {
                        if (!tp2.containsKey(Ckey)) {
                            tp2.put(Ckey, new ArrayList<Map<String, Object>>());
                        }
                        ((ArrayList<Map<String, Object>>) tp2.get(Ckey)).add(tp1);
                        break;
                    }
                }
                temp.add(tp1);
            }
        }
        Source.removeAll(temp);
        Level--;
        Tree(Pkey, Fkey, Depth, Ckey, Source, Level);
    }


    private static int maxLevel(List<Map<String, Object>> Source, String Dkey) {
        int maxLevel = 0;
        for (Map<String, Object> data : Source) {
            Integer temp = (Integer) data.get(Dkey);
            if (temp > maxLevel) maxLevel = temp;
        }
        return maxLevel;
    }
}
