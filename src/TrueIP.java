import java.util.regex.Pattern;

public class TrueIP {

    /*判断字符串是否为合法IP
     *
     *
     *
     *
     */

    public static void main(String[] args) {
        String IP = "192.168.1.1";
        String FIP= "12335.154.1";

        System.out.println(checkIP(IP));
        System.out.println(checkIP(FIP));
    }

    private static boolean checkIP(String str) {
        Pattern pattern = Pattern
                .compile("^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]"
                        + "|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$");
        return pattern.matcher(str).matches();
    }
}


/*
import java.io.*;

public class ValidIP {
    public boolean validIP(String ip){
        int count = 0;
        boolean isIP = true;
        String temp = ip;
        String tem ="";
        if(temp.charAt(0) == '.' || temp.charAt(temp.length()-1) == '.' || temp.length()>15)
            isIP = false;
        temp = temp+'.';//下面测试用到
        for(int i=0;i<temp.length();i++){

            if(temp.charAt(i) == '.'){
                count++;
                if(Integer.parseInt(tem)>255)
                    isIP = false;
                tem = "";
                continue;
            }
            if(temp.charAt(i)< '0' || temp.charAt(i) >'9')
                isIP = false;
            tem+=String.valueOf(temp.charAt(i));
        }
        if(count!= 3)
            isIP = false;

        return isIP;
    }
    public static void main(String[] args) throws IOException {
        System.out.print("Input IP Address:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tempbr = new String(br.readLine());
        ValidIP isip = new ValidIP();
        boolean bl = isip.validIP(tempbr);
        System.out.println(bl);
    }
}*/
