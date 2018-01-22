package com.mjw.bloomfilter.test;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;  
import java.io.Serializable;  
import java.util.BitSet;  
import java.util.concurrent.atomic.AtomicInteger;  
  
public class BloomFileter implements Serializable {  
    private static final long serialVersionUID = -5221305273707291280L;  
    private final int[] seeds;  
    private final int size;  
    private final BitSet notebook;  
    private final MisjudgmentRate rate;  
    private final AtomicInteger useCount = new AtomicInteger(0);  
    private final Double autoClearRate;  
  
    /** 
     * Ĭ���еȳ���������ʣ�MisjudgmentRate.MIDDLE �Լ����Զ�������ݣ����ܻ������������� 
     *  
     * @param dataCount 
     *            Ԥ�ڴ�������ݹ�ģ����Ԥ�����ڴ���1�������ݵĲ��أ���������д1000000 
     */  
    public BloomFileter(int dataCount) {  
        this(MisjudgmentRate.MIDDLE, dataCount, null);  
    }  
  
    /** 
     *  
     * @param rate 
     *            һ��ö�����͵������� 
     * @param dataCount 
     *            Ԥ�ڴ�������ݹ�ģ����Ԥ�����ڴ���1�������ݵĲ��أ���������д1000000 
     * @param autoClearRate 
     *            �Զ���չ������ڲ���Ϣ��ʹ�ñ��ʣ���null���ʾ�����Զ����� 
     *            ��������ʹ���ʴﵽ100%ʱ�������۴���ʲô���ݣ�������Ϊ�������Ѿ������� 
     *            ��ϣ��������ʹ���ʴﵽ80%ʱ�Զ��������ʹ�ã�����0.8 
     */  
    public BloomFileter(MisjudgmentRate rate, int dataCount, Double autoClearRate) {  
        long bitSize = rate.seeds.length * dataCount;  
        if (bitSize < 0 || bitSize > Integer.MAX_VALUE) {  
            throw new RuntimeException("λ��̫������ˣ��뽵�������ʻ��߽������ݴ�С");  
        }  
        this.rate = rate;  
        seeds = rate.seeds;  
        size = (int) bitSize;  
        notebook = new BitSet(size);  
        this.autoClearRate = autoClearRate;  
    }  
  
    public void add(String data) {  
        checkNeedClear();  
  
        for (int i = 0; i < seeds.length; i++) {  
            int index = hash(data, seeds[i]);  
            setTrue(index);  
        }  
    }  
  
    public boolean check(String data) {  
        for (int i = 0; i < seeds.length; i++) {  
            int index = hash(data, seeds[i]);  
            if (!notebook.get(index)) {  
                return false;  
            }  
        }  
        return true;  
    }  
  
    /** 
     * ��������ھͽ��м�¼������false����������˾ͷ���true 
     *  
     * @param data 
     * @return 
     */  
    public boolean addIfNotExist(String data) {  
        checkNeedClear();  
  
        int[] indexs = new int[seeds.length];  
        // �ȼٶ�����  
        boolean exist = true;  
        int index;  
  
        for (int i = 0; i < seeds.length; i++) {  
            indexs[i] = index = hash(data, seeds[i]);  
  
            if (exist) {  
                if (!notebook.get(index)) {  
                    // ֻҪ��һ�������ڣ��Ϳ�����Ϊ�����ַ������ǵ�һ�γ��ֵ�  
                    exist = false;  
                    // ����֮ǰ����Ϣ  
                    for (int j = 0; j <= i; j++) {  
                        setTrue(indexs[j]);  
                    }  
                }  
            } else {  
                setTrue(index);  
            }  
        }  
  
        return exist;  
  
    }  
  
    private void checkNeedClear() {  
        if (autoClearRate != null) {  
            if (getUseRate() >= autoClearRate) {  
                synchronized (this) {  
                    if (getUseRate() >= autoClearRate) {  
                        notebook.clear();  
                        useCount.set(0);  
                    }  
                }  
            }  
        }  
    }  
  
    public void setTrue(int index) {  
        useCount.incrementAndGet();  
        notebook.set(index, true);  
    }  
  
    private int hash(String data, int seeds) {  
        char[] value = data.toCharArray();  
        int hash = 0;  
        if (value.length > 0) {  
  
            for (int i = 0; i < value.length; i++) {  
                hash = i * hash + value[i];  
            }  
        }  
      
        hash = hash * seeds % size;  
        // ��ֹ�����ɸ���  
        return Math.abs(hash);  
    }  
  
    public double getUseRate() {  
        return (double) useCount.intValue() / (double) size;  
    }  
  
    public void saveFilterToFile(String path) {  
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {  
            oos.writeObject(this);  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
  
    }  
  
    public static BloomFileter readFilterFromFile(String path) {  
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {  
            return (BloomFileter) ois.readObject();  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * ��չ������еļ�¼��Ϣ 
     */  
    public void clear() {  
        useCount.set(0);  
        notebook.clear();  
    }  
  
    public MisjudgmentRate getRate() {  
        return rate;  
    }  
  
    /** 
     * �����λ��Խ�࣬������Խ�͵���Խռ�ڴ� 
     *  
     * 4��λ�����ʴ����0.14689159766308 
     *  
     * 8��λ�����ʴ����0.02157714146322 
     *  
     * 16��λ�����ʴ����0.00046557303372 
     *  
     * 32��λ�����ʴ����0.00000021167340 
     *  
     * @author lianghaohui 
     * 
     */  
    public enum MisjudgmentRate {  
        // ����Ҫѡȡ�������ܺܺõĽ��ʹ�����  
        /** 
         * ÿ���ַ�������4��λ 
         */  
        VERY_SMALL(new int[] { 2, 3, 5, 7 }),  
        /** 
         * ÿ���ַ�������8��λ 
         */  
        SMALL(new int[] { 2, 3, 5, 7, 11, 13, 17, 19 }), //  
        /** 
         * ÿ���ַ�������16��λ 
         */  
        MIDDLE(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53 }), //  
        /** 
         * ÿ���ַ�������32��λ 
         */  
        HIGH(new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,  
                101, 103, 107, 109, 113, 127, 131 });  
  
        private int[] seeds;  
  
        private MisjudgmentRate(int[] seeds) {  
            this.seeds = seeds;  
        }  
  
        public int[] getSeeds() {  
            return seeds;  
        }  
  
        public void setSeeds(int[] seeds) {  
            this.seeds = seeds;  
        }  
  
    }  
  
    public static void main(String[] args) {  
        BloomFileter fileter = new BloomFileter(7);  
        System.out.println(fileter.addIfNotExist("1111111111111"));  
        System.out.println(fileter.addIfNotExist("2222222222222222"));  
        System.out.println(fileter.addIfNotExist("3333333333333333"));  
        System.out.println(fileter.addIfNotExist("444444444444444"));  
        System.out.println(fileter.addIfNotExist("5555555555555"));  
        System.out.println(fileter.addIfNotExist("6666666666666"));  
        System.out.println(fileter.addIfNotExist("1111111111111"));  
        fileter.saveFilterToFile("C:\\Users\\admin\\Desktop\\11.obj");  
        fileter = readFilterFromFile("C:\\Users\\admin\\Desktop\\11.obj");  
        System.out.println(fileter.getUseRate());  
        System.out.println(fileter.addIfNotExist("1111111111111"));  
    }  
}  