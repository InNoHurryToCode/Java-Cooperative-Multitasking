import java.util.LinkedList;

public class ProcessManager {
    private LinkedList<Process> processes;
    private long previousTime;

    // initialize ProcessManager
    public ProcessManager() {
        this.processes = new LinkedList<>();
        this.previousTime = System.currentTimeMillis();
    }

    // subscribes process
    public void addProcess(Process process) {
        this.processes.add(process);
    }

    // unsubscribed process
    public void removeProcess(Process process) {
        this.processes.remove(process);
    }

    // update subscribed processes based on state
    public void update() {
        // calculate delta time
        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - this.previousTime;

        this.previousTime = currentTime;

        // calculate yield
        float currentYield = (float)deltaTime / 1000;  // Milliseconds to seconds;

        // update subscribed processes
        for (int i = 0; i < processes.size(); ++i) {
            Process currentProcess = this.processes.get(i);

            switch (currentProcess.state) {
                // initialize the process and pause it
                case UninitializedPaused:
                    currentProcess.init();
                    currentProcess.state = ProcessState.Paused;
                    break;

                // initialize the process and allow it to update
                case UninitializedUpdating:
                    currentProcess.init();
                    currentProcess.state = ProcessState.Updating;
                    break;

                // update tick for the process
                case Updating:
                    if (currentProcess.nextYield < currentProcess.currentYield) {
                        currentProcess.currentYield = 0.0f;
                        currentProcess.update();
                    }

                    currentProcess.currentYield += currentYield;
                    break;

                // allow paused process to update again
                case Enabling:
                    currentProcess.enable();
                    currentProcess.state = ProcessState.Updating;
                    break;

                // pause updating process
                case Disabling:
                    currentProcess.disable();
                    currentProcess.state = ProcessState.Paused;
                    break;

                // destroy the process
                case Destroying:
                    currentProcess.destroy();
                    this.removeProcess(this.processes.get(i));
                    break;
            }
        }
    }

    // get amount of registered processes
    public int count() {
        return this.processes.size();
    }
}
