public class TimeSimulationProcess extends Process {
    int second = 0;
    int minute = 0;
    int hour = 0;
    int day = 1;
    int weekDay = 1;
    int week = 1;
    int month = 1;
    int year = 1;

    // process init
    public void init() {
        printCurrentDateTime();
    }

    // process update
    public void update() {
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
        printCurrentDateTime();
    }

    // process disable
    public void disable() {
        printCurrentDateTime();
    }

    // process destroy
    public void destroy() {
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
            case 1:
            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
                return 31;

            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
                return 30;

            case 2:
                if (year % 4 == 0) {
                    return 28;
                } else {
                    return 27;
                }
        }

        return 0;
    }

    private void printCurrentDateTime() {
        System.out.println(this.year + "/" + this.month + "/" + this.day + " " + this.hour + "-" + this.minute + "-" + this.second);
    }
}
