/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.OptionalTest.java
 * 日期: 2017年9月21日上午9:50:08
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Test;

import cn.liuyiyou.java8.Streams.Status;

/**
 * @author liuyiyou.cn
 * @date 2017年9月21日 上午9:50:08
 * @version
 */
public class OptionalTest {

	// 这种使用方式还是会空指针
	@SuppressWarnings("null")
	@Test
	public void optionTest() {
		Optional<User> user = null;
		if (user.isPresent()) {
			System.out.println(user.get().getName());
		} else {
			System.out.println("xx");
		}
	}

	@Test
	public void optionTest2() {
		Optional<String> name = Optional.ofNullable(null);
		name.ifPresent(null);
		System.out.println(name.get());
	}

	@Test
	public void teset3() {
		final Collection<Streams.Task> tasks = Arrays.asList(new Streams.Task(Streams.Status.OPEN, 5),
				new Streams.Task(Streams.Status.OPEN, 13), new Streams.Task(Streams.Status.CLOSES, 8));

		final long totalPoints = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Streams.Task::getPoionts).sum();
		System.out.println(totalPoints);
	}

	@Test
	public void beforeJava8() {
		Outer outer = new Outer();
		if (outer != null && outer.nested != null && outer.nested.inner != null) {
			System.out.println(outer.nested.inner.foo);
		} else {
			System.out.println("为null");
		}

	}

	// map方法输入参数是lambda表达式，自动封装每个函数返回值至Optional，且可以管道式连接多个map操作，null检查自动完成。
	@Test
	public void onJava8() {
		Optional.of(new Outer()).map(Outer::getNested).map(Nested::getInner).map(Inner::getFoo)
				.ifPresent(System.out::println);
		
		//Optional.of(new Outer()).map(Outer::getNested).map(Nested::getInner).map(Inner::getFoo).isPresent()?1:2
	}

}

class Streams {
	enum Status {
		OPEN, CLOSES
	};

	static final class Task {
		private final Status status;
		private final Integer poionts;

		Task(final Status status, final Integer poionts) {
			this.status = status;
			this.poionts = poionts;
		}

		public Status getStatus() {
			return status;
		}

		public Integer getPoionts() {
			return poionts;
		}

		@Override
		public String toString() {
			return String.format("[%s, %d]", status, poionts);
		}
	}
}

class User {
	int age;
	String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Outer {

	Nested nested;

	Nested getNested() {

		return nested;

	}

}

class Nested {

	Inner inner;

	Inner getInner() {

		return inner;

	}

}

class Inner {

	String foo;

	String getFoo() {

		return foo;

	}
}
