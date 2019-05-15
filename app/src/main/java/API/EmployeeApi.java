package API;

import java.util.List;

import model.EmpolyeeCUD;
import model.Empolyees;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeApi {
    @GET("employees")
    Call<List<Empolyees>>getEmployee();

    @GET("employee/{empID}")
    Call<Empolyees>getEmployeeById(@Path("empID") int empId);

    @POST("create")
    Call<Void>registerEmployee(@Body EmpolyeeCUD emp);

    @PUT("upadte/{empID}")
    Call<Void>updateEmployee(@Path("empID") int empId);

    @DELETE("delete/{empID}")
    Call<Void>deleteEmployee(@Path("empID") int empId);

}


