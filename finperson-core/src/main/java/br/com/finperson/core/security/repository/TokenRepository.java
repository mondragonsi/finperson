package br.com.finperson.core.security.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.finperson.domain.UserEntity;
import br.com.finperson.domain.enumm.TypeEmailEnum;
import br.com.finperson.security.domain.TokenEntity;

public interface TokenRepository extends CrudRepository<TokenEntity, Long>{

	TokenEntity findByUserAndTypeEmail(UserEntity user, TypeEmailEnum typeEmail);

	TokenEntity findByTokenAndTypeEmail(String token, TypeEmailEnum typeEmail);
}
