import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author aobs
 * @date 2020-06-11 15:31
 */
public class ScheduledThreadPoolExecutorDemo {



    public static void main(String[] args) throws InterruptedException{
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(simpleDateFormat.format(date) + " " + "预定会议室完成");

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);

        Long meetingId = Long.valueOf(1234456);
        long betweenSeconds = 3000;

        ScheduledFuture sfa = ses.scheduleAtFixedRate(new TimerTask(String.valueOf(meetingId)), betweenSeconds,
                betweenSeconds, TimeUnit.MILLISECONDS);

/*        ScheduledFuture sfb = ses.scheduleAtFixedRate(new TimerTask(simpleDateFormat.format(new Date()).concat("b")), 1,
                1, TimeUnit.SECONDS);
        ScheduledFuture sfc = ses.scheduleAtFixedRate(new TimerTask(simpleDateFormat.format(new Date()).concat("c")), 2,
                1, TimeUnit.SECONDS);
        ScheduledFuture sfd = ses.scheduleAtFixedRate(new TimerTask(simpleDateFormat.format(new Date()).concat("d")), 3,
                1, TimeUnit.SECONDS);*/

        Thread.sleep(betweenSeconds + 1000);
/*        Thread.sleep(5000);
        //sfa.cancel(true);
        System.out.println(simpleDateFormat.format(new Date()).concat("over"));
        Thread.sleep(5000);*/
        ses.shutdown();

    }
}

