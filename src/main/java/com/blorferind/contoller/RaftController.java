package com.blorferind.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blorferind.entities.Raft;
import com.blorferind.repository.RaftRepository;

@Transactional
@RestController
@RequestMapping(value = "/rest/raft")
public class RaftController {
  @Autowired
  RaftRepository raftRepository;
  @GetMapping(value = "/all")
  public List<Raft> getAll() {
    return raftRepository.findAll();
  }
  public List<Raft> persist(@RequestBody final Raft raft) {
    raftRepository.save(raft);
    return raftRepository.findAll();
  }

}
