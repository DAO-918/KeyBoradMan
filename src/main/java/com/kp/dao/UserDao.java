package com.kp.dao;

        import com.kp.domain.User;
        import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User login(User user);
    void register(User user);
    public User findUser(User user);
    void updatePassword(User user);


    public User findPhone(User user);

}
