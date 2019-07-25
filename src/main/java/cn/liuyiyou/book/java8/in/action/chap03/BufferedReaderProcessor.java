package cn.liuyiyou.book.java8.in.action.chap03;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/19
 * @version: V1.0
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader bufferedReader) throws IOException;
}
