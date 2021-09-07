package com.ovd.projetoteste.config;

import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Luan
 * <p>
 * Anotação para inserir nos métodos 'Seguros'
 * É necessário conter no header de cada requisição o token do usuário
 * Assim, é possível fazer a validação do usuário no bd
 */

@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface Secured {
}
