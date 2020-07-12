/**
 * @author zhengnaishan
 * @date 2020/4/6 0006
 * @describe :
 */
class Data{
    int data = 0;
    public void set60(){
        this.data = 60;
    }

    public void increate(){
        for(int i=0 ; i<10000; i++){
            this.data ++;
        }
    }
}
public class VatilTest {
    public static void main(String[] args) {
        Data data = new Data();
//        new Thread(()->{
//            System.out.println("thread-" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            data.set60();
//            System.out.println("thread-" + Thread.currentThread().getName() + "///" + data.data);
//        },"AAA").start();
//        while (data.data == 0){
//        }
//        System.out.println("程序结束");

         for(int i= 0; i < 20 ;i++){
             new Thread(()->{
                 try {
                     Thread.sleep(3000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 data.increate();
             },String.valueOf(i)).start();
         }

         while (Thread.activeCount() >= 2){
             Thread.yield();
         }
        System.out.println(data.data);
    }
}
