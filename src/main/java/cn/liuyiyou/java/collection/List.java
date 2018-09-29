package cn.liuyiyou.java.collection;

/**
 * List源码分析
 *
 * @author: liuyiyou.cn
 * @date: 2018/9/26
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.UnaryOperator;

/**
 * 有序集合（也称为序列）。该接口的用户可以精确控制列表中每个元素的插入位置。用户可以通过整数索引（列表中的位置）访问元素，并搜索列表中的元素。
 * 与集合不同，列表通常允许重复元素。更正式地，列表通常允许元素对e1和e2成为e1.equals（e2），并且如果它们根本允许空元素，则它们通常允许多个空元素。有人可能希望通过在用户尝试插入运行时异常时抛出运行时异常来实现禁止重复的列表，这是不可想象的，但我们希望这种用法很少见。
 * List接口在迭代器，add，remove，equals和hashCode方法的契约上放置了除Collection接口中指定的规则之外的其他规定。为方便起见，此处还包括其他继承方法的声明。
 * List接口提供了四种对列表元素进行位置（索引）访问的方法。列表（如Java数组）基于零。注意，对于某些实现（例如，LinkedList类），这些操作可以与索引值成比例地执行。因此，如果调用者不知道实现，则迭代列表中的元素通常优选通过它进行索引。
 * List接口提供了一个特殊的迭代器，称为ListIterator，它允许元素插入和替换，以及Iterator接口提供的常规操作之外的双向访问。提供了一种方法来获得从列表中的指定位置开始的列表迭代器。
 * List接口提供了两种搜索指定对象的方法。从性能的角度来看，应谨慎使用这些方法。在许多实现中，它们将执行昂贵的线性搜索。
 * List接口提供了两种方法来有效地在列表中的任意点插入和删除多个元素。
 * 注意：虽然允许列表将自己包含为元素，但建议极其谨慎：equals和hashCode方法不再在这样的列表中很好地定义。
 * 某些列表实现对它们可能包含的元素有限制。例如，某些实现禁止null元素，并且一些实现对其元素的类型有限制。尝试添加不合格的元素会引发未经检查的异常，通常是NullPointerException或ClassCastException。试图查询不合格元素的存在可能会引发异常，或者它可能只是返回false;一些实现将展示前一种行为，一些将展示后者。更一般地，在完成不会导致将不合格元素插入列表的不合格元素上尝试操作可能会引发异常，或者可能在实现的选择中成功。此类异常在此接口的规范中标记为“可选”。
 * 此接口是Java Collections Framework的成员。
 */
public interface List<E> extends Collection<E> {
    //查询操作

    /**
     * 返回此列表中的元素数。 如果此列表包含多个Integer.MAX_VALUE元素，则返回Integer.MAX_VALUE。
     */
    int size();

    /**
     * 如果此列表不包含任何元素，则返回<tt> true </ tt>。
     */
    boolean isEmpty();

    /**
     * 如果此列表包含指定的元素，则返回true。
     * 更正式地，当且仅当此列表包含至少一个元素e时才返回true（o == null？e == nullo.equals（e））。
     */
    boolean contains(Object o);

    /**
     * 以适当的顺序返回此列表中元素的迭代器。
     */
    Iterator<E> iterator();

    /**
     * 以适当的顺序（从第一个元素到最后一个元素）返回包含此列表中所有元素的数组。
     * 返回的数组将是“安全的”，因为此列表不会保留对它的引用。 （换句话说，即使此列表由数组支持，此方法也必须分配新数组）。 因此调用者可以自由修改返回的数组。
     * 此方法充当基于数组和基于集合的API之间的桥梁。
     *
     * @see Arrays#asList(Object[])
     */
    Object[] toArray();

