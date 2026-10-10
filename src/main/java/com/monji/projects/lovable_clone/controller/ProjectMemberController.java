package com.monji.projects.lovable_clone.controller;

import com.monji.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.monji.projects.lovable_clone.dto.member.MemberResponse;
import com.monji.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.monji.projects.lovable_clone.service.projectmemberservice.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/projects/{projectId}/members")
@RequiredArgsConstructor
@Slf4j
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectMemberService.getAllProjectMembers(projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMembers(@PathVariable Long projectId, @RequestBody InviteMemberRequest inviteMemberRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.inviteMember(projectId, inviteMemberRequest));
    }

    @PatchMapping(value = "update-member-role")
    public ResponseEntity<MemberResponse> updateMemberRole(@PathVariable Long projectId, @RequestParam Long memberId,
                                                           @RequestBody UpdateMemberRoleRequest updateMemberRoleRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectMemberService.updateMemberRole(memberId, projectId, updateMemberRoleRequest));
    }

    @DeleteMapping(value = "delete-member")
    public ResponseEntity<MemberResponse> deleteMemberRole(@PathVariable Long projectId, @RequestParam Long memberId) {
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(memberId, projectId));
    }
}
