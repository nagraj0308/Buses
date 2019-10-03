
package com.nagraj.buses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("is_volvo")
    @Expose
    private boolean isVolvo;
    @SerializedName("operator")
    @Expose
    private String operator;
    @SerializedName("is_ac")
    @Expose
    private boolean isAc;
    @SerializedName("trip_start_time")
    @Expose
    private String tripStartTime;
    @SerializedName("trip_end_time")
    @Expose
    private String tripEndTime;
    @SerializedName("is_sleeper")
    @Expose
    private boolean isSleeper;
    @SerializedName("fare")
    @Expose
    private int fare;
    @SerializedName("seats_available")
    @Expose
    private int seatsAvailable;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean isIsVolvo() {
        return isVolvo;
    }

    public void setIsVolvo(boolean isVolvo) {
        this.isVolvo = isVolvo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isIsAc() {
        return isAc;
    }

    public void setIsAc(boolean isAc) {
        this.isAc = isAc;
    }

    public String getTripStartTime()
    {
        return tripStartTime.substring(12,20);
    }

    public void setTripStartTime(String tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    public String getTripEndTime() {
        return tripEndTime;
    }

    public void setTripEndTime(String tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public boolean isIsSleeper() {
        return isSleeper;
    }

    public void setIsSleeper(boolean isSleeper) {
        this.isSleeper = isSleeper;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

}
