package com.coe.getters.Controller;

import com.coe.getters.dto.ContactDTO;
import com.coe.getters.dto.GroupMemberDTO;
import com.coe.getters.entities.ContactEntity;
import com.coe.getters.entities.GroupMemberEntity;
import com.coe.getters.repository.GroupMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/group-member")
@CrossOrigin
public class GroupMemberController {
    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @GetMapping("/{groupMemberId}")
    public GroupMemberDTO getGroupMemberBYId(@PathVariable("groupMemberId") int groupMemberId){
        if (groupMemberId <= 0){
            return null;
        }
        GroupMemberEntity groupMemberEntity = groupMemberRepository.findById(groupMemberId).orElse(null);
        if (groupMemberEntity != null) {
            return new GroupMemberDTO(groupMemberEntity);
        }
        return null;
    }

    @GetMapping("")
    public List<GroupMemberDTO> getGroupMember(){
        List<GroupMemberDTO> groupMemberDTOList = new ArrayList<>();
        List<GroupMemberEntity> groupMemberEntities = groupMemberRepository.findAll();
        for (GroupMemberEntity entity: groupMemberEntities
        ) {
            groupMemberDTOList.add(new GroupMemberDTO(entity));
        }
        return groupMemberDTOList;
    }
}
