
public class MatchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String [] input = {"173-23-2342",
                "1113232222",
                "456679087",
                "45667-9087",
                "1245-23-2354",
                "abs-23-s3fg",
                "123-32-4a23",
                "123-25-233523"};
        		String pattern1 = "\\d{3}-?\\d{2}-[a-z0-9]{4}";

        		for (String s: input){
        			if ( s.matches(pattern1)){
        				System.out.println(s + " matches ");
        			}else{
        				System.out.println(s + " does not match ");
        				
        			}
        			
        		}

	}

}
