package Connection;


public class User {
    private int id;
    private String name;
    private String jobTitle;
    private String workPhone;
    private String workEmail;

    public int getId() {
        return id;
    }

    public User(int id, String name, String jobTitle, String workPhone, String workEmail) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.workPhone = workPhone;
        this.workEmail = workEmail;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }
}

