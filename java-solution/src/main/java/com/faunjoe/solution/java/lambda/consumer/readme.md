`Consumer`的作用顾名思义,是给定义一个参数,对其进行(消费)处理,处理的方式可以是任意操作.
```java
//接受一个输入参数，无返回值
Consumer<T> => void accept(T t);
```


```java
@FunctionalInterface
public interface Consumer<T> {
    //对给定的参数T执行定义的操作
    void accept(T t);
    //对给定的参数T执行定义的操作执行再继续执行after定义的操作
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
```