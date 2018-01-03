package trol.domain.trol_api.model;

import trol.domain.database_models.UserEntity;

import java.sql.Time;
import java.time.LocalTime;

public class User implements Comparable<User> {

    private int idUser;
    private String userIp;
    private boolean isActive;
    private boolean isTimed;
    private LocalTime timeBegin;
    private LocalTime timeEnd;
    private boolean hasDuration;
    private Integer durationInterval;
    private Integer usedTime;

    public User() {
        isActive = false;
        isTimed = false;
        timeBegin = LocalTime.MIN;
        timeEnd = LocalTime.MAX;
        userIp = "";
        hasDuration = false;
        durationInterval = new Integer(0);
        usedTime = new Integer(0);

    }

    public User(UserEntity entity) {
        idUser = entity.getIdUser();
        userIp = entity.getUserIp();
        isActive = entity.getIsActive() == 1;
        isTimed = entity.getIsTimed() == 1;
        timeBegin = entity.getTimeBegin().toLocalTime();
        timeEnd = entity.getTimeEnd().toLocalTime();
        hasDuration = entity.getHasDuration() == 1;
        durationInterval = entity.getDurationInterval();
        usedTime = entity.getUsedTime();
    }

    public int getIdUser() {
        return idUser;
    }

    public String getUserIp() {
        return userIp;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public boolean getIsTimed() {
        return isTimed;
    }

    public LocalTime getTimeBegin() {
        return timeBegin;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public boolean getHasDuration() {
        return hasDuration;
    }

    public Integer getDurationInterval() {
        return durationInterval;
    }

    public Integer getUsedTime() {
        return usedTime;
    }

    @Override
    public int compareTo(User o) {
        return idUser - o.idUser;
    }
}
