package com.bj.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neko on 2018/3/20.
 * @questions 有两个有序的集合，集合的每个元素都是一段范围，求其交集，
 * 例如集合{[4,8],[9,13]}和{[6,12]}的交集为{[6,8],[9,12]}
 */
public class NumberIntersection1 {

    public static void main(String[] args) {
        //构建两个集合
        Section section1 = new Section(2,4);
        Section section2 = new Section(8,11);
        Section section3 = new Section(6,10);
        Section section4 = new Section(11,13);

        List<Section> aList = new ArrayList<>();
        List<Section> bList = new ArrayList<>();

        aList.add(section1);
        aList.add(section2);
        bList.add(section3);
        bList.add(section4);

        //求交集
        List<Section> result = getIntegerSection(aList,bList);
        System.out.println("Section: ");
        if (result != null) {
            for (Section section : result) {
                System.out.println(section.toString());
            }
        }

    }

    private static List<Section> getIntegerSection(List<Section> aList, List<Section> bList) {
        int i = 0, j = 0; //集合的指针
        List<Section> interSection = new ArrayList<>();
        while (i < aList.size() && j < bList.size()){
            Section a = aList.get(i);
            Section b = bList.get(j);

            //a集合的左右范围
            int aLeft = a.getLeft();
            int aRight = a.getRight();
            //b集合的左右范围
            int bLeft = b.getLeft();
            int bRight = b.getRight();

            if (aLeft > bRight){ //[3,5] [1,2] 没啥交集 b换下一个
                j++;
            }else if (aRight < bLeft){ //[3,5] [7,8] 没啥交集 a换下一个
                i++;
            }else if (aLeft > bLeft){ // [3,5] [2,4] a的左边比b的左边大，不好判定 继续判断
                if (aRight < bRight){ // [3,5] [2,6] a 被包含 所以a是个交集，存入
                    interSection.add(a);
                    i++;
                }else { // aRight > bRight 相当于[3,8] [2,6] 交集
                    Section temp = new Section(aLeft,bRight);
                    interSection.add(temp);
                    j++;
                }
            }else { //aLeft < bLeft 不好判定 继续判断
                if (bRight < aRight){ //[3,6][4,5] 被包含
                    interSection.add(b);
                    j++;
                }else {// bRight > aRight [3,6][4,8]
                    Section temp = new Section(bLeft,aRight);
                    interSection.add(temp);
                    i++;
                }
            }
        }
        return interSection;
    }

    static class Section{
        int left, right;

        public Section(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "Section{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
