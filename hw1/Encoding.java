
import java.util.*;

public class Encoding
{
   public static Set<String> morseCodes(int m, int n)
   {
      Set<String> result = new TreeSet<>();
      helpMorseCode(m,n,result,"");
      return result;
   }
   
   public static void helpMorseCode(int m, int n, Set<String> set, String str){
      if(m == 0 && n == 0){
         set.add(str);
         return;
      }else if(m == 0){
         helpMorseCode(m,n-1,set,"-" + str);
         return;
      }else if(n == 0){
         helpMorseCode(m-1,n,set,"." + str);
         return;
      }else
      helpMorseCode(m-1,n,set,"." + str);
      helpMorseCode(m,n-1,set,"-" + str);
      return;
   }
}