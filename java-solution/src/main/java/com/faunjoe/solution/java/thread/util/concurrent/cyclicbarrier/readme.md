CountDownLatch vs CyclicBarrier

1.CountDownLatch 不能reset  CyclicBarrier 可以循环使用。
2.CountDownLatch线程间互不关心，CyclicBarrier 工作线程必须等到同一个共同点才去执行某个动作。