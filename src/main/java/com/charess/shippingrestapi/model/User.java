package com.charess.shippingrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Person person;

    @Size(min = 3, max = 80)
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "status", length = 50, nullable = false)
    private String status = Status.USER_LOCKED.toString();

    @ManyToOne
    @JoinColumn(name = "profile")
    private Profile profile;

    @Column(name = "created", nullable = false)
    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "creator")
    private User creator;

    @Column(name = "edited")
    private LocalDateTime edited;

    @ManyToOne
    @JoinColumn(name = "editor")
    private User editor;

    @Transient
    private String token;

    @ManyToOne
    @JoinColumn(name = "activated_by")
    private User activatedBy;

    @Column(name = "activated_date")
    private LocalDateTime activatedDate;


    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public User() {
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<Profile> getAuthorities() {
        List<Profile> authorities = new ArrayList<>();
        if (profile != null)
            authorities.add(profile);
        return authorities;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        boolean isLocked = false;
        if (Status.USER_ACTIVE.toString().equals(this.status) || Status.USER_PENDING.toString().equals(this.status))
            isLocked = true;
        return isLocked;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        boolean bool = true;
        if (getAuthorities().size() < 1)
            bool = false;
        return bool;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }

    public User getEditor() {
        return editor;
    }

    public void setEditor(User editor) {
        this.editor = editor;
    }

    public User getActivatedBy() {
        return activatedBy;
    }

    public void setActivatedBy(User activatedBy) {
        this.activatedBy = activatedBy;
    }

    public LocalDateTime getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(LocalDateTime activatedDate) {
        this.activatedDate = activatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", person=" + person +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", profile=" + profile +
                ", created=" + created +
                ", creator=" + creator +
                ", edited=" + edited +
                ", editor=" + editor +
                ", token='" + token + '\'' +
                '}';
    }
}
