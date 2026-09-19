package org.kata.connascence.timing;

// Connascence of Timing: waiting a fixed, arbitrary delay instead of
// actually waiting on the job's completion -- correctness depends on the
// job finishing within 1000ms, a race condition disguised as a constant.
public class BackgroundJobRunner {
    private volatile String jobResult = null;

    public void startJob() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            this.jobResult = "done";
        });
        thread.start();
    }

    public String waitForResult() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return jobResult;
    }
}
