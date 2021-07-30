package com.blorferind.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blorferind.repository.AtvRepository;
import com.blorferind.entities.Atv;

@Transactional
@RestController
@RequestMapping(value = "/rest/atv")
public class AtvController {
  @Autowired
  AtvRepository atvRepository;
  @GetMapping(value = "/all")
  public List<Atv> getAll() {
    return atvRepository.findAll();
  }
  public List<Atv> persist(@RequestBody final Atv atv) {
    atvRepository.save(atv);
    return atvRepository.findAll();
  }

}
