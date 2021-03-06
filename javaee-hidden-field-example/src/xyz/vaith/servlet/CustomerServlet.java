package xyz.vaith.servlet;

import xyz.vaith.bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer", "/editCustomer", "/updateCustomer"})
public class CustomerServlet extends HttpServlet {
    private static final long serialVesionUID = 20L;
    private List<Customer> customers = new ArrayList<Customer>();

    @Override
    public void init() throws ServletException {
        Customer customer = new Customer();
        customer.setId(1);;
        customer.setCity("Miami");
        customer.setName("Donald D.");

        customers.add(customer);

        Customer customer1 = new Customer();
        customer1.setId(2);
        customer1.setName("Mickey M.");
        customer1.setCity("Orlando");
        customers.add(customer1);
    }

    private void sendCustomerList(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>Customers</title></head><body><h2>Customers </h2>");
        writer.println("<ul>");
        for (Customer customer : customers) {
            writer.println("<li>" + customer.getName() + "(" + customer.getCity() + ") (" + "<a href='editCustomer?id=" + customer.getId() +"'>Edit</a>)</li>");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }

    private Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    private void sendEditCustomerForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        int customerId = 0;
        try {
            customerId = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e){

        }

        Customer customer = getCustomer(customerId);
        PrintWriter writer = response.getWriter();
        if (customer != null) {
            writer.println("<html><head><title>Edit Customer</title></head><body><h2>Edit Customer</h2><form method='post' action='updateCustomer'>");
            writer.println("<input type='hidden' name='id' value="+customer.getId()+" />");
            writer.println("<table>");
            writer.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+customer.getName().replaceAll("'", "&#39;")+"' /></td></tr>");
            writer.println("<tr><td>City:</td><td><input type='text' name='city' value='"+customer.getCity().replaceAll("'", "&#39;")+"' /></td></tr>");

            writer.println("<tr><td colspan='2' style='text-align:right'><input type='submit' value='Update' /></td></tr>");
            writer.println("<tr><td colspan='2' style='text-align:right'><a href='customer'>Customer List</a></td></tr>");
            writer.println("</table>");
            writer.println("</form></body></html>");
        } else {
            writer.println("No customer found");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if ("/customer".equals(uri)) {
            sendCustomerList(resp);
        } else if ("/editCustomer".equals(uri)) {
            sendEditCustomerForm(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerId = 0;
        try {
            customerId = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            customer.setName(req.getParameter("name"));
            customer.setCity(req.getParameter("city"));
        }
        sendCustomerList(resp);
    }
}
