package contaner;

public class DataContaner {
    private String  f_name,l_name,department;
    private int total;
    public DataContaner(String f_name,String l_name,String department,int total)
    {
        this.f_name=f_name;
        this.l_name=l_name;
        this.department=department;
        this.total=total;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getDepartment() {
        return department;
    }

    public int getTotal() {
        return total;
    }
}
