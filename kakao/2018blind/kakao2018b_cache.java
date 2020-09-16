import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class kakao2018b_cache {
    public int solution(int cacheSize, String[] cities) {
    	
        int answer = 0;
        if(cacheSize == 0) return cities.length * 5;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<cities.length;++i){
        	cities[i] = cities[i].toLowerCase();
            if(map.containsKey(cities[i])) {
            	answer +=1;
            	map.replace(cities[i], i);
            	continue;
            }else if(map.size() == cacheSize){
            	List<City> list = new ArrayList<City>();
            	map.forEach(((key,value)->{
            		list.add(new City(key, value));
            	}));
            	Collections.sort(list);
            	map.remove(list.get(0).name);
            }
        	map.put(cities[i], i);
        	answer +=5;
        }
        
        return answer;
    }
    class City implements Comparable<City>{
        String name;
        int time;
        public City(String name, int time) {
        	this.name = name;
        	this.time = time;
        }
		@Override
		public int compareTo(City o) {
			return this.time - o.time;
		}
    }
    public static void main(String[] args) {
    	String[] input1 = {"Jeju", "Pangyo", "NewYork", "newyork"};
    	String[] input2 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    	String[] input3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}; 
        System.out.println(new kakao2018b_cache().solution(2, input1));
    }
}
