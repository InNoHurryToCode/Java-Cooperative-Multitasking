import java.util.LinkedList;

public class ProcessManager {
    LinkedList<Process> processes = null;

    // initialize ProcessManager
    public ProcessManager() {
        this.processes = new LinkedList<>();
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
    public void Update() {
        for (int i = 0; i < processes.size(); ++i) {
            Process currentProcess = this.processes.get(i);

            switch (currentProcess.state) {
                // Initialize the process and pause it
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
                // TODO: add support for yields
                case Updating:
                    currentProcess.update();
                    break;

                // allow paused procecss to update again
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
                    this.processes.remove(i);
                    break;
            }
        }
    }

    // get amount of registered processes
    public int count() {
        return this.processes.size();
    }
}
