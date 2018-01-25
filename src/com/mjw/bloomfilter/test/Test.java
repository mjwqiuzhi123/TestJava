package com.mjw.bloomfilter.test;

import java.util.BitSet;

public class Test {
    public static void main(String[] args){

        BloomFilter b = new BloomFilter();
        b.addValue("www.baidu.com");
        b.addValue("www.sohu.com");

        System.out.println(b.contains("www.baidu.com"));
        System.out.println(b.contains("www.sina.com"));
        System.out.println(2 << 28);
    }
}

class BloomFilter{

    private static final int BIT_SIZE = 2 << 28 ;//������������λ�����൱���ܴ洢1000����url���ң�����Ϊǧ���֮һ
    private static final int[] seeds = new int[]{3, 5, 7, 11, 13, 31, 37, 61};//����������Ϣָ�Ƶ�8������������ѡȡ����

    private BitSet bits = new BitSet(BIT_SIZE);
    private Hash[] func = new Hash[seeds.length];//���ڴ洢8�������ϣֵ����

    public BloomFilter(){
        for(int i = 0; i < seeds.length; i++){
            func[i] = new Hash(BIT_SIZE, seeds[i]);
        }
    }

    /**
     * �������������ַ���
     */
    public void addValue(String value)  
    {  
        //���ַ���value��ϣΪ8������������Ȼ������Щ������bit�ϱ�Ϊ1
        if(value != null){
            for(Hash f : func) 
                bits.set(f.hash(value), true); 
        }

    }  

    /**
     * �ж��ַ����Ƿ�����ڲ�¡��������
     */
    public boolean contains(String value)  
    {  
        if(value == null) 
            return false;  

        boolean ret = true;  

        //��Ҫ�Ƚϵ��ַ���������������������hashֵ�����벼¡�������ȶ�
        for(Hash f : func)
            ret = ret && bits.get(f.hash(value));  
        return ret;  
    }  

    /**
     * �����ϣֵ����
     */

    public static class Hash{
        private int size;//���������������С
        private int seed;//���������

        public Hash(int cap, int seed){
            this.size = cap;
            this.seed = seed;
        }

        /**
         * �����ϣֵ(Ҳ����ѡ�ñ��ǡ���Ĺ�ϣ����)
         */
        public int hash(String value){
            int result = 0;
            int len = value.length();
            for(int i = 0; i < len; i++){
                result = seed * result + value.charAt(i);
            }

            return (size - 1) & result;
        }
    }

}