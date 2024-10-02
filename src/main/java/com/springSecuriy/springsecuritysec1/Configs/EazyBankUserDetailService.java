package com.springSecuriy.springsecuritysec1.Configs;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springSecuriy.springsecuritysec1.models.Customer;
import com.springSecuriy.springsecuritysec1.repositoy.CustomerRepository;

import lombok.RequiredArgsConstructor;

// this class implements UserDetailService so springboots knows it is used to fetch/(other related oprn) userDetils from DB 
//the following class only loads user from DB, to store the new user while regristration we need to have controller called usercontroller  
@Service
@RequiredArgsConstructor
public class EazyBankUserDetailService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username).orElseThrow(() -> new
                UsernameNotFoundException("User details not found for the user: " + username));
                
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));
        return new User(customer.getEmail(), customer.getPwd(), authorities);
    }
}
