package com.blorferind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blorferind.entities.Raft;

@Repository
public interface RaftRepository extends JpaRepository<Raft, Integer>{

}
