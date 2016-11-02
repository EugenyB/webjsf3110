package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 * Created by eugeny on 31.10.2016.
 */
@ManagedBean
@RequestScoped
public class Calculator {
    private double start;
    private double finish;
    private double step;
    private Point[] points;

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getFinish() {
        return finish;
    }

    public void setFinish(double finish) {
        this.finish = finish;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public int getN(){
        return (int) ((finish-start)/step+1);
    }

    public String tabulate() {
        points = new Point[getN()];
        for (int i = 0; i < points.length; i++) {
            double x = getStart()+i*getStep();
            double y = f(x);
            points[i] = new Point(x,y);
        }
        return "tabulation";
    }

    private double f(double x) {
        return Math.sin(x);
    }

    public Point[] getPoints() {
        return points;
    }
}
