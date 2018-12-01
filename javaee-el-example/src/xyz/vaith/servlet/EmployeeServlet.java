package xyz.vaith.servlet;

import xyz.vaith.bean.Address;
import xyz.vaith.bean.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = -5392874L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address address = new Address();
        address.setStreetName("Rue D'Anjou");
        address.setStreetName("2090B");
        address.setCity("Brossard");
        address.setState("Quebec");
        address.setZipcode("A1A B2B");
        address.setCountry("Canada");

        Employee employee = new Employee();
        employee.setId(1099);
        employee.setName("Charles Unjeye");
        employee.setAddress(address);

        req.setAttribute("employee", employee);

        Map<String, String> capitals = new HashMap<String, String>();
        capitals.put("China", "Beijing");
        capitals.put("Austria", "Vienna");
        capitals.put("Australia", "Canberra");
        capitals.put("Canada", "Ottawa");
        req.setAttribute("capitals", capitals);
        RequestDispatcher rd = req.getRequestDispatcher("/employee.jsp");
        rd.forward(req, resp);
    }
}
