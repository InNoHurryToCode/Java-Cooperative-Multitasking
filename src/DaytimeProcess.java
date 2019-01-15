public class DaytimeProcess extends Process {
    public Daytime daytime = new Daytime();

    // process init
    public void init() {
        // super
        super.init();

        // display current time
        this.printCurrentDateTime();
    }

    // process update
    public void update() {
        // super
        super.update();

        // update time
        this.updateSecond();
        this.updateMinute();
        this.updateHour();
        this.updateDay();
        this.updateWeek();
        this.updateMonth();
        this.updateYear();

        // display current time
        this.printCurrentDateTime();

        // wait for next update
        this.nextYield = 0.1f;
    }

    // process enable
    public void enable() {
        // super
        super.enable();

        // display current time
        this.printCurrentDateTime();
    }

    // process disable
    public void disable() {
        // super
        super.disable();

        // display current time
        this.printCurrentDateTime();
    }

    // process destroy
    public void destroy() {
        // super
        super.destroy();

        // display current time
        this.printCurrentDateTime();
    }

    private void updateSecond() {
        ++this.daytime.second;
    }

    private void updateMinute() {
        if (this.daytime.second > 59) {
            ++this.daytime.minute;
            this.daytime.second = 0;
        }
    }

    private void updateHour() {
        if (this.daytime.minute > 59) {
            ++this.daytime.hour;
            this.daytime.minute = 0;
        };
    }

    private void updateDay() {
        if (this.daytime.hour > 23) {
            ++this.daytime.day;
            ++this.daytime.weekDay;
            this.daytime.hour = 0;
        }
    }

    private void updateWeek() {
        if (this.daytime.weekDay > 7) {
            ++this.daytime.week;
            this.daytime.weekDay = 1;
        }
    }

    private void updateMonth() {
        if (this.daytime.day > getDaysInWeek(this.daytime.month, this.daytime.year)) {
            ++this.daytime.month;
            this.daytime.day = 1;
        }
    }

    private void updateYear() {
        if (this.daytime.month > 12) {
            ++this.daytime.year;
            this.daytime.week = 1;
            this.daytime.month = 1;
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
        System.out.println(this.daytime.year + "/" + this.daytime.month + "/" + this.daytime.day + " " + this.daytime.hour + "-" + this.daytime.minute + "-" + this.daytime.second);
    }
}
