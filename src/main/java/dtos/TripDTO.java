package dtos;

import entities.Trip;

import java.util.List;

public class TripDTO {

    private Trip id;
    private String name;
    private String date;
    private Integer time;
    private String location;
    private String duration;
    private String packing_list;
    private int guide_id;


    public TripDTO() {
    }

    public TripDTO(String name, String date, Integer time, String location, String duration, String packing_list, int guide_id) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.packing_list = packing_list;
        this.guide_id = guide_id;
    }

    public TripDTO(List<Trip> trips) {
    }

    public int getGuide_id() {
        return guide_id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPacking_list() {
        return packing_list;
    }

    public void setPacking_list(String packing_list) {
        this.packing_list = packing_list;
    }

    public Trip getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", duration='" + duration + '\'' +
                ", packing_list='" + packing_list + '\'' +
                '}';
    }
}
