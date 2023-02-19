package contaner;

public class StudentContaner {
    private String  f_name,l_name,address,department;
    private int id;
public StudentContaner(int id,String f_name,String l_name,String address,String department)
{
    this.id=id;
    this.f_name=f_name;
    this.l_name=l_name;
    this.address=address;
    this.department=department;
}
    public StudentContaner(String f_name,String l_name,String address,String department)
    {

        this.f_name=f_name;
        this.l_name=l_name;
        this.address=address;
        this.department=department;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getF_name() {
        return f_name;
    }

    public String getAddress() {
        return address;
    }

    public String getL_name() {
        return l_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
