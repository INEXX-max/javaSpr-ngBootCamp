package com.inexxinteractive.northwind.busiess.concrtes;

import com.inexxinteractive.northwind.busiess.abstracts.UserService;
import com.inexxinteractive.northwind.core.DataAccess.UserDao;
import com.inexxinteractive.northwind.core.entites.User;
import com.inexxinteractive.northwind.core.utilits.results.DataResults;
import com.inexxinteractive.northwind.core.utilits.results.Results;
import com.inexxinteractive.northwind.core.utilits.results.SucessDataResult;
import com.inexxinteractive.northwind.core.utilits.results.SucessResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // Tüm bağımlılıkları güvenle enjekte eder
public class UserManager implements UserService {

    // final ekledik: Bu sayede nesnenin boş (null) kalması kesinlikle engellenir.
    private final UserDao userDao;

    @Override
    public Results add(User user) {
        this.userDao.save(user);
        return new SucessResult("User added.");
    }

    @Override
    public DataResults<User> findByEmail(String email) {
        // Arama kısmına sabit metin yerine 'email' değişkenini verdik, metni mesaj kısmına taşıdık.
        return new SucessDataResult<User>(this.userDao.findByEmail(email), "Email is logged");
    }
}