    /**
     * <T> T [] toArray（T [] a）
     * 以适当的顺序返回包含此列表中所有元素的数组（从第一个元素到最后一个元素）; 返回数组的运行时类型是指定数组的运行时类型。 如果列表适合指定的数组，则返回其中。 否则，将为新数组分配指定数组的运行时类型和此列表的大小。
     * 如果列表适合指定的数组，并且有空余空间（即，数组的元素多于列表），则紧跟在列表末尾的数组中的元素将设置为null。 （仅当调用者知道列表不包含任何null元素时，这在确定列表长度时很有用。）
     * <p>
     * 与toArray（）方法一样，此方法充当基于数组的API和基于集合的API之间的桥梁。 此外，该方法允许精确控制输出阵列的运行时类型，并且在某些情况下可以用于节省分配成本。
     * 假设x是已知仅包含字符串的列表。 以下代码可用于将列表转储到新分配的String数组中：
     *       String [] y = x.toArray（new String [0]）;
     *  
     * 请注意，toArray（new Object [0]）在功能上与toArray（）相同。
     */
    <T> T[] toArray(T[] a);


    // 修改操作

    /**
     * 将指定的元素追加到此列表的末尾（可选操作）。
     * 支持此操作的列表可能会限制可能添加到此列表的元素。 特别是，某些列表将拒绝添加null元素，而其他列表将对可能添加的元素类型施加限制。 列表类应在其文档中明确指出可以添加哪些元素的任何限制。
     * <p>
     * 具体说明：
     * 添加接口Collection <E>
     * 参数：
     * e - 要附加到此列表的元素
     * 返回：
     * true（由Collection.add（E）指定）
     * 抛出：
     * UnsupportedOperationException - 如果此列表不支持添加操作
     * ClassCastException - 如果指定元素的类阻止将其添加到此列表中
     * NullPointerException - 如果指定的元素为null且此列表不允许null元素
     * IllegalArgumentException - 如果此元素的某些属性阻止它
     */
    boolean add(E e);

    /**
     * 从该列表中删除指定元素的第一个匹配项（如果存在）（可选操作）。 如果此列表不包含该元素，则不会更改。 更正式地，删除具有最低索引i的元素，使得（o == null？get（i）== null：o.equals（get（i）））（如果存在这样的元素）。 如果此列表包含指定的元素，则返回true（或等效地，如果此列表因调用而更改）。
     * 具体说明：
     * 在接口Collection <E>中删除
     * 参数：
     * o - 要从此列表中删除的元素（如果存在）
     * 返回：
     * 如果此列表包含指定的元素，则返回true
     * 抛出：
     * ClassCastException - 如果指定元素的类型与此列表不兼容（可选）
     * NullPointerException - 如果指定的元素为null且此列表不允许null元素（可选）
     * UnsupportedOperationException - 如果此列表不支持remove操作
     */
    boolean remove(Object o);


    // 批量修改操作

    /**
     * 如果此列表包含指定集合的所有元素，则为rue。
     * 具体说明：
     * containsAll接口Collection <E>
     * 参数：
     * c - 要在此列表中检查包含的集合
     * 返回：
     * 如果此列表包含指定集合的所有元素，则返回true
     * 抛出：
     * ClassCastException - 如果指定集合中的一个或多个元素的类型与此列表不兼容（可选）
     * NullPointerException - 如果指定的集合包含一个或多个null元素，并且此列表不允许null元素（可选），或者指定的集合为null
     *
     * @see #contains(Object)
     */
    boolean containsAll(Collection<?> c);

    /**
     * 将指定集合中的所有元素按指定集合的迭代器（可选操作）返回的顺序追加到此列表的末尾。
     * 如果在操作正在进行时修改了指定的集合，则此操作的行为是不确定的。
     * （请注意，如果指定的集合是此列表，则会发生这种情况，并且它是非空的。）
     * <p>
     * 覆盖：
     * 接口Collection中的addAll
     * 参数：
     * c - 包含要添加到此列表的元素的集合
     * 返回：
     * 如果此列表因调用而更改，则为true
     * 抛出：
     * UnsupportedOperationException - 如果此列表不支持addAll操作
     * ClassCastException - 如果指定集合的元素的类阻止将其添加到此列表中
     * NullPointerException - 如果指定的集合包含一个或多个null元素，并且此列表不允许null元素，或者指定的集合为null
     * IllegalArgumentException - 如果指定collection的元素的某些属性阻止将其添加到此列表中
     * IllegalStateException - 如果由于插入限制，此时不能添加所有元素
     *
     * @see #add(Object)
     */
    boolean addAll(Collection<? extends E> c);

