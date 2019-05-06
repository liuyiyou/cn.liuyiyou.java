package cn.liuyiyou.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class MapToIntTest {


    //https://www.leveluplunch.com/java/examples/java-util-stream-intstream-example/

    @Test
    public void builderTest() {
        int sum = IntStream.builder().add(10).add(10).build().sum();
        assertEquals(20, sum);
    }

    @Test
    public void concatTest() {

        IntStream first = IntStream.builder().add(10).build();
        IntStream second = IntStream.builder().add(10).build();

        IntStream third = IntStream.concat(first, second);

        assertEquals(20, third.sum());
    }


    @Test
    public void intstream_empty() {

        IntStream emptyStream = IntStream.empty();

        assertEquals(0, emptyStream.count());
    }


    @Test
    public void intstream_generate() {

        OptionalInt one = IntStream.generate(() -> 1).limit(10).distinct()
                .findFirst();

        assertEquals(1, one.getAsInt());
    }

    @Test
    public void intstream_iterate() {

        List<Integer> numbers = IntStream.iterate(0, n -> n + 3).limit(3)
                .boxed().collect(Collectors.toList());

        // assertThat(numbers, contains(new Integer(0), new Integer(3), new Integer(6)));
    }

    @Test
    public void intstream_of() {

        OptionalInt max = IntStream.of(5, 10).max();

        assertEquals(10, max.getAsInt());
    }

    @Test
    public void intstream_range() {

        List<Integer> numbers = IntStream.range(1, 3).boxed()
                .collect(Collectors.toList());

//        assertThat(numbers, contains(new Integer(1), new Integer(2)));
    }

    @Test
    public void intstream_rangeClosed() {

        List<Integer> numbers = IntStream.rangeClosed(1, 3).boxed()
                .collect(Collectors.toList());

//        assertThat(numbers,
//                contains(new Integer(1), new Integer(2), new Integer(3)));
    }

    @Test
    public void map_to_intstream() {

        List<String> integers = new ArrayList<String>();
        integers.add("1");
        integers.add("2");
        integers.add("3");

        OptionalInt intStream = integers.stream().mapToInt(Integer::parseInt)
                .max();

        assertEquals(3, intStream.getAsInt());
    }

    @Test
    public void convert_to_stream_of_objects() {

        int[] numbers = {1, 2, 3, 4, 5, 6};


        List<Integer> listOfInteger = Arrays.stream(numbers).boxed()
                .collect(Collectors.toList());


//        assertThat(
//                listOfInteger,
//                contains(new Integer(1), new Integer(2), new Integer(3),
//                        new Integer(4), new Integer(5), new Integer(6)));

    }


    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });

        //1-2=-1
        //-1-3=-4
        //-4-4=-8
        //-8-5=-13
        Integer result = list.stream().reduce((integer, integer2) -> integer - integer2).orElse(0);
        System.out.println(result);

        Comparator.comparing(a -> 2, Integer::compareTo);
    }

    @Test
    public void provide_default() {

        List<String> integers = new ArrayList<String>();

        int optionalInt = integers.stream().mapToInt(Integer::parseInt)
                .max().orElse(5);

        assertEquals(5, optionalInt);
    }


    public static void main(String[] args) {
        System.out.println(buildPerson());
        List<Person> peosons = buildPerson();
        IntStream intStream = peosons.parallelStream().mapToInt(i -> i.getId());
        intStream.findAny();
        List<Integer> list = intStream.boxed().collect(toList());
        System.out.println(list.size());
    }


    public static List<Person> buildPerson() {
//        List<Integer> collect = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        List<Person> people = new ArrayList<>();
        IntStream.range(1, 20).forEach(i -> {
            Person person = new Person();
            person.setId(i);
            person.setName("name" + i);
            people.add(person);
        });
        System.out.println(people.size());
        return people;
    }
}


class Person {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}