package com.mjw.worm.test;

import java.util.regex.Pattern;

public class Validator {
    /**
     * ������ʽ����֤�û���
     */
    public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";
 
    /**
     * ������ʽ����֤����
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
 
    /**
     * ������ʽ����֤�ֻ���
     * */
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
 
    /**
     * ������ʽ����֤����
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
 
    /**
     * ������ʽ����֤����
     */
    public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";
 
    /**
     * ������ʽ����֤���֤
     */
    public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";
 
    /**
     * ������ʽ����֤URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
 
    /**
     * ������ʽ����֤IP��ַ
     */
    public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
    
    /**
     * ������ʽ����ΰ�Ĳ���(success)smile!
     */
    public static final String REGEX_PARAM = "^([a-zA-Z0-9\u4e00-\u9fa5]+=[0-9]+,)*([a-zA-Z0-9\u4e00-\u9fa5]+=[0-9]+)$";
 
    /**
     * ������ʽ����ΰ�Ĳ���(success)smile!
     */
    //[360����]|[189��վ]|
    public static final String REGEX_PARAM_1 = "^(([360����]|[189��վ]){1}|([a-zA-Z\u4e00-\u9fa5])+=[1-9][0-9]*,([1-9][0-9]*,)?)*(([a-zA-Z\u4e00-\u9fa5])+=[1-9][0-9]*(,[1-9][0-9]*)?)$";
    //public static final String REGEX_PARAM_1 = "^([a-zA-Z0-9\u4e00-\u9fa5]+=[1-9][0-9]*,([1-9][0-9]*,)?)*([a-zA-Z\u4e00-\u9fa5]+[0-9]+=[1-9][0-9]*(,[1-9][0-9]*)?)$";
    /**
     * У���û���
     * 
     * @param username
     * @return У��ͨ������true�����򷵻�false
     */
    public static boolean isUsername(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }
 
    /**
     * У������
     * 
     * @param password
     * @return У��ͨ������true�����򷵻�false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }
 
    /**
     * У���ֻ���
     * 
     * @param mobile
     * @return У��ͨ������true�����򷵻�false
     */
    public static boolean isMobile(String mobile) {
        //return Pattern.matches(REGEX_MOBILE, mobile);
    	return true;
    }
 
    /**
     * У������
     * 
     * @param email
     * @return У��ͨ������true�����򷵻�false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }
 
    /**
     * У�麺��
     * 
     * @param chinese
     * @return У��ͨ������true�����򷵻�false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches(REGEX_CHINESE, chinese);
    }
 
    /**
     * У�����֤
     * 
     * @param idCard
     * @return У��ͨ������true�����򷵻�false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }
 
    /**
     * У��URL
     * 
     * @param url
     * @return У��ͨ������true�����򷵻�false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }
 
    /**
     * У��IP��ַ
     * 
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }
    
    /**
     * ��ΰ�Ĳ���
     * @param param
     * @return
     */
    public static boolean isParam(String param) {
        return Pattern.matches(REGEX_PARAM, param);
    }
    
    /**
     * ��ΰ�Ĳ���
     * @param para,
     * @return
     */
    public static boolean isParam1(String param) {
        return Pattern.matches(REGEX_PARAM_1, param);
    }
 
    public static void main(String[] args) {
        String username = "261����=300,500,189��վ=50,5000,�Ա�=10,����=88,999";
        System.out.println(Validator.isParam1(username));
    }
}