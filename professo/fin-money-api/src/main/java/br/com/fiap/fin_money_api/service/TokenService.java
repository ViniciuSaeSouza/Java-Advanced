package br.com.fiap.fin_money_api.service;

import br.com.fiap.fin_money_api.model.Token;
import br.com.fiap.fin_money_api.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    private Instant expiresAt = LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.ofHours(-3));
    private Algorithm algorithm = Algorithm.HMAC256("segredinhuuu");
    public Token createToken(User user) {

        try {
            var jwt = JWT.create()
                    .withSubject(user.getId().toString()) //Quem é o sujeito
                    .withClaim("email", user.getEmail()) // Claim para definir 'chaves' do payload
                    .withExpiresAt(expiresAt)
                    .sign(algorithm);
            return new Token(jwt, user.getEmail());
        } catch (JWTCreationException ex) {
            throw new JWTCreationException("Invalid Signing configuration / Couldn't convert Claims.", ex);
        }

    }

    public User getUserFromToken(String token) {
        var verifiedToken = JWT.require(algorithm).build().verify(token);

        return User.builder()
                .id(Long.valueOf(verifiedToken.getSubject()))
                .email(verifiedToken.getClaim("email").toString())
                .build();
    }
}
