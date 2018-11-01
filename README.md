"# Pawoon - project" 


Soal no 2. 
public class reserveWord {

    public static void main(String[] args) {
        System.out.println(isPalindrome("kakak")+"");
    }

    public static boolean isPalindrome(String s){

        StringBuilder temp = new StringBuilder();

        for (int i = s.length()-1 ; i >=0 ; i--){
            temp.append(s.toCharArray()[i]);
        }


        return temp.toString().equals(s);
    }
}



