package cn.liuyiyou.java.exception;

/***
 * 业务处理异常
 * @author: liuyiyou
 * @date: 2018/7/18
 */
public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }
}
