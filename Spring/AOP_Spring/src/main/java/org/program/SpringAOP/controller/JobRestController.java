package org.program.SpringAOP.controller;
import org.program.SpringAOP.model.JobPost;
import org.program.SpringAOP.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;

//  ResponseBody
    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

//  Path Variable
    @GetMapping("jobPost/{postID}")
    @ResponseBody
    public JobPost getJob(@PathVariable("postID") int postID){
        return service.getJob(postID);
    }

//    RequestBody
    @PostMapping("jobPost")
    public JobPost jobPost(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public void deleteJob(@PathVariable("postId") int postId){
         service.deleteJob(postId);
    }

    @GetMapping("jobPosts/skill/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.findByKeyword(keyword);
    }

    @GetMapping("jobPosts/loadData")
    public boolean loadData(){
        return service.loadData();
    }

// Content Negotiation
//        @GetMapping(path="jobPostsCN",produces = {"application/xml"})
//    @ResponseBody
//    public List<JobPost> getAllJobsCN(){
//        return service.getAllJobs();
//    }
//
//    @PostMapping(path="jobPostCN",consumes = {"application/xml","application/json"})
//    public JobPost jobPostCN(@RequestBody JobPost jobPost){
//        service.addJob(jobPost);
//        return service.getJob(jobPost.getPostId());
//    }


}
