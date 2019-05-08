package cn.liuyiyou.java8.optional;

import cn.liuyiyou.model.SubsProd;
import cn.liuyiyou.service.SubsProdService;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

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

    /***
     *
     * @author: liuyiyou.cn
     * @date: 2019/4/28
     * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
     */
    public static class SubsProdOptionalExample {

        @Test
        public void test() {
            List<SubsProd> subsProds = SubsProdService.getSubsProds();
            Optional<SubsProd> subsProd = subsProds.stream().findFirst();
            Float aFloat = subsProd.map(SubsProd::getTaxPrice).orElse(0F);
            System.out.println(aFloat);
            Float taxPric = subsProd
                    .map(SubsProd::getTaxRate)
                    .map(f -> f * subsProd.map(SubsProd::getTaxPrice).orElse(0F)).orElse(0F);
            System.out.println(taxPric);

        }
    }
}
