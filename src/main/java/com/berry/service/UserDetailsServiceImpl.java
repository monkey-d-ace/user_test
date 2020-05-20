package com.berry.service;

import com.berry.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User currentUser = mongoTemplate.findOne(new Query(Criteria.where("email").is(s)), User.class);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(s, currentUser.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList());
        return userDetails;
    }
}
