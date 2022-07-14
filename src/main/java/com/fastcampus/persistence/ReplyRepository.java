package com.fastcampus.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastcampus.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
