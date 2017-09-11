public class Huihuan {

    /*
    * 判断回环字符串
    *
    * Java中字符串中子串的查找共有四种方法，如下：
        1、int indexOf(String str) ：返回第一次出现的指定子字符串在此字符串中的索引。
        2、int indexOf(String str, int startIndex)：从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。
        3、int lastIndexOf(String str) ：返回在此字符串中最右边出现的指定子字符串的索引。
        4、int lastIndexOf(String str, int startIndex) ：从指定的索引处开始向后搜索，返回在此字符串中最后一次出现的指定子字符串的索引。
    *
    *
    * 例子
    *   String s = "xXccxxxXX";
        // 从头开始查找是否存在指定的字符 结果如下
        System.out.println(s.indexOf("c"));  //2
        // 从第四个字符位置开始往后继续查找，包含当前位置
        System.out.println(s.indexOf("c", 3));  //3
        //若指定字符串中没有该字符则系统返回-1
        System.out.println(s.indexOf("y"));   //-1
        System.out.println(s.lastIndexOf("x")); //6
    * */

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";
        if(s.length() == t.length()&&(s+s).indexOf(t)>0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }


    }
}
