package com.project.Backend_Layers.service;
import com.project.Backend_Layers.model.Computer;
import com.project.Backend_Layers.repo.ComRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComService {
    private ComRepo repo;

    public ComRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(ComRepo repo) {
        this.repo = repo;
    }

    public void addCom(Computer com){
        repo.save(com);

    }

    public List<Computer> getCom() {
        return repo.findAll();
    }
}
