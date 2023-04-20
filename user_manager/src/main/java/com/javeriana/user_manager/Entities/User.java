package com.javeriana.user_manager.Entities;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.OneToMany;


@Entity
@Table(name = "user")
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User implements UserDetails, JsonSerializable
{

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @Setter
    @Getter
    @Column(name = "name", nullable = false)
    @JsonProperty("username")
    private String username;

    @Setter
    @Getter
    @Column(name = "pass")
    @JsonProperty("password")
    private String password;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @JsonProperty("role")
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "user")
    @JsonProperty("tokens")
    @Getter
    @Setter
    private List<Token> tokens;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() 
    {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public boolean isAccountNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() 
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() 
    {
        return true;
    }

    @Override
    public boolean isEnabled() 
    {
        return true;
    }
    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", this.id);
        gen.writeStringField("username", this.username);
        gen.writeStringField("password", this.password);
        gen.writeStringField("role", this.role.name());
        int tokensActivos = 0;
        for(int i = 0 ; i < this.tokens.size() ; i++)
        {
            if(!tokens.get(i).expired && !tokens.get(i).revoked)
            {
                gen.writeStringField("access_token" + tokensActivos, this.tokens.get(i).getToken());
                tokensActivos ++;
            }
        }
        gen.writeEndObject();
    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer)
            throws IOException {
        serialize(gen, serializers);
    }
}
