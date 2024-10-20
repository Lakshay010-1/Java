package org.program.JobPortal.repo;
import org.program.JobPortal.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    List<JobPost> findByPostDescContainingOrPostPostTechStackContaining(String skill1,
                                                                        String skill2);

}

