import javax.swing.*;

public class CarRunnable implements Runnable {
    private int delayTime;
    private CarShape carShape;
    private JLabel jLabel;

    public CarRunnable(int delayTime, final CarShape carShape, final JLabel jLabel){
        this.carShape = carShape;
        this.jLabel = jLabel;
        this.delayTime = delayTime;
    }
    public void run(){
        try{
            while(true){
                carShape.translate(1,0);
                jLabel.repaint();
                Thread.sleep(delayTime);
            }
        }catch (InterruptedException exception){}
    }
}
