package edu.csustan.cs4950.sqlwithmenu;

public class Score {
    private int id;
    private String name;
    private float point;

    public Score(int id, String name, float point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public String toString() {
        return id + " " + name + " " + point;
    }
}
