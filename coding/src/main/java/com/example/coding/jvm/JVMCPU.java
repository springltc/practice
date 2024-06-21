//public class JVMCPU {
//    private static Object lock = new Object();
//
//    public static void main(String[] args) {
//        new Thread(() -> {
//            synchronized (lock) {
//                long sum = 0L;
//                while (true) {
//                    sum += 1;
//                }
//            }
//        }).start();
//    }
//}
