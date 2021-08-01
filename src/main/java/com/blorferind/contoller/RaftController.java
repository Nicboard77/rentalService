package com.blorferind.contoller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  
  @PostMapping(value = "/createNewRaft")
  public ResponseEntity<Raft> createNewRaft(@RequestBody Raft newRaft) {
    Raft raft = raftRepository.save(newRaft);
    return new ResponseEntity<>(raft , HttpStatus.CREATED);
  }
  @DeleteMapping(value = "/deleteRaftById")
  public ResponseEntity<Integer> deleteRaftById(Integer id) {
    raftRepository.deleteById(id);
    return new ResponseEntity<>(id,HttpStatus.OK);
  }
  @PutMapping(value = "/updateRaftById/{id}")
  public ResponseEntity<Integer> updateCarById(@RequestBody Raft raft,
      @PathVariable Integer id) {
    Optional<Raft> raftOptional = raftRepository.findById(id);
    if (!raftOptional.isPresent())
      return ResponseEntity.notFound().build();
    raft.setRaftId(id);
    raftRepository.save(raft);
    return ResponseEntity.noContent().build();
      
    
    
  }
  

}
