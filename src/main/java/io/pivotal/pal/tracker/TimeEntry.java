package io.pivotal.pal.tracker;
import java.time.LocalDate;

public class TimeEntry {

    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;
    private int counter = 1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public TimeEntry(long id,long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        this.id = counter;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
        counter++;
    }

    public TimeEntry(){

    };

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        else {
            TimeEntry timeEntry = (TimeEntry) obj;
            return this.id == timeEntry.id &&
                    this.projectId == timeEntry.projectId &&
                    this.userId == timeEntry.userId  &&
                    this.date.equals(timeEntry.date) &&
                    this.hours == timeEntry.hours;
        }
    }
}
