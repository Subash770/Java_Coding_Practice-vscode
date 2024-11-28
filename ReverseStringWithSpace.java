package programs;

public class ReverseStringWithSpace {
    
    public String reverse(String st){
        st=st.trim();
        String[] words=st.split("\\s+");

        StringBuilder reversedString=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            reversedString.append(words[i]);
            if(i>0){
                reversedString.append(" ");
            }
        }
       

        return reversedString.toString();

    }

    public static void main(String [] args){

        ReverseStringWithSpace r=new ReverseStringWithSpace();
        String demoString="ha ku na ma ta ta";
        String revString=r.reverse(demoString);
        System.out.println(revString);

    }
}
