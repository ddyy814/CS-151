import java.awt.*;
import java.lang.reflect.Array;

public class dumpArray {
    public static void dump (Object[] obj){
        if(!obj.getClass().isArray()){
            throw new IllegalArgumentException("pass");
        }
        for(int i = 0; i < obj.length; i++){
            System.out.println(obj[i].toString());
        }
    }
    public static void main(String[] args){
        Object[] obj = {"text", 8, new Rectangle(50,80)};
        dump(obj);
    }
}
