package com.hp.it.spring_security_test.dao;

import com.hp.it.spring_security_test.beans.DbUser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bruce jia (chen-wei.jia@hp.com)
 * Date: 14-5-6
 * Time: 下午5:04
 * To change this template use File | Settings | File Templates.
 */
public class UserDao {
    protected static Logger logger = Logger.getLogger("dao");

    public DbUser getDatabase(String username) {

        List<DbUser> users = internalDatabase();

        for (DbUser dbUser : users) {
            if (dbUser.getUsername().equals(username)) {
                logger.debug("User found");
                return dbUser;
            }
        }
        logger.error("User does not exist!");
        throw new RuntimeException("User does not exist!");

    }

    /**
     * Init data
     */
    private List<DbUser> internalDatabase() {

        List<DbUser> users = new ArrayList<DbUser>();
        DbUser user = null;

        user = new DbUser();
        user.setUsername("admin");

        // "admin" md5
        user.setPassword("21232f297a57a5a743894a0e4a801fc3");
        user.setAccess(1);

        users.add(user);

        user = new DbUser();
        user.setUsername("user");

        // "user" md5
        user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
        user.setAccess(2);

        users.add(user);

        return users;

    }
}
