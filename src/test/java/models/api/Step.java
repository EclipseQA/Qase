package models.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.jackson.Jacksonized;

import java.util.Objects;

@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class Step {

    private String action;
    private String expected_result;
    private String data;
    private Integer position;

    public Step() {
    }

    public Step(String action, String expected_result, String data, Integer position) {
        this.action = action;
        this.expected_result = expected_result;
        this.data = data;
        this.position = position;
    }

    @Override
    public String toString() {
        return "step{" +
                "action='" + action + '\'' +
                ", expected_result='" + expected_result + '\'' +
                ", data='" + data + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return Objects.equals(action, step.action) && Objects.equals(expected_result, step.expected_result) && Objects.equals(data, step.data) && Objects.equals(position, step.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, expected_result, data, position);
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getExpected_result() {
        return expected_result;
    }

    public void setExpected_result(String expected_result) {
        this.expected_result = expected_result;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}