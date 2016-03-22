import java.util.*;
public class LRUCache {
    
    public LinkedHashMap<Integer, Integer> hmap;
    
    public LRUCache(int capacity) {
        hmap = new LinkedHashMap<Integer, Integer>(){
        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> e){
            return this.size()>capacity;
        }
     };
    }
    
    public int get(int key) {
        if(hmap.containsKey(key)){
            moveToFront(key,hmap.get(key));
            return hmap.get(key);
        }else{
            return -1;
        }
        
    }
    
    public void set(int key, int value) {
        if(hmap.containsKey(key)){
            moveToFront(key,value);
        }else{
            hmap.put(key,value);
        }
        
    }
    
    public void moveToFront(int key, int value){
        hmap.remove(key);
        hmap.put(key, value);
        
    }
}
