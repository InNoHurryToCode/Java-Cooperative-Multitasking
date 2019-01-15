public class Main {
    public static void main(String[] args) {
        ProcessManager manager = new ProcessManager();
        TimeSimulationProcess timeSimulationProcess = new TimeSimulationProcess();

        // subscribe processes
        manager.addProcess(timeSimulationProcess);

        while (true) {
            // unsubscribe the process
            if (timeSimulationProcess.minute > 1) {
                timeSimulationProcess.state = ProcessState.Destroying;
            }

            // break condition
            if (manager.count() < 1) {
                break;
            }

            // update simulation
            manager.update();
        }
    }
}
