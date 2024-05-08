package org.spring.Team_project_1.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.spring.Team_project_1.entity.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MyUserDetails implements UserDetails, OAuth2User {


    private MemberEntity memberEntity;
    private Map<String, Object> attribute;

    // 일반회원
    public MyUserDetails(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public MyUserDetails(MemberEntity memberEntity, Map<String, Object> attribute) {
        this.memberEntity = memberEntity;
        this.attribute = attribute;
    }

    public String getNickName(){
        return memberEntity.getNickName();
    }
    @Override
    public Map<String, Object> getAttributes() {
        return attribute;
    }

    @Override
    public String getName() {
        return memberEntity.getName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_" + memberEntity.getRole().toString();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return memberEntity.getUserPw();
    }

    @Override
    public String getUsername() {
        return memberEntity.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}