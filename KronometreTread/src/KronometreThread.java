public class KronometreThread implements Runnable {
    private Thread thread;
    private String threadName;
    public KronometreThread( String threadName ) {
        this.threadName = threadName;
        System.out.println(  threadName + " creating");

    }

    @Override
    public void run() {
        System.out.println( threadName + " starting");

        try {
            for (int i = 1; i < 10; i++) {
                System.out.println(threadName + " running " + i);
                Thread.sleep(1000);
            }
        }catch( InterruptedException e ) {
            System.out.println( threadName + " interrupted");
        }
        System.out.println( threadName + " stopping");
    }
    public void start() {
        System.out.println( threadName + " Tread objesct is beeing");
        if ( thread == null ) {
            thread = new Thread( this, threadName );
            thread.start();
        }
    }
}
