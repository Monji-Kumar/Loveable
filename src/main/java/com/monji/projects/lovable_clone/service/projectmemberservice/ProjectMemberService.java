package com.monji.projects.lovable_clone.service.projectmemberservice;

import com.monji.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.monji.projects.lovable_clone.dto.member.MemberResponse;
import com.monji.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getAllProjectMembers(Long userId, Long projectId);

    MemberResponse inviteMember(Long userId, Long projectId, InviteMemberRequest inviteMemberRequest);

    MemberResponse updateMemberRole(Long userId, Long memberId, Long projectId, UpdateMemberRoleRequest updateMemberRoleRequest);

    MemberResponse deleteProjectMember(Long userId, Long memberId, Long projectId);
}
