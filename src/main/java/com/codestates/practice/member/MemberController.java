package com.codestates.practice.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/members")
public class MemberController {
    private final Map<Long, Map<String, Object>> members = new HashMap<>();

    @PostConstruct
    public void init(){
        Map<String, Object> member1 = new HashMap<>();
        long memberId = 1L;
        member1.put("memberId", memberId);
        member1.put("email", "hgd@gmail.com");
        member1.put("name", "홍길동");
        member1.put("phone", "010-1234-5678");

        members.put(memberId, member1);
    }

    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                                     @RequestParam("name") String name,
                                     @RequestParam("phone") String phone){

        Map<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
//                                      @RequestParam("email") String email,
//                                      @RequestParam("name") String name,
                                      @RequestParam("phone") String phone){

        Map<String, Object> map = members.get(memberId);
//        map.put("email", email);
//        map.put("name", name);
        map.put("phone", phone);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId){
        Map<String, Object> map = members.get(memberId);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers(){
        Map<Long, Map<String, Object>> maps = members;

        return new ResponseEntity<>(maps, HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") long memberId){
        members.remove(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
