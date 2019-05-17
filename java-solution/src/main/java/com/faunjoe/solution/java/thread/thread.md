sleep 和 wait区别
1.sleep是thread方法，wait是Object方法
2.sleep不会释放object monitor lock,wait释放monitor lock且添加到monitor等待队列里。
3.sleep不依赖synchronized,wait需要synchronized
4.sleep不需要唤醒，wait需要唤醒。




原子性、可见性、有序性(顺序性)。
1.原子性A
  一个操作或者多个操作,要么都成功,要么都失败,中间不能由于任何的因素终端。
  i = 10;
  cache 10, memory 10
  a = 10; 原子性
  b = a; 非原子性。1.read a;2.赋值b
  c++; 非原子性。1.read c;2.add;3.assign to c
  c=c+1;非原子性。1.read c;2.add;3.assign to c
  
2.可见性 v (使用volatile关键字保证可见性)
Thread-1            Thread-2
int i = 0;          int j = i;
i = 10;
cache               cache
(i=10)              j=0(maybe)

i = 10              j = 10

3.有序性(顺序性)o
{
    int i = 0;(1)
    i = 1;    (2)
    boolean flag = false;(3)
    flag = true;(4) 
}

i = 1;
flag = true;
重排序只要求最终一致性

happens-before relationship


volatile关键字。
一旦一个共享变量被volatile修饰,具备两层语义
1.保证了不同线程间的可见性。
2.禁止对其进行重排序,也就是保证了有序性。
3.并未保证原子性。


synchronized 是可重入锁 
  
