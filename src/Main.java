public class Main {
    public static void main(String[] args) {
        ProcessManager manager = new ProcessManager();
        TimeSimulationProcess timeSimulationProcess = new TimeSimulationProcess();

        // subscribe processes
        manager.addProcess(timeSimulationProcess);

        // update the processes state
        int i = 0;

        while (true) {
            manager.Update();

            // disable the process
            if (i == 2) {
                timeSimulationProcess.state = ProcessState.Disabling;
            }

            // enable the process
            if (i == 5) {
                timeSimulationProcess.state = ProcessState.Enabling;
            }

            // unsubscribe the process
            if (timeSimulationProcess.year > 1) {
                timeSimulationProcess.state = ProcessState.Destroying;
            }

            // terminate the process
            if (timeSimulationProcess.year > 1 && timeSimulationProcess.second > 0) {
                manager.removeProcess(timeSimulationProcess);
                break;
            }

            // increase tick
            ++i;
        }
    }
}
