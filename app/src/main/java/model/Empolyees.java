package model;

import retrofit2.http.GET;

public class Empolyees {
    private int id;
private String employee_name;
private float employes_salary;
private int employee_age;
private String profile_image;

    public Empolyees(int id, String employee_name, float employes_salary, int employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employes_salary = employes_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public float getEmployes_salary() {
        return employes_salary;
    }

    public void setEmployes_salary(float employes_salary) {
        this.employes_salary = employes_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
