public class TimeSimulationProcess extends Process {
    public int second = 0;
    public int minute = 0;
    public int hour = 0;
    public int day = 1;
    public int weekDay = 1;
    public int week = 1;
    public int month = 1;
    public int year = 1;

    // process init
    public void init() {
        super.init();
        printCurrentDateTime();
    }

    // process update
    public void update() {
        super.update();
        this.updateSecond();
        this.updateMinute();
        this.updateHour();
        this.updateDay();
        this.updateWeek();
        this.updateMonth();
        this.updateYear();
    }

    // process enable
    public void enable() {
        super.enable();
        printCurrentDateTime();
    }

    // process disable
    public void disable() {
        super.disable();;
        printCurrentDateTime();
    }

    // process destroy
    public void destroy() {
        super.destroy();
        printCurrentDateTime();
    }

    private void updateSecond() {
        ++this.second;
    }

    private void updateMinute() {
        if (this.second > 60) {
            ++this.minute;
            this.second = 0;
        }
    }

    private void updateHour() {
        if (this.minute > 60) {
            ++this.hour;
            this.minute = 0;
        };
    }

    private void updateDay() {
        if (this.hour > 23) {
            ++this.day;
            ++this.weekDay;
            this.hour = 0;
        }
    }

    private void updateWeek() {
        if (this.weekDay > 7) {
            ++this.week;
            this.weekDay = 1;
        }
    }

    private void updateMonth() {
        if (this.day > getDaysInWeek(this.month, this.year)) {
            ++this.month;
            this.day = 1;
        }
    }

    private void updateYear() {
        if (this.month > 12) {
            ++this.year;
            this.week = 1;
            this.month = 1;
        }
    }

    private int getDaysInWeek(int month, int year) {
        switch (month) {
            // months with 31 days
            case 1:
            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
                return 31;

            // months with 30 days
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
                return 30;

            // leap year
            case 2:
                if (year % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
        }

        return 0;
    }

    private void printCurrentDateTime() {
        System.out.println(this.year + "/" + this.month + "/" + this.day + " " + this.hour + "-" + this.minute + "-" + this.second);
    }
}
