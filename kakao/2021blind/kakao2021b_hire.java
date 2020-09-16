import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class kakao2021b_hire {
	HashMap<String,boolean[]> map;
	List<Info> infoList; 
	public void init(String info[]) {
		infoList = new ArrayList<Info>();
		map = new HashMap<String, boolean[]>();
        for(int i=0;i<info.length;++i) {
        	String[] infoArr = info[i].split(" ");
        	infoList.add(new Info(infoArr[0],infoArr[1],infoArr[2],infoArr[3],Integer.parseInt(infoArr[4])));
        }
        map.put("cpp", new boolean[info.length]);
        map.put("java", new boolean[info.length]);
        map.put("python", new boolean[info.length]);
        map.put("backend", new boolean[info.length]);
        map.put("frontend", new boolean[info.length]);
        map.put("junior", new boolean[info.length]);
        map.put("senior", new boolean[info.length]);
        map.put("chicken", new boolean[info.length]);
        map.put("pizza", new boolean[info.length]);
	}
	public void insert() {
		for(int i=0;i<infoList.size();++i) {
        	Info now = infoList.get(i);
        	boolean[] langArr = map.get(now.lang);
        	boolean[] posArr = map.get(now.position);
        	boolean[] careerArr = map.get(now.career);
        	boolean[] foodArr = map.get(now.food);
        	langArr[i] = true;
        	posArr[i] = true;
        	careerArr[i] = true;
        	foodArr[i] = true;
        }
	}
	public int[] search(String[] query) {
		int[] result = new int[query.length];
		
		for(int i=0;i<query.length;++i) {
			String[] arr = query[i].split(" ");
			int score = Integer.parseInt(arr[7]);
			for(int j=0;j<infoList.size();++j) {
				boolean flag = true;
				for(int k=0;k<=6;k+=2) {
					if(arr[k].equals("-"))continue;
					boolean[] check = map.get(arr[k]);
					if(!check[j]) {
						flag = false;
						break;
					}
				}
				if(flag && score <= infoList.get(j).score) {
					++result[i];
				}
			}
		}
		return result;
	}
	
	public int[] solution(String[] info, String[] query) {
        init(info);
        insert();
        
        return search(query);
    }
	class Info{
		String lang;
		String position;
		String career;
		String food;
		int score;
		public Info(String lang, String position, String career, String food, int score) {
			this.lang = lang;
			this.position = position;
			this.career = career;
			this.food = food;
			this.score = score;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(new kakao2021b_hire().solution(new String[] {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, new String[] {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
	}

}
