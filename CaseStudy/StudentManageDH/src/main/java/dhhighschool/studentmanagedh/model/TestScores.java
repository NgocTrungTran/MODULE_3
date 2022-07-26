package dhhighschool.studentmanagedh.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class TestScores {
    private int testScores_id;
    private String student_code;
    private int subjects_id;
    private float f_testScore;
    private float s_testScore;
    private float t_testScore;
    private float sum;
    private float sumAll;
    private int classification_id;

    public TestScores() {
    }

    public TestScores(String student_code, float sumAll) {
        this.student_code = student_code;
        this.sumAll = sumAll;
    }

    public TestScores(int testScores_id, String student_code, int subjects_id, float f_testScore, float s_testScore, float t_testScore, int classification_id, float sum) {
        this.testScores_id = testScores_id;
        this.student_code = student_code;
        this.subjects_id = subjects_id;
        this.f_testScore = f_testScore;
        this.s_testScore = s_testScore;
        this.t_testScore = t_testScore;
        this.classification_id = classification_id;
        this.sum = sum;
    }

    public int getTestScores_id() {
        return testScores_id;
    }

    public void setTestScores_id(int testScores_id) {
        this.testScores_id = testScores_id;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public int getSubjects_id() {
        return subjects_id;
    }

    public void setSubjects_id(int subjects_id) {
        this.subjects_id = subjects_id;
    }
    @Max (value = 10, message = "Score must be greater than or equal to 10!")
    @Min (value = 0, message = "Score must be less than or equal to 10!")
    public float getF_testScore() {
        return f_testScore;
    }

    public void setF_testScore(float f_testScore) {
        this.f_testScore = f_testScore;
    }
    @Max (value = 10, message = "Score must be greater than or equal to 10!")
    @Min (value = 0, message = "Score must be less than or equal to 0!")
    public float getS_testScore() {
        return s_testScore;
    }

    public void setS_testScore(float s_testScore) {
        this.s_testScore = s_testScore;
    }
    @Max (value = 10, message = "Score must be greater than or equal to 10!")
    @Min (value = 0, message = "Score must be less than or equal to 0!")
    public float getT_testScore() {
        return t_testScore;
    }

    public void setT_testScore(float t_testScore) {
        this.t_testScore = t_testScore;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public int getClassification_id() {
        return classification_id;
    }

    public void setClassification_id(int classification_id) {
        this.classification_id = classification_id;
    }

    public float getSumAll() {
        return sumAll;
    }

    public void setSumAll(float sumAll) {
        this.sumAll = sumAll;
    }

    @Override
    public String toString() {
        return "TestScores{" +
                "testScores_id=" + testScores_id +
                ", subjects_id=" + subjects_id +
                ", f_testScore=" + f_testScore +
                ", s_testScore=" + s_testScore +
                ", t_testScore=" + t_testScore +
                '}';
    }
}
