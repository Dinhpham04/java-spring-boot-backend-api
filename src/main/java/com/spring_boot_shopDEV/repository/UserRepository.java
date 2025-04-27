package com.spring_boot_shopDEV.repository;

import com.spring_boot_shopDEV.entity.user.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.beans.Transient;
import java.util.List;

// Annotation
//@RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    // find username vs userEmail
    // cu phap hoat dong
    // findByUserNameAndUserEmail (loai bo findBy)
    // UserNameAndUserEmail (convert hoa thanh thuong)
    // userNameAnduserEmail => neu viet userNameAAnduserEmail => ko hoat dong
    // where userName = ? and userEmail = ?
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    // use Pageable
    Page<UserEntity> findByUserNameContaining(String userName, Pageable pageable);
    // userName
    UserEntity findByUserName(String userName);

    // Where userName Like %?
    List<UserEntity> findByUserNameStartingWith(String userEmail);

    // Where userName Like ?%
    List<UserEntity> findByUserNameEndingWith(String userEmail);

    // Where id < 1
    List<UserEntity> findByIdLessThan(Long id);

    // RAW JPQL
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(p.id) FROM UserEntity p)")
    UserEntity findMaxIdUser();
    // => Nho add JpaSpecificaitonExecutor<Entity>

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2") // tu dong nhan dien tham so thu 1 va tham so thu 2
    List<UserEntity> getUserEntityBy(String userName, String userEmail);

    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.userEmail = :userEmail") // tu dong nhan dien tham so thu 1 va tham so thu 2
    List<UserEntity> getUserEntityByTwo(@Param("userName") String userName,@Param("userEmail") String userEmail);

    // Update Delete
    @Modifying
    @Query("UPDATE UserEntity u SET u.userEmail = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    // native query (SQL Thuần)
    // get count user use native query
    @Query(value = "SELECT COUNT(id) FROM java_user_01", nativeQuery = true)
    long getTotalUser();
}

