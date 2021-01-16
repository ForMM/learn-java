package learn.thread.pool;

import java.util.concurrent.ForkJoinTask;

public class Forkjoin extends ForkJoinTask<Long> {

    private long start;
    private long end;
    public static final int Threshold = 2;

    @Override
    public Long getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Long value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }

    @Override
    public void complete(Long value) {
        super.complete(value);
    }
}
