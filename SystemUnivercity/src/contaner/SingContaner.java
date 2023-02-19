package contaner;

public class SingContaner {
    private String username,password,department;
    public SingContaner(String username,String password,String department)
    {
        this.username=username;
        this.password=password;
        this.department=department;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }
}
