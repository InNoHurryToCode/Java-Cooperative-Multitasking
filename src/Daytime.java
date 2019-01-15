public class Daytime {
    public int second;
    public int minute;
    public int hour;
    public int day;
    public int weekDay;
    public int week;
    public int month;
    public int year;

    public Daytime() {
        this.second = 0;
        this.minute = 0;
        this.hour = 0;
        this.day = 1;
        this.weekDay = 1;
        this.week = 1;
        this.month = 1;
        this.year = 1;
    }

    public Daytime(int second, int minute, int hour, int day, int weekDay, int week, int month, int year) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
        this.day = day;
        this.weekDay = weekDay;
        this.week = week;
        this.month = month;
        this.year = year;
    }
}
