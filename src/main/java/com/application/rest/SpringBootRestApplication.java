package com.application.rest;

import com.application.rest.entities.Permission;
import com.application.rest.entities.Role;
import com.application.rest.entities.RoleEnum;
import com.application.rest.entities.User;
import com.application.rest.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository){
		return args -> {

			//PERMISSIONS

			Permission createPermission = Permission.builder()
					.name("CREATE")
					.build();

			Permission readPermission = Permission.builder()
					.name("READ")
					.build();

			Permission updatePermission = Permission.builder()
					.name("UPDATE")
					.build();

			Permission deletePermission = Permission.builder()
					.name("DELETE")
					.build();

			//ROLES

			Role adminRole = Role.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionsList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			Role userRole = Role.builder()
					.roleEnum(RoleEnum.USER)
					.permissionsList(Set.of(createPermission, readPermission))
					.build();

			Role invitedRole = Role.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionsList(Set.of(readPermission))
					.build();

			Role developerRole = Role.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionsList(Set.of(createPermission, readPermission, updatePermission))
					.build();


			//Creacion de Usuarios
			User userJohn = User.builder()
					.username("John")
					.password("1234")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountLocked(false)
					.credentialNoExpired(true)
					.roles(Set.of(adminRole))
					.build();

			User userDave = User.builder()
					.username("Dave")
					.password("1234")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountLocked(false)
					.credentialNoExpired(true)
					.roles(Set.of(userRole))
					.build();

			User userJames = User.builder()
					.username("James")
					.password("1234")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountLocked(false)
					.credentialNoExpired(true)
					.roles(Set.of(developerRole))
					.build();

			userRepository.saveAll(List.of(userJohn, userDave, userJames));


		};
	}

}
