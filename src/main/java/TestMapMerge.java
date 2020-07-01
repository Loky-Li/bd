import java.util.HashMap;
import java.util.Map;

public class TestMapMerge {
    public static void main(String[] args) {
        String name = "test";
        int i = 1;
        HashMap<String, Integer> mp1 = new HashMap();
        HashMap<String, Integer> mp2 = new HashMap();

        mp1.put("a",1);
        mp1.put("b",2);
        mp1.put("c",3);

        mp2.put("a",4);
        mp2.put("d",5);
        mp2.put("c",6);

        for (Map.Entry<String, Integer> entry : mp2.entrySet()) {
            if(mp1.get(entry.getKey()) != null){
                mp1.put(entry.getKey(),mp1.get(entry.getKey()) + entry.getValue());
            }else{
                //todo 逻辑虽然对，但是下面代码有误，直接put中传一个entry，和put要传的参数不符
                //mp1.put(entry)
                mp1.put(entry.getKey(),entry.getValue());
            }
        }

        System.out.println(mp1);

    }
}
