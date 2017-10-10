package com.bj.stack;


import java.util.Stack;
import java.util.regex.Pattern;

//Dijkstra 双栈算法实现表达式求值 djskla

//未完成
public class D {
    public static void main(String[] args) {
        String a = "(((1+(2+3))*12)+2)";//必须输入括号，必须以这种形式进行表达式输入
        System.out.println(evl(a));
    }
    public static Double evl(String str){
        Stack<Double> vals = new Stack<>();//操作数
        Stack<Character> op = new Stack<>();//运算符
        char[] data= str.toCharArray();


        //先分解数字
        String[] data1 = str.split("[()-/*+]");
        for(int i = 0;i < data1.length;i++) {
            if(data1[i].equals("")) {
                continue;
            }
            vals.push(Double.parseDouble(data1[i]));
        }

        for(int i = 0;i < data.length;i++){
            //把符号写入运算符栈
            //正则表达式
            if(Pattern.matches("^\\d$",data[i]+"")){//操作数

            }else{ //运算符
                if(data[i] == '('){//左括号不动

                }else if(data[i] == ')') {//开始计算了
                    Double a1 = vals.pop();
                    Double a2 = vals.pop();
                    //弹出运算符
                    Character c = op.pop();
                    if(c == '+'){
                        vals.push(a1+a2);
                    }else if(c == '-'){
                        vals.push(a2-a1);
                    }else if(c == '*'){
                        vals.push(a1*a2);
                    }else if(c == '/'){
                        vals.push(a2/a1);
                    }
                }else {
                    op.push(data[i]);//压入运算符
                }
            }
        }
        return vals.pop();
    }
}
