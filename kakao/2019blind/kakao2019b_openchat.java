import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class kakao2019b_openchat {
	HashMap<String, String> nickNameHash = new HashMap<String, String>();
    public String[] solution(String[] record) {
        String[] answer = {};
        List<Log> logInfo = new ArrayList<Log>();
        for(int i=0;i<record.length;++i) {
        	String[] recordArr = record[i].split(" ");
        	if(recordArr[0].equals("Change")) {
        		nickNameHash.put(recordArr[1],recordArr[2]);
        	}else {
            	Log log = new Log();
        		log.setMsg(record[i]);
        		logInfo.add(log);
        	}
        }
        answer = new String[logInfo.size()];
        for(int i=0;i<logInfo.size();++i) {
        	answer[i] = logInfo.get(i).getMsg();
        }
        
        return answer;
    }
    
    class Log{
        String uid;
        String msg;
        
        public Log(){}
        
        public void setMsg(String record){
            String[] recordArr = record.split(" ");
            this.uid = recordArr[1];
            switch(recordArr[0]) {
            case "Enter":
            	msg = recordArr[1] + "님이 들어왔습니다.";
            	nickNameHash.put(recordArr[1], recordArr[2]);
            	break;
            case "Leave":
            	msg = recordArr[1] + "님이 나갔습니다.";
            	break;
            }
        }
        public String getMsg() {
        	return nickNameHash.get(msg.substring(0, uid.length())) + msg.substring(uid.length(), msg.length());
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String record[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		System.out.println(Arrays.toString(new kakao2019b_openchat().solution(record)));
	}
}
