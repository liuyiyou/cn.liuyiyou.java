/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.Profiler.java
 * 日期: 2017年10月17日上午9:01:31
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.thread;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liuyiyou.cn
 * @date 2017年10月17日 上午9:01:31
 * @version
 */
public class Profiler {

	public void test() {
		new Button().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		});

		new Button().addActionListener(e -> System.out.println(e.getActionCommand()));
	}

}
