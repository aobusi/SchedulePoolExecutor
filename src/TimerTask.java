/**
 * @author aobs
 * @date 2020-06-11 17:06
 */

public class TimerTask implements Runnable{

    private String id;

    public TimerTask(String id){

        this.id = id;
    }

    @Override
    public void run(){
        System.out.println(id);
    }
}