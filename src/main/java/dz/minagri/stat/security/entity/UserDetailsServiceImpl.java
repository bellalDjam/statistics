package dz.minagri.stat.security.entity;

import org.springframework.stereotype.Service;
@Service
public interface UserDetailsServiceImpl {

    /**@Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Map<String, Object> userMap = userService.getUserByUsername(userName);

        //check if this user with this username exist, if not, throw an exception
        // and stop the security process
        if (userMap == null) {
            throw new UsernameNotFoundException("User details not found with this username: " + userName);
        }

        String username = (String) userMap.get("username");
        String password = (String) userMap.get("password");
        String role = (String) userMap.get("role");

        List<SimpleGrantedAuthority> authList = getAuthorities(role);

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail((String) userMap.get("email"));
        user.setFirstName((String) userMap.get("firstName"));
        user.setLastName((String) userMap.get("lastName"));
        user.setId((Long) userMap.get("id"));
        for (SimpleGrantedAuthority authority : authList) {
            user.getAuthorities().add(authority);
        }

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthorities(String role) {
        List<SimpleGrantedAuthority> authList = new ArrayList<>();
        authList.add(new SimpleGrantedAuthority("READ_PRIVILEGE"));

        //you can also add different roles here
        //for example, the user is also an admin of the site, then you can add ROLE_ADMIN
        //so that he can view pages that are ROLE_ADMIN specific
        if (role != null && role.trim().length() > 0) {
            if (role.equals("admin")) {
                authList.add(new SimpleGrantedAuthority("WRITE_PRIVILEGE"));
            }
        }

        return authList;
    }*/
}