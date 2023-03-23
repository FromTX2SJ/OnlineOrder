package laioffer.com.onlineOrder;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import laioffer.com.onlineOrder.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!!!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        // Hello
        ObjectMapper mapper = new ObjectMapper();

        Customer customer = new Customer();

        customer.setEmail("sun@laioffer.com");
        customer.setPassword("123456");
        customer.setFirstName("rick");
        customer.setLastName("sun");
        customer.setEnabled(true);

        response.getWriter().print(mapper.writeValueAsString(customer));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Customer customer = mapper.readValue(IOUtils.toString(request.getReader()), Customer.class);

        System.out.println(customer.getEmail());
        System.out.println(customer.getPassword());
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());

        response.setContentType("application/json");

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}