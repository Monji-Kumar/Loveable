package com.monji.projects.lovable_clone.service.projectmemberservice;

import com.monji.projects.lovable_clone.dto.member.InviteMemberRequest;
import com.monji.projects.lovable_clone.dto.member.MemberResponse;
import com.monji.projects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponse> getAllProjectMembers(Long userId, Long projectId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long userId, Long projectId, InviteMemberRequest inviteMemberRequest) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long userId, Long memberId, Long projectId, UpdateMemberRoleRequest updateMemberRoleRequest) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long userId, Long memberId, Long projectId) {
        return null;
    }
}
