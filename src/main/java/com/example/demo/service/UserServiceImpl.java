package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userDao.getAll();
        log.info("Получен список всех пользователей");
        return users;
    }

    @Override
    @Transactional
    public void create(User user) {
        userDao.create(user);
        log.info("Пользователь с именем={} сохранен", user.getName());
    }

    @Override
    @Transactional
    public void update(User user, Long id) {
        userDao.update(user, id);
        log.info("Пользователь с id={} обновлен", id);
    }

    @Override
    public User get(Long id) {
        User user = userDao.get(id);
        log.info("Пользователь с id={} найден", id);
        return user;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
        log.info("Пользователь с id={} удален", id);
    }

}
