package cn.liuyiyou.java8.optional;

/**
 * @author: liuyiyou.cn
 * @date: 2019/5/6
 * @version: V1.0
 */
public class Streams {
    public enum Status {
        OPEN, CLOSES
    }

    public static final class Task {
        private final Status status;
        private final Integer poionts;

        public Task(final Status status, final Integer poionts) {
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