package gnuvil.validation.controller;

import ch.qos.logback.core.model.*;
import gnuvil.validation.domain.entity.Group;
import gnuvil.validation.domain.entity.Member;
import gnuvil.validation.domain.entity.TimeStamp;
import gnuvil.validation.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/{groupId}")
    public ResponseEntity<Group> getGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getGroupById(groupId));
    }

    @PostMapping
    public ResponseEntity<Group> addGroup(@RequestBody Group group) {
        Group savedGroup = groupService.createGroup(group);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGroup);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long groupId) {
        groupService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{groupId}/timestamp")
    public ResponseEntity<TimeStamp> addTimeStamp(@PathVariable Long groupId, @RequestParam Long memberId) {
        TimeStamp timeStamp = groupService.createTimeStamp(groupId, memberId);
        return ResponseEntity.status(HttpStatus.CREATED).body(timeStamp);
    }

    @GetMapping("/createGroup")
    public String createGroupForm() {
        return "CreateGroup";
    }

    @GetMapping("/groupInfo/{groupId}")
    public String getGroupInfo(@PathVariable Long groupId, Model model) {
        Group group = groupService.getGroupById(groupId);
        model.addAttribute("group", group);
        return "GroupInfo";
    }
}
