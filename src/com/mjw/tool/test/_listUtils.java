package com.mjw.tool.test;
import java.lang.reflect.Field;  
import java.text.NumberFormat;  
import java.util.Collections;  
import java.util.Comparator;  
import java.util.Date;  
import java.util.List;  
  
/**
 * ��������-����
 */
public class _listUtils {  
    /** 
     * ��list��Ԫ�ذ��ն��������������, 
     * listԪ�ص����Կ��������֣�byte��short��int��long��float��double�ȣ�֧��������������0����char��String��java.util.Date 
     *  
     *  
     * @param lsit 
     * @param sortname 
     *            listԪ�ص��������� 
     * @param isAsc 
     *            true����false���� 
     */  
    public static <E> void sort(List<E> list, final boolean isAsc, final String... sortnameArr) {  
        Collections.sort(list, new Comparator<E>() {  
  
            public int compare(E a, E b) {  
                int ret = 0;  
                try {  
                    for (int i = 0; i < sortnameArr.length; i++) {  
                        ret = _listUtils.compareObject(sortnameArr[i], isAsc, a, b);  
                        if (0 != ret) {  
                            break;  
                        }  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
                return ret;  
            }  
        });  
    }  
      
    /** 
     * ��list��ÿ�����Զ�ָ���������ǽ��� 
     *  
     * @param list 
     * @param sortnameArr  �������� 
     * @param typeArr      ÿ�����Զ�Ӧ�����������飬 true����false���� 
     */  
  
    public static <E> void sort(List<E> list, final String[] sortnameArr, final boolean[] typeArr) {  
        if (sortnameArr.length != typeArr.length) {  
            throw new RuntimeException("��������Ԫ�ظ���������������Ԫ�ظ��������");  
        }  
        Collections.sort(list, new Comparator<E>() {  
            public int compare(E a, E b) {  
                int ret = 0;  
                try {  
                    for (int i = 0; i < sortnameArr.length; i++) {  
                        ret = _listUtils.compareObject(sortnameArr[i], typeArr[i], a, b);  
                        if (0 != ret) {  
                            break;  
                        }  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
                return ret;  
            }  
        });  
    }  
  
    /** 
     * ��2��������ָ���������ƽ������� 
     *  
     * @param sortname 
     *            �������� 
     * @param isAsc 
     *            true����false���� 
     * @param a 
     * @param b 
     * @return 
     * @throws Exception 
     */  
    private static <E> int compareObject(final String sortname, final boolean isAsc, E a, E b) throws Exception {  
        int ret;  
        Object value1 = _listUtils.forceGetFieldValue(a, sortname);  
        Object value2 = _listUtils.forceGetFieldValue(b, sortname);  
        String str1 = value1.toString();  
        String str2 = value2.toString();  
        if (value1 instanceof Number && value2 instanceof Number) {  
            int maxlen = Math.max(str1.length(), str2.length());  
            str1 = _listUtils.addZero2Str((Number) value1, maxlen);  
            str2 = _listUtils.addZero2Str((Number) value2, maxlen);  
        } else if (value1 instanceof Date && value2 instanceof Date) {  
            long time1 = ((Date) value1).getTime();  
            long time2 = ((Date) value2).getTime();  
            int maxlen = Long.toString(Math.max(time1, time2)).length();  
            str1 = _listUtils.addZero2Str(time1, maxlen);  
            str2 = _listUtils.addZero2Str(time2, maxlen);  
        }  
        if (isAsc) {  
            ret = str1.compareTo(str2);  
        } else {  
            ret = str2.compareTo(str1);  
        }  
        return ret;  
    }  
  
    /** 
     * �����ֶ�����ָ����������ಹ0. 
     *  
     * ʹ�ð���: addZero2Str(11,4) ���� "0011", addZero2Str(-18,6)���� "-000018" 
     *  
     * @param numObj 
     *            ���ֶ��� 
     * @param length 
     *            ָ���ĳ��� 
     * @return 
     */  
    public static String addZero2Str(Number numObj, int length) {  
        NumberFormat nf = NumberFormat.getInstance();  
        // �����Ƿ�ʹ�÷���  
        nf.setGroupingUsed(false);  
        // �����������λ��  
        nf.setMaximumIntegerDigits(length);  
        // ������С����λ��  
        nf.setMinimumIntegerDigits(length);  
        return nf.format(numObj);  
    }  
  
    /** 
     * ��ȡָ�������ָ������ֵ��ȥ��private,protected�����ƣ� 
     *  
     * @param obj 
     *            �����������ڵĶ��� 
     * @param fieldName 
     *            �������� 
     * @return 
     * @throws Exception 
     */  
    public static Object forceGetFieldValue(Object obj, String fieldName) throws Exception {  
        Field field = obj.getClass().getDeclaredField(fieldName);  
        Object object = null;  
        boolean accessible = field.isAccessible();  
        if (!accessible) {  
            // �����private,protected���ε����ԣ���Ҫ�޸�Ϊ���Է��ʵ�  
            field.setAccessible(true);  
            object = field.get(obj);  
            // ��ԭprivate,protected���Եķ�������  
            field.setAccessible(accessible);  
            return object;  
        }  
        object = field.get(obj);  
        return object;  
    } 
    
}