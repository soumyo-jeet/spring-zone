package in.soumyo.servlet;

import in.soumyo.model.User;
import in.soumyo.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// all the methods are available at localhost:8080/crud-app/users/
@WebServlet("/users")
public class UserServlet extends HttpServlet {
    // tightly coupling
    private final UserService service = new UserService();

    @Override
    public void doPost (HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if(id == 0 || name == null || email == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Some fields are missing\"\n" +
                            "}"
            );

        }

        User newUser = new User(id, name, email);
        User created = service.createUser(newUser);
        response.setStatus(201);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User Added successfully\"\n" +
                        "}"
        );
    }


    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        if(idParam == null) {
            List<User> users = service.getAllUsers();
            response.setStatus(200);
            response.setContentType("application/json");
            response.getWriter().write(usersToJson(users));
            return;
        }
        Integer id = Integer.parseInt(idParam);

        User userResp = service.getUserById(id);

        if(userResp == null) {
            response.setStatus(404);
            response.setContentType("application/json");
        }

        response.setStatus(200);
        response.setContentType("application/json");
        response.getWriter().write(userToJson(userResp));

    }


    // manual parsing reqd
    private String userToJson(User user) {
        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : " + user.getName() + ",\n" +
                "    \"email\" : " + user.getEmail() + ",\n" +
                "}";
    }

    private String usersToJson(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for(int i = 0; i<users.size(); i++) {
            stringBuilder.append(userToJson(users.get(i)));

            if(i < users.size() - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
