package com.javeriana.user_manager.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

  @Id
  @GeneratedValue
  @JsonProperty("id")
  public Integer id;

  @JsonProperty("token")
  @Column(unique = true)
  public String token;

  @JsonProperty("tokenType")
  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  @JsonProperty("revoked")
  public boolean revoked;

  @JsonProperty("expired")
  public boolean expired;

  @JsonProperty("user")
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  public User user;
}
