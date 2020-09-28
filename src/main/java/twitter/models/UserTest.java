package twitter.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Users")
public class UserTest implements UserDetails {

    public UserTest() {
    }

    public static enum Role{ USER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @JsonProperty(access= Access.WRITE_ONLY)
    private String password;

    private String role;

    private String lastName;

    private String firstName;

    private String phone;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    private String profession;

    public UserTest(String username, String password, String lastName, String firstName, String phone, LocalDate birthday, String profession) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.birthday = birthday;
        this.profession = profession;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Post> posts = new ArrayList<>();



    public List<Post> getPosts() {
        return posts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role +
                ",]";
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }


    //    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//
//    @Size(min=5, message = "Не меньше 5 знаков")
//    @Column(name = "nik_name")//login
//    private String nikName;
//
//    @Size(min=5, message = "Не меньше 5 знаков")
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Size(min=5, message = "Не меньше 5 знаков")
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Size(min=5, message = "Не меньше 5 знаков")
//    @Column(name="password")
//    private String password;
//
//    @Column(name="role")
//    private String role;
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
//    private List<Post> posts;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getNikName() {
//        return nikName;
//    }
//
//    public void setNikName(String nikName) {
//        this.nikName = nikName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    public User(String nikName, String firstName, String lastName, String password) {
//        this.nikName = nikName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.password = password;
//    }
//
//    public User() {
//
//    }


}
