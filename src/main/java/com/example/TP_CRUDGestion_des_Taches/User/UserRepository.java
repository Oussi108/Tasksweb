package com.example.TP_CRUDGestion_des_Taches.User;

import com.example.TP_CRUDGestion_des_Taches.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
