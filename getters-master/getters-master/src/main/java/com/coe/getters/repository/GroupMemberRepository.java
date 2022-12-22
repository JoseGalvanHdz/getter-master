package com.coe.getters.repository;

import com.coe.getters.entities.GroupMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMemberEntity, Integer> {
}
