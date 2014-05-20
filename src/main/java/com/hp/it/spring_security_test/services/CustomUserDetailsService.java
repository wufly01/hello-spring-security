package com.hp.it.spring_security_test.services;

import com.hp.it.spring_security_test.beans.DbUser;
import com.hp.it.spring_security_test.dao.UserDao;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bruce jia (chen-wei.jia@hp.com)
 * Date: 14-5-6
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
public class CustomUserDetailsService implements UserDetailsService {
    protected static Logger logger = Logger.getLogger("service");
    private UserDao userDAO = new UserDao();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user;

        try {

            //Can be replaced by real database
            DbUser dbUser = userDAO.getDatabase(username);

            // Populate the Spring User object with details from the dbUser
            // Here we just pass the username, password, and access level
            // getAuthorities() will translate the access level to the correct
            // role type

            user = new User(dbUser.getUsername(), dbUser.getPassword()
                    .toLowerCase(), true, true, true, true,
                    getAuthorities(dbUser.getAccess()));

        } catch (Exception e) {
            logger.error("Error in retrieving user");
            throw new UsernameNotFoundException("Error in retrieving user");
        }

        return user;
    }

    /**
     * RBAC
     *
     * @param access
     * @return
     */
    public Collection<GrantedAuthority> getAuthorities(Integer access) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        //SET ROLE_USER
        logger.debug("Grant ROLE_USER to this user");
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        //SET ROLE_ADMIN
        if (access.compareTo(1) == 0) {
            logger.debug("Grant ROLE_ADMIN to this user");
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }

        return authList;
    }
}
