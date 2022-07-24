package dhhighschool.studentmanagedh.model;

public class Classification {
    private int classification_id;
    private String classification;

    public Classification() {
    }

    public Classification(int classification_id, String classification) {
        this.classification_id = classification_id;
        this.classification = classification;
    }

    public int getClassification_id() {
        return classification_id;
    }

    public void setClassification_id(int classification_id) {
        this.classification_id = classification_id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "classification_id=" + classification_id +
                ", classification='" + classification + '\'' +
                '}';
    }
}
