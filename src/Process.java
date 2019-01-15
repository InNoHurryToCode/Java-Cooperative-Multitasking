public class Process {
    public ProcessState state = ProcessState.UninitializedUpdating;

    // initialize the process
    public void init() {
        System.out.println("Initializing process");
    }

    // update the process
    public void update() {
        // code here
    }

    // called before resuming
    public void enable() {
        System.out.println("Enabling process");
    }

    // called before being paused
    public void disable() {
        System.out.println("Disabling process");
    }

    // called before destruction
    public void destroy() {
        System.out.println("Destroying process");
    }
}
