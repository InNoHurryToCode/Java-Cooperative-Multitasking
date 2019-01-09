public abstract class Process {
    ProcessState state = ProcessState.UninitializedUpdating;

    // initialize the process
    public abstract void init();

    // update the process
    public abstract void update();

    // called before resuming
    public abstract void enable();

    // called before being paused
    public abstract void disable();

    // called before destruction
    public abstract void destroy();
}
