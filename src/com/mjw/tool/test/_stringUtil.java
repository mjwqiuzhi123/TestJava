package com.mjw.tool.test;
import java.text.*;
import java.util.*;


public class _stringUtil {
	
	//-encoding UTF-8 -charset UTF-8
	
	/**
	 * 去掉html样式
	 * @param html 带html样式字符串
	 * @return
	 */
	public static String html2text(String html){
		String result = html.replaceAll("</?[^>]+>", "");
		return result;
	}

	public static void main(String[] args) {
		//		String html = "<p>dsdfdf地方第三方</p>";
		//		String text = html2text(html);
		//		System.out.println(text);
		//		String a = getTwoRandom("34","36");
		//		System.out.println(a);
		String pro = "10";
		boolean a = isWinning(pro);
		System.out.println(a);
	}

	/**
	 * 是否中奖
	 * @param pro 中奖概率
	 * @return true 中奖
	 * 		   false 未中奖
	 */
	public static boolean isWinning(String pro){
		double num = (double)new Random().nextInt(100)+1; //产生的是1-100的随机数  
		double proNum = Double.parseDouble(pro); 
		if(num < proNum){
			return true;
		}else{
			return false;
		}

	} 

	//从两个范围内取一个数
	public static String getTwoRandom(String min,String max){
		double min1 = Double.parseDouble(min);
		double max1 = Double.parseDouble(max);
		double i = new Random().nextDouble()*(max1-min1)+min1;
		DecimalFormat df=new DecimalFormat(".##");
		String result = df.format(i);
		return result;
	}

	/**
	 * 生成uuid
	 * @return 生成的uuid
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * String数组转为Integer数组
	 * @param strs 需要转换的String数组
	 * @return 转换后的Integer数组
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
	 * 延时若干毫秒
	 * 
	 * @param millinSecond 需要延时的毫秒数
	 */
	public static void sleep(long milliSecond) {
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 解析日期字符串(使用yyyy-MM-dd HH:mm:ss格式)
	 * @param str 日期字符串
	 * @param formatStr 日期格式
	 * @return 解析后的日期
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
	 * 使用指定的日期格式格式化字符串
	 * @param date 需要格式化的日期
	 * @param formatStr 日期格式
	 * @return 格式化后的日期字符串
	 */
	public static String formatDate(Date date, String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}

	/**
	 * 计算两个日期间隔的天数，忽略时分秒
	 * 
	 * @param dateStart 开始时间
	 * @param dateEnd 结束时间
	 * @return 两个日期间隔的天数
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
	 * 获取两个字符串中间的字符
	 * @param str 原始字符串
	 * @param left 左边的分隔符(从左边查找)
	 * @param right 右边的分隔符(从右边查找)
	 * @return 中间的字符串
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
	 * 四舍五入,保留小数点后两位
	 * @param num 需要四舍五入的数字
	 * @return 四舍五入后的字符串
	 */
	public static String round(Double num) {
		return String.format("%.2f", num);
	}

	/**
	 * 四舍五入,保留小数点后两位
	 * @param num 需要四舍五入的数字
	 * @return 四舍五入后的字符串
	 */
	public static String round(int num) {
		return num + ".00";
	}

	/**
	 * 获取集合的第一个元素
	 * @param list 原始集合
	 * @return 集合中的第一个元素
	 */
	public static <T> T getListFirst(List<T> list) {
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 获取数组中的第一个元素
	 * @param array 原始数组
	 * @return 数组中的第一个元素
	 */
	public static <T> T getArrayFirst(T[] array) {
		if (array == null || array.length == 0) {
			return null;
		} else {
			return array[0];
		}
	}
	
	/**
     * 对字符串指定位置进行屏蔽(使用星号代替,基于前开后闭原则)
     * @param str 原字符串
     * @param start 需要屏蔽的起始位置
     * @param end 需要屏蔽的结束位置
     * @return 结果字符串
     */
    public static String mistWord(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if ("".equals(str.trim())) {
            return "";
        }
        if (start < 0) {
            throw new RuntimeException("开始位置不可为负数");
        }
        if (end < 0) {
            throw new RuntimeException("结束位置不可为负数");
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
     * 对字符串指定位置进行屏蔽
     * @param str 原字符串
     * @return 结果字符串 a**
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
     * 计算身份证校验位
     * 
     * @param numStr
     *            身份证前17位
     * @return 计算的校验值
     */
    public static String idCardlastValid(String numStr) {
        if (numStr == null) {
            throw new RuntimeException("输入的参数不能为空");
        }
        if (numStr.length() < 17) {
            throw new RuntimeException("输入的参数长度至少为17位");
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
     * 判断校验位是否正确
     * 
     * @param numStr
     *            18位证件号
     * @return 校验码是否正确
     */
    public static boolean idCardValid(String numStr) {
        if (numStr == null) {
            throw new RuntimeException("输入的参数不能为空");
        }
        if (numStr.length() != 18) {
            throw new RuntimeException("输入的参数长度应为为18位");
        }
        String idCardlastValid = idCardlastValid(numStr);
        String lastChar = numStr.substring(17);
        return idCardlastValid.equalsIgnoreCase(lastChar);
    }
    
    
    /**
     * 使用指定的分割符拆分字符串
     * 
     * @param str
     *            源字符串
     * @param limitChar
     *            分隔符
     * @return 拆分后的字符串
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
     * 使用逗号拆分字符串
     * 
     * @param str
     *            需要拆分的字符串
     * @return 拆分后的字符串
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
		
//		String a = "的答f";
//		String b = _stringUtil.mistName(a);
//		System.out.println(b);
		
//		String a = "发地fdgsdfg";
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