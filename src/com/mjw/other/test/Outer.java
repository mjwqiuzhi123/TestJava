package com.mjw.other.test;
public class Outer { 
    public static void main(String[] args) { 
        Outer outer = new Outer(); 
        Outer.Inner inner = outer.new Inner(); 
        inner.print("Outer.new"); 
 
        inner = outer.getInner(); 
        inner.print("Outer.get"); 
    } 
 
    // �����Ƽ�ʹ��getxxx()����ȡ��Ա�ڲ��࣬�����Ǹ��ڲ���Ĺ��캯���޲���ʱ 
    public Inner getInner() { 
        return new Inner(); 
    } 
 
    public class Inner { 
        public void print(String str) { 
            System.out.println(str); 
        } 
    } 
} 