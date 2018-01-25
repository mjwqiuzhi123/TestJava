package com.mjw.bloomfilter.test;

import java.util.BitSet;

public class BloomFilter1 {  
    /* BitSet��ʼ����2^24��bit */  
    private static final int DEFAULT_SIZE = 1 << 25;  
    /* ��ͬ��ϣ���������ӣ�һ��Ӧȡ���� */  
    private static final int[] seeds = new int[] { 5, 7, 11, 13, 31, 37, 61 };  
    private BitSet bits = new BitSet(DEFAULT_SIZE);  
    /* ��ϣ�������� */  
    private SimpleHash[] func = new SimpleHash[seeds.length];  
    
    // ������
    public static void main(String args[]){
    	BloomFilter1 bf = new BloomFilter1();
    	bf.add("mjw723318462@");
    	System.out.println(bf.contains("mjw723318462@"));
    }
    
    public BloomFilter1() {  
        for (int i = 0; i < seeds.length; i++) {  
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);  
        }  
    }  
  
    // ���ַ�����ǵ�bits��  
    public void add(String value) {  
        for (SimpleHash f : func) {  
            bits.set(f.hash(value), true);  
        }  
    }  
  
    // �ж��ַ����Ƿ��Ѿ���bits���  
    public boolean contains(String value) {  
        if (value == null) {  
            return false;  
        }  
        boolean ret = true;  
        for (SimpleHash f : func) {  
            ret = ret && bits.get(f.hash(value));  
        }  
        return ret;  
    }  
  
    /* ��ϣ������ */  
    public static class SimpleHash {  
        private int cap;  
        private int seed;  
  
        public SimpleHash(int cap, int seed) {  
            this.cap = cap;  
            this.seed = seed;  
        }  
  
        // hash���������ü򵥵ļ�Ȩ��hash  
        public int hash(String value) {  
            int result = 0;  
            int len = value.length();  
            for (int i = 0; i < len; i++) {  
                result = seed * result + value.charAt(i);  
            }
            System.out.println((cap - 1) & result);
            return (cap - 1) & result;  
        }  
    }  
}  