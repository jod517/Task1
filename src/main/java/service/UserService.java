package service;

import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Collections;

public class UserService {


    private static UserService instance;

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }


    /* хранилище данных */
    private Map<Long, User> dataBase = Collections.synchronizedMap(new HashMap<>());
    /* счетчик id */
    private AtomicLong maxId = new AtomicLong(0);
    /* список авторизованных пользователей */
    private Map<Long, User> authMap = Collections.synchronizedMap(new HashMap<>());



        public List<User> getAllUsers() {
            return new ArrayList<>(dataBase.values());
        }

    public User getUserById(Long id) {
        return dataBase.get(id);
    }

    public boolean addUser(User user) {
        if (isExistsThisUser(user)){
            return false;
        }
         else {
             long newid = maxId.addAndGet(1);
             user.setId(newid);
             dataBase.put(newid,user);
        }
        return true;
    }

    public void deleteAllUser() {
        dataBase.clear();
    }

    public boolean isExistsThisUser(User user)
    {
        return getAllUsers().contains(user);
    }
    public boolean isUserAuth(User user) {              //дописанный метод
        return getAllAuth().contains(user);
    }

    public List<User> getAllAuth() {
        return new ArrayList<>(authMap.values());

    }

    public boolean authUser(User user) {
        boolean user1 = isExistsThisUser(user);
        boolean user2 = isUserAuth(user);
        if (user1 && user2 ) {
            return false;
        }
        else if (user1) {
            authMap.put(maxId.addAndGet(1), user);
            return true;
        }
        return false;
    }

    public void logoutAllUsers() {
        authMap.clear();

    }

    public boolean isUserAuthById(Long id) {
        return authMap.containsKey(id);
    }


    }