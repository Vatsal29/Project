/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package N.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author shanks
 */
public class UniqueIdentifier {
    
    private static List<Integer> ids=new ArrayList<Integer>();
    private static final int Range=10000;
    
    private static int index=0;
    
    static{
        
       for(int i=0;i<Range;i++) 
       {
           ids.add(i);
       }
        Collections.shuffle(ids);
    }
    
    private UniqueIdentifier(){
        
    }
    
    public static int getIdentifier()
    {
        if(index>ids.size()-1) index=0;
        return ids.get(index++);
    }
    
}
