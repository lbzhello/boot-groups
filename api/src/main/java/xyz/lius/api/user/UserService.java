package xyz.lius.api.user;

public interface UserService {
    User findById(int id);

    User findByName(String name);

    void create(User user);

    void update(User user);

    void delete(int id);
}
