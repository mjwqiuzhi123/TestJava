package com.mjw.tool.test;
import java.text.*;
import java.util.*;


public class _stringUtil {
	
	//-encoding UTF-8 -charset UTF-8
	
	/**
	 * ȥ��html��ʽ
	 * @param html ��html��ʽ�ַ���
	 * @return
	 */
	public static String html2text(String html){
		String result = html.replaceAll("</?[^>]+>", "");
		return result;
	}

	public static void main(String[] args) {
		//		String html = "<p>dsdfdf�ط�������</p>";
		//		String text = html2text(html);
		//		System.out.println(text);
		//		String a = getTwoRandom("34","36");
		//		System.out.println(a);
		String pro = "10";
		boolean a = isWinning(pro);
		System.out.println(a);
	}

	/**
	 * �Ƿ��н�
	 * @param pro �н�����
	 * @return true �н�
	 * 		   false δ�н�
	 */
	public static boolean isWinning(String pro){
		double num = (double)new Random().nextInt(100)+1; //��������1-100�������  
		double proNum = Double.parseDouble(pro); 
		if(num < proNum){
			return true;
		}else{
			return false;
		}

	} 

	//��������Χ��ȡһ����
	public static String getTwoRandom(String min,String max){
		double min1 = Double.parseDouble(min);
		double max1 = Double.parseDouble(max);
		double i = new Random().nextDouble()*(max1-min1)+min1;
		DecimalFormat df=new DecimalFormat(".##");
		String result = df.format(i);
		return result;
	}

	/**
	 * ����uuid
	 * @return ���ɵ�uuid
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * String����תΪInteger����
	 * @param strs ��Ҫת����String����
	 * @return ת�����Integer����
	 */
	public static Integer[] convert2Int(String[] strs) {
		Integer[] nums = new Integer[strs.length];
		for (int i = 0; i < strs.length; i++) {
			try {
				nums[i] = Integer.parseInt(strs[i]);
			} catch (NumberFormatException e) {
				nums[i] = null;
			}
		}
		return nums;
	}

