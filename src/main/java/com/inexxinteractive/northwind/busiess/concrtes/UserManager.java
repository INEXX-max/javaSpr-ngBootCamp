package com.inexxinteractive.northwind.busiess.concrtes;

import com.inexxinteractive.northwind.busiess.abstracts.UserService;
import com.inexxinteractive.northwind.core.DataAccess.UserDao;
import com.inexxinteractive.northwind.core.entites.User;
import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.core.utilits.results.SucessDataResult;
import com.inexxinteractive.northwind.core.utilits.results.SucessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    @Override
    public Results add(User user) {
        this.userDao.save(user);
        return  new SucessResult("User added. ");
    }

    @Override
    public DataResults<User> findByEmail(String email) {
        return  new SucessDataResult<User>(this.userDao.findByEmail("Email is logged"));
    }
}