    /**
     * 将指定集合中的所有元素插入到指定位置的此列表中（可选操作）。
     * 将当前位置的元素（如果有）和任何后续元素向右移动（增加其索引）。
     * 新元素将按照指定集合的​​迭代器返回的顺序出现在此列表中。如果在操作正在进行时修改了指定的集合，则此操作的行为是不确定的。
     * （请注意，如果指定的集合是此列表，则会发生这种情况，并且它是非空的。）
     * 参数：
     * index - 从指定集合中插入第一个元素的索引
     * c - 包含要添加到此列表的元素的集合
     * 返回：
     * 如果此列表因调用而更改，则为true
     * 抛出：
     * UnsupportedOperationException - 如果此列表不支持addAll操作
     * ClassCastException - 如果指定集合的​​元素的类阻止将其添加到此列表中
     * NullPointerException - 如果指定的集合包含一个或多个null元素，并且此列表不允许null元素，或者指定的集合为null
     * IllegalArgumentException - 如果指定collection的元素的某些属性阻止将其添加到此列表中
     * IndexOutOfBoundsException - 如果索引超出范围（索引<0 || index> size（））
     */
    boolean addAll(int index, Collection<? extends E> c);

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection (optional operation).
     *
     * @param c collection containing elements to be removed from this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws UnsupportedOperationException if the <tt>removeAll</tt> operation
     *                                       is not supported by this list
     * @throws ClassCastException            if the class of an element of this list
     *                                       is incompatible with the specified collection
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException          if this list contains a null element and the
     *                                       specified collection does not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>),
     *                                       or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    boolean removeAll(Collection<?> c);

    /**
     * 仅保留此列表中包含在指定集合中的元素（可选操作）。 换句话说，从该列表中删除未包含在指定集合中的所有元素。
     * 覆盖：
     * retainAll在接口Collection中
     * 参数：
     * c - 包含要保留在此列表中的元素的集合
     * 返回：
     * 如果此列表因调用而更改，则为true
     * 抛出：
     * UnsupportedOperationException - 如果此列表不支持retainAll操作
     * ClassCastException - 如果此列表的元素的类与指定的集合不兼容（可选）
     * NullPointerException - 如果此列表包含null元素且指定的collection不允许null元素（可选），或者指定的collection是null
     *
     * @see #remove(Object)
     * @see #contains(Object)
     */
    boolean retainAll(Collection<?> c);

    /**
     * 将该列表的每个元素替换为将运算符应用于该元素的结果。 操作员抛出的错误或运行时异常将转发给调用者。
     * 参数：
     * operator - 要应用于每个元素的运算符
     * 抛出：
     * UnsupportedOperationException - 如果此列表不可修改。 如果无法替换元素或者通常不支持修改，则实现可能会抛出此异常
     * NullPointerException - 如果指定的运算符为null或者运算符结果为空值且此列表不允许null元素（可选）
     * implSpec
     * 对于此列表，默认实现等效于：
     *            final ListIterator <E> li = list.listIterator（）;
     *            while（li.hasNext（））{
     *               li.set（operator.apply（li.next（）））;
     *           }
     *       
     * 如果列表的list-iterator不支持set操作，则在替换第一个元素时将抛出UnsupportedOperationException。
     *
     * @since 1.8
     */
    default void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        final ListIterator<E> li = this.listIterator();
        while (li.hasNext()) {
            li.set(operator.apply(li.next()));
        }
    }

    /**
     * 根据指定的比较器引发的顺序对此列表进行排序。
     * <p>
     * 此列表中的所有元素必须使用指定的比较器进行相互比较（即，c.compare（e1，e2）不得对列表中的任何元素e1和e2抛出ClassCastException）。
     * <p>
     * 如果指定的比较器为null，则此列表中的所有元素都必须实现Comparable接口，并且应使用元素的自然顺序。
     * <p>
     * 此列表必须是可修改的，但无需调整大小。
     * 参数：
     * c - 用于比较列表元素的比较器。空值表示应使用元素的自然顺序
     * 抛出：
     * ClassCastException - 如果列表包含使用指定的比较器无法相互比较的元素
     * UnsupportedOperationException - 如果列表的list-iterator不支持set操作
     * IllegalArgumentException - （可选）如果发现比较器违反了比较器合同
     * implSpec
     * 默认实现获取包含此列表中所有元素的数组，对数组进行排序，并迭代此列表，从数组中的相应位置重置每个元素。
     * （这样可以避免因尝试对链接列表进行排序而导致的n2 log（n）性能。）
     * implNote
     * 此实现是一个稳定的，自适应的迭代合并输出，当输入数组被部分排序时，它需要远远少于n lg（n）的比较，
     * 同时在输入数组随机排序时提供传统合并输出的性能。如果输入数组几乎已排序，则实现需要大约n次比较。
     * 临时存储要求从几乎排序的输入数组的小常量到随机排序的输入数组的n / 2个对象引用不等。
     * <p>
     * 该实现在其输入数组中具有升序和降序的相同优势，并且可以利用同一输入数组的不同部分中的升序和降序。
     * 它非常适合合并两个或多个排序数组：只需连接数组并对结果数组进行排序。
     * <p>
     * 该实现改编自Tim Peters的Python排序（TimSort）。它使用了Peter McIlroy的“乐观排序和信息理论复杂性”中的技术，
     * 参见“第四届年度ACM-SIAM离散算法研讨会论文集”，第467-474页，1993年1月。
     *
     * @since 1.8
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<E> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((E) e);
        }
    }

    /**
     * 从此列表中删除所有元素（可选操作）。 此调用返回后，列表将为空。
     *
     * @throws UnsupportedOperationException
     */
    void clear();


    // 比较和散列

    /**
     * 将指定对象与此列表进行比较以获得相等性。
     * 当且仅当指定的对象也是列表时，返回true，两个列表具有相同的大小，并且两个列表中的所有对应元素对都相等。
     * （如果（e1 == null？e2 == null：e1.equals（e2）），则两个元素e1和e2相等。）
     * 换句话说，如果两个列表包含相同顺序的相同元素，则它们被定义为相等。 此定义确保equals方法在List接口的不同实现中正常工作。
     *
     * @param o the object to be compared for equality with this list
     * @return <tt>true</tt> if the specified object is equal to this list
     */
    boolean equals(Object o);

    /**
     * 返回此列表的哈希码值。 列表的哈希码被定义为以下计算的结果：
     *            int hashCode = 1;
     *            for（E e：list）
     *                hashCode = 31 * hashCode +（e == null？0：e.hashCode（））;
     *       
     * 这确保了list1.equals（list2）暗示了对于任何两个列表list1和list2的list1.hashCode（）== list2.hashCode（），这是Object.hashCode的常规协定所要求的。
     *
     * @return the hash code value for this list
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();


    // 位置访问操作

    /**
     * 返回此列表中指定位置的元素。
     * 参数：
     * index - 要返回的元素的索引
     * 返回：
     * 此列表中指定位置的元素
     * 抛出：
     * IndexOutOfBoundsException - 如果索引超出范围（索引<0 || index> = size（））
     */
    E get(int index);

    /**
     * 用指定的元素替换此列表中指定位置的元素（可选操作）。
     * 参数：
     * index - 要替换的元素的索引
     * element - 要存储在指定位置的元素
     * 返回：
     * 先前在指定位置的元素
     * 抛出：
     * UnsupportedOperationException - 如果此列表不支持set操作
     * ClassCastException - 如果指定元素的类阻止将其添加到此列表中
     * NullPointerException - 如果指定的元素为null且此列表不允许null元素
     * IllegalArgumentException - 如果指定元素的某些属性阻止将其添加到此列表中
     * IndexOutOfBoundsException - 如果索引超出范围（索引<0 || index> = size（））
     */
    E set(int index, E element);

    /**
     * 将指定元素插入此列表中的指定位置（可选操作）。 将当前位于该位置的元素（如果有）和任何后续元素移位到右侧（将其添加到其索引中）。
     * 参数：
     * index - 要插入指定元素的索引
     * element - 要插入的元素
     * 抛出：
     * UnsupportedOperationException - 如果此列表不支持添加操作
     * ClassCastException - 如果指定元素的类阻止将其添加到此列表中
     * NullPointerException - 如果指定的元素为null且此列表不允许null元素
     * IllegalArgumentException - 如果指定元素的某些属性阻止将其添加到此列表中
     * IndexOutOfBoundsException - 如果索引超出范围（索引<0 || index> size（））
     */
    void add(int index, E element);

    /**
     * 删除此列表中指定位置的元素（可选操作）。 将任何后续元素向左移位（从索引中减去一个元素）。 返回从列表中删除的元素。
     * 参数：
     * index - 要删除的元素的索引
     * 返回：
     * 先前在指定位置的元素
     * 抛出：
     * UnsupportedOperationException - 如果此列表不支持remove操作
     * IndexOutOfBoundsException - 如果索引超出范围（索引<0 || index> = size（））
     */
    E remove(int index);


    // 搜索操作

    /**
     * 返回此列表中第一次出现的指定元素的索引，如果此列表不包含该元素，则返回-1。 更正式地，返回最低索引i，使得（o == null？get（i）== null：o.equals（get（i））），如果没有这样的索引则返回-1。
     * 参数：
     * o - 要搜索的元素
     * 返回：
     * 此列表中第一次出现的指定元素的索引，如果此列表不包含该元素，则返回-1
     * 抛出：
     * ClassCastException - 如果指定元素的类型与此列表不兼容（可选）
     * NullPointerException - 如果指定的元素为null且此列表不允许null元素（可选）
     */
    int indexOf(Object o);

    /**
     * 返回此列表中指定元素最后一次出现的索引，如果此列表不包含该元素，则返回-1。 更正式地，返回最高索引i，使得（o == null？get（i）== null：o.equals（get（i））），如果没有这样的索引则返回-1。
     * 参数：
     * o - 要搜索的元素
     * 返回：
     * 此列表中指定元素最后一次出现的索引，如果此列表不包含该元素，则返回-1
     * 抛出：
     * ClassCastException - 如果指定元素的类型与此列表不兼容（可选）
     * NullPointerException - 如果指定的元素为null且此列表不允许null元素（可选）
     */
    int lastIndexOf(Object o);


    // List Iterators

    /**
     * 返回此列表中元素的列表迭代器（按适当顺序）。
     * 返回：
     * 列表中的元素列表迭代器（按正确顺序）
     */
    ListIterator<E> listIterator();

    /**
     * 从列表中的指定位置开始，返回列表中元素的列表迭代器（按正确顺序）。 指定的索引指示初始调用next时将返回的第一个元素。 对previous的初始调用将返回指定索引减去1的元素。
     * 参数：
     * index - 从列表迭代器返回的第一个元素的索引（通过调用next）
     * 返回：
     * 列表中元素的列表迭代器（按正确顺序），从列表中的指定位置开始
     * 抛出：
     * IndexOutOfBoundsException - 如果索引超出范围（索引<0 || index> size（））
     */
    ListIterator<E> listIterator(int index);

    // View

    /**
     * 返回指定fromIndex（包含）和toIndex（独占）之间此列表部分的视图。
     * （如果fromIndex和toIndex相等，则返回的列表为空。）返回的列表由此列表支持，因此返回列表中的非结构更改将反映在此列表中，反之亦然。
     * 返回的列表支持此列表支持的所有可选列表操作。
     * <p>
     * 此方法消除了对显式范围操作的需要（对于数组通常存在的排序）。
     * 任何需要列表的操作都可以通过传递subList视图而不是整个列表来用作范围操作。 例如，以下习语从列表中删除了一系列元素：
     *             list.subList（from，to）.clear（）;
     *       
     * 可以为indexOf和lastIndexOf构造类似的习语，并且可以将Collections类中的所有算法应用于subList。
     * java.util.List<E> subList(int fromIndex, int toIndex);
     * <p>
     * /**
     * 在此列表中的元素上创建Spliterator。
     * <p>
     * Spliterator报告Spliterator.SIZED和Spliterator.ORDERED。 实施应记录其他特征值的报告。
     * 返回：
     * Spliterator对此列表中的元素
     * implSpec
     * 默认实现从列表的Iterator创建一个后期绑定的spliterator。 spliterator继承了列表迭代器的fail-fast属性。
     * implNote
     * 创建的Spliterator还会报告Spliterator.SUBSIZED。
     *
     * @since 1.8
     */
    @Override
    default Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, Spliterator.ORDERED);
    }
}