	/**
	 * ��ʱ���ɺ���
	 * 
	 * @param millinSecond ��Ҫ��ʱ�ĺ�����
	 */
	public static void sleep(long milliSecond) {
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���������ַ���(ʹ��yyyy-MM-dd HH:mm:ss��ʽ)
	 * @param str �����ַ���
	 * @param formatStr ���ڸ�ʽ
	 * @return �����������
	 */
	public static Date parseDate(String str,String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ʹ��ָ�������ڸ�ʽ��ʽ���ַ���
	 * @param date ��Ҫ��ʽ��������
	 * @param formatStr ���ڸ�ʽ
	 * @return ��ʽ����������ַ���
	 */
	public static String formatDate(Date date, String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}

	/**
	 * �����������ڼ��������������ʱ����
	 * 
	 * @param dateStart ��ʼʱ��
	 * @param dateEnd ����ʱ��
	 * @return �������ڼ��������
	 */
	public static int dayLength(Date dateStart, Date dateEnd) {
		int sign = 1;
		if (dateStart.after(dateEnd)) {
			Date dateTemp = dateStart;
			dateStart = dateEnd;
			dateEnd = dateTemp;
			sign = -1;
		}
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(dateStart);
		calendarStart.set(Calendar.HOUR_OF_DAY, 1);
		calendarStart.set(Calendar.MINUTE, 0);
		calendarStart.set(Calendar.SECOND, 0);
		Calendar calendarEnd = Calendar.getInstance();
		calendarEnd.setTime(dateEnd);
		calendarEnd.set(Calendar.HOUR_OF_DAY, 2);
		calendarEnd.set(Calendar.MINUTE, 0);
		calendarEnd.set(Calendar.SECOND, 0);
		long diffSecond = calendarEnd.getTimeInMillis() - calendarStart.getTimeInMillis();
		long diffDays = diffSecond / 86400000L;
		return (int) diffDays * sign;
	}

	/**
	 * ��ȡ�����ַ����м���ַ�
	 * @param str ԭʼ�ַ���
	 * @param left ��ߵķָ���(����߲���)
	 * @param right �ұߵķָ���(���ұ߲���)
	 * @return �м���ַ���
	 */
	public static String between(String str, String left, String right) {
		int leftIndex = str.indexOf(left);
		int rightIndex = str.lastIndexOf(right);
		if (rightIndex == -1) {
			rightIndex = str.length();
		}
		return str.substring(leftIndex + left.length(), rightIndex);
	}

	/**
	 * ��������,����С�������λ
	 * @param num ��Ҫ�������������
	 * @return �����������ַ���
	 */
	public static String round(Double num) {
		return String.format("%.2f", num);
	}

	/**
	 * ��������,����С�������λ
	 * @param num ��Ҫ�������������
	 * @return �����������ַ���
	 */
	public static String round(int num) {
		return num + ".00";
	}

	/**
	 * ��ȡ���ϵĵ�һ��Ԫ��
	 * @param list ԭʼ����
	 * @return �����еĵ�һ��Ԫ��
	 */
	public static <T> T getListFirst(List<T> list) {
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * ��ȡ�����еĵ�һ��Ԫ��
	 * @param array ԭʼ����
	 * @return �����еĵ�һ��Ԫ��
	 */
	public static <T> T getArrayFirst(T[] array) {
		if (array == null || array.length == 0) {
			return null;
		} else {
			return array[0];
		}
	}
	
	/**
     * ���ַ���ָ��λ�ý�������(ʹ���ǺŴ���,����ǰ�����ԭ��)
     * @param str ԭ�ַ���
     * @param start ��Ҫ���ε���ʼλ��
     * @param end ��Ҫ���εĽ���λ��
     * @return ����ַ���
     */
    public static String mistWord(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if ("".equals(str.trim())) {
            return "";
        }
        if (start < 0) {
            throw new RuntimeException("��ʼλ�ò���Ϊ����");
        }
        if (end < 0) {
            throw new RuntimeException("����λ�ò���Ϊ����");
        }
        if (end < start) {
            int temp = start;
            start = end;
            end = temp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, start));
        if (end >= str.length()) {
            end = str.length() - 1;
        }
        int len = end - start;
        for (int i = 0; i < len; i++) {
            sb.append("*");
        }
        sb.append(str.substring(end + 1));
        return sb.toString();
    }
    
    /**
     * ���ַ���ָ��λ�ý�������
     * @param str ԭ�ַ���
     * @return ����ַ��� a**
     */
    public static String mistName(String str) {
        if (str == null) {
            return null;
        }
        if ("".equals(str.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, 1));
        for (int i = 0; i < str.length()-1; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
    
    /**
     * �������֤У��λ
     * 
     * @param numStr
     *            ���֤ǰ17λ
     * @return �����У��ֵ
     */
    public static String idCardlastValid(String numStr) {
        if (numStr == null) {
            throw new RuntimeException("����Ĳ�������Ϊ��");
        }
        if (numStr.length() < 17) {
            throw new RuntimeException("����Ĳ�����������Ϊ17λ");
        }
        String sub = numStr.substring(0, 17);
        int[] coefficient = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        String[] valid = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
        int sum = 0;
        for (int i = 0; i < sub.length(); i++) {
            int numCur = sub.charAt(i) - 48;
            sum += numCur * coefficient[i];
        }
        sum %= 11;
        return valid[sum];
    }

    /**
     * �ж�У��λ�Ƿ���ȷ
     * 
     * @param numStr
     *            18λ֤����
     * @return У�����Ƿ���ȷ
     */
    public static boolean idCardValid(String numStr) {
        if (numStr == null) {
            throw new RuntimeException("����Ĳ�������Ϊ��");
        }
        if (numStr.length() != 18) {
            throw new RuntimeException("����Ĳ�������ӦΪΪ18λ");
        }
        String idCardlastValid = idCardlastValid(numStr);
        String lastChar = numStr.substring(17);
        return idCardlastValid.equalsIgnoreCase(lastChar);
    }
    
    
    /**
     * ʹ��ָ���ķָ������ַ���
     * 
     * @param str
     *            Դ�ַ���
     * @param limitChar
     *            �ָ���
     * @return ��ֺ���ַ���
     */
    public static String[] splitTrim(String str, String limitChar) {
        if (str == null) {
            return null;
        }
        if ("".equals(str) || limitChar == null || "".equals(limitChar)) {
            return new String[] { str };
        }
        int limitLength = limitChar.length();
        if (limitLength > str.length()) {
            return new String[] { str };
        }
        List<String> list = new ArrayList<String>();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i + limitLength > str.length()) {
                break;
            }
            String cur = str.substring(i, i + limitLength);
            if (limitChar.equals(cur)) {
                list.add(str.substring(start, i));
                start = i + limitLength;
                i += limitLength - 1;
            }
        }
        list.add(str.substring(start));
        int splitLength = list.size();
        String[] result = new String[splitLength];
        for (int i = 0; i < splitLength; i++) {
            result[i] = list.get(i).trim();
        }
        return result;
    }
    
    /**
     * ʹ�ö��Ų���ַ���
     * 
     * @param str
     *            ��Ҫ��ֵ��ַ���
     * @return ��ֺ���ַ���
     */
    public static String[] splitTrim(String str) {
        return splitTrim(str, ",");
    }
    

//	public static void main(String[] args) {
		
//		String a = "dsfas,d^344*,^6";
//		String b[] = _stringUtil.splitTrim(a);
//		for(String s : b){
//			System.out.println(s);
//		}
		
//		String a = "dsfasd^344*^6";
//		String b[] = _stringUtil.splitTrim(a,"^");
//		for(String s : b){
//			System.out.println(s);
//		}
		
//		String a = "";
//		Boolean b = _stringUtil.idCardValid(a);
//		System.out.println(b);
		
//		String a = "�Ĵ�f";
//		String b = _stringUtil.mistName(a);
//		System.out.println(b);
		
//		String a = "����fdgsdfg";
//		String b = _stringUtil.mistWord(a,3,4);
//		System.out.println(b);

		//    	Integer a[] = {1,2,3};
		//    	Integer b = _stringUtil.getArrayFirst(a);
		//    	System.out.println(b);

		/*List<String> a = new ArrayList<String>();
    	a.add("1");
    	a.add("2");

    	String b = _stringUtil.getListFirst(a);
    	System.out.println(b);*/

		//    	String a = round(1.56577);
		//    	String b = round(56);
		//    	System.out.println(a);
		//    	System.out.println(b);

		//    	String a = "adlfhasjldfndjklaslfdbf";
		//    	String b = _stringUtil.between(a, "adl", "dbf");
		//    	System.out.println(b);

//		    	Date date1 = null,date2 = null;
//		    	date1 = _stringUtil.parseDate("2017-05-05 16:04:27","yyyy-MM-dd HH:mm:ss");
//		    	date2 = _stringUtil.parseDate("2017-06-08 16:04:27","yyyy-MM-dd HH:mm:ss");
//				int a = _stringUtil.dayLength(date1,date2);
//				System.out.println(a);



		//    	String d = _stringUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
		//    	System.out.println(d);
		//    	Date d = _stringUtil.parseDate("2017-05-05 16:04:27","yyyy-MM-dd HH:mm:ss");
		//    	System.out.println(d);

		//    	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//    	for(int i = 0;i < 10;i++){
		//    		if(i==3){
		//    			_stringUtil.sleep(5000);
		//    		}else{
		//    			_stringUtil.sleep(1000);
		//    		}
		//    		Date d = new Date();
		//    		String time = s.format(d);
		//    		System.out.println("hello world"+(i+1)+" "+time);
		//    	}

		//    	String[] strs = {"1","2","3"};
		//    	Integer[] a = _stringUtil.convert2Int(strs);
		//    	for(Integer i : a){
		//    		System.out.println(i);
		//    	}


		//    	String a = _stringUtil.uuid();
		//    	System.out.println(a);



//	}

}