public class Main {
    public static void main(String[] args) {
        ProcessManager manager = new ProcessManager();
        DaytimeProcess daytimeProcess = new DaytimeProcess();

        // subscribe processes
        manager.addProcess(daytimeProcess);

        while (true) {
            // unsubscribe the process
            if (daytimeProcess.daytime.year > 4) {
                daytimeProcess.state = ProcessState.Destroying;
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
