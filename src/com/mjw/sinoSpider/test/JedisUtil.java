package com.mjw.sinoSpider.test;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
  
/** 
 * Redis ������ 
 */  
public class JedisUtil {  
  
    protected static ReentrantLock lockPool = new ReentrantLock();  
    protected static ReentrantLock lockJedis = new ReentrantLock();  
  
    protected static Logger logger = Logger.getLogger(JedisUtil.class);  
  
    //Redis������IP  
    private static String REDIS_IP = "47.94.240.80";  
  
    //Redis�Ķ˿ں�  
    private static int PORT = 6379;  
  
    //��������  
    private static String AUTH = "123456";  
    //��������ʵ���������Ŀ��Ĭ��ֵΪ8��  
    //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��  
    private static int MAX_ACTIVE = 8;  
  
    //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����Ĭ��ֵҲ��8��  
    private static int MAX_IDLE = 8;  
  
    //�ȴ��������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ����������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��  
    private static int MAX_WAIT = 3000;  
  
    //��ʱʱ��  
    private static int TIMEOUT = 10000;  
  
    //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�  
    private static boolean TEST_ON_BORROW = false;  
  
    private static JedisPool jedisPool = null;  
  
    /** 
     * redis����ʱ��,����Ϊ��λ 
     */  
    public final static int EXRP_HOUR = 60 * 60;            //һСʱ  
    public final static int EXRP_DAY = 60 * 60 * 24;        //һ��  
    public final static int EXRP_MONTH = 60 * 60 * 24 * 30; //һ����  
  
    /** 
     * ��ʼ��Redis���ӳ� 
     */  
    private static void initialPool() {  
        try {  
            JedisPoolConfig config = new JedisPoolConfig();  
            config.setMaxTotal(MAX_ACTIVE);  
            config.setMaxIdle(MAX_IDLE);  
            config.setMaxWaitMillis(MAX_WAIT);  
            config.setTestOnBorrow(TEST_ON_BORROW);  
            jedisPool = new JedisPool(config, REDIS_IP.split(",")[0], PORT, TIMEOUT, AUTH);  
        } catch (Exception e) {  
            logger.error("First create JedisPool error : " + e);  
            try {  
                //�����һ��IP�쳣������ʵڶ���IP  
                JedisPoolConfig config = new JedisPoolConfig();  
                config.setMaxTotal(MAX_ACTIVE);  
                config.setMaxIdle(MAX_IDLE);  
                config.setMaxWaitMillis(MAX_WAIT);  
                config.setTestOnBorrow(TEST_ON_BORROW);  
                jedisPool = new JedisPool(config, REDIS_IP.split(",")[1], PORT, TIMEOUT, AUTH);  
            } catch (Exception e2) {  
                logger.error("Second create JedisPool error : " + e2);  
            }  
        }  
    }  
  
    /** 
     * �ڶ��̻߳���ͬ����ʼ�� 
     */  
    private static void poolInit() {  
        lockPool.lock();  
        try {  
            if (jedisPool == null) {  
                initialPool();  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            lockPool.unlock();  
        }  
    }  
  
    public static Jedis getJedis() {  
        lockJedis.lock();  
        if (jedisPool == null) {  
            poolInit();  
        }  
        Jedis jedis = null;  
        try {  
            if (jedisPool != null) {  
                jedis = jedisPool.getResource();  
            }  
        } catch (Exception e) {  
            logger.error("Get jedis error : " + e);  
        } finally {  
            returnResource(jedis);  
            lockJedis.unlock();  
        }  
        return jedis;  
    }  
  
    /** 
     * �ͷ�jedis��Դ 
     * 
     * @param jedis 
     */  
    public static void returnResource(final Jedis jedis) {  
        if (jedis != null && jedisPool != null) {  
            jedisPool.returnResource(jedis);  
        }  
    }  
  
    /** 
     * ���� String 
     * 
     * @param key 
     * @param value 
     */  
    public synchronized static void setString(String key, String value) {  
        try {  
            value = StringUtils.isEmpty(value) ? "" : value;  
            getJedis().set(key, value);  
        } catch (Exception e) {  
            logger.error("Set key error : " + e);  
        }  
    }  
  
    /** 
     * ���� ����ʱ�� 
     * 
     * @param key 
     * @param seconds ����Ϊ��λ 
     * @param value 
     */  
    public synchronized static void setString(String key, int seconds, String value) {  
        try {  
            value = StringUtils.isEmpty(value) ? "" : value;  
            getJedis().setex(key, seconds, value);  
        } catch (Exception e) {  
            logger.error("Set keyex error : " + e);  
        }  
    }
    
    /**
     * 	���url��set
     */
    public static Long setUrlToSet(String key,String url){
    	Long l = 0L;
    	try {  
            l = getJedis().sadd(key, url); 
        } catch (Exception e) {  
            logger.error("put data to Set error : " + e);  
        }
    	return l;
    }
  
    /** 
     * ��ȡStringֵ 
     * 
     * @param key 
     * @return value 
     */  
    public synchronized static String getString(String key) {  
        if (getJedis() == null || !getJedis().exists(key)) {  
            return null;  
        }  
        return getJedis().get(key);  
    }  
}  