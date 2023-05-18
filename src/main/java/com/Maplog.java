package com;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maplog {
    static Map<String,String> map=new HashMap<>();
    Maplog(){}
    public static String FindID() {
        if(map.get("ID")==null)return "";
        return map.get("ID");
    }

    public static int FindTeamID() {
        if(map.get("TeamID")==null)return 0;
        return Integer.parseInt(map.get("TeamID"));
    }

    public static String FinduserType(){
        if(map.get("userType")==null)return "";
        return map.get("userType");
    }
    public static void setMap(String key, String val){
        map.put(key,val);
        System.out.println("----------------------------------------------");
        System.out.println("ID="+FindID()+'\n'+
        "userType="+FinduserType()+'\n'+
        "TeamID=" +FindTeamID()       );

        System.out.println("----------------------------------------------");
    }
}
