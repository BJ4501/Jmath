import java.util.Scanner;

public class Huiwen {

    /*
    * 回文算法
    *
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int i = word.length();
        int j = 0;
        while (j <= (i/2)-1 && word.charAt(j) == word.charAt(i-j-1)){
            j++;
        }
        if(j == i/2){
            System.out.println("是回文");
        }else {
            System.out.println("不是回文");
        }
    }
}
