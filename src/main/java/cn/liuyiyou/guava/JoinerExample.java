package cn.liuyiyou.guava;

import com.google.common.base.Joiner;
import org.junit.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/13
 * @version: V1.0
 */
public class JoinerExample {

  //Joiner是连接器，Splitter是分割器
  @Test
  public void join(){
    Joiner joiner = Joiner.on(": ").skipNulls();
    final String join = joiner.join("Harry", null, "Rom", "Heermione");
    System.out.println(join);
  }
}
