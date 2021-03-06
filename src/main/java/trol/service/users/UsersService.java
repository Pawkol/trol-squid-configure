package trol.service.users;

import trol.model.User;

import java.util.List;

public interface UsersService {
    List<User> getUsersList();
    User getUser(int userId);
    int addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
}
